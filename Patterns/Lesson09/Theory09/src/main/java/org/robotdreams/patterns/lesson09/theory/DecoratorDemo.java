package org.robotdreams.patterns.lesson09.theory;

import java.util.Random;

public class DecoratorDemo {
    public void run() throws Exception {
        System.out.println("Starting Decorator Demo");

        int filesCount = new Random().nextInt(15, 25);
        System.out.println("File to process: " + filesCount);

        for (int i = 0; i < filesCount; i++) {
            Processor fileProcessor = new FileProcessor(i);
            fileProcessor = new ExceptionDecorator(fileProcessor);
            // Log decorator
            // Trace decorator
            // Verify decorator
            // Retry decorator
            // Exception decorator

            fileProcessor.Process();
        }

        System.out.println("Decorator Demo Completed");
    }
}

interface Processor {
    void Process() throws Exception;
}

class FileProcessor implements Processor {
    private int id;

    public FileProcessor(int id){

        this.id = id;
    }

    @Override
    public void Process() throws Exception {
        imitateLongProcessing();
    }

    private void imitateLongProcessing() throws Exception {
        int millisToSleep = new Random().nextInt(500, 2000);

        System.out.printf("Processing item # %d%n", this.id);

        if (millisToSleep % 7 == 0)
            throw new Exception("You are not lucky: the processing has failed");

        Thread.sleep(millisToSleep);
        System.out.printf("Item # %d processed in %d%n", this.id, millisToSleep);
    }
}

class ExceptionDecorator implements Processor {
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
                e.printStackTrace();
                hasError = true;
            }
        }
        while (hasError);
    }
}
