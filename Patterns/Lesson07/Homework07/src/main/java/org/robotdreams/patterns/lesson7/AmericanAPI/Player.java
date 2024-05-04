package org.robotdreams.patterns.lesson7.AmericanAPI;

public class Player {
    private final int id;
    private final String name;
    private final String heightFootIn;

    public Player(int id, String name, String heightFootIn){
        this.id = id;
        this.name = name;
        this.heightFootIn = heightFootIn;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeightFootIn() {
        return heightFootIn;
    }
}
