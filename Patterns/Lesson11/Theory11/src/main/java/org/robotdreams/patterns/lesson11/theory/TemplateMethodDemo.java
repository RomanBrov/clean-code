package org.robotdreams.patterns.lesson11.theory;

public class TemplateMethodDemo {
    public void start() {
        new ElectricVehicleService().process();
    }
}

abstract class VehicleService{
    public void process(){
        checkTires();
        checkSuspension();
        checkEngine();
    }

    protected abstract void checkTires();

    protected abstract void checkSuspension();

    protected abstract void checkEngine();
}

class ElectricVehicleService extends VehicleService{

    @Override
    protected void checkEngine() {
        // check electrical parts
    }

    @Override
    protected void checkTires() {

    }

    @Override
    protected void checkSuspension() {

    }
}

class DieselVehicleService extends VehicleService{

    @Override
    protected void checkEngine() {
        // check fuel parts
    }

    @Override
    protected void checkTires() {
        // default tires check
    }

    @Override
    protected void checkSuspension() {

    }
}

// example of adding new class without the TemplateMethod pattern
class HybridVehicleService extends VehicleService {

    public void process(){
        // what is the order or calls??
    }

    protected void checkEngine() {
        // check electrical
        // check fuel parts
    }

//    public EngineState getElectricalEngineState(){
//
//    }

    protected void checkTires() {

    }

    protected void checkSuspension() {

    }
}