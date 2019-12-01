package lk.ayesh.Models;

import java.util.Date;

public class Schedule {
    private Date pickUpDate;
    private Date dropOffDate;

    public Schedule() {
        this.pickUpDate = null;
        this.dropOffDate = null;
    }


    public Schedule(Date pickUpDate, Date dropOffDate) {
        if (dropOffDate.compareTo(pickUpDate) == 1) {
            this.pickUpDate = pickUpDate;
            this.dropOffDate = dropOffDate;
        } else {
            System.out.println("Invalid drop off date!");
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

    @Override
    public String toString() {
        return "Schedule{" +
                "pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }
}
