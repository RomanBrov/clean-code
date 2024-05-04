package org.robotdreams.patterns.lesson11.theory;

import java.awt.*;
import java.util.ArrayList;

public class MementoDemo {
    public void start() {
        System.out.println("↓↓↓↓");
        System.out.println("Starting Memento pattern Demo");

        Player player = new Player();
        player.move(5,10);
        player.move(5,10);

        CareTaker careTaker = new CareTaker();

        careTaker.add(player.saveStateToMemento());

        player.move(5,10);

        player.getStateFromMemento(careTaker.get(0));

        System.out.println("↑↑↑↑");
        System.out.println();
    }
}

class PlayerInfo{
    public Point location;
    public String weapon;
    public Boolean isInHand;
    public Integer health;
    public String alliance;
}

class Player {

    private Point location = new Point();
    private String weapon = "";

    private Boolean isInHand = false;

    public void move(int dx, int dy) {
        location.setLocation(location.x + dx, location.y + dy);
        System.out.printf("Player moved to (%d,%d) %n", location.x, location.y);
    }

    public Memento saveStateToMemento() {
        return new Memento(location, weapon, isInHand);
    }

    public void getStateFromMemento(Memento memento) {
        // BARRIER ENTER
        location = memento.getLocation();
        weapon = memento.getWeapon();
        isInHand = memento.getInHand();
        // BARRIER EXIT
        System.out.printf("Player's location restored to (%d,%d) %n", location.x, location.y);
    }
}

class Memento {
    private Point location;
    private final String weapon;
    private final Boolean isInHand;

    public Memento(Point location, String weapon, Boolean isInHand) {
        this.location = new Point(location.x, location.y);
        this.weapon = weapon;
        this.isInHand = isInHand;
        System.out.printf("Player's location (%d,%d) saved to memento %n", location.x, location.y);
    }

    public Point getLocation() {
        return location;
    }

    public String getWeapon() {
        return weapon;
    }

    public Boolean getInHand() {
        return isInHand;
    }
}

class CareTaker {
    private ArrayList<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}