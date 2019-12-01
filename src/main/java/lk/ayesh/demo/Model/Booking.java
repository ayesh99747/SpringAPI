package lk.ayesh.demo.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "Bookings")
public class Booking {
    @Id
    private String BookingId;

    @Field("username")
    private String username;
    @Field("plateNumber")
    private String plateNumber;
    @Field("pickUpDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date pickUpDate;
    @Field("dropOffDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dropOffDate;
    @Field("bookedDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date bookedDate;

    public Booking(String username, String plateNumber, Date pickUpDate, Date dropOffDate, Date bookedDate) {
        this.username = username;
        this.plateNumber = plateNumber;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.bookedDate = bookedDate;
    }

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
        this.username = username;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
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
