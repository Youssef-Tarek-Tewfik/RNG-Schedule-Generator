package emotionalSupport;

public class Course
{
    private String ID;
    private String Name;
    private int No_of_lecs, No_of_sections, No_of_labs;
    private int Lec_hrs, Sec_hrs, Lab_hrs;
    private int No_of_TAs;
    private Teacher t;
    private TA ta[] = new TA[No_of_TAs]; 
    private Hall hall;
    private Room room [] = new Room [No_of_sections] ;
    private Lab lab[] = new Lab [No_of_labs];

	public Course (String ID, String Name, int No_of_lecs, int No_of_sections, int No_of_labs,
			 int Lec_hrs, int Sec_hrs, int Lab_hrs, int No_of_TAs,
			 Teacher t, TA ta[], Hall hall, Room room[], Lab lab[])
	{
		this.ID = ID;
		this.Name = Name;
		this.No_of_lecs = No_of_lecs;
		this.No_of_sections = No_of_sections;
		this.No_of_labs = No_of_labs;
		this.Lec_hrs = Lec_hrs;
		this.Sec_hrs = Sec_hrs;
		this.Lab_hrs = Lab_hrs;
		this.No_of_TAs =No_of_TAs;
		this.t = t;
		this.ta = ta;
		this.hall = hall;
		this.room = room;
		this.lab = lab;
	
	 }

    public int getNo_of_lecs() {
        return No_of_lecs;
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