// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: Fokker100.java
// Date: 4 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

public class Fokker100 extends Plane
{
    // Constructor
    public Fokker100(int scheduleDate)    
    {
        super(scheduleDate);
        super.setSeatsPassenger(Values.ECONOMY_SEATS_FOKKER);
        super.setSeatsBusiness(Values.BUSINESS_SEATS_FOKKER);
    }

    // Display
    @Override
    public String toString()
    {
        return "";
    }
    
}
