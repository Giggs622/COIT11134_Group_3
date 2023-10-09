// Programmer: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
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
    public DataHandler(String passengertxt) throws FileNotFoundException
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
        catch (ArrayIndexOutOfBoundsException ex)
        {

        }
        catch (FileNotFoundException ex)
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
                out.format("%s\n", curPassenger.toString());
            }

            out.close();//close file
        }
        catch (SecurityException | FileNotFoundException ex)
        {

        }

    }//end of the SaveData method 
    
    public void addPassenger(Passenger p)
    {
        passengerList.add(p);
    }
}