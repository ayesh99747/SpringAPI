package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * This class is the Test class for the Vehicle class
 * This test class tests all the getter and setter methods
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
class VehicleTest {

    private Car vehicle;

    //This method is run before each test and a new Car object is initialised
    @BeforeEach
    void initEach() {
        MathContext mc = new MathContext(2);
        vehicle = new Car("test-1234", "test", "test", "2019", "test", "22", "2", "22", "test", 22, "test", new BigDecimal("0.129", mc), new Schedule(), "22", "22", "test");
    }

    //This tests the get plate number method
    @Test
    void getPlateNumber() {
        assertTrue(vehicle.getPlateNumber().equals("test-1234"));
        assertFalse(vehicle.getPlateNumber().equals("test"));
        assertFalse(vehicle.getPlateNumber().equals("1234"));
    }

    //This tests the set plate number method
    @Test
    void setPlateNumber() {
        //The plate number can contain letters and numbers
        vehicle.setPlateNumber("test1");
        assertTrue(vehicle.getPlateNumber().equals("test1"));
        assertFalse(vehicle.getPlateNumber().equals("test"));
        //The plate number can contain numbers
        vehicle.setPlateNumber("123");
        assertTrue(vehicle.getPlateNumber().equals("123"));
        assertFalse(vehicle.getPlateNumber().equals("test"));
        //The plate number can contain letters and numbers and dashes
        vehicle.setPlateNumber("AA-1234");
        assertTrue(vehicle.getPlateNumber().equals("AA-1234"));
        assertFalse(vehicle.getPlateNumber().equals("test"));
        //The plate number cannot be empty
        vehicle.setPlateNumber("");
        assertTrue(vehicle.getPlateNumber().equals("AA-1234"));
        assertFalse(vehicle.getPlateNumber().equals(""));
    }

    //This tests the get make method
    @Test
    void getMake() {
        assertTrue(vehicle.getMake().equals("test"));
        assertFalse(vehicle.getMake().equals("test1"));
        assertFalse(vehicle.getMake().equals("123"));
    }

    //This tests the set make method
    @Test
    void setMake() {
        //The make can only contain letters
        vehicle.setMake("test");
        assertTrue(vehicle.getMake().equals("test"));
        assertFalse(vehicle.getMake().equals("asd"));
        //The make cannot contain numbers
        vehicle.setMake("123");
        assertTrue(vehicle.getMake().equals("test"));
        assertFalse(vehicle.getMake().equals("123"));
        //The make cannot be empty
        vehicle.setMake("");
        assertTrue(vehicle.getMake().equals("test"));
        assertFalse(vehicle.getMake().equals(""));
    }

    //This tests the get model method
    @Test
    void getModel() {
        assertTrue(vehicle.getModel().equals("test"));
        assertFalse(vehicle.getModel().equals("123"));
        assertFalse(vehicle.getModel().equals("test123"));
    }

    //This tests the set model method
    @Test
    void setModel() {
        //Model can contain letters and numbers
        vehicle.setModel("test");
        assertTrue(vehicle.getModel().equals("test"));
        assertFalse(vehicle.getModel().equals("asd"));
        vehicle.setModel("test12");
        assertTrue(vehicle.getModel().equals("test12"));
        assertFalse(vehicle.getModel().equals("asd"));
        //Model cannot be empty
        vehicle.setModel("");
        assertTrue(vehicle.getModel().equals("test12"));
        assertFalse(vehicle.getModel().equals(""));
    }

    //This tests the get year of manufacture method
    @Test
    void getYearOfManufacture() {
        assertTrue(vehicle.getYearOfManufacture().equals("2019"));
        assertFalse(vehicle.getYearOfManufacture().equals("1999"));
    }

    //This tests the set year of manufacture method
    @Test
    void setYearOfManufacture() {
        //Year of manufacture can only contain numbers
        vehicle.setYearOfManufacture("1999");
        assertTrue(vehicle.getYearOfManufacture().equals("1999"));
        assertFalse(vehicle.getYearOfManufacture().equals("2000"));
        //Year of manufacture cannot contain letters
        vehicle.setYearOfManufacture("asd");
        assertTrue(vehicle.getYearOfManufacture().equals("1999"));
        assertFalse(vehicle.getYearOfManufacture().equals("asd"));
        //Year of manufacture cannot be empty
        vehicle.setYearOfManufacture("");
        assertTrue(vehicle.getYearOfManufacture().equals("1999"));
        assertFalse(vehicle.getYearOfManufacture().equals(""));
    }

    //This tests the get transmission type method
    @Test
    void getTransmissionType() {
        assertTrue(vehicle.getTransmissionType().equals("test"));
        assertFalse(vehicle.getTransmissionType().equals("test1"));
    }

    //This tests the set transmission type method
    @Test
    void setTransmissionType() {
        //Transmission type can only contain letters
        vehicle.setTransmissionType("test");
        assertTrue(vehicle.getTransmissionType().equals("test"));
        assertFalse(vehicle.getTransmissionType().equals("asd"));
        //Transmission type cannot contain numbers
        vehicle.setTransmissionType("123");
        assertTrue(vehicle.getTransmissionType().equals("test"));
        assertFalse(vehicle.getTransmissionType().equals("123"));
        //Transmission type cannot be empty
        vehicle.setTransmissionType("");
        assertTrue(vehicle.getTransmissionType().equals("test"));
        assertFalse(vehicle.getTransmissionType().equals(""));
    }

    //This tests the get engine capacity method
    @Test
    void getEngineCapacity() {
        assertTrue(vehicle.getEngineCapacity().equals("22cc"));
        assertFalse(vehicle.getEngineCapacity().equals("22"));
    }

