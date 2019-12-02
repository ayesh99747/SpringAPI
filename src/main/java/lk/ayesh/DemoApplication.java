package lk.ayesh;

import lk.ayesh.Controllers.BookingManagerManager;
import lk.ayesh.Controllers.CustomerLoginInfoManager;
import lk.ayesh.Controllers.ManagerLoginInfoManager;
import lk.ayesh.Controllers.WestminsterRentalVehicleManager;
import lk.ayesh.Models.Booking;
import lk.ayesh.Models.Customer;
import lk.ayesh.Models.Manager;
import lk.ayesh.Models.Vehicle;
import lk.ayesh.Repositories.BookingRepository;
import lk.ayesh.Repositories.CustomerRepository;
import lk.ayesh.Repositories.ManagerRepository;
import lk.ayesh.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

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
        BookingManagerManager.addBookingsFromDatabase(listOfBookingsFromDb);

    }
}
