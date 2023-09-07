// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: FirstClass.java
// Date: 4 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

import java.time.LocalDate;

public class FirstClass extends Passenger
{
    // Instance variables
    private float firstClassBaggage;
    
    // Constructor
    public FirstClass(int bookingID, LocalDate bookingDate, String bookingName, String bookingDOB, String bookingEmail, String bookingPhone)
    {
        super(bookingID, bookingDate, bookingName, bookingDOB, bookingEmail, bookingPhone);
        this.firstClassBaggage = Values.FIRST_CLASS_BAGGAGE;
    }

    // First Class Baggage Getter and Setter
    public float getFirstClassBaggage()
    {
        return firstClassBaggage;
    }

    public void setFirstClassBaggage(float firstClassBaggage)
    {
        this.firstClassBaggage = firstClassBaggage;
    }

    // Display
    @Override
    public String toString()
    {
        return "Business{" + "businessBaggage=" + firstClassBaggage + '}';
    }
    
    
}
