package org.robotdreams.patterns.lesson09.theory;

public class TwinDemo {
    public void start() {
        System.out.println("Starting Twin Demo");
    }
}

class PetrolCar {
    public void start() {
    }
    public void stop() {
    }
    public void refuel(){
    }
}

class ElectricCar {
    public void start() {
    }
    public void stop() {
    }
    public void charge(){
    }
}

// normal composition, _without_ Twin pattern
class TwinCar {
    private final ElectricCar electricCar;
    private final PetrolCar petrolCar;

    public TwinCar(){
        electricCar = new ElectricCar();
        petrolCar = new PetrolCar();
    }

    public void start() {
        // do some logic to define which engine to start
    }
    public void stop() {
        // as above but for stop
    }
    public void refuel(){
        petrolCar.refuel();
    }
    public void charge(){
        electricCar.charge();
    }
}

// twin pattern
class HybridPetrolCar extends PetrolCar {
    private final TwinCar twin;

    public HybridPetrolCar(TwinCar twin){
        this.twin = twin;
    }

    @Override
    public void start() {
        twin.start();
    }

    @Override
    public void stop() {
        twin.stop();
    }

    @Override
    public void refuel() {
        twin.refuel();
    }
}

class HybridElectricCar extends ElectricCar {
    private final TwinCar twin;

    public HybridElectricCar(TwinCar twin){

        this.twin = twin;
    }

    @Override
    public void start() {
        twin.start();
    }

    @Override
    public void stop() {
        twin.stop();
    }

    @Override
    public void charge() {
        twin.charge();
    }
}
