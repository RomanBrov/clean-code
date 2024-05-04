package org.robotdreams.patterns.lesson09.homework;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Homework {
    static {
        System.setProperty(
                "java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
    }
    private static final Logger log = Logger.getLogger(Homework.class.getSimpleName());

    public static void main(String[] args) throws Exception {
        log.info("Starting Homework #09");
        log.info(String.format("Author: %s%n", "TODO: Your Name or Nickname here"));

        int filesCount = new Random().nextInt(15, 25);
        log.info("File to process: " + filesCount);

        for (int i = 0; i < filesCount; i++) {
            Processor fileProcessor = new ExceptionDecorator(
                    new TraceDecorator(
                            new FileProcessor(i)));

            fileProcessor.Process();
        }

        log.info("Homework #09 Completed");
    }
}

interface Processor {
    void Process() throws Exception;
}

class FileProcessor implements Processor {
    private static final Logger log = Logger.getLogger(FileProcessor.class.getSimpleName());

    public static final int MIN_PROCESSING_TIME_MS = 500;
    public static final int MAX_PROCESSING_TIME_MS = 1500;
    private int id;

    public FileProcessor(int id){

        this.id = id;
    }

    @Override
    public void Process() throws Exception {
        imitateLongProcessing();
    }

    private void imitateLongProcessing() throws Exception {
        int millisToSleep = new Random().nextInt(MIN_PROCESSING_TIME_MS, MAX_PROCESSING_TIME_MS);

        log.info(String.format("Processing item # %d %n", this.id));

        if (millisToSleep % 7 == 0)
            throw new Exception("You are not lucky: the processing has failed in " + millisToSleep + "ms");

        Thread.sleep(millisToSleep);
        log.info(String.format("Item # %d processed in %dms %n", this.id, millisToSleep));
    }
}

class ExceptionDecorator implements Processor {

    private static final Logger log = Logger.getLogger(ExceptionDecorator.class.getSimpleName());
    private final Processor decorated;

    public ExceptionDecorator(Processor decorated) {
        this.decorated = decorated;
    }

    @Override
    public void Process() {
        Boolean hasError;
        do {
            try {
                this.decorated.Process();
                hasError = false;
            } catch (Exception e) {
                log.log(Level.SEVERE, e.getMessage());
                hasError = true;
            }
        }
        while (hasError);
    }
}

class TraceDecorator implements Processor {
    private static final Logger log = Logger.getLogger(TraceDecorator.class.getSimpleName());
    private final Processor decorated;

    public TraceDecorator(Processor decorated) {
        this.decorated = decorated;
    }

    @Override
    public void Process() throws Exception {
        log.log(Level.INFO, "Start processing");
        this.decorated.Process();
        log.log(Level.INFO, "End processing");
    }
}