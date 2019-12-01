package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VanTest {
    private Van vehicle;

    @BeforeEach
    void initEach() {
        MathContext mc = new MathContext(2);
        vehicle = new Van("def", "asd", "asd", "2000", "asd", "32", "2", "35", "Economy", 22, "asd", new BigDecimal("0.129", mc), new Schedule(), "22", "55");
    }

    @Test
    void getNumberOfSuitcases() {
        assertTrue(vehicle.getNumberOfSuitcases().equals("22"));
    }

    @Test
    void setNumberOfSuitcases() {
        vehicle.setNumberOfSuitcases("44");
        assertTrue(vehicle.getNumberOfSuitcases().equals("44"));
    }

    @Test
    void getNumberOfDoors() {
        assertTrue(vehicle.getNumberOfDoors().equals("55"));
    }

    @Test
    void setNumberOfDoors() {
        vehicle.setNumberOfDoors("11");
        assertTrue(vehicle.getNumberOfDoors().equals("11"));
    }

}