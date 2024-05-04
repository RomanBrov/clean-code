package org.robotdreams.patterns.lesson7.homework;

import org.robotdreams.patterns.lesson7.EuropeanAPI.Player;

public class AmericanPlayerAdapter {
    private final int id;
    private final String name;
    private final String heightFootIn;

    public AmericanPlayerAdapter(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.heightFootIn = "0' 0\"";
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
