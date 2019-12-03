package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * This class is the Test class for the Van class
 * This test class tests all the getter and setter methods
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
class VanTest {
    private Van vehicle;

    //This method is run before each test and a new Van object is initialised
    @BeforeEach
    void initEach() {
        MathContext mc = new MathContext(2);
        vehicle = new Van("test", "test", "test", "2000", "test", "22", "2", "22", "test", 22, "test", new BigDecimal("0.129", mc), new Schedule(), "22", "22");
    }

    //This tests the get number of suitcases method
    @Test
    void getNumberOfSuitcases() {
        assertTrue(vehicle.getNumberOfSuitcases().equals("22"));
        assertFalse(vehicle.getNumberOfSuitcases().equals("33"));
        assertFalse(vehicle.getNumberOfSuitcases().equals("test"));
    }

    //This tests the set number of suitcases method
    @Test
    void setNumberOfSuitcases() {
        //The number of suitcases can only contain numbers
        vehicle.setNumberOfSuitcases("44");
        assertTrue(vehicle.getNumberOfSuitcases().equals("44"));
        assertFalse(vehicle.getNumberOfSuitcases().equals("55"));
        assertFalse(vehicle.getNumberOfSuitcases().equals("test"));
        //The number of suitcases cannot contain letters
        vehicle.setNumberOfSuitcases("test");
        assertFalse(vehicle.getNumberOfSuitcases().equals("test"));
        assertTrue(vehicle.getNumberOfSuitcases().equals("44"));
        //The number of suitcases cannot be empty
        vehicle.setNumberOfSuitcases("");
        assertFalse(vehicle.getNumberOfSuitcases().equals(""));
        assertTrue(vehicle.getNumberOfSuitcases().equals("44"));
    }

    //This tests the get number of doors method
    @Test
    void getNumberOfDoors() {
        assertTrue(vehicle.getNumberOfDoors().equals("22"));
        assertFalse(vehicle.getNumberOfDoors().equals("33"));
        assertFalse(vehicle.getNumberOfDoors().equals("test"));
    }

    //This tests the set number of doors method
    @Test
    void setNumberOfDoors() {
        //The number of suitcases can only contain numbers
        vehicle.setNumberOfDoors("11");
        assertTrue(vehicle.getNumberOfDoors().equals("11"));
        assertFalse(vehicle.getNumberOfDoors().equals("22"));
        assertFalse(vehicle.getNumberOfDoors().equals("test"));
        //The number of suitcases cannot contain letters
        vehicle.setNumberOfDoors("test");
        assertFalse(vehicle.getNumberOfDoors().equals("test"));
        assertTrue(vehicle.getNumberOfDoors().equals("11"));
        //The number of suitcases cannot be empty
        vehicle.setNumberOfDoors("");
        assertFalse(vehicle.getNumberOfDoors().equals(""));
        assertTrue(vehicle.getNumberOfDoors().equals("11"));
    }

}