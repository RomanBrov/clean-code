package org.robotdreams.patterns.lesson6.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Homework {

    public static void main(String[] args) {
        System.out.println("Starting Homework #06");
        System.out.printf("Author: %s%n", "Roman Martsenko");

        Car car = new Car("Toyota", "Supra", new DieselEngine(), 2023);

        car.start();

        System.out.println("Initializing spring context");

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        appContext.register(DieselEngine.class);
        appContext.register(ElectricEngine.class);
        appContext.register(DieselEngineFactory.class);
        appContext.register(ElectricEngineFactory.class);
        appContext.register(Car.class);
        appContext.register(CarFactory.class);

        System.out.println("Spring context initialized");

        DieselEngine dieselEngine = appContext.getBean(DieselEngine.class);
        dieselEngine.setHp(345);

        // test DI works
        dieselEngine.startEngine();

        CarFactory carFactory = (CarFactory) appContext.getBean("carFactory");

        carFactory.getCar("Nissan", "Leaf", 2021, 340).start();
        carFactory.getCar("Honda", "Fit", 2022, 150).start();

        carFactory.getCar("Chevrolet", "Camaro", 2024, 455).start();
        carFactory.getCar("Jeep", "Wrangler", 2018, 285).start();
    }
}
