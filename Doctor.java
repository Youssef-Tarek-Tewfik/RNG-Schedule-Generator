package emotionalSupport;

public class Doctor extends Instructor
{
    public Doctor(String Name, String Email, String PhoneNumber)
    {
        super(Name, Email, PhoneNumber);
    }
    public Doctor(Instructor OtherInstructor)
    {
        super(OtherInstructor);
    }
    
}
