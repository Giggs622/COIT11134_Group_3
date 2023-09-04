// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: Passenger.java
// Date: 4 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

import java.time.LocalDate;

public class Passenger 
{
    // Instance Variables
    private int bookingID;
    private LocalDate bookingDate;
    private String bookingName;
    private String bookingDOB;
    private String bookingEmail;
    private String bookingPhone;
    
    // Contructor
    public Passenger(int bookingID, LocalDate bookingDate, String bookingName, String bookingDOB, String bookingEmail, String bookingPhone)
    {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.bookingName = bookingName;
        this.bookingDOB = bookingDOB;
        this.bookingEmail = bookingEmail;
        this.bookingPhone = bookingPhone;
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
    public LocalDate getBookingDate()
    {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate)
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

    // Booking Date of Birth Getter and Setter
    public String getBookingDOB()
    {
        return bookingDOB;
    }

    public void setBookingDOB(String bookingDOB)
    {
        this.bookingDOB = bookingDOB;
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

    // Print object
    @Override
    public String toString()
    {
        return "Passenger{" + "bookingID=" + bookingID + ", bookingDate=" + bookingDate + ", bookingName=" + bookingName + ", bookingDOB=" + bookingDOB + ", bookingEmail=" + bookingEmail + ", bookingPhone=" + bookingPhone + '}';
    }
    
}
