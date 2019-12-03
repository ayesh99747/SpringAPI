package lk.ayesh;

import lk.ayesh.Controllers.BookingsManager;
import lk.ayesh.Controllers.CustomerLoginInfoManager;
import lk.ayesh.Controllers.ManagerLoginInfoManager;
import lk.ayesh.Controllers.WestminsterRentalVehicleManager;

import lk.ayesh.Models.*;
import lk.ayesh.Repositories.BookingRepository;
import lk.ayesh.Repositories.CustomerRepository;
import lk.ayesh.Repositories.ManagerRepository;
import lk.ayesh.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
 * This class is the main class which is the starting point of the application
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */

@SpringBootApplication
@EnableScheduling
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private BookingRepository bookingRepository;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //This is called once the program has started
    @Override
    public void run(String... args) throws Exception {
        //Vehicles are read from the database and inserted to the list
        System.out.println("Vehicles retrieved from db.");
        List<Vehicle> listOfVehiclesFromDb = vehicleRepository.findAll();
        WestminsterRentalVehicleManager.addVehicleFromDatabase(listOfVehiclesFromDb);

        //Customers are read from the database and inserted to the list
        System.out.println();
        System.out.println("Customers retrieved from db.");
        List<Customer> listOfCustomersFromDb = customerRepository.findAll();
        CustomerLoginInfoManager.addCustomerFromDatabase(listOfCustomersFromDb);

        //Managers are read from the database and inserted to the list
        System.out.println();
        System.out.println("Managers retrieved from db.");
        List<Manager> listOfManagersFromDb = managerRepository.findAll();
        ManagerLoginInfoManager.addManagersFromDatabase(listOfManagersFromDb);

        //Bookings are read from the database and inserted to the list
        System.out.println();
        System.out.println("Bookings retrieved from db.");
        List<Booking> listOfBookingsFromDb = bookingRepository.findAll();
        BookingsManager.addBookingsFromDatabase(listOfBookingsFromDb);

    }
}
