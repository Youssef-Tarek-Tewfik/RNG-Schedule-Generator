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
    public String CourseName;
    public String instructor;
    public String room;
    public int Group;
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
        
        if((this.lessonType == LessonType.Lecture || other.lessonType == LessonType.Lecture) && this.TimeFrame.equals(other.TimeFrame))
        {
            return true;
        }
        else if(this.TimeFrame.equals(other.TimeFrame) && this.Group == other.Group)
        {
            return true;
        }
        else if (!this.room.equals(other.room) && !this.instructor.equals(other.instructor))
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
        hash = 59 * hash + Objects.hashCode(this.CourseName);
        hash = 59 * hash + Objects.hashCode(this.instructor);
        hash = 59 * hash + Objects.hashCode(this.room);
        hash = 59 * hash + Objects.hashCode(this.TimeFrame);
        return hash;
    }

    public Lesson(String instructor, String room, TimePeriod TimeFrame, LessonType lessonType, String course,int Group)
    {
        this.lessonType = lessonType;
        this.CourseName = course;
        this.instructor = instructor;
        this.room = room;
        this.TimeFrame = TimeFrame;
        this.Group = Group;
    }
    @Override
    public String toString()
    {
        if(TimeFrame.StartTime > 12)
        {
            TimeFrame.StartTime -=12;
        }
        if(TimeFrame.EndTime > 12)
        {
            TimeFrame.EndTime -=12;
        }
        return("Day : " + TimeFrame.CurrentDay + "\nName : " + CourseName +"\nStartTime : " + TimeFrame.StartTime + "\nEndTime : "
                + TimeFrame.EndTime + "\nType : " + lessonType + " " + Group + "\nInstructor : " + instructor + "\nRoom : " + room);
    }
    
    public static int getCount()
    {
        return Count;
    }
}
