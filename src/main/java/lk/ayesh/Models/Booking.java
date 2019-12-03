package lk.ayesh.Models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * This class is the booking class.
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
@Data
@Document(collection = "Bookings")
public class Booking {
    @Id
    private String BookingId;   //This is the booking id

    @Field("username")
    private String username;    //This is the username
    @Field("plateNumber")
    private String plateNumber; //This is the car plate number
    @Field("pickUpDate")
    @JsonFormat(pattern = "yyyy-MM-dd") //This is the pick up date
    private Date pickUpDate;
    @Field("dropOffDate")
    @JsonFormat(pattern = "yyyy-MM-dd") //This is the drop off date
    private Date dropOffDate;
    @Field("bookedDate")
    @JsonFormat(pattern = "yyyy-MM-dd") //This is the date it was booked
    private Date bookedDate;

    //This is the booking constructor
    public Booking(String username, String plateNumber, Date pickUpDate, Date dropOffDate, Date bookedDate) {
        this.setUsername(username);
        this.setPlateNumber(plateNumber);
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.bookedDate = bookedDate;
    }

    //Following are the getters and setters
    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (InputValidator.stringWithNumbersAndLetters(username)) {
            this.username = username;
        }
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        if (InputValidator.plateNumbers(plateNumber)) {
            this.plateNumber = plateNumber;
        }
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    //This is the toString method
    @Override
    public String toString() {
        return "Booking{" +
                "BookingId='" + BookingId + '\'' +
                ", username='" + username + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                ", bookedDate=" + bookedDate +
                '}';
    }
}
