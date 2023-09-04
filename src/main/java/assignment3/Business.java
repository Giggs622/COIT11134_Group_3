// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: Business.java
// Date: 4 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

import java.time.LocalDate;

public class Business extends Passenger
{
    // Instance variables
    private float businessBaggage;
    
    // Constructor
    public Business(int bookingID, LocalDate bookingDate, String bookingName, String bookingDOB, String bookingEmail, String bookingPhone, float businessBaggage)
    {
        super(bookingID, bookingDate, bookingName, bookingDOB, bookingEmail, bookingPhone);
        this.businessBaggage = businessBaggage;
    }

    // Business Baggage Getter and Setter
    public float getBusinessBaggage()
    {
        return businessBaggage;
    }

    public void setBusinessBaggage(float businessBaggage)
    {
        this.businessBaggage = businessBaggage;
    }

    // Display
    @Override
    public String toString()
    {
        return "Business{" + "businessBaggage=" + businessBaggage + '}';
    }
    
    
}
