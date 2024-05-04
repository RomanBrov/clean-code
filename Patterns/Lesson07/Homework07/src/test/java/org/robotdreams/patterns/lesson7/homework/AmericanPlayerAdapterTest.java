package org.robotdreams.patterns.lesson7.homework;

import org.junit.jupiter.api.Test;
import org.robotdreams.patterns.lesson7.EuropeanAPI.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmericanPlayerAdapterTest {
    @Test
    void correctTransformation(){
        Player babe_ruth = new Player(123, "Babe Ruth", 188);
        AmericanPlayerAdapter americanPlayerAdapter = new AmericanPlayerAdapter(babe_ruth);

        assertEquals(babe_ruth.getId(), americanPlayerAdapter.getId());
        assertEquals(babe_ruth.getName(), americanPlayerAdapter.getName());
        assertEquals("6' 2\"", americanPlayerAdapter.getHeightFootIn());
    }
}