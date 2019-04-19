package emotionalSupport;

import java.util.HashMap;
import java.util.Objects;


public class Instructor
{
    protected String Name,Email,PhoneNumber;
    int ID;
    static int Count = DataManager.AllDoctors.size() + DataManager.AllTeachingAssistants.size();

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
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        return true;
    }

    public Instructor(Instructor OtherInstructor)
    {
        this.ID = OtherInstructor.ID;
        this.Name = OtherInstructor.Name;
        this.Email = OtherInstructor.Email;
        this.PhoneNumber = OtherInstructor.PhoneNumber;
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

  
      
}
