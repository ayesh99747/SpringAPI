package lk.ayesh.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This class is the Vehicle class
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
@Data
@Document(collection = "Customers")
public class Customer {
    @Id
    private String Id;

    @Field("customerName")
    private String customerName;
    @Field("emailAddress")
    private String emailAddress;
    @Field("driversLicenseNumber")
    private String driversLicenseNumber;
    @Field("username")
    private String username;
    @Field("password")
    private String password;

    public Customer(String customerName, String emailAddress, String driversLicenseNumber, String username, String password) {
        this.setCustomerName(customerName);
        this.setEmailAddress(emailAddress);
        this.setDriversLicenseNumber(driversLicenseNumber);
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (InputValidator.stringWithLetters(customerName)) {
            this.customerName = customerName;
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        if (InputValidator.emailAddress(emailAddress)) {
            this.emailAddress = emailAddress;
        }
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        if (InputValidator.stringWithNumbers(driversLicenseNumber)) {
            this.driversLicenseNumber = driversLicenseNumber;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (InputValidator.stringWithLetters(username)) {
            this.username = username;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (InputValidator.anyString(password)) {
            this.password = password;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id='" + Id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", driversLicenseNumber='" + driversLicenseNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
