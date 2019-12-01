package lk.ayesh.demo.Controller;

import lk.ayesh.demo.Model.Booking;
import lk.ayesh.demo.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingManagerService {
    @Autowired
    private BookingRepository bookingRepository;

    private static List<Booking> listOfBookings = new ArrayList<Booking>();

    public static List<Booking> getListOfBookings() {
        return listOfBookings;
    }

    public void addBookingToList(Booking newBooking) {
        listOfBookings.add(newBooking);
    }

    public void addBookingToDatabase(Booking newBooking) {
        bookingRepository.insert(newBooking);
    }

    public static void addBookingsFromDatabase(List<Booking> listOfBookingsFromDb) {
        listOfBookings.clear();
        System.out.println("Bookings added to List: ");
        for (Booking m : listOfBookingsFromDb) {
            listOfBookings.add(m);
            System.out.println(m);
        }
    }

    public void printListOfBookings(){
        for (Booking m : listOfBookings) {
            System.out.println(m);
        }
    }
}
