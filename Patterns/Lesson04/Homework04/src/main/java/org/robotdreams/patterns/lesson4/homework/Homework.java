package org.robotdreams.patterns.lesson4.homework;

public class Homework {

    public static void main(String[] args) {
        System.out.println("Hello, this is Homework #04");

        System.out.println("Simpler task output: ");


        try {
            new simpler().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Harder task output: ");

        try{
            new harder().execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
