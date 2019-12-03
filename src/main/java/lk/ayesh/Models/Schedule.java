package lk.ayesh.Models;

import java.util.Date;

/**
 * This class is the Schedule class
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
public class Schedule {
    private Date pickUpDate;    //This is the pick up date
    private Date dropOffDate;   //This is the drop off date

    //This constructor is used when a vehicle is first created
    public Schedule() {
        this.pickUpDate = null;
        this.dropOffDate = null;
    }

    //This is used when a vehicle is booked
    public Schedule(Date pickUpDate, Date dropOffDate) {
        if (dropOffDate.compareTo(pickUpDate) >= 0) {
            this.pickUpDate = pickUpDate;
            this.dropOffDate = dropOffDate;
        } else {
            System.out.println("Invalid drop off date!");
        }
    }

    //The following are the getters and setters
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

    //The following is the toString method
    @Override
    public String toString() {
        return "Schedule{" +
                "pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }
}
