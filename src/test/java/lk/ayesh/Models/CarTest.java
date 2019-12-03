package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * This class is the Test class for the Car class
 * This test class tests all the getter and setter methods
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
class CarTest {

    private Car car;

    //Before each test, the car object is initialised
    @BeforeEach
    void initEach() {
        MathContext mc = new MathContext(2);
        car = new Car("test-1234", "test", "test", "2019", "test", "22", "2", "22", "test", 22, "test", new BigDecimal("0.129", mc), new Schedule(), "22", "22", "test");
    }

    //This tests the get number of suitcases method
    @Test
    void getNumberOfSuitcases() {
        assertTrue(car.getNumberOfSuitcases().equals("22"));
        assertFalse(car.getNumberOfSuitcases().equals("11"));
    }

    //This tests the set number of suitcases method
    @Test
    void setNumberOfSuitcases() {
        car.setNumberOfSuitcases("44");
        assertTrue(car.getNumberOfSuitcases().equals("44"));
        assertFalse(car.getNumberOfSuitcases().equals("22"));
        car.setNumberOfSuitcases("test");
        assertTrue(car.getNumberOfSuitcases().equals("44"));
        assertFalse(car.getNumberOfSuitcases().equals("test"));
        //The number of suitcases cannot be empty
        car.setNumberOfSuitcases("");
        assertTrue(car.getNumberOfSuitcases().equals("44"));
        assertFalse(car.getNumberOfSuitcases().equals(""));
    }

    //This tests the get number of doors method
    @Test
    void getNumberOfDoors() {
        assertTrue(car.getNumberOfDoors().equals("22"));
        assertFalse(car.getNumberOfDoors().equals("33"));
    }

    //This tests the set number of suitcases method
    @Test
    void setNumberOfDoors() {
        car.setNumberOfDoors("11");
        assertTrue(car.getNumberOfDoors().equals("11"));
        assertFalse(car.getNumberOfDoors().equals("33"));
        car.setNumberOfDoors("test");
        assertTrue(car.getNumberOfDoors().equals("11"));
        assertFalse(car.getNumberOfDoors().equals("test"));
        //The number of doors cannot be empty
        car.setNumberOfDoors("");
        assertTrue(car.getNumberOfDoors().equals("11"));
        assertFalse(car.getNumberOfDoors().equals(""));
    }

    //This tests the get body type method
    @Test
    void getBodyType() {
        assertTrue(car.getBodyType().equals("test"));
        assertFalse(car.getBodyType().equals("test1"));
    }

    //This tests the set body type method
    @Test
    void setBodyType() {
        car.setBodyType("test");
        assertTrue(car.getBodyType().equals("test"));
        assertFalse(car.getBodyType().equals("test1"));
        //This happens because body type can only contain letters
        car.setBodyType("test1");
        assertTrue(car.getBodyType().equals("test"));
        assertFalse(car.getBodyType().equals("test1"));
        //The body type cannot be empty
        car.setBodyType("");
        assertTrue(car.getBodyType().equals("test"));
        assertFalse(car.getBodyType().equals(""));
    }
}