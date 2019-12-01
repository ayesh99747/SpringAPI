package lk.ayesh.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * This class is the Vehicle class
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
@Data
@Document(collection = "Vehicles")
public abstract class Vehicle implements Comparable<Vehicle> {
    @Id
    private String Id;

    @Field("plateNumber")
    private String plateNumber;     //This is the vehicle plate number
    @Field("make")
    private String make;    //This is the make of the vehicle
    @Field("model")
    private String model;   //This is the model of the vehicle
    @Field("yearOfManufacture")
    private String yearOfManufacture;   //This is the year of manufacture of the vehicle
    @Field("transmissionType")
    private String transmissionType;    //This is the transmission type of the vehicle
    @Field("engineCapacity")
    private String engineCapacity;      //This is the engine capacity of the vehicle
    @Field("numberOfPassengers")
    private String numberOfPassengers;  //This is the number of passengers that the vehicle can carry
    @Field("combinedEfficiency")
    private String combinedEfficiency;  //This is the combined efficiency of the vehicle
    @Field("vehicleCategory")
    private String vehicleCategory;     //This is the vehicle category of the vehicle
    @Field("numberOfFreeMiles")
    private int numberOfFreeMiles;      //This is the number of free miles the vehicle comes with
    @Field("fuelType")
    private String fuelType;    //This is the fuel type of the vehicle
    @Field("rate")
    private BigDecimal rate;    //This is the rate for the vehicle
    @Field("scheduleForVehicle")
    private Schedule scheduleForVehicle;    //This is the schedule which determines whether a vehicle is booked or not


    //The constructor is used to declare a new vehicle
    public Vehicle(String plateNumber, String make, String model, String yearOfManufacture, String transmissionType, String engineCapacity, String numberOfPassengers, String combinedEfficiency, String vehicleCategory, int numberOfFreeMiles, String fuelType, BigDecimal rate, Schedule scheduleForVehicle) {
        this.setPlateNumber(plateNumber);
        this.setMake(make);
        this.setModel(model);
        this.setYearOfManufacture(yearOfManufacture);
        this.setTransmissionType(transmissionType);
        this.setEngineCapacity(engineCapacity);
        this.setNumberOfPassengers(numberOfPassengers);
        this.setCombinedEfficiency(combinedEfficiency);
        this.setVehicleCategory(vehicleCategory);
        this.setNumberOfFreeMiles(numberOfFreeMiles);
        this.setFuelType(fuelType);
        this.rate = rate;
        this.scheduleForVehicle = scheduleForVehicle;
    }


    /* All the get methods have been declared after this
     * All the set methods are private so that other classes cannot access that variable
     * All the validation has been implemented in the set methods
     */

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        if (InputValidator.plateNumbers(plateNumber)) {
            this.plateNumber = plateNumber;
        }
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        if (InputValidator.stringWithLetters(make)) {
            this.make = make;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (InputValidator.stringWithNumbersAndLetters(model)) {
            this.model = model;
        }
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        if (InputValidator.stringWithNumbers(yearOfManufacture)) {
            this.yearOfManufacture = yearOfManufacture;
        }
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        if (InputValidator.stringWithLetters(transmissionType)) {
            this.transmissionType = transmissionType;
        }
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        if (engineCapacity.charAt(engineCapacity.length() - 1) != 'c') {
            if (InputValidator.stringWithNumbers(engineCapacity)) {
                this.engineCapacity = engineCapacity + "cc";
            }
        } else {
            this.engineCapacity = engineCapacity;
        }
    }

    public String getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(String numberOfPassengers) {
        if (InputValidator.stringWithNumbers(numberOfPassengers)) {
            this.numberOfPassengers = numberOfPassengers;
        }
    }

    public String getCombinedEfficiency() {
        return combinedEfficiency;
    }

    public void setCombinedEfficiency(String combinedEfficiency) {
        if (combinedEfficiency.charAt(combinedEfficiency.length() - 1) != 'g') {
            if (InputValidator.stringWithNumbers(combinedEfficiency)) {
                this.combinedEfficiency = combinedEfficiency + "mpg";
            }
        } else {
            this.combinedEfficiency = combinedEfficiency;
        }
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        if (InputValidator.stringWithLetters(vehicleCategory)) {
            this.vehicleCategory = vehicleCategory;
        }
    }

    public int getNumberOfFreeMiles() {
        return numberOfFreeMiles;
    }

    public void setNumberOfFreeMiles(int numberOfFreeMiles) {
        if (InputValidator.integers(numberOfFreeMiles)) {
            this.numberOfFreeMiles = numberOfFreeMiles;
        }
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        if (InputValidator.stringWithLetters(fuelType)) {
            this.fuelType = fuelType;
        }
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Schedule getScheduleForVehicle() {
        return scheduleForVehicle;
    }

    public void setScheduleForVehicle(Schedule scheduleForVehicle) {
        this.scheduleForVehicle = scheduleForVehicle;
    }


    //The toString method is used to return the Vehicle as a string
    @Override
    public String toString() {
        return "Vehicle{" +
                "Id='" + Id + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", numberOfPassengers='" + numberOfPassengers + '\'' +
                ", combinedEfficiency='" + combinedEfficiency + '\'' +
                ", vehicleCategory='" + vehicleCategory + '\'' +
                ", numberOfFreeMiles=" + numberOfFreeMiles +
                ", fuelType='" + fuelType + '\'' +
                ", rate=" + rate +
                ", scheduleForVehicle=" + scheduleForVehicle +
                '}';
    }

    @Override
    public int compareTo(Vehicle vehicle) {
        return this.getClass().toString().compareTo(vehicle.getClass().toString());
    }
}
