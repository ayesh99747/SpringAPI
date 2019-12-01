package lk.ayesh.demo.Model;

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
        this.numberOfSuitcases = numberOfSuitcases;
        this.numberOfDoors = numberOfDoors;
        this.bodyType = bodyType;
    }

    //The following are the getter and setter methods
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

    public String getBodyType() {
        return bodyType;
    }

    private void setBodyType(String bodyType) {
        if ((!bodyType.equals("")) && (bodyType != null) && (bodyType.matches("^[a-zA-Z]*$"))) {
            this.bodyType = bodyType;
        } else {
            System.out.println("Invalid body type!");
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
