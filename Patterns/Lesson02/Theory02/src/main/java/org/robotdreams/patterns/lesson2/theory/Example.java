package org.robotdreams.patterns.lesson2.theory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

// TODO 00: Double click, triple click, double click and move
// TODO 01: Double ⇧: Search Everywhere
// TODO 02: Use Search Everywhere to find actions: duplicate, commit, method, parameter, format code
// TODO 03: ⌥ ⏎ : Show Context Actions
// TODO 04: ⌥ ↑ , ⌥ ↓ : Extend or shrink selection
// TODO 05: ⌘ / , ⌥ ⌘ / : Add/remove line or block comment
// TODO 06:  ⇧ ⌘ ↑, ⇧ ⌘ ↓ : Move function up / down
// TODO 07: Multiple carets
//      ⇧ ⌥ : Rectangular selection : cut
//      ⌥ Click : add caret : show paste
// TODO 08: Tab , ⇧ Tab: Indent/Unindent selected lines
// TODO 09: ⌥ ⌘ ], ⌥ ⌘ [ : Move to code block start/end
// TODO 10: ⌘ B: Go to declaration
// TODO 11: ⌥ ⌘ ← , ⌥ ⌘ → : Navigate back / Navigate forward
// TODO 12: ⌥ ⇧ ⌘ ← , ⌥ ⇧ ⌘ → : move (swap) a code element left/right.
// TODO 13: introduce field for 'newfile.txt'
// TODO 14: show how introduce constant is different (replace 2 occurences works only for global)
// TODO 15: ⌘ N : Generate code : create constructor : use path to be initialized
// TODO 16: Introduce parameter for "this.data"
// TODO 17: ⌥ F7 : Find Usages
// TODO 18: renaming using find and replace

public class Example {

    public static void main(String[] args) {
        System.out.println("Hello, this is Theory #02");

        // TODO: action 03: add parameter
        new WorkingWithFileDemo().writeToFile("p1", 2).readFromFile();;;;

        String configFile = null;
        String configDir = null;
        String configValue = null;
    }
}

class WorkingWithFileDemo {
    private String data = "Demo file contents";;;; // TODO: action 03

    private void unusedMethod() { // TODO: action 03

    }

    // TODO: action 12: swap
    public WorkingWithFileDemo writeToFile(String p1, Integer p2) {
        try {
            FileWriter myWriter = new FileWriter("newfile.txt");
            myWriter.write(data);
            myWriter.close();
            System.out.println("File is created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return this;
    }

    public void readFromFile() {
        try {
            File myObj = new File("newfile.txt");
            Scanner myReader = new Scanner(myObj);
            StringBuilder stringBuilder = new StringBuilder();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringBuilder.append(data);
            }
            myReader.close();

            System.out.println("File content is: " + stringBuilder.toString());
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
