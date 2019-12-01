package lk.ayesh.Controllers;

import lk.ayesh.Models.*;
import lk.ayesh.Repositories.VehicleRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is the Westminster Rental Vehicle Manager class
 * This class implements the functions in the Rental Vehicle Manager Interface
 * This class is called from the ConsoleMenu Class to perform operations on the listOfVehicles
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */

@Service
public class WestminsterRentalVehicleManager implements RentalVehicleManager {
    private static List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();

    @Autowired
    public VehicleRepository vehicleRepository;

    public static List<Vehicle> getListOfVehicles() {
        return listOfVehicles;
    }

    public static void addVehicleFromDatabase(List<Vehicle> listOfVehiclesFromDb) {
        listOfVehicles.clear();
        System.out.println("Vehicles added to list");
        for (Vehicle vehicle : listOfVehiclesFromDb) {
            listOfVehicles.add(vehicle);
            System.out.println(vehicle);
        }
    }

    //This method returns true or false depending whether the given vehicle is present or not
    public boolean isVehiclePresent(String plateNumber) {
        for (Vehicle v1 : listOfVehicles) {
            if (plateNumber.equals(v1.getPlateNumber())) {
                return true;
            }
        }
        return false;
    }

    public String updateVehicleSchedule(String plateNumber, Date pickUpDate, Date dropOffDate) {
        vehicleRepository.deleteAll();
        String totalAmount = null;
        long difference = dropOffDate.getTime() - pickUpDate.getTime();
        MathContext m = new MathContext(2);
        String daysBetween = String.valueOf((difference / (1000 * 60 * 60 * 24)) + 1.0);
        BigDecimal b1 = new BigDecimal(daysBetween, m);
        for (Vehicle v : listOfVehicles) {
            if (v.getPlateNumber().equals(plateNumber)) {
                v.setScheduleForVehicle(new Schedule(pickUpDate, dropOffDate));
                BigDecimal b3 = b1.multiply(v.getRate(), m);
                totalAmount = String.valueOf(b3);
                System.out.println(v);
            }
            vehicleRepository.insert(v);
        }
        return totalAmount;
    }

    //This method adds vehicles to the listOfVehicles
    @Override
    public void addVehicle(Vehicle v) {
        if (v != null) {
            if (isVehiclePresent(v.getPlateNumber()) == false) {
                listOfVehicles.add(v);
                System.out.println("New Vehicle added : " + v);
            } else {
                System.out.println("Vehicle already exists!");
            }
        } else {
            System.out.println("Vehicle is Empty!");
        }
    }

    //This method gets the vehicle requested using the plate number from the listOfVehicles
    public Vehicle getVehicle(String plateNumber) {
        for (Vehicle v1 : listOfVehicles) {
            if (plateNumber.equals(v1.getPlateNumber())) {
                return v1;
            }
        }
        return null;
    }

    //This method deletes vehicles from the listOfVehicles
    @Override
    public void deleteVehicle(String plateNumber) {
        for (Vehicle v1 : listOfVehicles) {
            if (v1.getPlateNumber().equals(plateNumber)) {
                listOfVehicles.remove(v1);
                System.out.println("Vehicle deleted successfully!");
                break;
            }
        }
    }

