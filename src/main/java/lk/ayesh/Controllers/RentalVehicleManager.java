package lk.ayesh.Controllers;

import lk.ayesh.Models.Vehicle;

import java.io.IOException;
import java.util.Date;

/**
 * This interface is the Rental Vehicle Manager Interface
 * This interface contains all the functionalities required by the specification
 * The methods are implemented in the WestminsterRentalVehicleManager
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */

public interface RentalVehicleManager {

    boolean isVehiclePresent(String plateNumber);//This returns whether a vehicle is present or not

    String updateVehicleSchedule(String plateNumber, Date pickUpDate, Date dropOffDate);//This method updates the vehicle in the vehicle list once a booking is made

    Vehicle getVehicle(String plateNumber);//This method returns a vehicle when the plate number is passed

    void addVehicle(Vehicle v);//This method adds vehicles to the list

    void deleteVehicle(String plateNumber);//This method deletes vehicles from the list

    void generateReport() throws IOException;//This method generates the report

    void saveToTextFile();//This method writes the vehicle list into a text file

    void saveToDatabase();//This method saves the data to the database

    void printListOfVehicles();//This method prints the list of vehicles
}
