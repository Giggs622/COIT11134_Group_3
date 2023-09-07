// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: Plane.java
// Date: 4 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

public class Plane 
{
    // Instance Variables
    private int scheduleDate;
    private int seatsTakenPassenger;
    private int seatsTakenBusiness;
    private int seatsTakenFirstClass;
    private int seatsPassenger;
    private int seatsBusiness;
    
    // Constructor

    public Plane(int scheduleDate)
    {
        this.scheduleDate = scheduleDate;
        this.seatsTakenPassenger = 0;
        this.seatsTakenBusiness = 0;
        this.seatsTakenFirstClass = 0;
    }
    

    // Schedule Date Getter and Setter
    public int getScheduleDate()
    {
        return scheduleDate;
    }

    public void setScheduleDate(int scheduleDate)
    {
        this.scheduleDate = scheduleDate;
    }

    // Passenger Seats Taken Getter and Setter
    public int getSeatsTakenPassenger()
    {
        return seatsTakenPassenger;
    }

    public void setSeatsTakenPassenger(int seatsTakenPassenger)
    {
        this.seatsTakenPassenger = seatsTakenPassenger;
    }

    // Business Seats Taken Getter and Setter
    public int getSeatsTakenBusiness()
    {
        return seatsTakenBusiness;
    }

    public void setSeatsTakenBusiness(int seatsTakenBusiness)
    {
        this.seatsTakenBusiness = seatsTakenBusiness;
    }

    // First Class Seats Taken Getter and Setter
    public int getSeatsTakenFirstClass()
    {
        return seatsTakenFirstClass;
    }

    public void setSeatsTakenFirstClass(int seatsTakenFirstClass)
    {
        this.seatsTakenFirstClass = seatsTakenFirstClass;
    }

    // Passenger Seats Getter and Setter
    public int getSeatsPassenger()
    {
        return seatsPassenger;
    }

    public void setSeatsPassenger(int seatsPassenger)
    {
        this.seatsPassenger = seatsPassenger;
    }

    // Business Seats Getter and Setter
    public int getSeatsBusiness()
    {
        return seatsBusiness;
    }

    public void setSeatsBusiness(int seatsBusiness)
    {
        this.seatsBusiness = seatsBusiness;
    }
    
    // Display
    @Override
    public String toString()
    {
        return "Plane{" + "scheduleDate=" + scheduleDate + ", seatsTakenPassenger=" + seatsTakenPassenger + ", seatsTakenBusiness=" + seatsTakenBusiness + ", seatsTakenFirstClass=" + seatsTakenFirstClass + '}';
    }
    
}
