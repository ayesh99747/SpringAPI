package lk.ayesh.Controllers;

import lk.ayesh.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/vehicles")
public class WestminsterRentalVehicleApi {

    @Autowired
    BookingManagerManager bms;
    @Autowired
    WestminsterRentalVehicleManager vm1;

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<Vehicle> allVehicles() {
        return WestminsterRentalVehicleManager.getListOfVehicles();
    }

    @GetMapping("/getAllCars")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Car> returnAllCars() {
        List<Vehicle> listOfVehicles = WestminsterRentalVehicleManager.getListOfVehicles();
        List<Car> listOfCars = new ArrayList<>();
        for (Vehicle v : listOfVehicles) {
            if (v instanceof Car) {
                Car c = (Car) v;
                listOfCars.add(c);
            }
        }
        return listOfCars;
    }

    @GetMapping("/getAllVans")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Van> returnAllVans() {
        List<Vehicle> listOfVehicles = WestminsterRentalVehicleManager.getListOfVehicles();
        List<Van> listOfVans = new ArrayList<>();
        for (Vehicle v : listOfVehicles) {
            if (v instanceof Van) {
                Van c = (Van) v;
                listOfVans.add(c);
            }
        }
        return listOfVans;
    }

    @GetMapping("/getAllMotorbikes")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Motorbike> returnAllMotorbikes() {
        List<Vehicle> listOfVehicles = WestminsterRentalVehicleManager.getListOfVehicles();
        List<Motorbike> listOfMotorbikes = new ArrayList<>();
        for (Vehicle v : listOfVehicles) {
            if (v instanceof Motorbike) {
                Motorbike c = (Motorbike) v;
                listOfMotorbikes.add(c);
            }
        }
        return listOfMotorbikes;
    }

    @GetMapping("/getAllFreeCars")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Car> returnAllFreeCars() {
        List<Vehicle> listOfVehicles = WestminsterRentalVehicleManager.getListOfVehicles();
        List<Car> listOfCars = new ArrayList<>();
        for (Vehicle v : listOfVehicles) {
            if (v instanceof Car) {
                if (v.getScheduleForVehicle().getPickUpDate() == null && v.getScheduleForVehicle().getDropOffDate() == null) {
                    Car c = (Car) v;
                    listOfCars.add(c);
                }
            }
        }
        return listOfCars;
    }

    @GetMapping("getAllFreeVans")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Van> returnAllFreeVans() {
        List<Vehicle> listOfVehicles = WestminsterRentalVehicleManager.getListOfVehicles();
        List<Van> listOfVans = new ArrayList<>();
        for (Vehicle v : listOfVehicles) {
            if (v instanceof Van) {
                if (v.getScheduleForVehicle().getPickUpDate() == null && v.getScheduleForVehicle().getDropOffDate() == null) {
                    Van c = (Van) v;
                    listOfVans.add(c);
                }
            }
        }
        return listOfVans;
    }

    @GetMapping("/getAllFreeMotorbikes")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Motorbike> returnAllFreeMotorbikes() {
        List<Vehicle> listOfVehicles = WestminsterRentalVehicleManager.getListOfVehicles();
        List<Motorbike> listOfMotorbikes = new ArrayList<>();
        for (Vehicle v : listOfVehicles) {
            if (v instanceof Motorbike) {
                if (v.getScheduleForVehicle().getPickUpDate() == null && v.getScheduleForVehicle().getDropOffDate() == null) {
                    Motorbike c = (Motorbike) v;
                    listOfMotorbikes.add(c);
                }
            }
        }
        return listOfMotorbikes;
    }

    @GetMapping("/getAllBookedCars")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Car> returnAllBookedCars() {
        List<Vehicle> listOfVehicles = WestminsterRentalVehicleManager.getListOfVehicles();
        List<Car> listOfBookedCars = new ArrayList<>();
        for (Vehicle v : listOfVehicles) {
            if (v instanceof Car) {
                if (v.getScheduleForVehicle().getPickUpDate() != null && v.getScheduleForVehicle().getDropOffDate() != null) {
                    listOfBookedCars.add((Car) v);
                }
            }
        }
        return listOfBookedCars;
    }

    @GetMapping("/getAllBookedVans")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Van> returnAllBookedVans() {
        List<Vehicle> listOfVehicles = WestminsterRentalVehicleManager.getListOfVehicles();
        List<Van> listOfBookedVans = new ArrayList<>();
        for (Vehicle v : listOfVehicles) {
            if (v instanceof Van) {
                if (v.getScheduleForVehicle().getPickUpDate() != null && v.getScheduleForVehicle().getDropOffDate() != null) {
                    listOfBookedVans.add((Van) v);
                }
            }
        }
        return listOfBookedVans;
    }

    @GetMapping("/getAllBookedMotorbikes")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Motorbike> returnAllBookedMotorbikes() {
        List<Vehicle> listOfVehicles = WestminsterRentalVehicleManager.getListOfVehicles();
        List<Motorbike> listOfBookedMotorbikes = new ArrayList<>();
        for (Vehicle v : listOfVehicles) {
            if (v instanceof Motorbike) {
                if (v.getScheduleForVehicle().getPickUpDate() != null && v.getScheduleForVehicle().getDropOffDate() != null) {
                    listOfBookedMotorbikes.add((Motorbike) v);
                }
            }
        }
        return listOfBookedMotorbikes;
    }

    @RequestMapping(value = "/getBookings", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Booking> getPreviousBookings(@RequestParam(value = "username", required = true) String username) {
        List<Booking> listOfBookings = new ArrayList<>();
        List<Booking> list = BookingManagerManager.getListOfBookings();
        for (Booking b : list) {
            System.out.println(b);
            if (username.equals(b.getUsername())) {
                listOfBookings.add(b);
            }
        }
        return listOfBookings;
    }

    @RequestMapping(value = "/getVehiclesToBeReturned", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Vehicle> getVehiclesToBeReturned() {
        List<Vehicle> listOfVehicles = WestminsterRentalVehicleManager.getListOfVehicles();
        List<Vehicle> listOfVehiclesToBeReturned = new ArrayList<>();
        for (Vehicle v:listOfVehicles) {
            if (v.getScheduleForVehicle().getDropOffDate() != null && v.getScheduleForVehicle().getPickUpDate() != null){
                if (v.getScheduleForVehicle().getDropOffDate().compareTo(new Date())  == 0){
                    listOfVehiclesToBeReturned.add(v);
                }
            }
        }
        return listOfVehiclesToBeReturned;
    }

    @GetMapping("/getAllCustomers")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Customer> returnAllCustomers() {
        return CustomerLoginInfoManager.getListOfCustomers();
    }
}
