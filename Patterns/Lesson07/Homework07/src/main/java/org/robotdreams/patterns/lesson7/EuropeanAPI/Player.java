package org.robotdreams.patterns.lesson7.EuropeanAPI;

public class Player {
    private final int id;
    private final String name;
    private final int heightCm;

    public Player(int id, String name, int heightCm){
        this.id = id;
        this.name = name;
        this.heightCm = heightCm;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHeightCm() {
        return heightCm;
    }
}

