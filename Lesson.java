class Lesson
{
    
    String Type;              // Lecture / section / lab
    String Name;              // subject Name
    String Teacher;
    String Place;             // class/section/lab
    String Time; 
    static int Count;

    Lesson(Course c,Teacher t,Hall hall,String time)    //Lecture
    {
        Type = "Lecture";
        Name = c.getName();
        Teacher = t.getName();
        Count++;
    }
    
    Lesson(Course c,TA ta,Room r,Lab lab)                                          // section 
    {
        Type = "section";
        Name = c.getName();
        Teacher = ta.getName();
        Count++;
        
    }
   
    
    
    
}
