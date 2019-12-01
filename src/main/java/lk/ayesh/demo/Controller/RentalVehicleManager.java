package lk.ayesh.demo.Controller;

import lk.ayesh.demo.Model.Vehicle;

import java.io.IOException;

/**
 * This interface is the Rental Vehicle Manager Interface
 * This interface contains all the functionalities required by the specification
 * The methods are implemented in the WestminsterRentalVehicleManager
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */

public interface RentalVehicleManager {
    void addVehicle(Vehicle v);//This method adds vehicles to the list

    void deleteVehicle(String plateNumber);//This method deletes vehicles from the list

    void generateReport() throws IOException;//This method generates the report

    void saveToDatabase();//This method saves the data to the database

    void printListOfVehicles();//This method prints the list of vehicles
}
