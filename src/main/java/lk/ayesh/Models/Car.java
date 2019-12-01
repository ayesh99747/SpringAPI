package lk.ayesh.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * This class is the Car class
 * The car class extends from Vehicle
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
@Document
public class Car extends Vehicle {
    private String numberOfSuitcases;   //This represents the number of suitcases
    private String numberOfDoors;   //This represents the number of doors
    private String bodyType;    //This represents the body type

    //The following is a constructor for the car object
    public Car(String plateNumber, String make, String model, String yearOfManufacture, String transmissionType, String engineCapacity, String numberOfPassengers, String combinedEfficiency, String vehicleCategory, int numberOfFreeMiles, String fuelType, BigDecimal rate, Schedule scheduleForVehicle, String numberOfSuitcases, String numberOfDoors, String bodyType) {
        super(plateNumber, make, model, yearOfManufacture, transmissionType, engineCapacity, numberOfPassengers, combinedEfficiency, vehicleCategory, numberOfFreeMiles, fuelType, rate, scheduleForVehicle);
        this.setNumberOfSuitcases(numberOfSuitcases);
        this.setNumberOfDoors(numberOfDoors);
        this.setBodyType(bodyType);
    }

    //The following are the getter and setter methods
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

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        if (InputValidator.stringWithLetters(bodyType)) {
            this.bodyType = bodyType;
        }
    }

    //The following is the toString() method
    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                "numberOfSuitcases='" + numberOfSuitcases + '\'' +
                ", numberOfDoors='" + numberOfDoors + '\'' +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
