package emotionalSupport;

public class LessonDetails {
    public int no_of_lecs, no_of_sections;
    public float lec_hrs, sec_hrs;
    public int lectureAttendees, sectionAttendees;
    
	public LessonDetails(int no_of_lecs, int no_of_sections, float lec_hrs, float sec_hrs, int lectureAttendees,
			int sectionAttendees) 
	{
		this.no_of_lecs = no_of_lecs;
		this.no_of_sections = no_of_sections;
		this.lec_hrs = lec_hrs;
		this.sec_hrs = sec_hrs;
		this.lectureAttendees = lectureAttendees;
		this.sectionAttendees = sectionAttendees;
	}
	
	public LessonDetails(int no_of_lecs, int no_of_sections, float lec_hrs, float sec_hrs)
	{
		this(no_of_lecs, no_of_sections, lec_hrs, sec_hrs, 0, 0);
	}	
}