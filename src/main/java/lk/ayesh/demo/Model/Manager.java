package lk.ayesh.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Managers")
public class Manager {
    @Id
    private String Id;

    @Field("employeeID")
    private String employeeID;
    @Field("username")
    private String username;
    @Field("password")
    private String password;

    public Manager(String employeeID, String username, String password) {
        this.employeeID = employeeID;
        this.username = username;
        this.password = password;
    }

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
        this.employeeID = employeeID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
