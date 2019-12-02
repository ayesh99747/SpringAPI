package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScheduleTest {

    private Schedule schedule;

    @BeforeEach
    void initEach() {
        schedule = new Schedule();
    }

    @Test
    void getPickUpDate() {
        assertTrue(schedule.getPickUpDate() == null);
        assertFalse(schedule.getPickUpDate() != null);
    }

    @Test
    void setPickUpDate() {
        schedule.setPickUpDate(new Date());
        assertTrue(schedule.getPickUpDate().equals(new Date()));
        assertFalse(schedule.getPickUpDate().equals(new Date(2019,2,12)));
    }

    @Test
    void getDropOffDate() {
        assertTrue(schedule.getDropOffDate() == null);
        assertFalse(schedule.getDropOffDate() != null);
    }

    @Test
    void setDropOffDate() {
        schedule.setDropOffDate(new Date());
        assertTrue(schedule.getDropOffDate().equals(new Date()));
        assertFalse(schedule.getDropOffDate().equals(new Date(2019,2,12)));
    }
}