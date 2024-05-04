package org.robotdreams.patterns.lesson5.theory;

public class FactoryMethodDemo {
    private int value;
    private int value2;
    private int value3;

    public FactoryMethodDemo(int value) {
        this.value = value;
    }

    public FactoryMethodDemo(int value, int value2) {
        this.value = value;
        this.value2 = value2;
    }

    public FactoryMethodDemo(int value, int value2, int value3) {
        this.value = value;
        this.value2 = value2;
        this.value3 = value3;
    }
}
