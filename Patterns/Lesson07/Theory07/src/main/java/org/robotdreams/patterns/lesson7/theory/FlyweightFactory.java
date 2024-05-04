package org.robotdreams.patterns.lesson7.theory;

import java.util.Map;
import java.util.TreeMap;

public class FlyweightFactory {

    Map<String, Flyweight> pool;

    public FlyweightFactory() {
        this.pool = new TreeMap<>();
    }

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = pool.get(key);

        if (flyweight == null) {
            flyweight = new Flyweight(key);
            pool.put(key, flyweight);
        }

        return flyweight;
    }

}
