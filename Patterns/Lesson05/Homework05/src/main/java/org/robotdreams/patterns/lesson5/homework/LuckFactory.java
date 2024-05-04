package org.robotdreams.patterns.lesson5.homework;

public class LuckFactory {
    public LuckGenerator GetLuckGenerator(String name) {
        // TODO: Implement factory here
        return new DefaultLuckGenerator();
    }

}