    //This method generates a report of all the available vehicles in the listOfVehicles
    @Override
    public void generateReport() throws IOException {
        List<Vehicle> sortedListOfVehicles = listOfVehicles;
        sortedListOfVehicles.sort(Vehicle::compareTo);
        if (listOfVehicles.size() > 0) {
            String[] vehicleAttributes = {"Plate Number", "Make", "Model", "Year of Manufacture", "Transmission Type", "Engine Capacity", "Number of Passengers", "Combined Efficiency", "Vehicle Category", "Number of Free miles", "Fuel Type", "Rate", "Pickup Date", "Drop Off Date", "Number of Suitcases", "Number of Doors", "Body Type", "Motorbike Type", "Helmet Provided", "Side Car Present"};

            // This creates a new Excel Workbook
            Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

            /* CreationHelper helps us create instances of various things like DataFormat,
            Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
            CreationHelper createHelper = workbook.getCreationHelper();

            // Create a Sheet
            Sheet sheet = workbook.createSheet("Vehicles");

            // Create a Font for styling header cells
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);


            // Create a CellStyle with the font
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Create a Row
            Row headerRow = sheet.createRow(0);

            // Create cells
            for (int i = 0; i < vehicleAttributes.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(vehicleAttributes[i]);
                cell.setCellStyle(headerCellStyle);
            }

            // Create Cell Style for formatting Date
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

            // Create Other rows and cells with employees data
            int rowNum = 1;
            for (Vehicle vehicle : sortedListOfVehicles) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(vehicle.getPlateNumber());

                row.createCell(1).setCellValue(vehicle.getMake());

                row.createCell(2).setCellValue(vehicle.getModel());

                row.createCell(3).setCellValue(vehicle.getYearOfManufacture());

                row.createCell(4).setCellValue(vehicle.getTransmissionType());

                row.createCell(5).setCellValue(vehicle.getEngineCapacity());

                row.createCell(6).setCellValue(vehicle.getNumberOfPassengers());

                row.createCell(7).setCellValue(vehicle.getCombinedEfficiency());

                row.createCell(8).setCellValue(vehicle.getVehicleCategory());

                row.createCell(9).setCellValue(vehicle.getNumberOfFreeMiles());

                row.createCell(10).setCellValue(vehicle.getFuelType());

                row.createCell(11).setCellValue(vehicle.getRate().toString());

                row.createCell(12).setCellValue(vehicle.getScheduleForVehicle().getPickUpDate());

                row.createCell(13).setCellValue(vehicle.getScheduleForVehicle().getDropOffDate());

                if (vehicle instanceof Car) {
                    row.createCell(14).setCellValue(((Car) vehicle).getNumberOfDoors());
                    row.createCell(15).setCellValue(((Car) vehicle).getNumberOfSuitcases());
                    row.createCell(16).setCellValue(((Car) vehicle).getBodyType());
                    row.createCell(17).setCellValue("N/A");
                    row.createCell(18).setCellValue("N/A");
                    row.createCell(19).setCellValue("N/A");
                } else if (vehicle instanceof Van) {
                    row.createCell(14).setCellValue(((Van) vehicle).getNumberOfDoors());
                    row.createCell(15).setCellValue(((Van) vehicle).getNumberOfSuitcases());
                    row.createCell(16).setCellValue("N/A");
                    row.createCell(17).setCellValue("N/A");
                    row.createCell(18).setCellValue("N/A");
                    row.createCell(19).setCellValue("N/A");
                } else if (vehicle instanceof Motorbike) {
                    row.createCell(14).setCellValue("N/A");
                    row.createCell(15).setCellValue("N/A");
                    row.createCell(16).setCellValue("N/A");
                    row.createCell(17).setCellValue(((Motorbike) vehicle).getMotorbikeType());
                    row.createCell(18).setCellValue(((Motorbike) vehicle).isHelmetProvided());
                    row.createCell(19).setCellValue(((Motorbike) vehicle).isSideCarPresent());
                }
            }

            // This will Resize all columns to fit the text size
            for (int i = 0; i < vehicleAttributes.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream("Vehicle Report - " + LocalDate.now() + ".xlsx");
            workbook.write(fileOut);
            fileOut.close();

            System.out.println("Excel Sheet Produced Successfully!");
            // Closing the workbook
            workbook.close();
        } else {
            System.out.println("There are no available vehicles!");
        }
    }

    //This method save the listOfVehicles to the database
    @Override
    public void saveToDatabase() {
        vehicleRepository.deleteAll();
        for (Vehicle vehicle : listOfVehicles) {
            vehicleRepository.insert(vehicle);
        }
        System.out.println("Successfully saved to database!");
    }

    //This method prints the list of vehicles from the listOfVehicles
    public void printListOfVehicles() {
        List<Vehicle> sortedListOfVehicles = listOfVehicles;
        sortedListOfVehicles.sort(Vehicle::compareTo);
        for (Vehicle v1 : sortedListOfVehicles) {
            if (v1 instanceof Car) {
                System.out.println("Plate Number : " + v1.getPlateNumber());
                System.out.println("Type Of Vehicle : Car");
                System.out.println();
            } else if (v1 instanceof Van) {
                System.out.println("Plate Number : " + v1.getPlateNumber());
                System.out.println("Type Of Vehicle : Van");
                System.out.println();
            } else if (v1 instanceof Motorbike) {
                System.out.println("Plate Number : " + v1.getPlateNumber());
                System.out.println("Type Of Vehicle : Motorbike");
                System.out.println();
            }
        }
    }

    public void saveTextToFile() {
        List<Vehicle> sortedListOfVehicles = listOfVehicles;
        sortedListOfVehicles.sort(Vehicle::compareTo);
        File file = new File("Vehicle Stock List.txt");
        try (FileWriter fw = new FileWriter(file, true)) {
            try (PrintWriter pw = new PrintWriter(fw, true)) {
                for (Vehicle v : sortedListOfVehicles) {
                    if (v instanceof Car) {
                        pw.println("Vehicle Type : Car");
                    } else if (v instanceof Van) {
                        pw.println("Vehicle Type : Van");
                    } else if (v instanceof Motorbike) {
                        pw.println("Vehicle Type : Motorbike");
                    }
                    pw.println("Plate Number : " + v.getPlateNumber());
                    pw.println("Make : " + v.getMake());
                    pw.println("Model : " + v.getMake());
                    pw.println("Year Of Manufacture : " + v.getYearOfManufacture());
                    pw.println("Transmission Type : " + v.getTransmissionType());
                    pw.println("Engine Capacity : " + v.getEngineCapacity());
                    pw.println("Number Of Passengers : " + v.getNumberOfPassengers());
                    pw.println("Combined Efficiency : " + v.getCombinedEfficiency());
                    pw.println("Vehicle Category : " + v.getVehicleCategory());
                    pw.println("Number Of Free Miles : " + v.getNumberOfFreeMiles());
                    pw.println("Fuel Type : " + v.getFuelType());
                    pw.println("Rate : " + v.getRate().toString());
                    pw.println("Vehicle Category : " + v.getVehicleCategory());
                    pw.println("Schedule For Vehicle - ");
                    pw.println("    Pick Up Date : " + v.getScheduleForVehicle().getPickUpDate());
                    pw.println("    Drop Off Date : " + v.getScheduleForVehicle().getDropOffDate());
                    if (v instanceof Car) {
                        pw.println("Number Of Suitcases : " + ((Car) v).getNumberOfSuitcases());
                        pw.println("Number Of Doors : " + ((Car) v).getNumberOfDoors());
                        pw.println("Number Of BodyType : " + ((Car) v).getBodyType());
                        pw.println();
                    } else if (v instanceof Van) {
                        pw.println("Number Of Suitcases : " + ((Van) v).getNumberOfSuitcases());
                        pw.println("Number Of Doors : " + ((Van) v).getNumberOfDoors());
                        pw.println();
                    } else if (v instanceof Motorbike) {
                        pw.println("Motorbike Type : " + ((Motorbike) v).getMotorbikeType());
                        pw.println("Is Helmet Provided : " + ((Motorbike) v).isHelmetProvided());
                        pw.println("Is Side Car Present : " + ((Motorbike) v).isSideCarPresent());
                        pw.println();
                    }
                }
                System.out.println("File write successful");
            }
        } catch (IOException e) {
            System.err.println("Error Occurred" + e.getMessage());
        }
    }
}
