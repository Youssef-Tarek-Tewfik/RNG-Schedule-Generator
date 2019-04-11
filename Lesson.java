package emotionalSupport;

public class Lesson {
	public enum LessonType {
		Lecture,
		Section
	}
	
	public LessonType lessonType;
	public Course course;
    public Instructor instructor;
    public Room room;
    private int startTime;
    private int endTime;
    private static int Count = 0;

    @Override
    public boolean equals(Object obj) { // false = yet7at
    	Lesson other = (Lesson) obj;
    	if (!this.room.equals(other.room))
    		return false;
    	
    	// TBA Day, Time and Instructor overlapping
    }
    
    public Lesson(Course c, Instructor t, Hall hall, LessonType lt) {
        lessonType = lt;
        course = c;
        instructor = (lt == LessonType.Lecture)? (Doctor) t: (TeachingAssistant) t;
        Count++;
        // TBA Day and Time initializations
    }

    public static int getCount() {
        return Count;
    }
}
