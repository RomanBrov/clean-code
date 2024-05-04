package org.robotdreams.patterns.lesson6.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Homework {

    public static void main(String[] args) {
        System.out.println("Starting Homework #06");
        System.out.printf("Author: %s%n", "TODO: Your Name or Nickname here");

        Car car = new Car("Mercedes", "SLS AMG", new DieselEngine(), 2022);

        car.start();

        System.out.println("Initializing spring context");

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        // registration, option #2
        //appContext.register(DieselEngine.class);
        // TODO: add missing registrations

        System.out.println("Spring context initialized");

        DieselEngine dieselEngine = appContext.getBean(DieselEngine.class);
        dieselEngine.setHp(333);

        // test DI works
        dieselEngine.startEngine();

        CarFactory carFactory = (CarFactory) appContext.getBean("carFactory");

        carFactory.getCar("TODO: your diesel car option", "TODO", 2020, 170).start();
        carFactory.getCar("TODO: your electric car option", "TODO", 2015, 259).start();
    }
}

