package org.robotdreams.patterns.lesson7.homework;

import org.robotdreams.patterns.lesson7.AmericanAPI.Player;

public class EuropeanPlayerAdapter {
    private final int id;
    private final String name;
    private final double heightCm;

    public EuropeanPlayerAdapter(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.heightCm = 0;
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
