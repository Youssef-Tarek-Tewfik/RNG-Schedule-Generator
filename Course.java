package emotionalSupport;

public class Course {
    private final String id;
    public final String name;
    
    public String[] doctors;
    public String[] tAs;
    public String[] rooms;
    public LessonDetails details;
    
    public Course(String id, String name, LessonDetails lessonDetails, String[] doctors, String[] TAs, String[] rooms) {
		this.id = id;
		this.name = name;
		this.details = lessonDetails;	
		this.doctors = doctors;
		this.tAs = TAs;
    }

	public String getID() {
		return id;
	}
}
