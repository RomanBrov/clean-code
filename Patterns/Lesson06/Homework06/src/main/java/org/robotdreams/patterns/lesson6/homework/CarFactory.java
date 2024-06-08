package org.robotdreams.patterns.lesson6.homework;

public class CarFactory {
    private final ElectricEngineFactory electricEngineFactory;
    private final DieselEngineFactory dieselEngineFactory;

    public CarFactory(DieselEngineFactory dieselEngineFactory, ElectricEngineFactory electricEngineFactory) {
        this.electricEngineFactory = electricEngineFactory;
        this.dieselEngineFactory = dieselEngineFactory;
    }

    public Car getCar(String make, String model, int year, int hp) {
        return switch (make) {
            case "Nissan", "Honda" -> new Car(make, model, this.electricEngineFactory.getEngine(hp), year);
            default -> new Car(make, model, this.dieselEngineFactory.getEngine(hp), year);
        };
    }
}