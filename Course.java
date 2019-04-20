package emotionalSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Course
{
    private final int id;
    public final String name;
    static int Count = DataManager.AllCourses.size();
    public HashMap<String ,Integer> Doctors;
    public HashMap<String ,Integer> TAs;
    public HashMap<String ,Integer> Rooms;
    public LessonDetails Details;
    
    
    public Course(String name, LessonDetails lessonDetails)
    {
        this.name = name;
        this.Details = lessonDetails;	
        id = ++Count;  
    }
    
    public Course(String name, LessonDetails lessonDetails, HashMap<String ,Integer> doctors, HashMap<String ,Integer> TAs, HashMap<String ,Integer> rooms)
    {
        id = ++Count;
        this.name = name;
        this.Details = lessonDetails;	
        this.Doctors = doctors;
        this.TAs = TAs;
        this.Rooms = rooms;
    }

    public String getName()
    {
        return name;
    }
    
    public String GetFreestDoctor()
    {
        String Name = "";
        int Min = 9999;
        for(Map.Entry<String,Integer> CurrentDoctor : Doctors.entrySet())
        {
            if(CurrentDoctor.getValue() < Min)
            {
                Min = CurrentDoctor.getValue();
                Name = CurrentDoctor.getKey();
            }
        }
        Doctors.put(Name,Doctors.get(Name)+1);
        return Name;
    }
    
    public String GetFreestTA()
    {
        String Name = "";
        int Min = 9999;
        for(Map.Entry<String,Integer> CurrentTA : TAs.entrySet())
        {
            if(CurrentTA.getValue() < Min)
            {
                Min = CurrentTA.getValue();
                Name = CurrentTA.getKey();
            }
        }
        TAs.put(Name, TAs.get(Name)+1);
        return Name;
    }
    
    public String GetFreestRoom()
    {
        String Name = "";
        int Min = 9999;
        for(Map.Entry<String,Integer> CurrentRoom : Rooms.entrySet())
        {
            if(CurrentRoom.getValue() < Min)
            {
                Min = CurrentRoom.getValue();
                Name = CurrentRoom.getKey();
            }
        }
        //Rooms.put(Name, Rooms.get(Name)+1);
        return Name;
    }
    

    public void Reset()
    {
        for(Integer DoctorLessons : Doctors.values())
        {
            DoctorLessons= 0;
        }
        for(Integer TALessons : TAs.values())
        {
            TALessons = 0;
        }
        for(Integer RoomLessons : Rooms.values())
        {
            RoomLessons= 0;
        }
    }
    
    @Override
    public String toString()
    {
        String Result = name + "/" + Details.toString() + "/";
        
        for(String CurrentDoctor : Doctors.keySet())
        {
            Result += CurrentDoctor + "!";
        }
        Result = Result.substring(0, Result.length()-1);
        Result += "/";
        for(String CurrentTA : TAs.keySet())
        {
            Result += CurrentTA + "@";
        }
        Result = Result.substring(0, Result.length()-1);
        Result += "/";
        for(String CurrentRoom : Rooms.keySet())
        {
            Result += CurrentRoom + "#";
        }
        Result = Result.substring(0, Result.length()-1);
        return Result;
    }
    
   
    
    public int getID()
    {
            return id;
    }
}
