package lk.ayesh.demo.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * This class is the Van class
 * The Van class extends from Vehicle
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
@Document
public class Van extends Vehicle {
    private String numberOfSuitcases;   //This represents the number of suitcases
    private String numberOfDoors;   //This represents the number of doors

    //The following is the van constructor
    public Van(String plateNumber, String make, String model, String yearOfManufacture, String transmissionType, String engineCapacity, String numberOfPassengers, String combinedEfficiency, String vehicleCategory, int numberOfFreeMiles, String fuelType, BigDecimal rate, Schedule scheduleForVehicle, String numberOfSuitcases, String numberOfDoors) {
        super(plateNumber, make, model, yearOfManufacture, transmissionType, engineCapacity, numberOfPassengers, combinedEfficiency, vehicleCategory, numberOfFreeMiles, fuelType, rate, scheduleForVehicle);
        this.numberOfSuitcases = numberOfSuitcases;
        this.numberOfDoors = numberOfDoors;
    }

    //THe following are the getter and setter methods
    public String getNumberOfSuitcases() {
        return numberOfSuitcases;
    }

    private void setNumberOfSuitcases(String numberOfSuitcases) {
        if ((!numberOfSuitcases.equals("")) && (numberOfSuitcases != null) && (numberOfSuitcases.matches("^[0-9]*$"))) {
            this.numberOfSuitcases = numberOfSuitcases;
        } else {
            System.out.println("Invalid Number of Suitcases!");
        }
    }

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    private void setNumberOfDoors(String numberOfDoors) {
        if ((!numberOfDoors.equals("")) && (numberOfDoors != null) && (numberOfDoors.matches("^[0-9]*$"))) {
            this.numberOfDoors = numberOfDoors;
        } else {
            System.out.println("Invalid number of doors!");
        }
    }

    //The following is the toString() method
    @Override
    public String toString() {
        return "Van{" + super.toString() +
                "numberOfSuitcases='" + numberOfSuitcases + '\'' +
                ", numberOfDoors='" + numberOfDoors + '\'' +
                '}';
    }
}
