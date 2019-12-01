package lk.ayesh.demo;

import lk.ayesh.demo.Controller.BookingManagerService;
import lk.ayesh.demo.Controller.CustomerLoginInfoManager;
import lk.ayesh.demo.Controller.ManagerLoginInfoManager;
import lk.ayesh.demo.Controller.WestminsterRentalVehicleManager;
import lk.ayesh.demo.Model.*;
import lk.ayesh.demo.Repository.BookingRepository;
import lk.ayesh.demo.Repository.CustomerRepository;
import lk.ayesh.demo.Repository.ManagerRepository;
import lk.ayesh.demo.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@SpringBootApplication
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

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Vehicles retrieved from db.");
        List<Vehicle> listOfVehiclesFromDb = vehicleRepository.findAll();
        WestminsterRentalVehicleManager.addVehicleFromDatabase(listOfVehiclesFromDb);

        System.out.println();
        System.out.println("Customers retrieved from db.");
        List<Customer> listOfCustomersFromDb = customerRepository.findAll();
        CustomerLoginInfoManager.addCustomerFromDatabase(listOfCustomersFromDb);

        System.out.println();
        System.out.println("Managers retrieved from db.");
        List<Manager> listOfManagersFromDb = managerRepository.findAll();
        ManagerLoginInfoManager.addManagersFromDatabase(listOfManagersFromDb);

        System.out.println();
        System.out.println("Bookings retrieved from db.");
        List<Booking> listOfBookingsFromDb = bookingRepository.findAll();
        System.out.println();
        BookingManagerService.addBookingsFromDatabase(listOfBookingsFromDb);

    }

}
