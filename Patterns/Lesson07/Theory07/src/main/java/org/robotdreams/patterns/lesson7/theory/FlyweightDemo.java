package org.robotdreams.patterns.lesson7.theory;

public class FlyweightDemo {
    public void start() {
        System.out.println("Starting Flyweight Demo");

        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("A");
        Flyweight flyweight2 = factory.getFlyweight("A");
        System.out.printf("%s%s to %s%n", flyweight1, getEqual(flyweight1, flyweight2), flyweight2);

        Flyweight flyweight3 = factory.getFlyweight("B");
        Flyweight flyweight4 = factory.getFlyweight("B");
        System.out.printf("%s%s to %s%n", flyweight3, getEqual(flyweight3, flyweight4), flyweight4);

        System.out.printf("%s%s to %s%n", flyweight1, getEqual(flyweight1, flyweight3), flyweight3);
    }

    private String getEqual(Object o1, Object o2) {
        return o1 == o2 ? " is equal" : " is NOT equal";
    }
}
