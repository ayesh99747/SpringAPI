package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class is the Test class for the Booking class
 * This test class tests all the getter and setter methods
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
class BookingTest {

    private Booking booking;

    //This is run before each test and an object of booking is created
    @BeforeEach
    void initEach() {
        booking = new Booking("test", "AA-1234", new Date(2019,12,1), new Date(2019,12,1), new Date(2019,12,1));
    }

    //This tests the get username method
    @Test
    void getUsername() {
        assertTrue(booking.getUsername().equals("test"));
        assertFalse(booking.getUsername().equals("test1"));
    }

    //This tests the set username method
    @Test
    void setUsername() {
        //The username can contain numbers and letters
        booking.setUsername("test1");
        assertTrue(booking.getUsername().equals("test1"));
        assertFalse(booking.getUsername().equals("test"));
        //The username can contain numbers
        booking.setUsername("123");
        assertTrue(booking.getUsername().equals("123"));
        assertFalse(booking.getUsername().equals("test"));
        //The username cannot be empty
        booking.setUsername("");
        assertTrue(booking.getUsername().equals("123"));
        assertFalse(booking.getUsername().equals(""));
    }

    //This tests the get plate number method
    @Test
    void getPlateNumber() {
        assertTrue(booking.getPlateNumber().equals("AA-1234"));
        assertFalse(booking.getPlateNumber().equals("test1"));
    }

    //This tests the set plate number method
    @Test
    void setPlateNumber() {
        //The plate number can contain letters and numbers
        booking.setPlateNumber("test1");
        assertTrue(booking.getPlateNumber().equals("test1"));
        assertFalse(booking.getPlateNumber().equals("test"));
        //The plate number can contain numbers
        booking.setPlateNumber("123");
        assertTrue(booking.getPlateNumber().equals("123"));
        assertFalse(booking.getPlateNumber().equals("test"));
        //The plate number can contain letters and numbers and dashes
        booking.setPlateNumber("AA-1234");
        assertTrue(booking.getPlateNumber().equals("AA-1234"));
        assertFalse(booking.getPlateNumber().equals("test"));
        //The plate number cannot be empty
        booking.setPlateNumber("");
        assertTrue(booking.getPlateNumber().equals("AA-1234"));
        assertFalse(booking.getPlateNumber().equals(""));
    }

    //This tests the get pick up date method
    @Test
    void getPickUpDate() {
        assertTrue(booking.getPickUpDate().equals(new Date(2019,12,1)));
        assertFalse(booking.getPickUpDate().equals(new Date(2019,12,2)));
    }

    //This tests the set pick up date method
    @Test
    void setPickUpDate() {
        booking.setPickUpDate(new Date(2019,12,22));
        assertTrue(booking.getPickUpDate().equals(new Date(2019,12,22)));
        assertFalse(booking.getPickUpDate().equals(new Date(2019,12,2)));
    }

    //This tests the get drop off date method
    @Test
    void getDropOffDate() {
        assertTrue(booking.getDropOffDate().equals(new Date(2019,12,1)));
        assertFalse(booking.getDropOffDate().equals(new Date(2019,12,2)));
    }

    //This tests the set drop off date method
    @Test
    void setDropOffDate() {
        booking.setDropOffDate(new Date(2019,12,22));
        assertTrue(booking.getDropOffDate().equals(new Date(2019,12,22)));
        assertFalse(booking.getDropOffDate().equals(new Date(2019,12,1)));
    }

    //This tests the get booked date method
    @Test
    void getBookedDate() {
        assertTrue(booking.getBookedDate().equals(new Date(2019,12,1)));
        assertFalse(booking.getBookedDate().equals(new Date(2019,12,2)));
    }

    //This tests the set booked date method
    @Test
    void setBookedDate() {
        booking.setBookedDate(new Date(2019,12,22));
        assertTrue(booking.getBookedDate().equals(new Date(2019,12,22)));
        assertFalse(booking.getBookedDate().equals(new Date(2019,12,1)));
    }
}