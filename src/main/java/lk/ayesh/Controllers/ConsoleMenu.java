package lk.ayesh.Controllers;

import lk.ayesh.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * This class is the Console Menu class
 * This class handles all the console related functionalities
 * This class is called from the Main class at runtime
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */

@Service
public class ConsoleMenu {
    //A class scope static variable was used for the westminster vehicle manager
    @Autowired
    WestminsterRentalVehicleManager vm1;

    //This method validates the login information
    private static boolean validateLogin(String username, String password) {
        List<Manager> listOfManagers = ManagerLoginInfoManager.getListOfManagers();
        for (Manager manager : listOfManagers) {
            if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                System.out.println("Login Successful!");
                return true;
            } else {
                continue;
            }
        }
        System.out.println("Wrong username or password!");
        System.out.println();
        return false;
    }

    //This is the welcome menu for the console
    public void run() {
        System.out.println("=============================================");
        System.out.println("Welcome to Westminster Rental Vehicle Manager");
        System.out.println("=============================================");
        Scanner sc = new Scanner(System.in);
        //The next few lines contain the login validation
        boolean start = false;
        while (start == false) {
            System.out.print("Please enter the username :");
            String username = sc.next().trim();
            System.out.print("Please enter the password :");
            String password = sc.next().trim();
            start = validateLogin(username, password);
        }
        //Once the admin is logged in successfully the following lines are entered
        char exit = 'c';
        while (exit != 'e') {
            System.out.println();
            System.out.println("What action would you like to carry out?");
            System.out.println("Add a new Vehicle [1]");
            System.out.println("Search whether a vehicle is present [2]");
            System.out.println("Delete a Vehicle [3]");
            System.out.println("Print the list of Vehicles [4]");
            System.out.println("Save to the database [5]");
            System.out.println("Save to Text File [6]");
            System.out.println("Generate a report [7]");
            System.out.println("Exit [8]");
            System.out.print("Please select an action: ");
            char input = sc.next().charAt(0);
            switch (input) {
                case '1':
                    addVehicle();//This is vehicle is called to add a vehicle
                    break;
                case '2':
                    findVehicle();//This method is used to find a vehicle
                    break;
                case '3':
                    deleteVehicle();//This method will delete a vehicle
                    break;
                case '4':
                    printListOfVehicles();//This method will print all the vehicles out in the console
                    break;
                case '5':
                    saveToDatabase();//This method will save all the vehicles to the database
                    break;
                case '6':
                    saveToTextFile();
                    break;
                case '7':
                    try {
                        generateReport();//This method will produce an excel sheet with all the vehicles and the attributes
                    } catch (IOException e) {
                        System.out.println("Error in generating report!");
                    }
                    break;
                case '8':
                    saveToDatabase();//This method will save all the vehicles to the database
                    exit = 'e';//This can be used to exit the program
                    System.out.println("Exiting Console...");
                    break;
                default:
                    System.out.println("An invalid character has been entered!");//This will be displayed if the character entered has no method
            }

        }
        System.out.println("Console closed");
    }

    private void saveToTextFile() {
        vm1.saveTextToFile();
    }

    /*
     * This method is used to add the vehicle
     * The user is first asked which type of vehicle they are adding
     * Then the user is prompted for all the common attributes
     * Then the user is prompted for the vehicle specific variables
     * Finally the object is created
     * and the vehicle is passed to the addVehicle method in the
     * WestminsterRentalVehicleManager
     * All the inputs are validated as soon as they are entered*/
    private void addVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter which vehicle you wish to add: ");
        while (true) {
            System.out.println("Car [1]");
            System.out.println("Motorbike [2]");
            System.out.println("Van [3]");
            System.out.print("Choice: ");
            char vehicleType = sc.next().charAt(0);
            sc.nextLine();
            if (vehicleType == '1' || vehicleType == '2' || vehicleType == '3') {
                System.out.println("Please enter the vehicle details");
                System.out.print("Enter the plate number: ");
                String plateNumber = "";
                while (true) {
                    plateNumber = sc.nextLine().trim();
                    if (InputValidator.stringWithNumbersAndLetters(plateNumber) == true) {
                        if (vm1.isVehiclePresent(plateNumber) == false) {
                            System.out.println("The plate number is : " + plateNumber);
                            break;
                        } else {
                            System.out.print("Please Re-Enter the plate number: ");
                            continue;
                        }
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.print("Please Re-Enter the plate number: ");
                        continue;
                    }
                }
                System.out.print("Enter the make: ");
                String make = "";
                while (true) {
                    make = sc.nextLine().trim();
                    if (InputValidator.stringWithLetters(make) == true) {
                        System.out.println("The make is : " + make);
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.print("Please Re-Enter the make: ");
                        continue;
                    }
                }
                System.out.print("Enter the model: ");
                String model = "";
                while (true) {
                    model = sc.nextLine().trim();
                    if (InputValidator.stringWithNumbersAndLetters(model) == true) {
                        System.out.println("The model is : " + model);
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.print("Please Re-Enter the make: ");
                        continue;
                    }
                }
                System.out.print("Enter the year of manufacture: ");
                String yearOfManufacture = "";
                while (true) {
                    yearOfManufacture = sc.nextLine().trim();
                    if (InputValidator.stringWithNumbers(yearOfManufacture) == true && yearOfManufacture.length() == 4) {
                        System.out.println("The Year Of Manufacture is : " + yearOfManufacture);
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.print("Please Re-Enter the year of manufacture: ");
                        continue;
                    }
                }
                System.out.print("Enter the transmission type: ");
                String transmissionType = "";
                while (true) {
                    transmissionType = sc.nextLine().trim();
                    if (InputValidator.stringWithLetters(transmissionType) == true) {
                        System.out.println("The transmission type is : " + transmissionType);
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.print("Please Re-Enter the transmission type: ");
                        continue;
                    }
                }
                System.out.print("Enter the engine capacity: ");
                String engineCapacity = "";
                while (true) {
                    engineCapacity = sc.nextLine().trim();
                    if (InputValidator.stringWithNumbers(engineCapacity) == true && Integer.parseInt(engineCapacity) > 0) {
                        System.out.println("The engine capacity is : " + engineCapacity);
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.print("Please Re-Enter the engine capacity: ");
                        continue;
                    }
                }
                System.out.print("Enter the number of passengers: ");
                String numberOfPassengers = "";
                while (true) {
                    numberOfPassengers = sc.nextLine().trim();
                    if (InputValidator.stringWithNumbers(numberOfPassengers) == true && Integer.parseInt(numberOfPassengers) > 0) {
                        System.out.println("The number of passenger(s) are : " + numberOfPassengers);
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.print("Please Re-Enter the number of passengers: ");
                        continue;
                    }
                }
                System.out.print("Enter the Combined Efficiency: ");
                String combinedEfficiency = "";
                while (true) {
                    combinedEfficiency = sc.nextLine().trim();
                    if (InputValidator.stringWithNumbers(combinedEfficiency) == true && Integer.parseInt(combinedEfficiency) > 0) {
                        System.out.println("The combined efficiency is : " + combinedEfficiency);
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.print("Please Re-Enter the Combined Efficiency: ");
                        continue;
                    }
                }
                System.out.print("Enter the vehicle category: ");
                String vehicleCategory = "";
                while (true) {
                    vehicleCategory = sc.nextLine().trim();
                    if (InputValidator.stringWithLetters(vehicleCategory) == true) {
                        System.out.println("The vehicle category is : " + vehicleCategory);
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.print("Please Re-Enter the vehicle category: ");
                        continue;
                    }
                }
                System.out.print("Enter the number of free miles: ");
                int numberOfFreeMiles = 0;
                while (true) {
                    try {
                        numberOfFreeMiles = sc.nextInt();
                        if (numberOfFreeMiles > 0) {
                            System.out.println("The number of free miles are : " + numberOfFreeMiles);
                            break;
                        } else {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                            System.out.print("Please Re-Enter the number of free miles: ");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Input!");
                        sc.nextLine();
                        System.out.print("Please Re-Enter the number of free miles: ");
                        continue;
                    }

                }
                System.out.print("Enter the fuel type: ");
                sc.nextLine();
                String fuelType = "";
                while (true) {
                    fuelType = sc.nextLine().trim();
                    if (InputValidator.stringWithLetters(fuelType) == true) {
                        System.out.println("The fuel type is : " + fuelType);
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.print("Please Re-Enter the fuel type: ");
                        continue;
                    }
                }
                System.out.print("Enter the rate[xxx.xx]: ");
                double rate = 0.00;
                while (true) {
                    try {
                        rate = sc.nextDouble();
                        if (InputValidator.bigDecimals(rate) == true) {
                            System.out.println("The rate is : " + rate);
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid Input!");
                            System.out.print("Please Re-Enter the rate: ");
                            sc.nextLine();
                            continue;
                        }
                    } catch (Exception e) {
                        break;
                    }
                }
                switch (vehicleType) {
                    case '1':
                        System.out.print("Enter the number of suitcases: ");
                        String numberOfSuitcases = "";
                        while (true) {
                            numberOfSuitcases = sc.nextLine().trim();
                            if (InputValidator.stringWithNumbers(numberOfSuitcases) == true && Integer.parseInt(numberOfSuitcases) > 0) {
                                System.out.println("The number of suitcase(s) are : " + numberOfSuitcases);
                                break;
                            } else {
                                System.out.println("Invalid Input!");
                                System.out.print("Please Re-Enter the number of suitcases: ");
                                continue;
                            }
                        }
                        System.out.print("Enter the number of doors: ");
                        String numberOfDoors = "";
                        while (true) {
                            numberOfDoors = sc.nextLine().trim();
                            if (InputValidator.stringWithNumbers(numberOfDoors) == true && Integer.parseInt(numberOfDoors) > 0) {
                                System.out.println("The number of doors are : " + numberOfDoors);
                                break;
                            } else {
                                System.out.println("Invalid Input!");
                                System.out.print("Please Re-Enter the number of doors: ");
                                continue;
                            }
                        }
                        System.out.print("Enter the body type: ");
                        String bodyType = "";
                        while (true) {
                            bodyType = sc.nextLine().trim();
                            if (InputValidator.stringWithLetters(bodyType) == true) {
                                System.out.println("The Body Type is : " + bodyType);
                                break;
                            } else {
                                System.out.println("Invalid Input!");
                                System.out.print("Please Re-Enter the body type: ");
                                continue;
                            }
                        }
                        vm1.addVehicle(new Car(plateNumber, make, model, yearOfManufacture, transmissionType, engineCapacity, numberOfPassengers, combinedEfficiency, vehicleCategory, numberOfFreeMiles, fuelType, new BigDecimal(rate), new Schedule(), numberOfSuitcases, numberOfDoors, bodyType));
                        break;
                    case '2':
                        System.out.print("Enter the type of motorbike: ");
                        String motorbikeType = "";
                        while (true) {
                            motorbikeType = sc.nextLine().trim();
                            if (InputValidator.stringWithLetters(motorbikeType) == true) {
                                System.out.println("The motorbike type is :  " + motorbikeType);
                                break;
                            } else {
                                System.out.println("Invalid Input!");
                                System.out.print("Please Re-Enter the type of motorbike: ");
                                continue;
                            }
                        }

                        char isHelmetProvidedInput = '0';
                        boolean isHelmetProvided = false;
                        System.out.print("Enter whether the helmet is provided[y/n]: ");
                        while (true) {
                            isHelmetProvidedInput = sc.nextLine().trim().toLowerCase().charAt(0);
                            if (isHelmetProvidedInput == ('y')) {
                                isHelmetProvided = true;
                                System.out.println("Helmet is provided");
                                break;
                            } else if (isHelmetProvidedInput == ('n')) {
                                isHelmetProvided = false;
                                System.out.println("Helmet is not provided");
                                break;
                            } else {
                                System.out.println("Invalid Input!");
                                System.out.print("Please Re-Enter whether the helmet is provided[y/n]: ");
                                continue;
                            }
                        }

                        char isSideCarPresentInput = '0';
                        boolean isSideCarPresent = false;
                        System.out.print("Enter whether the side car is present[y/n]: ");
                        while (true) {
                            isSideCarPresentInput = sc.nextLine().trim().toLowerCase().charAt(0);
                            if (isSideCarPresentInput == ('y')) {
                                isSideCarPresent = true;
                                System.out.println("Side car is present");
                                break;
                            } else if (isSideCarPresentInput == ('n')) {
                                isSideCarPresent = false;
                                System.out.println("Side car is absent");
                                break;
                            } else {
                                System.out.println("Invalid Input!");
                                System.out.print("Please Re-Enter whether the side car is present[y/n]: ");
                                continue;
                            }
                        }

                        vm1.addVehicle(new Motorbike(plateNumber, make, model, yearOfManufacture, transmissionType, engineCapacity, numberOfPassengers, combinedEfficiency, vehicleCategory, numberOfFreeMiles, fuelType, new BigDecimal(rate), new Schedule(), motorbikeType, isHelmetProvided, isSideCarPresent));
                        break;
                    case '3':
                        System.out.print("Enter the number of suitcases: ");
                        numberOfSuitcases = "";
                        while (true) {
                            numberOfSuitcases = sc.nextLine().trim();
                            if (InputValidator.stringWithNumbers(numberOfSuitcases) == true) {
                                System.out.println("The number of suitcases : " + numberOfSuitcases);
                                break;
                            } else {
                                System.out.println("Invalid Input!");
                                System.out.print("Please Re-Enter the number of suitcases: ");
                                continue;
                            }
                        }
                        System.out.print("Enter the number of doors: ");
                        numberOfDoors = "";
                        while (true) {
                            numberOfDoors = sc.nextLine().trim();
                            if (InputValidator.stringWithNumbers(numberOfDoors) == true) {
                                System.out.println("The number of doors : " + numberOfDoors);
                                break;
                            } else {
                                System.out.println("Invalid Input!");
                                System.out.print("Please Re-Enter the number of doors: ");
                                continue;
                            }
                        }
                        vm1.addVehicle(new Van(plateNumber, make, model, yearOfManufacture, transmissionType, engineCapacity, numberOfPassengers, combinedEfficiency, vehicleCategory, numberOfFreeMiles, fuelType, new BigDecimal(rate), new Schedule(), numberOfSuitcases, numberOfDoors));
                        break;
                    default:
                        System.out.println("Invalid vehicle Type!");
                        System.out.print("Please Re-Enter the vehicle type: ");
                        break;
                }
                break;
            } else {
                System.out.println("Invalid Input");
                System.out.println("Please Re-Enter the vehicle you wish to add: ");
                continue;
            }
        }
    }

    //This method generates a report in an excel sheet
    private void generateReport() throws IOException {
        vm1.generateReport();
    }

    //This method saves the list to the database
    private void saveToDatabase() {
        vm1.saveToDatabase();
    }

    //This method displays all the vehicles
    private void printListOfVehicles() {
        vm1.printListOfVehicles();
    }

    //This deletes a vehicle from the listOfVehicles
    private void deleteVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the plate number of the vehicle you wish to delete: ");
        String plateNumber = "";
        while (true) {
            plateNumber = sc.nextLine().trim();
            if (InputValidator.stringWithNumbersAndLetters(plateNumber) == true) {
                if (vm1.isVehiclePresent(plateNumber) == true) {
                    break;
                } else {
                    System.out.println("Vehicle does not exist");
                    System.out.print("Please Re-Enter the plate number of the vehicle you wish to delete: ");
                    continue;
                }
            } else {
                System.out.println("Invalid Input!");
                System.out.print("Please Re-Enter the plate number of the vehicle you wish to delete: ");
                continue;
            }
        }
        vm1.deleteVehicle(plateNumber);
    }

    //This method searches for a vehicle and displays the attributes.
    private void findVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter the plate number of the vehicle you wish to find: ");
        String plateNumber = "";
        while (true) {
            plateNumber = sc.nextLine().trim();
            if (InputValidator.stringWithNumbersAndLetters(plateNumber) == true) {
                break;
            } else {
                System.out.println("Invalid Input!");
                System.out.print("Please Re-Enter the plate number of the vehicle you wish to find: ");
                continue;
            }
        }
        if (vm1.isVehiclePresent(plateNumber) == true) {
            System.out.println("Vehicle has been found!");
            System.out.println(vm1.getVehicle(plateNumber).toString());
        } else {
            System.out.println("Vehicle does not exist!");
        }
    }
}
