package org.robotdreams.patterns.lesson6.homework;

public class ElectricEngine implements Engine {
    private int hp;

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void startEngine() {
        System.out.printf("Electric engine with %d hp has been started%n", this.hp);
    }
}