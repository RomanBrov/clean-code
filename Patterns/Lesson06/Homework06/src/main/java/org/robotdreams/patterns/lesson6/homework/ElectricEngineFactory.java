package org.robotdreams.patterns.lesson6.homework;

public class ElectricEngineFactory {
    private final ElectricEngine electricEngine;

    public ElectricEngineFactory(ElectricEngine electricEngine) {
        this.electricEngine = electricEngine;
    }

    public Engine getEngine(int hp) {
        this.electricEngine.setHp(hp);
        return this.electricEngine;
    }
}