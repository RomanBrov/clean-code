package org.robotdreams.patterns.lesson5.homework;

public class Homework {

    public static void main(String[] args) throws Exception {
        ExecuteSpecificLuckGenerator("Dice");
        System.out.println();
        ExecuteSpecificLuckGenerator("Coin");
    }

    private static void ExecuteSpecificLuckGenerator(String luckType) {
        System.out.println("Testing luck generator of type '" + luckType + "'");

        var luckGenerator = new LuckFactory().GetLuckGenerator(luckType);

        for (int iteration = 0; iteration < 5; iteration++) {
            System.out.println("Test #" + iteration + ", LuckGenerator '" + luckGenerator.GetType() + "': " + luckGenerator.GenerateNext());
        }
    }
}

