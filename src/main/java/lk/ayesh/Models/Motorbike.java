package lk.ayesh.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * This class is the Motorbike class
 * The Motorbike class extends from Vehicle
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
@Document
public class Motorbike extends Vehicle {
    private String motorbikeType;   //This represents the motorbike type
    private boolean isHelmetProvided;   //This represents whether a helmet is provided or not
    private boolean isSideCarPresent;   //This represents whether a side car is present or not

    //This is the constructor for the motorbike object
    public Motorbike(String plateNumber, String make, String model, String yearOfManufacture, String transmissionType, String engineCapacity, String numberOfPassengers, String combinedEfficiency, String vehicleCategory, int numberOfFreeMiles, String fuelType, BigDecimal rate, Schedule scheduleForVehicle, String motorbikeType, boolean isHelmetProvided, boolean isSideCarPresent) {
        super(plateNumber, make, model, yearOfManufacture, transmissionType, engineCapacity, numberOfPassengers, combinedEfficiency, vehicleCategory, numberOfFreeMiles, fuelType, rate, scheduleForVehicle);
        setMotorbikeType(motorbikeType);
        this.setHelmetProvided(isHelmetProvided);
        this.setSideCarPresent(isSideCarPresent);
    }

    //The following are the getter and setter method
    public String getMotorbikeType() {
        return motorbikeType;
    }

    public void setMotorbikeType(String motorbikeType) {
        if (InputValidator.stringWithLetters(motorbikeType)) {
            this.motorbikeType = motorbikeType;
        }
    }

    public boolean isHelmetProvided() {
        return isHelmetProvided;
    }

    public void setHelmetProvided(boolean helmetProvided) {
        isHelmetProvided = helmetProvided;
    }

    public boolean isSideCarPresent() {
        return isSideCarPresent;
    }

    public void setSideCarPresent(boolean sideCarPresent) {
        isSideCarPresent = sideCarPresent;
    }

    //The following is the toString() method
    @Override
    public String toString() {
        return "Motorbike{" + super.toString() +
                "motorbikeType='" + motorbikeType + '\'' +
                ", isHelmetProvided=" + isHelmetProvided +
                ", isSideCarPresent=" + isSideCarPresent +
                '}';
    }
}
