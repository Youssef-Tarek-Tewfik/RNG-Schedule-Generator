package emotionalSupport; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed Hatem
 */
public final class DataManager
{
    private static String Location;
    static HashMap<String,Course>AllCourses;
    static HashMap<String,Doctor>AllDoctors;
    static HashMap<String,TeachingAssistant>AllTeachingAssistants;
    static HashMap<String,Room>AllRooms;
        
    private DataManager()
    {       
    }
    
    public static void Intialize()
    {
        AllCourses = new HashMap<String, Course>();
        AllDoctors = new HashMap<String,Doctor>();
        AllTeachingAssistants = new HashMap<String,TeachingAssistant>();
        AllRooms = new HashMap<String,Room>();
    }
    public static void ReadData(String Path)
    {
        Location = Path;
        ReadFile(Location + "Doctors.txt");
        ReadFile(Location + "TeachingAssistants.txt");
        ReadFile(Location + "Courses.txt");
        ReadFile(Location + "Rooms.txt");
    }
    
    private static void ReadFile(String FileName)
    {
        String CurrentLine = null;
        try 
        {
            // FileReader reads text files in the default encoding.
            FileReader MyReader = new FileReader(FileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader MyBufferedReader = new BufferedReader(MyReader);

            while((CurrentLine = MyBufferedReader.readLine()) != null)
            {
               String []Information= CurrentLine.split("/");
               
               if(FileName.equals(Location + "Doctors.txt"))
               {
                   Doctor CurrentDoctor = new Doctor(Information[0],Information[1],Information[2],Information[3]);
                   System.out.println(CurrentDoctor.toString());
                   AllDoctors.put(CurrentDoctor.getID(),CurrentDoctor);
               }
               else if(FileName.equals(Location + "TeachingAssistants.txt"))
               {
                  TeachingAssistant CurrentTeachingAssistant = new TeachingAssistant(Information[0],Information[1],Information[2],Information[3]);
                  AllTeachingAssistants.put(CurrentTeachingAssistant.getID(),CurrentTeachingAssistant);
               }
               else if (FileName.equals(Location + "Courses.txt"))
               {
                   
               }
               else if(FileName.equals(Location + "Rooms.txt"))
               {
                   
               }
               
            }   

            // Always close files.
            MyBufferedReader.close();         
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + FileName + "'");                
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + FileName + "'");                  
        }
    }   
}
