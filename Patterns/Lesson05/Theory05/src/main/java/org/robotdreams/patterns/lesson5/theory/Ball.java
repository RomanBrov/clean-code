package org.robotdreams.patterns.lesson5.theory;

public abstract class Ball {

    public String getBallType(){
        return this.getClass().getSimpleName();
    }

    public static Ball CreateVolleyBall() {
        return new VolleyBall();
    }

    public static Ball CreateBasketBall() {
        return new BasketBall();
    }

    public static Ball CreateFootBall() {
        return FootBall.getInstance();
    }
}

class VolleyBall extends Ball {
}

class BasketBall extends Ball {
}

class FootBall extends Ball {
    private final static Ball instance = new FootBall();

    private FootBall(){}

    public static Ball getInstance(){
        return instance;
    }
}


