package emotionalSupport; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
				
			} catch (IOException e)
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
				
			} catch (IOException e)
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
				
			} catch (IOException e)
            {
				System.out.println("Error Creating File");
			}
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + FileName + "'");                  
        }
    }
    
    public static void AddData(Object Data)
    {
        String FileName="";
        
        if(Data instanceof Doctor)
        {
            FileName = "Doctors.txt";
        }
        else if (Data instanceof TeachingAssistant)
        {
            FileName = "TeachingAssistants.txt";
        }
        else if(Data instanceof Course)
        {
            FileName = "Courses.txt";
        }
        else if(Data instanceof Room)
        {
            FileName= "Rooms.txt";
        }
        
        try
        {
          FileWriter MyFile = new FileWriter(FileName,true);
          BufferedWriter MyBufferedWriter = new BufferedWriter(MyFile);
          MyBufferedWriter.write(Data.toString()+ "\n");
          MyBufferedWriter.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + FileName + "'");     
            File file = new File(FileName);
            try 
            {
				file.createNewFile();
				AddData(Data);
				
			} catch (IOException e)
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
                   System.out.println(CurrentDoctor.toString());
                   AllDoctors.put(CurrentDoctor.getName(),CurrentDoctor);
               }
               else if(FileName.equals("TeachingAssistants.txt"))
               {
                  TeachingAssistant CurrentTeachingAssistant = new TeachingAssistant(Information[0],Information[1],Information[2]);
                  AllTeachingAssistants.put(CurrentTeachingAssistant.getName(),CurrentTeachingAssistant);
               }
               else if (FileName.equals("Courses.txt"))
               {
                   
               }
               else if(FileName.equals("Rooms.txt"))
               {
                   Room CurrentRoom  = new Room(Information[0], 4);
                   AllRooms.put(Information[0], CurrentRoom);
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
				
			} catch (IOException e)
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
