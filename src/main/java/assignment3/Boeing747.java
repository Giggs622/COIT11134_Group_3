// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: Boeing747.java
// Date: 4 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

import java.time.LocalDate;

public class Boeing747 extends Plane
{
    // Instance variables
    private int seatsFirstClass;

    // Constructor

    public Boeing747(int seatsFirstClass, LocalDate scheduleDate)
    {
        super(scheduleDate);
        super.setSeatsPassenger(Values.ECONOMY_SEATS_BOEING);
        super.setSeatsBusiness(Values.BUSINESS_SEATS_BOEING);
        this.seatsFirstClass = Values.FIRST_CLASS_SEATS_BOEING;
    }
    
    
    // First Class Seats Getter and Setter
    public int getSeatsFirstClass()
    {
        return seatsFirstClass;
    }

    public void setSeatsFirstClass(int seatsFirstClass)
    {
        this.seatsFirstClass = seatsFirstClass;
    }

    // Display
    @Override
    public String toString()
    {
        return "";
    }
    
}
