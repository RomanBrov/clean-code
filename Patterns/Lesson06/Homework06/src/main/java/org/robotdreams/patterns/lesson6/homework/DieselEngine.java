package org.robotdreams.patterns.lesson6.homework;

public class DieselEngine implements Engine {
    private int hp;

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void startEngine() {

        System.out.printf("Diesel engine with %d hp has been started%n", this.hp);
    }
}
