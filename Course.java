package emotionalSupport;

public class Course {
    private final String id;
    public final String name;
    
    public Doctor doctor;
    public TeachingAssistant ta[];
    public LessonDetails details;
    
    public Course(String id, String name, LessonDetails lessonDetails, Doctor doctor, TeachingAssistant[] TAs)
    {
        this.id = id;
        this.name = name;
        this.details = lessonDetails;	
        this.doctor = doctor;
        this.ta = TAs;
    }

	public String getID() {
		return id;
	}
}
