package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MotorbikeTest {
    private Motorbike vehicle;

    @BeforeEach
    void initEach() {
        MathContext mc = new MathContext(2);
        vehicle = new Motorbike("def", "asd", "asd", "2000", "asd", "32", "2", "35", "Economy", 22, "asd", new BigDecimal("0.129", mc), new Schedule(), "asd", true, true);
    }

    @Test
    void getMotorbikeType() {
        assertTrue(vehicle.getMotorbikeType().equals("asd"));
    }

    @Test
    void setMotorbikeType() {
        vehicle.setMotorbikeType("qwe");
        assertTrue(vehicle.getMotorbikeType().equals("qwe"));
    }

    @Test
    void isHelmetProvided() {
        assertTrue(vehicle.isHelmetProvided());
    }

    @Test
    void setHelmetProvided() {
        vehicle.setHelmetProvided(false);
        assertTrue(vehicle.isHelmetProvided() == false);
    }

    @Test
    void isSideCarPresent() {
        assertTrue(vehicle.isSideCarPresent());
    }

    @Test
    void setSideCarPresent() {
        vehicle.setSideCarPresent(false);
        assertTrue(vehicle.isSideCarPresent() == false);
    }
}