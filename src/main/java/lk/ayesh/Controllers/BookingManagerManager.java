package lk.ayesh.Controllers;

import lk.ayesh.Models.Booking;
import lk.ayesh.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingManagerManager {
    private static List<Booking> listOfBookings = new ArrayList<Booking>();//This is the bookings list
    @Autowired
    private BookingRepository bookingRepository;

    //This method returns the booking list
    public static List<Booking> getListOfBookings() {
        return listOfBookings;
    }

    //This method is called when writing from the database to the list
    public static void addBookingsFromDatabase(List<Booking> listOfBookingsFromDb) {
        listOfBookings.clear();
        System.out.println("Bookings added to List: ");
        for (Booking m : listOfBookingsFromDb) {
            listOfBookings.add(m);
            System.out.println(m);
        }
    }

    //This following methods are called when a new booking is added to the list
    public void addBookingToList(Booking newBooking) {
        listOfBookings.add(newBooking);
    }

    public void addBookingToDatabase(Booking newBooking) {
        bookingRepository.insert(newBooking);
    }

    public void printListOfBookings() {
        for (Booking m : listOfBookings) {
            System.out.println(m);
        }
    }
}
