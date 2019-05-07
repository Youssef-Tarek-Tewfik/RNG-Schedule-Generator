package emotionalSupport;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Mohamed Amr
 * A class for all the course details
 */

public class Course   
{
  /** Each course has an id depends on "count variable" */
    private final int id; 
                                 /** Each course has a name */
    public final String name; 
    /** to know the number of courses
     * also used for determining the course ID
     */
    static int Count = DataManager.AllCourses.size(); 
                                           /** Each course is given by a doctor or more. */
    public  ArrayList<String> Doctors;
                                           /** Each course is assigned to a number of TA's. */
    public  ArrayList<String> TAs; 
                                           /** Each course is assigned to specific rooms. */
    public ArrayList<String> Rooms;
                                           /**  For more course details. */
    public LessonDetails Details; 
    
    /**
     * 
     * @param name To set the name of the course.
     * @param lessonDetails  To set  details for each course.
     */
    public Course(String name, LessonDetails lessonDetails)
    {
        this.name = name;
        this.Details = lessonDetails;	
        /** 
         * ID depends on the number of courses
         */
        id = ++Count;  
    }
    /**
     * Constructor for assigning the course to the instructors and it's rooms.
     * @param name Course name
     * @param lessonDetails More course details.
     * @param doctors Course Doctor
     * @param TAs Course teaching assistants
     * @param rooms  Course rooms
     */
    public Course(String name, LessonDetails lessonDetails,  ArrayList<String> doctors,  ArrayList<String> TAs, ArrayList<String> rooms)
    {
        id = ++Count;
        this.name = name;
        this.Details = lessonDetails;	
        this.Doctors = doctors;
        this.TAs = TAs;
        this.Rooms = rooms;
    }
   /**
    * 
    * @return Course name 
    */
    public String getName()
    {
        return name;
    }
    /**
     * 
     * @return A random doctor to give the Lecture. 
     */
    public String GetRandomDoctor()
    {
        return Doctors.get(new Random().nextInt(Doctors.size()));
    }
    /**
     * 
     * @return a random TA to give section or lab 
     */
    
    public String GetRandomTA()
    {
        return TAs.get(new Random().nextInt(TAs.size()));
    }
    /**
     * 
     * @return a random room for a lecture, a section or a lab 
     */
    public String GetRandomRoom()
    {
        return Rooms.get(new Random().nextInt(Rooms.size()));
    }
    /**
     * used for checking 
     * "console only" and not used in the GUI
     * @return 
     */
    
    @Override
    public String toString()
    {
        String Result = name + "/" + Details.toString() + "/";
        
        for(String CurrentDoctor : Doctors)
        {
            Result += CurrentDoctor + "!";
        }
        Result = Result.substring(0, Result.length()-1);
        Result += "/";
        for(String CurrentTA : TAs)
        {
            Result += CurrentTA + "@";
        }
        Result = Result.substring(0, Result.length()-1);
        Result += "/";
        for(String CurrentRoom : Rooms)
        {
            Result += CurrentRoom + "#";
        }
        Result = Result.substring(0, Result.length()-1);
        return Result;
    }
    
   
    /**
     * 
     * @return course ID 
     */
    public int getID()
    {
            return id;
    }
}
