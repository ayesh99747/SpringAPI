package lk.ayesh.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This class is the Manager class
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */

@Data
@Document(collection = "Managers")
public class Manager {
    @Id
    private String Id;  //This is a manger id

    @Field("employeeID")
    private String employeeID;  //This is the employee id of teh manager
    @Field("username")
    private String username;    //This is the username
    @Field("password")
    private String password;    //This is the password

    //This is the manager constructor
    public Manager(String employeeID, String username, String password) {
        this.setEmployeeID(employeeID);
        this.setUsername(username);
        this.setPassword(password);
    }

    //The following are getter and setter methods
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        if (InputValidator.stringWithNumbersAndLetters(employeeID)) {
            this.employeeID = employeeID;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (InputValidator.anyString(username)) {
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

    //This is the toString method
    @Override
    public String toString() {
        return "Manager{" +
                "Id='" + Id + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
