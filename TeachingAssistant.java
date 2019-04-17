package emotionalSupport;

public class TeachingAssistant extends Instructor
{
    public TeachingAssistant(String ID, String Name, String Email, String PhoneNumber)
    {
        super(ID, Name, Email, PhoneNumber);
    }
    
    public TeachingAssistant(Instructor OtherInstructor)
    {
        super(OtherInstructor);
    }
}
