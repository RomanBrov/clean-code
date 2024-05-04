package org.robotdreams.patterns.lesson09.theory;

public class Example {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, this is Theory #09");


        try {
            System.out.println("Starting Module Demo");

            ModuleDemo.getInstance().init(ModuleDemo.class.getCanonicalName());
            System.out.printf("Class has %d public members%n", ModuleDemo.getInstance().countPublic());
            System.out.printf("Class has %d private members%n", ModuleDemo.getInstance().countPrivate());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new TwinDemo().start();

        new DecoratorDemo().run();
    }

}

