package emotionalSupport;

public class Course {
    private final String id;
    public final String name;
    
    public String[] doctors;
    public String[] tAs;
    public String[] rooms;
    public LessonDetails details;
    
<<<<<<< HEAD
    public Course(String id, String name, LessonDetails lessonDetails, Doctor doctor, TeachingAssistant[] TAs)
    {
        this.id = id;
        this.name = name;
        this.details = lessonDetails;	
        this.doctor = doctor;
        this.ta = TAs;
=======
    public Course(String id, String name, LessonDetails lessonDetails, String[] doctors, String[] TAs, String[] rooms) {
		this.id = id;
		this.name = name;
		this.details = lessonDetails;	
		this.doctors = doctors;
		this.tAs = TAs;
>>>>>>> origin/SomeBranch
    }

	public String getID() {
		return id;
	}
}
