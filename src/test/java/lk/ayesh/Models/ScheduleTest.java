package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * This class is the Test class for the Schedule class
 * This test class tests all the getter and setter methods
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
class ScheduleTest {

    private Schedule schedule;

    //This is run before each test and a new schedule object is initialised
    @BeforeEach
    void initEach() {
        schedule = new Schedule();
    }

    //This tests the get pickup date method
    @Test
    void getPickUpDate() {
        assertTrue(schedule.getPickUpDate() == null);
        assertFalse(schedule.getPickUpDate() != null);
    }

    //This tests the set pickup date method
    @Test
    void setPickUpDate() {
        schedule.setPickUpDate(new Date());
        assertTrue(schedule.getPickUpDate().equals(new Date()));
        assertFalse(schedule.getPickUpDate().equals(new Date(2019,2,12)));
    }

    //This tests the get drop off date method
    @Test
    void getDropOffDate() {
        assertTrue(schedule.getDropOffDate() == null);
        assertFalse(schedule.getDropOffDate() != null);
    }

    //This tests the set drop off date method
    @Test
    void setDropOffDate() {
        schedule.setDropOffDate(new Date());
        assertTrue(schedule.getDropOffDate().equals(new Date()));
        assertFalse(schedule.getDropOffDate().equals(new Date(2019,2,12)));
    }
}