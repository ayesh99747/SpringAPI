package lk.ayesh.Models;

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
        this.setNumberOfSuitcases(numberOfSuitcases);
        this.setNumberOfDoors(numberOfDoors);
    }

    //THe following are the getter and setter methods
    public String getNumberOfSuitcases() {
        return numberOfSuitcases;
    }

    public void setNumberOfSuitcases(String numberOfSuitcases) {
        if (InputValidator.stringWithNumbers(numberOfSuitcases)) {
            this.numberOfSuitcases = numberOfSuitcases;
        }
    }

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        if (InputValidator.stringWithNumbers(numberOfDoors)) {
            this.numberOfDoors = numberOfDoors;
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
