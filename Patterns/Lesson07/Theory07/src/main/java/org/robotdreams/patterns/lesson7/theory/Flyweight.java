package org.robotdreams.patterns.lesson7.theory;

public class Flyweight {

    public Flyweight(String data) {
        this.data = data;
    }

    private String data;

    @Override
    public String toString() {
        return data;
    }
}