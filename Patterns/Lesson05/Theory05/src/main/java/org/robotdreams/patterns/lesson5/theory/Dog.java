package org.robotdreams.patterns.lesson5.theory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Dog {

    private static final Logger LOGGER = Logger.getLogger(Dog.class.getName());

    private final String name;
    private final int years;
    private final int weightKgs;
    private final int heightCms;
    private final int color;
    private Ball takenBall;

    public Dog(String name, int weightKgs) {
        this.name = name;
        this.weightKgs = weightKgs;
        this.years = 0;
        this.heightCms = 0;
        this.color = 0;
        LOGGER.log(Level.INFO, "Dog '%s' (%dkg) created".formatted(name, weightKgs));
    }

    public Dog(String name, int weightKgs, int heightCms, int years, int color) {
        this.name = name;
        this.weightKgs = weightKgs;
        this.years = years;
        this.heightCms = heightCms;
        this.color = color;
        LOGGER.log(Level.INFO, "Dog '%s' (%dkg) created".formatted(name, weightKgs));
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weightKgs;
    }

    public void take(Ball ball) throws DogException {
        if (takenBall != null)
            throw new DogException("The dog already took another ball");
        this.takenBall = ball;
        LOGGER.log(Level.INFO, "Dog '%s' received a %s".formatted(name, this.takenBall.getBallType()));
    }

    public Ball give() throws DogException {
        if (takenBall == null)
            throw new DogException();
        var ball = takenBall;
        takenBall = null;
        return ball;
    }

    public static Dog createSmallDog(String name){
        return new Dog(name, 3);
    }
}