    //This tests the set engine capacity method
    @Test
    void setEngineCapacity() {
        //Engine capacity can only contain numbers
        vehicle.setEngineCapacity("11");
        assertTrue(vehicle.getEngineCapacity().equals("11cc"));
        assertFalse(vehicle.getEngineCapacity().equals("11"));
        //Engine capacity cannot contain letters
        vehicle.setEngineCapacity("test");
        assertTrue(vehicle.getEngineCapacity().equals("11cc"));
        assertFalse(vehicle.getEngineCapacity().equals("test"));
    }

    //This tests the get number of passengers method
    @Test
    void getNumberOfPassengers() {
        assertTrue(vehicle.getNumberOfPassengers().equals("2"));
        assertFalse(vehicle.getNumberOfPassengers().equals("4"));
    }

    //This tests the set number of passengers method
    @Test
    void setNumberOfPassengers() {
        //Number of passenger can only be numbers
        vehicle.setNumberOfPassengers("11");
        assertTrue(vehicle.getNumberOfPassengers().equals("11"));
        assertFalse(vehicle.getNumberOfPassengers().equals("asd"));
        //Number of passenger cannot be letters
        vehicle.setNumberOfPassengers("asd");
        assertTrue(vehicle.getNumberOfPassengers().equals("11"));
        assertFalse(vehicle.getNumberOfPassengers().equals("asd"));
    }

    //This tests the get combined efficiency method
    @Test
    void getCombinedEfficiency() {
        assertTrue(vehicle.getCombinedEfficiency().equals("22mpg"));
        assertFalse(vehicle.getCombinedEfficiency().equals("22"));
    }

    //This tests the set combined efficiency method
    @Test
    void setCombinedEfficiency() {
        //Combined Efficiency can only contain numbers
        vehicle.setCombinedEfficiency("11");
        assertTrue(vehicle.getCombinedEfficiency().equals("11mpg"));
        assertFalse(vehicle.getCombinedEfficiency().equals("11"));
        //Combined Efficiency cannot contain letters
        vehicle.setCombinedEfficiency("asd");
        assertTrue(vehicle.getCombinedEfficiency().equals("11mpg"));
        assertFalse(vehicle.getCombinedEfficiency().equals("asd"));
    }

    //This tests the get vehicle category method
    @Test
    void getVehicleCategory() {
        assertTrue(vehicle.getVehicleCategory().equals("test"));
        assertFalse(vehicle.getVehicleCategory().equals("test1"));
    }

    //This tests the set vehicle category method
    @Test
    void setVehicleCategory() {
        //Vehicle Category can only contain letters
        vehicle.setVehicleCategory("test");
        assertTrue(vehicle.getVehicleCategory().equals("test"));
        assertFalse(vehicle.getVehicleCategory().equals("test1"));
        vehicle.setVehicleCategory("123");
        //Vehicle Category cannot contain numbers
        assertTrue(vehicle.getVehicleCategory().equals("test"));
        assertFalse(vehicle.getVehicleCategory().equals("123"));
        //Vehicle Category cannot be empty
        vehicle.setVehicleCategory("");
        assertTrue(vehicle.getVehicleCategory().equals("test"));
        assertFalse(vehicle.getVehicleCategory().equals(""));
    }

    //This tests the get number of free miles method
    @Test
    void getNumberOfFreeMiles() {
        assertTrue(vehicle.getNumberOfFreeMiles() == 22);
        assertFalse(vehicle.getNumberOfFreeMiles() == 11);
    }

    //This tests the set number of free miles method
    @Test
    void setNumberOfFreeMiles() {
        //Number of free miles only accept integers
        vehicle.setNumberOfFreeMiles(11);
        assertTrue(vehicle.getNumberOfFreeMiles() == 11);
        assertFalse(vehicle.getNumberOfFreeMiles() == 22);
        vehicle.setNumberOfFreeMiles(0);
        assertTrue(vehicle.getNumberOfFreeMiles() == 11);
        assertFalse(vehicle.getNumberOfFreeMiles() == 0);
    }

    //This tests the get fuel type method
    @Test
    void getFuelType() {
        assertTrue(vehicle.getFuelType().equals("test"));
        assertFalse(vehicle.getFuelType().equals("test1"));
    }

    //This tests the set fuel type method
    @Test
    void setFuelType() {
        //Fuel Type can only contain letters and numbers
        vehicle.setFuelType("test");
        assertTrue(vehicle.getFuelType().equals("test"));
        assertFalse(vehicle.getFuelType().equals("test1"));
        //Fuel type can contain numbers and letters
        vehicle.setFuelType("test123");
        assertTrue(vehicle.getFuelType().equals("test123"));
        assertFalse(vehicle.getFuelType().equals("test"));
        //Fuel type cannot be empty
        vehicle.setFuelType("");
        assertTrue(vehicle.getFuelType().equals("test123"));
        assertFalse(vehicle.getFuelType().equals(""));
    }

    //This tests the get rate method
    @Test
    void getRate() {
        MathContext mc = new MathContext(2);
        assertTrue(vehicle.getRate().equals(new BigDecimal("0.129", mc)));
        assertFalse(vehicle.getRate().equals(new BigDecimal("0.15", mc)));
    }

    //This tests the set rate method
    @Test
    void setRate() {
        MathContext mc = new MathContext(2);
        vehicle.setRate(new BigDecimal("5.199", mc));
        assertTrue(vehicle.getRate().equals(new BigDecimal("5.199", mc)));
        assertFalse(vehicle.getRate().equals(new BigDecimal("6.199", mc)));
    }

}