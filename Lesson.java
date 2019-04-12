package emotionalSupport;

import java.util.Objects;


public class Lesson
{
    public enum LessonType
    {
            Lecture,
            Section
    }
	
    public LessonType lessonType;
    public Course course;
    public Instructor instructor;
    public Room room;
    public TimePeriod TimeFrame;
    private static int Count = 0;

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Lesson other = (Lesson) obj;
        
        if (!this.room.equals(other.room) && !this.instructor.equals(other.instructor))
        {
            return false;
        }
        else if(this.room.equals(other.room) && this.TimeFrame.equals(other.TimeFrame))
        {
            return true;
        }
        else if(this.instructor.equals(other.instructor) && this.TimeFrame.equals(other.TimeFrame))
        {
            return true;
        }
        
        return false;
    }

    
    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.lessonType);
        hash = 59 * hash + Objects.hashCode(this.course);
        hash = 59 * hash + Objects.hashCode(this.instructor);
        hash = 59 * hash + Objects.hashCode(this.room);
        hash = 59 * hash + Objects.hashCode(this.TimeFrame);
        return hash;
    }

    public Lesson(Instructor instructor, Room room, TimePeriod TimeFrame)
    {
        this.lessonType = lessonType;
        //this.course = course;
        this.instructor = instructor;
        this.room = room;
        this.TimeFrame = TimeFrame;
    }


    public static int getCount() {
        return Count;
    }
}
