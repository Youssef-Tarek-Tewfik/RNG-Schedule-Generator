class Lesson
{
    
    private String Type;              // Lecture / section / lab
    private String Name;              // subject Name
    private String Teacher;
    private String Place;             // class/section/lab
    private String Time; 
    private static int Count;

    Lesson(Course c,Doctor t,Hall hall,String Time)    //Lecture
    {
        Type = "Lecture";
        Name = c.getName();
        Teacher = t.getName();
        Count++;
    }
    
    Lesson(Course c,TeachingAssistant ta,Room r,Lab lab,String Time)                                          // section 
    {
        Type = "section";
        Name = c.getName();
        Teacher = ta.getName();
        Count++;
        
    }

    public static int getCount() {
        return Count;
    }
    
   
    
    
    
}
