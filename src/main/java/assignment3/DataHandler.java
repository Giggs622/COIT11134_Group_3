// Programmer: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: DataHandler.java
// Date: 7 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataHandler
{

    // Enter code here
    private final String FILE_NAME_PASSENGER = "passenger.txt";
    private final String FILE_NAME_PLANE = "plane.txt";
    private ArrayList<Passenger> passengerList;
    private ArrayList<Plane> planeList;

    public DataHandler(String type) throws FileNotFoundException
    {
        if (type.equals("passenger"))
        {
            this.passengerList = new ArrayList<Passenger>();
            readDataFilePassenger();
        }
        else if (type.equals("plane"))
        {
            this.planeList = new ArrayList<Plane>();
            readDataFilePlane();
        }
    }
    
    private void readDataFilePassenger() throws FileNotFoundException
    {
	try {
            Scanner in = new Scanner(new FileReader(FILE_NAME_PASSENGER)); //open file
            String myEntry = "";
            String bookingId = "";
            String bookingDate = "";
            String bookingClass = "";
            String bookingName = "";
            String bookingDOB = "";
            String bookingEmail = "";
            String bookingPhone = "";

            while (in.hasNextLine()) {
                myEntry = in.nextLine();
                StringTokenizer st = new StringTokenizer(myEntry, ",");

                while (st.hasMoreTokens()) {
                    bookingId = st.nextToken();
                    bookingDate = st.nextToken();
                    bookingClass = st.nextToken();
                    bookingName = st.nextToken();
                    bookingDOB = st.nextToken();
                    bookingEmail = st.nextToken();
                    bookingPhone = st.nextToken();
                }
                
                int bookingIdNumber = Integer.parseInt(bookingId);
                LocalDate bookingDateParse = LocalDate.parse(bookingDate);
                // Add phone number to the PhoneNo ArrayList
                switch (bookingClass)
                {
                    case "E":
                        Passenger p = new Passenger(bookingIdNumber, bookingDateParse, bookingName, bookingDOB, bookingEmail, bookingPhone);
                        passengerList.add(p);
                        break;
                    case "B":
                        Business b = new Business(bookingIdNumber, bookingDateParse, bookingName, bookingDOB, bookingEmail, bookingPhone);
                        passengerList.add(b);
                        break;
                    case "F":
                        FirstClass f = new FirstClass(bookingIdNumber, bookingDateParse, bookingName, bookingDOB, bookingEmail, bookingPhone);
                        passengerList.add(f);
                        break;
                    default:
                        break;
                }

            }// end of while loop

            in.close();//close file
        } catch (ArrayIndexOutOfBoundsException ex) {
              //JOptionPane.showMessageDialog(null, "ArrayOutOfBoundsException: " + ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
              //JOptionPane.showMessageDialog(null, "FileNotFoundException: " + ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);

        }

     }//end of the readDataFile method
    
    private void readDataFilePlane() throws FileNotFoundException
    {
	try {
            Scanner in = new Scanner(new FileReader(FILE_NAME_PLANE)); //open file
            String myEntry = "";
            String scheduleDate = "";
            String seatsTakenPassenger = "";
            String seatsTakenBusiness = "";
            String seatsTakenFirstClass = "";
            String planeType = "";

            while (in.hasNextLine()) {
                myEntry = in.nextLine();
                StringTokenizer st = new StringTokenizer(myEntry, ",");

                while (st.hasMoreTokens()) {
                    scheduleDate = st.nextToken();
                    seatsTakenPassenger = st.nextToken();
                    seatsTakenBusiness = st.nextToken();
                    seatsTakenFirstClass = st.nextToken();
                    planeType = st.nextToken();
                }
                
                int scheduleDateParse = Integer.parseInt(scheduleDate);
                int seatsTakenPassengerParse = Integer.parseInt(seatsTakenPassenger);
                int seatsTakenBusinessParse = Integer.parseInt(seatsTakenBusiness);
                int seatsTakenFirstClassParse = Integer.parseInt(seatsTakenFirstClass);
                
                // Add phone number to the PhoneNo ArrayList
                switch (planeType)
                {
                    case "F":
                        Fokker100 f = new Fokker100(scheduleDateParse);
                        f.setSeatsTakenPassenger(seatsTakenPassengerParse);
                        f.setSeatsTakenBusiness(seatsTakenBusinessParse);
                        f.setSeatsTakenFirstClass(seatsTakenFirstClassParse);
                        planeList.add(f);
                        break;
                    case "B":
                        Boeing747 b = new Boeing747(scheduleDateParse);
                        b.setSeatsTakenPassenger(seatsTakenPassengerParse);
                        b.setSeatsTakenBusiness(seatsTakenBusinessParse);
                        b.setSeatsTakenFirstClass(seatsTakenFirstClassParse);
                        planeList.add(b);
                        break;
                    default:
                        break;
                }

            }// end of while loop

            in.close();//close file
        } catch (ArrayIndexOutOfBoundsException ex) {
              //JOptionPane.showMessageDialog(null, "ArrayOutOfBoundsException: " + ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
              //JOptionPane.showMessageDialog(null, "FileNotFoundException: " + ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);

        }

     }//end of the readDataFile method
    
     //Method for saving all phone numbers from the phoneNo ArrayList to the text file
   public void saveDataPassenger()
   {
        try
        {
            Formatter out = new Formatter(FILE_NAME_PASSENGER);    //open file     
             
            for (Passenger curPassenger : passengerList)
            {
                out.format("%s\n", curPassenger.toString());
            }            
            //JOptionPane.showMessageDialog(null,"Total records saved: " + totalNumbers, "Data Saved", JOptionPane.INFORMATION_MESSAGE);

            out.close();//close file
           } catch(SecurityException ex)  {
                 //JOptionPane.showMessageDialog(null,"SecurityException: "+ ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
           }  catch(FileNotFoundException ex)   {
                 //JOptionPane.showMessageDialog(null,"FileNotFoundException: " + ex.getMessage(), "Error",JOptionPane.INFORMATION_MESSAGE);
           }

   }//end of the SaveData method 
   
   //Method for saving all phone numbers from the phoneNo ArrayList to the text file
   public void saveDataPlane()
   {
        try
        {
            Formatter out = new Formatter(FILE_NAME_PLANE);    //open file     
             
            for (Plane curPlane : planeList)
            {
                out.format("%s\n", curPlane.toString());
            }            
            //JOptionPane.showMessageDialog(null,"Total records saved: " + totalNumbers, "Data Saved", JOptionPane.INFORMATION_MESSAGE);

            out.close();//close file
           } catch(SecurityException ex)  {
                 //JOptionPane.showMessageDialog(null,"SecurityException: "+ ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
           }  catch(FileNotFoundException ex)   {
                 //JOptionPane.showMessageDialog(null,"FileNotFoundException: " + ex.getMessage(), "Error",JOptionPane.INFORMATION_MESSAGE);
           }

   }//end of the SaveData method 
}
