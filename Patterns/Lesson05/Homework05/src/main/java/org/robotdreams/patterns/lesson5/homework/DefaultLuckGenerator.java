package org.robotdreams.patterns.lesson5.homework;

public class DefaultLuckGenerator implements LuckGenerator {
    @Override
    public String GetType() {
        return "Default";
    }

    @Override
    public int GenerateNext() {
        return 0;
    }
}
