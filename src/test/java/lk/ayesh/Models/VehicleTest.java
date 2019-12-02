package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VehicleTest {

    private Car vehicle;

    @BeforeEach
    void initEach() {
        MathContext mc = new MathContext(2);
        vehicle = new Car("def", "asd", "asd", "2000", "asd", "32", "2", "35", "Economy", 22, "asd", new BigDecimal("0.129", mc), new Schedule(), "22", "55", "asd");
    }

    @Test
    void getPlateNumber() {
        assertTrue(vehicle.getPlateNumber().equals("def"));
        assertFalse(vehicle.getPlateNumber().equals("asd"));
    }

    @Test
    void setPlateNumber() {
        vehicle.setPlateNumber("AA-1234");
        assertTrue(vehicle.getPlateNumber().equals("AA-1234"));
        assertFalse(vehicle.getPlateNumber().equals("asd"));
        vehicle.setPlateNumber("test.");
        assertFalse(vehicle.getPlateNumber().equals("test."));
        assertTrue(vehicle.getPlateNumber().equals("AA-1234"));
    }

    @Test
    void getMake() {
        assertTrue(vehicle.getMake().equals("asd"));
        assertFalse(vehicle.getMake().equals("qwe"));
    }

    @Test
    void setMake() {
        vehicle.setMake("test");
        assertTrue(vehicle.getMake().equals("test"));
        assertFalse(vehicle.getMake().equals("asd"));
        vehicle.setMake("123");
        assertTrue(vehicle.getMake().equals("test"));
        assertFalse(vehicle.getMake().equals("123"));
    }

    @Test
    void getModel() {
        assertTrue(vehicle.getModel().equals("asd"));
        assertFalse(vehicle.getModel().equals("qwe"));
    }

    @Test
    void setModel() {
        vehicle.setModel("test");
        assertTrue(vehicle.getModel().equals("test"));
        assertFalse(vehicle.getModel().equals("asd"));
        vehicle.setModel("test12");
        assertTrue(vehicle.getModel().equals("test12"));
        assertFalse(vehicle.getModel().equals("asd"));
    }

    @Test
    void getYearOfManufacture() {
        assertTrue(vehicle.getYearOfManufacture().equals("2000"));
        assertFalse(vehicle.getYearOfManufacture().equals("1999"));
    }

    @Test
    void setYearOfManufacture() {
        vehicle.setYearOfManufacture("1999");
        assertTrue(vehicle.getYearOfManufacture().equals("1999"));
        assertFalse(vehicle.getYearOfManufacture().equals("2000"));
        vehicle.setYearOfManufacture("asd");
        assertTrue(vehicle.getYearOfManufacture().equals("1999"));
        assertFalse(vehicle.getYearOfManufacture().equals("asd"));
    }

    @Test
    void getTransmissionType() {
        assertTrue(vehicle.getTransmissionType().equals("asd"));
        assertFalse(vehicle.getTransmissionType().equals("qwe"));
    }

    @Test
    void setTransmissionType() {
        vehicle.setTransmissionType("test");
        assertTrue(vehicle.getTransmissionType().equals("test"));
        assertFalse(vehicle.getTransmissionType().equals("asd"));
        vehicle.setTransmissionType("123");
        assertTrue(vehicle.getTransmissionType().equals("test"));
        assertFalse(vehicle.getTransmissionType().equals("123"));
    }

    @Test
    void getEngineCapacity() {
        assertTrue(vehicle.getEngineCapacity().equals("32cc"));
        assertFalse(vehicle.getEngineCapacity().equals("32"));
    }

    @Test
    void setEngineCapacity() {
        vehicle.setEngineCapacity("11");
        assertTrue(vehicle.getEngineCapacity().equals("11cc"));
        assertFalse(vehicle.getEngineCapacity().equals("11"));
        vehicle.setEngineCapacity("qwe");
        assertTrue(vehicle.getEngineCapacity().equals("11cc"));
        assertFalse(vehicle.getEngineCapacity().equals("qwe"));
    }

    @Test
    void getNumberOfPassengers() {
        assertTrue(vehicle.getNumberOfPassengers().equals("2"));
        assertFalse(vehicle.getNumberOfPassengers().equals("4"));
    }

    @Test
    void setNumberOfPassengers() {
        vehicle.setNumberOfPassengers("11");
        assertTrue(vehicle.getNumberOfPassengers().equals("11"));
        assertFalse(vehicle.getNumberOfPassengers().equals("asd"));
        vehicle.setNumberOfPassengers("asd");
        assertTrue(vehicle.getNumberOfPassengers().equals("11"));
        assertFalse(vehicle.getNumberOfPassengers().equals("asd"));
    }

    @Test
    void getCombinedEfficiency() {
        assertTrue(vehicle.getCombinedEfficiency().equals("35mpg"));
        assertFalse(vehicle.getCombinedEfficiency().equals("35"));
    }

    @Test
    void setCombinedEfficiency() {
        vehicle.setCombinedEfficiency("11");
        assertTrue(vehicle.getCombinedEfficiency().equals("11mpg"));
        assertFalse(vehicle.getCombinedEfficiency().equals("11"));
        vehicle.setCombinedEfficiency("asd");
        assertTrue(vehicle.getCombinedEfficiency().equals("11mpg"));
        assertFalse(vehicle.getCombinedEfficiency().equals("asd"));
    }

    @Test
    void getVehicleCategory() {
        assertTrue(vehicle.getVehicleCategory().equals("Economy"));
        assertFalse(vehicle.getVehicleCategory().equals("asd"));
    }

    @Test
    void setVehicleCategory() {
        vehicle.setVehicleCategory("Premium");
        assertTrue(vehicle.getVehicleCategory().equals("Premium"));
        assertFalse(vehicle.getVehicleCategory().equals("asd"));
        vehicle.setVehicleCategory("123");
        assertTrue(vehicle.getVehicleCategory().equals("Premium"));
        assertFalse(vehicle.getVehicleCategory().equals("123"));
    }

    @Test
    void getNumberOfFreeMiles() {
        assertTrue(vehicle.getNumberOfFreeMiles() == 22);
        assertFalse(vehicle.getNumberOfFreeMiles() == 11);
    }

    @Test
    void setNumberOfFreeMiles() {
        vehicle.setNumberOfFreeMiles(11);
        assertTrue(vehicle.getNumberOfFreeMiles() == 11);
        assertFalse(vehicle.getNumberOfFreeMiles() == 22);
    }

    @Test
    void getFuelType() {
        assertTrue(vehicle.getFuelType().equals("asd"));
        assertFalse(vehicle.getFuelType().equals("qwe"));
    }

    @Test
    void setFuelType() {
        vehicle.setFuelType("qwe");
        assertTrue(vehicle.getFuelType().equals("qwe"));
        assertFalse(vehicle.getFuelType().equals("asd"));
    }

    @Test
    void getRate() {
        MathContext mc = new MathContext(2);
        assertTrue(vehicle.getRate().equals(new BigDecimal("0.129", mc)));
        assertFalse(vehicle.getRate().equals(new BigDecimal("0.15", mc)));
    }

    @Test
    void setRate() {
        MathContext mc = new MathContext(2);
        vehicle.setRate(new BigDecimal("5.199", mc));
        assertTrue(vehicle.getRate().equals(new BigDecimal("5.199", mc)));
        assertFalse(vehicle.getRate().equals(new BigDecimal("6.199", mc)));
    }

}