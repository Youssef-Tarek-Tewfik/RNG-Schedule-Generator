package emotionalSupport;

import java.util.HashMap;
import java.util.Objects;


public class Instructor
{
    protected String Name,Email,PhoneNumber;
    int ID;
    static int Count = DataManager.AllDoctors.size() + DataManager.AllTeachingAssistants.size();
    protected HashMap<String,Course>MyCourses;

    public Instructor(String Name, String Email, String PhoneNumber)
    {
        ID = ++Count;
        this.Name = Name;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Instructor other = (Instructor) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        return true;
    }

    public Instructor(Instructor OtherInstructor) {
        this.ID = OtherInstructor.ID;
        this.Name = OtherInstructor.Name;
        this.Email = OtherInstructor.Email;
        this.PhoneNumber = OtherInstructor.PhoneNumber;
        this.MyCourses = OtherInstructor.MyCourses;
    }
    
   
    
    protected boolean AddCourse(Course NewCourse)
    {
        boolean Present = MyCourses.containsKey(NewCourse.getID());
        if(!Present)
        {
            MyCourses.put(NewCourse.getID(),NewCourse);
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
        boolean Present = MyCourses.containsKey(RemovedCourse.getID());
        if(Present)
        {
            MyCourses.remove(RemovedCourse.getID());
            System.out.println("Removed Course Successfully");
        }
        else
        {
            System.out.println("Cousre Not Found");
        }
        return Present;
    }
    
    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setID(int ID) {
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
        return Name + "/" + Email + "/" + PhoneNumber ;
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
