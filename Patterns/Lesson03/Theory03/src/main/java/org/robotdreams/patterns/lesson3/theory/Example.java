package org.robotdreams.patterns.lesson3.theory;

public class Example {
    public static void main(String[] args) {
        System.out.println("Hello, this is Theory #03");
        System.out.println();

        System.out.println("New bug created: " + new Bug(1234567890, "My first bug", 0).getDescription());

        new BuiltInPatternsDemo().start();
    }
}


