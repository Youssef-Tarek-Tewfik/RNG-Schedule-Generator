package emotionalSupport;

public class TeachingAssistant extends Instructor
{
    public TeachingAssistant(String Name, String Email, String PhoneNumber)
    {
        super(Name, Email, PhoneNumber);
    }
    
    public TeachingAssistant(Instructor OtherInstructor)
    {
        super(OtherInstructor);
    }
}
