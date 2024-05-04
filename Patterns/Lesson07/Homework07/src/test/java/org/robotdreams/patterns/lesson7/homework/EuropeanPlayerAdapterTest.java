package org.robotdreams.patterns.lesson7.homework;

import org.junit.jupiter.api.Test;
import org.robotdreams.patterns.lesson7.AmericanAPI.Player;

import static org.junit.jupiter.api.Assertions.*;

class EuropeanPlayerAdapterTest {
    @Test
    void correctTransformation(){
        Player babe_ruth = new Player(123, "Babe Ruth", "6' 2\"");
        EuropeanPlayerAdapter europeanPlayerAdapter = new EuropeanPlayerAdapter(babe_ruth);

        assertEquals(babe_ruth.getId(), europeanPlayerAdapter.getId());
        assertEquals(babe_ruth.getName(), europeanPlayerAdapter.getName());
        assertEquals(188, europeanPlayerAdapter.getHeightCm());
    }
}