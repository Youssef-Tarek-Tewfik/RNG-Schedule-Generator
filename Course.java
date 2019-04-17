package emotionalSupport;

public class Course {
    private final String id;
    private final String name;
    public class LessonDetails {
        public int no_of_lecs, no_of_sections;
        public float lec_hrs, sec_hrs;
        public int lectureAttendees, sectionAttendees;
		public LessonDetails(int no_of_lecs, int no_of_sections, float lec_hrs, float sec_hrs, int lectureAttendees,
				int sectionAttendees) {
			super();
			this.no_of_lecs = no_of_lecs;
			this.no_of_sections = no_of_sections;
			this.lec_hrs = lec_hrs;
			this.sec_hrs = sec_hrs;
			this.lectureAttendees = lectureAttendees;
			this.sectionAttendees = sectionAttendees;
		}
    }
    
    private Doctor doctor;
    private TeachingAssistant ta[];
    
    public Course(String id, String name, ) {
		this.ID = ID;
		this.Name = Name;
		this.No_of_lecs = No_of_lecs;
		this.No_of_sections = No_of_sections;
		this.No_of_labs = No_of_labs;
		this.Lec_hrs = Lec_hrs;
		this.Sec_hrs = Sec_hrs;
		this.t = t;
		this.ta = ta;
    }

    public String getID() {
        return ID;
    }

    public int getNo_of_lecs() {
        return No_of_lecs;
    }

    public String getName() {
        return Name;
    }

    public int getNo_of_sections() {
        return No_of_sections;
    }

    public int getNo_of_labs() {
        return No_of_labs;
    }

    public int getLec_hrs() {
        return Lec_hrs;
    }

    public int getSec_hrs() {
        return Sec_hrs;
    }

    public int getLab_hrs() {
        return Lab_hrs;
    }

    public int getNo_of_TAs() {
        return No_of_TAs;
    }
}
