
import java.util.HashMap;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed Hatem
 */
public class Instructor
{
    protected String ID,Name,Email,PhoneNumber;
    protected HashMap<String,Course>MyCourses;

    public Instructor(String ID, String Name, String Email, String PhoneNumber)
    {
        this.ID = ID;
        this.Name = Name;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
    }
    
   
    
    protected boolean AddCourse(Course NewCourse)
    {
        boolean Present = MyCourses.containsKey(NewCourse.ID);
        if(!Present)
        {
            MyCourses.put(NewCourse.ID,NewCourse);
            System.out.println("Added Course Successfully");
        }
        else
        {
            System.out.println("Cousre Already Added");
        }
        return !Present;
    }
    
    
    protected boolean RemoveCourse(Course RemovedCourse)
    {
        boolean Present = MyCourses.containsKey(RemovedCourse.ID);
        if(Present)
        {
            MyCourses.remove(RemovedCourse.ID);
            System.out.println("Removed Course Successfully");
        }
        else
        {
            System.out.println("Cousre Not Found");
        }
        return Present;
    }
    
    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Instructor{" + "ID=" + ID + ", Name=" + Name + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + '}';
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public HashMap<String, Course> getMyCourses() {
        return MyCourses;
    }  
      
}
