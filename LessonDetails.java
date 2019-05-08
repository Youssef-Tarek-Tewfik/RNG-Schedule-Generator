package emotionalSupport;
/**
 * a class for more course  details 
 * @author Mohamed Amr
 */

public class LessonDetails
{
                                               /**course number of lectures per week */
    public int no_of_lecs;
                                               /**course number of sections per week */
    public int no_of_sections;
                                               /** A one lecture number of hours */
    public int lec_hrs;
                                               /**A one section number of hours*/
    public int sec_hrs;
                                               /** Number of students per lecture */
    public int lectureAttendees;
                                                /** Number of students per Section or Lab */
    public int sectionAttendees;
    
            /**
     * 
     * @param no_of_lecs course number of lectures per week
     * @param no_of_sections course number of sections per week
     * @param lec_hrs  A one lecture number of hours
     * @param sec_hrs A one section number of hours
     * @param lectureAttendees Number of students per lecture
     * @param sectionAttendees Number of students per Section or Lab
     */
	public LessonDetails(int no_of_lecs, int no_of_sections, int lec_hrs, int sec_hrs, int lectureAttendees,
			int sectionAttendees) 
	{
		this.no_of_lecs = no_of_lecs;
		this.no_of_sections = no_of_sections;
		this.lec_hrs = lec_hrs;
		this.sec_hrs = sec_hrs;
		this.lectureAttendees = lectureAttendees;
		this.sectionAttendees = sectionAttendees;
	}
	
        /**
         * Constructor without the number of attendees
         *  
         */
	public LessonDetails(int no_of_lecs, int no_of_sections, int lec_hrs, int sec_hrs)
	{
		this(no_of_lecs, no_of_sections, lec_hrs, sec_hrs, 0, 0);
	}

    @Override
    public String toString()
    {
        return no_of_lecs + "-" + no_of_sections + "-" + lec_hrs + "-" + sec_hrs;
    }
        
}