package emotionalSupport; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    public static HashMap<String,Course>AllCourses;
    public static HashMap<String,Doctor>AllDoctors;
    public static HashMap<String,TeachingAssistant>AllTeachingAssistants;
    public static HashMap<String,Room>AllRooms;
        
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
    public static void ReadData()
    {
        ReadFile("Doctors.txt");
        ReadFile("TeachingAssistants.txt");
        ReadFile("Courses.txt");
        ReadFile("Rooms.txt");
    }
    
    public static void ReWriteAllData()
    {
        WriteDoctors("Doctors.txt");
        WriteTAs("TeachingAssistants.txt");
        WriteRooms("Rooms.txt");
        WriteCourses("Courses.txt");
    }
    
    private static void WriteRooms(String FileName)
    {
        try 
        {
            FileWriter MyFile = new FileWriter(FileName);
            BufferedWriter MyBufferedWriter = new BufferedWriter(MyFile);
            
            for(String CurrentRoom : AllRooms.keySet())
            {
                MyBufferedWriter.write(AllRooms.get(CurrentRoom).toString()+ "\n");
            }
            
            MyBufferedWriter.close();         
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + FileName + "'");
            File file = new File(FileName);
            try 
            {
                file.createNewFile();
                WriteRooms(FileName);
				
            } 
            catch (IOException e)
            {
                System.out.println("Error Creating File");
            }
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + FileName + "'");                  
        }
    }
    
    private static void WriteDoctors(String FileName)
    {
        try 
        {
      
            FileWriter MyFile = new FileWriter(FileName);
            BufferedWriter MyBufferedWriter = new BufferedWriter(MyFile);
            
            for(String CurrentDoctor : AllDoctors.keySet())
            {
                MyBufferedWriter.write(AllDoctors.get(CurrentDoctor).toString()+ "\n");
            }
            
            MyBufferedWriter.close();         
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + FileName + "'");
            File file = new File(FileName);
            try 
            {
		file.createNewFile();
		WriteDoctors(FileName);
				
            }
            catch (IOException e)
            {
                System.out.println("Error Creating File");
            }
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + FileName + "'");                  
        }
    }
    
    private static void WriteTAs(String FileName)
    {
        try 
        {      
            FileWriter MyFile = new FileWriter(FileName);
            BufferedWriter MyBufferedWriter = new BufferedWriter(MyFile);
            
            for(String CurrentDoctor : AllTeachingAssistants.keySet())
            {
                MyBufferedWriter.write(AllTeachingAssistants.get(CurrentDoctor).toString()+ "\n");
            }
            
            MyBufferedWriter.close();         
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + FileName + "'");   
            File file = new File(FileName);
            try 
            {
		file.createNewFile();
		WriteTAs(FileName);
				
            }
            catch (IOException e)
            {
		System.out.println("Error Creating File");
            }
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + FileName + "'");                  
        }
    }
    
    public static void AddCourseToFile(Course NewCourse,String FileName)
    {      
        try 
        {      
            FileWriter MyFile = new FileWriter(FileName,true);
            BufferedWriter MyBufferedWriter = new BufferedWriter(MyFile);
            
            MyBufferedWriter.write(NewCourse.toString()+"\n");
            
            MyBufferedWriter.close();         
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + FileName + "'");   
            File file = new File(FileName);
            try 
            {
		file.createNewFile();
		AddCourseToFile(NewCourse,FileName);
				
            }
            catch (IOException e)
            {
		System.out.println("Error Creating File");
            }
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + FileName + "'");                  
        }
    }
    
    public static void WriteCourses(String FileName)
    {
        try 
        {      
            FileWriter MyFile = new FileWriter(FileName);
            BufferedWriter MyBufferedWriter = new BufferedWriter(MyFile);
            
            for(String CurrentCourse : AllCourses.keySet())
            {
                MyBufferedWriter.write(AllCourses.get(CurrentCourse).toString()+ "\n");
            }
            
            MyBufferedWriter.close();         
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + FileName + "'");   
            File file = new File(FileName);
            try 
            {
		file.createNewFile();
		WriteCourses(FileName);
				
            }
            catch (IOException e)
            {
		System.out.println("Error Creating File");
            }
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + FileName + "'");                  
        }
    }
    
    
    private static void ReadFile(String FileName)
    {
        String CurrentLine = null;
        try 
        {
      
            FileReader MyReader = new FileReader(FileName);

            BufferedReader MyBufferedReader = new BufferedReader(MyReader);

            while((CurrentLine = MyBufferedReader.readLine()) != null)
            {
               String []Information= CurrentLine.split("/");
               
               if(FileName.equals("Doctors.txt"))
               {
                   Doctor CurrentDoctor = new Doctor(Information[0],Information[1],Information[2]);
                   AllDoctors.put(CurrentDoctor.getName(),CurrentDoctor);
               }
               else if(FileName.equals("TeachingAssistants.txt"))
               {
                  TeachingAssistant CurrentTeachingAssistant = new TeachingAssistant(Information[0],Information[1],Information[2]);
                  AllTeachingAssistants.put(CurrentTeachingAssistant.getName(),CurrentTeachingAssistant);
               }
               else if (FileName.equals("Courses.txt"))
               {
                   String Name = Information[0];
                   LessonDetails Details;                 
                   ArrayList<String> Doctors = new  ArrayList<String>();
                    ArrayList<String> TAs = new  ArrayList<String>();
                   ArrayList<String> Rooms = new ArrayList<String>();
                   String []DetailInfo = Information[1].split("-");
                   String []DoctorNames = Information[2].split("!");
                   String []TANames = Information[3].split("@");
                   String []RoomNames = Information[4].split("#");
                   Details = new LessonDetails(Integer.parseInt(DetailInfo[0]),Integer.parseInt(DetailInfo[1]), Float.parseFloat(DetailInfo[2]), Float.parseFloat(DetailInfo[3]));
                   for(String CurrentDoctor : DoctorNames)
                   {
                       Doctors.add(CurrentDoctor);
                   }
                   for(String CurrentTA : TANames)
                   {
                       TAs.add(CurrentTA);
                   }
                   for(String CurrentRoom : RoomNames)
                   {
                        Rooms.add(CurrentRoom);
                   }
                   Course CurrentCourse = new Course(Name, Details, Doctors, TAs, Rooms);
                   AllCourses.put(Name, CurrentCourse);
               }
               else if(FileName.equals("Rooms.txt"))
               {
                   Room CurrentRoom  = new Room(Information[1], 4);
                   AllRooms.put(Information[1], CurrentRoom);
               }
               
            }   

            MyBufferedReader.close();         
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + FileName + "'");
            File file = new File(FileName);
            try 
            {
                file.createNewFile();
                ReadFile(FileName);
				
            } 
            catch (IOException e)
            {
                System.out.println("Error Creating File");
            }
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + FileName + "'");                  
        }
    }   
}
