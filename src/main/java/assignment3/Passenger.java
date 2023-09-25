// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: Passenger.java
// Date: 4 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

public class Passenger 
{
    // Instance Variables
    private int bookingID;
    private String bookingDate;
    private String bookingName;
    private String bookingEmail;
    private String bookingPhone;
    private String bookingClass;
    private String bookingDestination;
    
    // Contructor
    public Passenger(int bookingID, String bookingDate, String bookingName, String bookingEmail, String bookingPhone, String bookingClass, String bookingDestination)
    {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.bookingName = bookingName;
        this.bookingEmail = bookingEmail;
        this.bookingPhone = bookingPhone;
        this.bookingClass = bookingClass;
        this.bookingDestination = bookingDestination;
    }

    // Booking ID Getter and Setter
    public int getBookingID()
    {
        return bookingID;
    }

    public void setBookingID(int bookingID)
    {
        this.bookingID = bookingID;
    }

    // Booking Date Getter and Setter
    public String getBookingDate()
    {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate)
    {
        this.bookingDate = bookingDate;
    }

    // Booking Name Getter and Setter
    public String getBookingName()
    {
        return bookingName;
    }

    public void setBookingName(String bookingName)
    {
        this.bookingName = bookingName;
    }

    // Booking Email Address Getter and Setter
    public String getBookingEmail()
    {
        return bookingEmail;
    }

    public void setBookingEmail(String bookingEmail)
    {
        this.bookingEmail = bookingEmail;
    }

    // Booking Phone Number Getter and Setter
    public String getBookingPhone()
    {
        return bookingPhone;
    }

    public void setBookingPhone(String bookingPhone)
    {
        this.bookingPhone = bookingPhone;
    }

    // Booking Class Getter and Setter
    public String getBookingClass()
    {
        return bookingClass;
    }

    public void setBookingClass(String bookingClass)
    {
        this.bookingClass = bookingClass;
    }

    // Booking Destination Getter and Setter
    public String getBookingDestination()
    {
        return bookingDestination;
    }

    public void setBookingDestination(String bookingDestination)
    {
        this.bookingDestination = bookingDestination;
    }
    
    // Print object
    @Override
    public String toString()
    {
        return String.format("%s,%s,%s,%s,%s,%s,%s,", bookingID, bookingDate, bookingName, bookingEmail, bookingPhone, bookingClass, bookingDestination);
    }
    
}
