package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

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
    }

    @Test
    void setPlateNumber() {
        vehicle.setPlateNumber("test");
        assertTrue(vehicle.getPlateNumber().equals("test"));
    }

    @Test
    void getMake() {
        assertTrue(vehicle.getMake().equals("asd"));
    }

    @Test
    void setMake() {
        vehicle.setMake("test");
        assertTrue(vehicle.getMake().equals("test"));
    }

    @Test
    void getModel() {
        assertTrue(vehicle.getModel().equals("asd"));
    }

    @Test
    void setModel() {
        vehicle.setModel("test");
        assertTrue(vehicle.getModel().equals("test"));
    }

    @Test
    void getYearOfManufacture() {
        assertTrue(vehicle.getYearOfManufacture().equals("2000"));
    }

    @Test
    void setYearOfManufacture() {
        vehicle.setYearOfManufacture("1999");
        assertTrue(vehicle.getYearOfManufacture().equals("1999"));
    }

    @Test
    void getTransmissionType() {
        assertTrue(vehicle.getTransmissionType().equals("asd"));
    }

    @Test
    void setTransmissionType() {
        vehicle.setTransmissionType("test");
        assertTrue(vehicle.getTransmissionType().equals("test"));
    }

    @Test
    void getEngineCapacity() {
        assertTrue(vehicle.getEngineCapacity().equals("32cc"));
    }

    @Test
    void setEngineCapacity() {
        vehicle.setEngineCapacity("11");
        assertTrue(vehicle.getEngineCapacity().equals("11cc"));
    }

    @Test
    void getNumberOfPassengers() {
        assertTrue(vehicle.getNumberOfPassengers().equals("2"));
    }

    @Test
    void setNumberOfPassengers() {
        vehicle.setNumberOfPassengers("11");
        assertTrue(vehicle.getNumberOfPassengers().equals("11"));
    }

    @Test
    void getCombinedEfficiency() {
        assertTrue(vehicle.getCombinedEfficiency().equals("35mpg"));
    }

    @Test
    void setCombinedEfficiency() {
        vehicle.setCombinedEfficiency("11");
        assertTrue(vehicle.getCombinedEfficiency().equals("11mpg"));
    }

    @Test
    void getVehicleCategory() {
        assertTrue(vehicle.getVehicleCategory().equals("Economy"));
    }

    @Test
    void setVehicleCategory() {
        vehicle.setVehicleCategory("Premium");
        assertTrue(vehicle.getVehicleCategory().equals("Premium"));
    }

    @Test
    void getNumberOfFreeMiles() {
        assertTrue(vehicle.getNumberOfFreeMiles() == 22);
    }

    @Test
    void setNumberOfFreeMiles() {
        vehicle.setNumberOfFreeMiles(11);
        assertTrue(vehicle.getNumberOfFreeMiles() == 11);
    }

    @Test
    void getFuelType() {
        assertTrue(vehicle.getFuelType().equals("asd"));
    }

    @Test
    void setFuelType() {
        vehicle.setFuelType("qwe");
        assertTrue(vehicle.getFuelType().equals("qwe"));
    }

    @Test
    void getRate() {
        MathContext mc = new MathContext(2);
        assertTrue(vehicle.getRate().equals(new BigDecimal("0.129", mc)));
    }

    @Test
    void setRate() {
        MathContext mc = new MathContext(2);
        vehicle.setRate(new BigDecimal("5.199", mc));
        assertTrue(vehicle.getRate().equals(new BigDecimal("5.199", mc)));
    }

}