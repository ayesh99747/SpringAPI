package lk.ayesh.Controllers;

import lk.ayesh.Models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/bookings")
public class BookingManagerApi {
    @Autowired
    BookingManagerManager bms;

    @Autowired
    WestminsterRentalVehicleManager vm1;

    //This url is used if a new booking is placed
    @RequestMapping(value = "/newBooking", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public String addNewBooking(@RequestBody Booking booking) {
        bms.addBookingToList(booking);  //the bookings list is updated here
        bms.addBookingToDatabase(booking);  //the booking is added to the database
        String rate = vm1.updateVehicleSchedule(booking.getPlateNumber(), booking.getPickUpDate(), booking.getDropOffDate());//The rate is calculated here
        System.out.println("Vehicle Update Successfully");
        bms.printListOfBookings();//All the bookings are displayed on the console
        return rate;//The rate is returned
    }

}
