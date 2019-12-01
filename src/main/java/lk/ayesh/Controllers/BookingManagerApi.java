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

    @RequestMapping(value = "/newBooking", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public String addNewBooking(@RequestBody Booking booking) {
        bms.addBookingToList(booking);
        bms.addBookingToDatabase(booking);
        String rate = vm1.updateVehicleSchedule(booking.getPlateNumber(), booking.getPickUpDate(), booking.getDropOffDate());
        System.out.println("Vehicle Update Successfully");
        bms.printListOfBookings();
        return rate;
    }

}
