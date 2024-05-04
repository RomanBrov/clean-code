package org.robotdreams.patterns.lesson09.theory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ModuleDemo {
    private static ModuleDemo singleton = null;
    private String contents = "";

    private ModuleDemo() {
    }

    public static ModuleDemo getInstance() {
        if (ModuleDemo.singleton == null) {
            ModuleDemo.singleton = new ModuleDemo();
        }

        return ModuleDemo.singleton;
    }

    public void init(String classToInspect) throws IOException {
        String workingDirectory = new File("").getAbsolutePath();

        Path pathToClass = Path.of(
                workingDirectory,
                "Patterns/Lesson09/Theory09/src/main/java/",
                classToInspect.replace('.', '/') + ".java");
        contents = readFile(pathToClass);
    }

    public int countPublic() {
        String searchWord = "public";
        return CountWords(searchWord);
    }

    public int countPrivate() {
        String searchWord = "private";
        return CountWords(searchWord);
    }

    private String readFile(Path path) throws IOException {
        return Files.readString(path);
    }

    private int CountWords(String searchWord) {
        Pattern pattern = Pattern.compile(" *" + searchWord + " +");
        Matcher matcher = pattern.matcher(this.contents);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public void PublicMethod1() {

    }

    private void PrivateMethod1() {

    }

    private void PrivateMethod2() {

    }
}
