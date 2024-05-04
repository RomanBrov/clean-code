package org.robotdreams.patterns.lesson6.homework;

public class DieselEngineFactory {
    private final DieselEngine dieselEngine;

    public DieselEngineFactory(DieselEngine dieselEngine) {
        this.dieselEngine = dieselEngine;
    }

    public Engine getEngine(int hp) {
        this.dieselEngine.setHp(hp);
        return this.dieselEngine;
    }
}
