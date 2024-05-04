package org.robotdreams.patterns.lesson5.theory;

import java.util.logging.Logger;

public class Example {

    private static final Logger LOGGER = Logger.getLogger(Example.class.getName());

    public static void main(String[] args) {
        System.out.println("Hello, this is Theory #05");

        try {
            Dog dog = new Dog("Max", 23);
            int weight = dog.getWeight();
            dog.take(Ball.CreateBasketBall());
            Ball ball = dog.give();
            dog.take(Ball.CreateFootBall());
            ball = dog.give();
        } catch (DogException e) {
            throw new RuntimeException(e);
        }
    }
}

