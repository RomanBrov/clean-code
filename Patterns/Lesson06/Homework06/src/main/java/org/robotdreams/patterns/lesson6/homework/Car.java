package org.robotdreams.patterns.lesson6.homework;

public class Car {
    private final String make;
    private final String model;
    private final Engine engine;
    private final int year;

    Car(String make, String model, Engine engine, int year) {
        this.make = make;
        this.model = model;
        this.engine = engine;
        this.year = year;
    }

    public void start() {
        System.out.println("Starting %s %s car, manufactured %d".formatted(this.make, this.model, this.year));
        this.engine.startEngine();
    }
}