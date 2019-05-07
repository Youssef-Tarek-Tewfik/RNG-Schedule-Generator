package emotionalSupport;

import emotionalSupport.Lesson.LessonType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator; 
import java.util.HashSet;
import java.util.TreeSet;

class SortByTime implements Comparator<Lesson>
{
    @Override
    public int compare(Lesson L1 ,Lesson L2)
    {
        return (L1.TimeFrame.StartTime - L2.TimeFrame.StartTime);
    }
}

public class Schedule
{
    public int Fitness;
    public final float DayStart,DayEnd;
    public static int OpeningTime,ClosingTime;
    int FreestDay;
    ArrayList<ArrayList<Lesson>> WeekDays;
      
    public Schedule()
    {
        Fitness = 0;
        FreestDay = 0;
        DayStart = 8.0f;
        DayEnd = 20.0f;
        WeekDays = new ArrayList<>(5);
        for(int i = 0; i<5; i++)
        {
            WeekDays.add(new ArrayList<>());
        }
    }
    
    public static void SetWorkingHours(int Start,int End)
    {
        OpeningTime = Start;
        ClosingTime = End;
    }
    
    public void AddLesson(int Day,Lesson NewLesson)
    {
        if(NewLesson.TimeFrame.EndTime <= ClosingTime)
        {
            Fitness++;
            WeekDays.get(Day).add(NewLesson);
            SortDay(Day);
        }
    }
    
    public int FreestDay()
    {       
        return (FreestDay++) % 5;
    }
    
    public TimePeriod SetOptimalTime(Lesson NewLesson)
    {
        int OptimalDay = FreestDay();
        int NumberOfTries = 50;
        NewLesson.TimeFrame.CurrentDay = Day.GetDay(OptimalDay);
        
        for(Lesson CurrentLesson : WeekDays.get(OptimalDay))
        {
            boolean OneIsALecture = CurrentLesson.lessonType.equals(LessonType.Lecture) || NewLesson.lessonType.equals(LessonType.Lecture) && NewLesson.Group == CurrentLesson.Group;
            boolean RoomOverLaped = CurrentLesson.room.equals(NewLesson.room);
            boolean TAOverLap = CurrentLesson.instructor.equals(NewLesson.instructor);
            boolean TimeOverLap = CurrentLesson.TimeFrame.equals(NewLesson.TimeFrame);
            boolean SameGroup = CurrentLesson.Group == NewLesson.Group && !OneIsALecture;

            if(CurrentLesson.equals(NewLesson))
            {
                if(RoomOverLaped && TimeOverLap && !OneIsALecture && !SameGroup)
                {
                    for(int i = 0; i < NumberOfTries; i++)
                    {
                        NewLesson.room = DataManager.AllCourses.get(NewLesson.CourseName).GetRandomRoom();
                        if(!CurrentLesson.equals(NewLesson))
                        {
                            return NewLesson.TimeFrame;
                        }
                    }
                }
                else if(TAOverLap && TimeOverLap && !OneIsALecture && !SameGroup)
                {
                    for(int i = 0; i < NumberOfTries; i++)
                    {
                        NewLesson.instructor = DataManager.AllCourses.get(NewLesson.CourseName).GetRandomTA();
                        if(!CurrentLesson.equals(NewLesson))
                        {
                            return NewLesson.TimeFrame;
                        }
                    }
                }
                
                if(NewLesson.Priority > CurrentLesson.Priority && !OneIsALecture)
                {
                    CurrentLesson.TimeFrame.StartTime = NewLesson.TimeFrame.EndTime;
                    CurrentLesson.TimeFrame.EndTime = CurrentLesson.TimeFrame.StartTime + CurrentLesson.TimeFrame.Duration;
                    NewLesson = new Lesson(CurrentLesson);
                }
                else
                {
                    NewLesson.TimeFrame.StartTime = CurrentLesson.TimeFrame.EndTime;
                    NewLesson.TimeFrame.EndTime = NewLesson.TimeFrame.StartTime + NewLesson.TimeFrame.Duration;    
                }         
            }
        }
        return NewLesson.TimeFrame;
    }
    
    
    public void SortDay(int DayIndex)
    {
        Collections.sort(WeekDays.get(DayIndex),new SortByTime());
    }
    
    public void PrintSchedule()
    {
        for(int i = 0; i < WeekDays.size(); i++)
        {
            System.out.println("***********" + Day.GetDay(i) + "***********");
            if(WeekDays.get(i).size() > 0)
            {
                for(Lesson CurrentLesson : WeekDays.get(i))
                {
                   System.out.println(CurrentLesson.toString());
                   System.out.println();
                }
            }
            else
            {
                System.out.println("Holiday");
            }
        }
    }
}