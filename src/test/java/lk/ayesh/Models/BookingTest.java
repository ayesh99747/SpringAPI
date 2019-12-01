package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookingTest {

    private Booking booking;

    @BeforeEach
    void initEach() {
        booking = new Booking("asd", "asd", new Date(), new Date(), new Date());
    }

    @Test
    void getUsername() {
        assertTrue(booking.getUsername().equals("asd"));
    }

    @Test
    void setUsername() {
        booking.setUsername("test");
        assertTrue(booking.getUsername().equals("test"));
    }

    @Test
    void getPlateNumber() {
        assertTrue(booking.getPlateNumber().equals("asd"));
    }

    @Test
    void setPlateNumber() {
        booking.setPlateNumber("test");
        assertTrue(booking.getPlateNumber().equals("test"));
    }

    @Test
    void getPickUpDate() {
        assertTrue(booking.getPickUpDate().equals(new Date()));
    }

    @Test
    void setPickUpDate() {
        booking.setPickUpDate(new Date());
        assertTrue(booking.getPickUpDate().equals(new Date()));
    }

    @Test
    void getDropOffDate() {
        assertFalse(booking.getDropOffDate().equals(new Date()));
    }

    @Test
    void setDropOffDate() {
        booking.setDropOffDate(new Date());
        assertTrue(booking.getDropOffDate().equals(new Date()));
    }

    @Test
    void getBookedDate() {
        assertTrue(booking.getBookedDate().equals(new Date()));
    }

    @Test
    void setBookedDate() {
        booking.setBookedDate(new Date());
        assertTrue(booking.getBookedDate().equals(new Date()));
    }
}