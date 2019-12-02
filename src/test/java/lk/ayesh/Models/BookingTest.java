package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    private Booking booking;

    @BeforeEach
    void initEach() {
        booking = new Booking("asd", "asd", new Date(2019,12,1), new Date(2019,12,1), new Date(2019,12,1));
    }

    @Test
    void getUsername() {
        assertTrue(booking.getUsername().equals("asd"));
        assertFalse(booking.getUsername().equals("qwe"));
    }

    @Test
    void setUsername() {
        booking.setUsername("test");
        assertTrue(booking.getUsername().equals("test"));
        assertFalse(booking.getUsername().equals("asd"));
    }

    @Test
    void getPlateNumber() {
        assertTrue(booking.getPlateNumber().equals("asd"));
        assertFalse(booking.getPlateNumber().equals("qwe"));
    }

    @Test
    void setPlateNumber() {
        booking.setPlateNumber("test");
        assertTrue(booking.getPlateNumber().equals("test"));
        assertFalse(booking.getPlateNumber().equals("zxc"));
    }

    @Test
    void getPickUpDate() {
        assertTrue(booking.getPickUpDate().equals(new Date(2019,12,1)));
        assertFalse(booking.getPickUpDate().equals(new Date(2019,12,2)));
    }

    @Test
    void setPickUpDate() {
        booking.setPickUpDate(new Date(2019,12,22));
        assertTrue(booking.getPickUpDate().equals(new Date(2019,12,22)));
        assertFalse(booking.getPickUpDate().equals(new Date(2019,12,2)));
    }

    @Test
    void getDropOffDate() {
        assertTrue(booking.getDropOffDate().equals(new Date(2019,12,1)));
        assertFalse(booking.getDropOffDate().equals(new Date(2019,12,2)));
    }

    @Test
    void setDropOffDate() {
        booking.setDropOffDate(new Date(2019,12,22));
        assertTrue(booking.getDropOffDate().equals(new Date(2019,12,22)));
        assertFalse(booking.getDropOffDate().equals(new Date(2019,12,1)));
    }

    @Test
    void getBookedDate() {
        assertTrue(booking.getBookedDate().equals(new Date(2019,12,1)));
        assertFalse(booking.getBookedDate().equals(new Date(2019,12,2)));
    }

    @Test
    void setBookedDate() {
        booking.setBookedDate(new Date(2019,12,22));
        assertTrue(booking.getBookedDate().equals(new Date(2019,12,22)));
        assertFalse(booking.getBookedDate().equals(new Date(2019,12,1)));
    }
}