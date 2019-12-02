package lk.ayesh.Controllers;

import jdk.jfr.Event;
import lk.ayesh.Models.Vehicle;
import lk.ayesh.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public class Refresh {
    @Autowired
    private VehicleRepository vehicleRepository;

    /*
     * This is method is run everyday at midnight, what it does is, all the vehicles
     * that are in the data base are refreshed and also the database is refreshed. This is
     * This is done to refresh the vehicle schedule
     */
    @Scheduled(cron = "0 0 0 * * *")
    public void refreshVehicleList() {
        System.out.println("Vehicles retrieved from db.");
        List<Vehicle> listOfVehiclesFromDb = vehicleRepository.findAll();
        WestminsterRentalVehicleManager.addVehicleFromDatabase(listOfVehiclesFromDb);
        vehicleRepository.deleteAll();
        vehicleRepository.insert(WestminsterRentalVehicleManager.getListOfVehicles());
    }
}
