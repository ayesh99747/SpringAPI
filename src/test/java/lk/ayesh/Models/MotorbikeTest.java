package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * This class is the Test class for the Motorbike class
 * This test class tests all the getter and setter methods
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
class MotorbikeTest {
    private Motorbike vehicle;

    //This is run before each test and a new motorbike object is initialised
    @BeforeEach
    void initEach() {
        MathContext mc = new MathContext(2);
        vehicle = new Motorbike("test", "test", "test", "2000", "test", "22", "2", "22", "test", 22, "test", new BigDecimal("0.129", mc), new Schedule(), "test", true, true);
    }

    //This tests the get motorbike type method
    @Test
    void getMotorbikeType() {
        assertTrue(vehicle.getMotorbikeType().equals("test"));
        assertFalse(vehicle.getMotorbikeType().equals("test1"));
    }

    //This tests the set motorbike type method
    @Test
    void setMotorbikeType() {
        //Set motorbike type can contain letters only
        vehicle.setMotorbikeType("test");
        assertTrue(vehicle.getMotorbikeType().equals("test"));
        assertFalse(vehicle.getMotorbikeType().equals("test1"));
        //Motorbike type cannot be null
        vehicle.setMotorbikeType("");
        assertTrue(vehicle.getMotorbikeType().equals("test"));
        assertFalse(vehicle.getMotorbikeType().equals(""));
    }

    //This tests the is helmet provided method
    @Test
    void isHelmetProvided() {
        assertTrue(vehicle.isHelmetProvided());
    }

    //This tests the set helmet provided method
    @Test
    void setHelmetProvided() {
        vehicle.setHelmetProvided(false);
        assertTrue(vehicle.isHelmetProvided() == false);
        assertFalse(vehicle.isHelmetProvided() == true);
    }

    //This tests the is side car present method
    @Test
    void isSideCarPresent() {
        assertTrue(vehicle.isSideCarPresent());
    }

    //This tests the set side car present method
    @Test
    void setSideCarPresent() {
        vehicle.setSideCarPresent(false);
        assertTrue(vehicle.isSideCarPresent() == false);
        assertFalse(vehicle.isSideCarPresent() == true);
    }
}