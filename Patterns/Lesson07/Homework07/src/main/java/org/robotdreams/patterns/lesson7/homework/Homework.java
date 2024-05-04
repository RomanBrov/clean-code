package org.robotdreams.patterns.lesson7.homework;

public class Homework {

    public static void main(String[] args) {
        System.out.println("Starting Homework #07: Adapters");
        System.out.printf("Author: %s%n", "TODO: Your Name or Nickname here");
        System.out.println("----");

        // TODO: implement adapters. Test using Unit tests

        System.out.println("Testing " + AmericanPlayerAdapter.class.getSimpleName());
        org.robotdreams.patterns.lesson7.EuropeanAPI.Player euPlayer = new org.robotdreams.patterns.lesson7.EuropeanAPI.Player(11, "John Smith", 188);
        AmericanPlayerAdapter adaptedEuPlayer = new AmericanPlayerAdapter(euPlayer);
        System.out.printf("Original player: %d, %s, %s%n",
                euPlayer.getId(),
                euPlayer.getName(),
                euPlayer.getHeightCm());
        System.out.printf("Adapted player: %d, %s, %s%n",
                adaptedEuPlayer.getId(),
                adaptedEuPlayer.getName(),
                adaptedEuPlayer.getHeightFootIn());

        System.out.println("----");
        System.out.println("Testing " + EuropeanPlayerAdapter.class.getSimpleName());
        org.robotdreams.patterns.lesson7.AmericanAPI.Player americanPlayer = new org.robotdreams.patterns.lesson7.AmericanAPI.Player(123, "Babe Ruth", "6' 2\"");
        EuropeanPlayerAdapter adaptedAmericanPlayer = new EuropeanPlayerAdapter(americanPlayer);
        System.out.printf("Original player: %d, %s, %s%n",
                americanPlayer.getId(),
                americanPlayer.getName(),
                americanPlayer.getHeightFootIn());
        System.out.printf("Adapted player: %d, %s, %s%n",
                adaptedAmericanPlayer.getId(),
                adaptedAmericanPlayer.getName(),
                adaptedAmericanPlayer.getHeightCm());
    }
}

