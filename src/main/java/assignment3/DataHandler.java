// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: DataHandler.java
// Date: 7 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataHandler
{

    // Declare variables
    private final String FILE_NAME = "passenger.txt";
    private ArrayList<Passenger> passengerList;

    // Constructor
    public DataHandler() throws FileNotFoundException
    {
        this.passengerList = new ArrayList<Passenger>();
        readDataFilePassenger();
    }

    // Method to read data file and store passengers into passengerList ArrayList
    private void readDataFilePassenger() throws FileNotFoundException
    {
        try
        {
            Scanner in = new Scanner(new FileReader(FILE_NAME)); //open file
            String myEntry = "";
            int bookingId = 0;
            String bookingDate = "";
            String bookingName = "";
            String bookingEmail = "";
            String bookingPhone = "";
            String bookingClass = "";
            String bookingDestintation = "";

            while (in.hasNextLine())
            {
                myEntry = in.nextLine();
                StringTokenizer st = new StringTokenizer(myEntry, ",");

                while (st.hasMoreTokens())
                {
                    bookingId = Integer.parseInt(st.nextToken());
                    bookingDate = st.nextToken();
                    bookingName = st.nextToken();
                    bookingEmail = st.nextToken();
                    bookingPhone = st.nextToken();
                    bookingClass = st.nextToken();
                    bookingDestintation = st.nextToken();
                }

                Passenger passenger = new Passenger(bookingId, bookingDate, bookingName, bookingEmail, bookingPhone, bookingClass, bookingDestintation);
                addPassenger(passenger);

            } //end of while loop

            in.close();//close file
        }
        catch (ArrayIndexOutOfBoundsException | FileNotFoundException ex)
        {

        }
    }//end of the readDataFile method

    //Method for saving all passengers in passengerList ArrayList to the text file
    public void saveDataPassenger()
    {
        try
        {
            Formatter out = new Formatter(FILE_NAME);    //open file     

            for (Passenger curPassenger : passengerList)
            {
                out.format("%s\n", curPassenger.fileSavePrint());
            }

            out.close();//close file
        }
        catch (SecurityException | FileNotFoundException ex)
        {

        }

    }//end of the SaveData method 

    // Method to add a booking to the ArrayList
    public void addPassenger(Passenger p)
    {
        passengerList.add(p);
    }

    // Method to get the ArrayList passengerList
    public ArrayList<Passenger> getArrayList()
    {
        return passengerList;
    }

    // Method to find the last booking ID in the ArrayList and return the index
    public int findLastBookingID()
    {
        // Initialise variable to store last booking number found
        int lastBookingID = 0;

        // Search through the ArrayList and change the variable if a larger number is found
        for (Passenger p : passengerList)
        {
            if (p.getBookingID() > lastBookingID)
            {
                lastBookingID = p.getBookingID();
            }
        }

        // return the last booking ID number index found
        return lastBookingID;
    }

    // Method to find the booking number user inputs and return either the 
    // ArrayList element number if found or -1 if not found
    public int findBookingID(int bookingID)
    {
        // Declare variables
        int index = -1;                 // Store array index number if found or pass number < 0
        int arrayCounter = 0;           // Count to which array index is found in for loop

        // Check every element in ListArray for matching member ID
        for (Passenger p : passengerList)
        {
            if (bookingID == p.getBookingID())
            {
                index = arrayCounter;
            }
            arrayCounter++;
        }

        // Return the index number
        return index;
    }

    // Method to delete an passenger from the ArrayList
    public void deleteBooking(int index)
    {
        passengerList.remove(index);
        saveDataPassenger();
    }
}
