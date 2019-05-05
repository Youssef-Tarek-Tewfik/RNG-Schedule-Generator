package emotionalSupport;

import emotionalSupport.Lesson.LessonType;
import java.util.ArrayList;
import java.util.Comparator; 
import java.util.HashSet;
import java.util.TreeSet;

class SortByTime implements Comparator<Lesson>
{
    @Override
    public int compare(Lesson L1 ,Lesson L2)
    {
        return (int)(L1.TimeFrame.StartTime - L2.TimeFrame.StartTime);
    }
}

public class Schedule
{
    public int Fitness;
    public final float DayStart,DayEnd;
    public static int OpeningTime,ClosingTime;
    int FreestDay;
    ArrayList<HashSet<Lesson>> WeekDays;
    ArrayList<TreeSet<Lesson>> SortedWeekDays;
    
    
    public Schedule()
    {
        Fitness = 0;
        FreestDay = 0;
        DayStart = 8.0f;
        DayEnd = 20.0f;
        WeekDays = new ArrayList<>(5);
        for(int i = 0; i<5; i++)
        {
            WeekDays.add(new HashSet<>());
            //SortedWeekDays.add(new TreeSet<>(new SortByTime()));
        }
    }
    
    public static void SetWorkingHours(int Start,int End)
    {
        OpeningTime = Start;
        ClosingTime = End;
    }
    
    public void AddLesson(int Day,Lesson NewLesson)
    {
        if(WeekDays.get(Day).add(NewLesson))
        {
            Fitness++;
            System.out.println("Added " + NewLesson.toString()+ "\n\n");
        }
        else
        {
            WeekDays.get(Day).contains(NewLesson);
            System.out.println("Failed to Add " + NewLesson.toString() + "\n\n");
        }
    }
    
    public int FreestDay()
    {       
        return (FreestDay++) % 5;
    }
    
    public TimePeriod SetOptimalTime(Lesson NewLesson)
    {
        int OptimalDay = FreestDay();
        int NumberOfTries = 10;
        float MaxEndTime = 8;
        NewLesson.TimeFrame = new TimePeriod(OpeningTime,OpeningTime + NewLesson.TimeFrame.Duration ,Day.GetDay(OptimalDay));
        
        for(Lesson CurrentLesson : WeekDays.get(OptimalDay))
        {
            boolean OneIsALecture = CurrentLesson.lessonType.equals(LessonType.Lecture) || NewLesson.lessonType.equals(LessonType.Lecture);
            boolean RoomOverLaped = CurrentLesson.room.equals(NewLesson.room);
            boolean TAOverLap = CurrentLesson.instructor.equals(NewLesson.instructor);
            boolean TimeOverLap = CurrentLesson.TimeFrame.equals(NewLesson.TimeFrame);
            if(CurrentLesson.TimeFrame.EndTime > MaxEndTime)
            {
                MaxEndTime = CurrentLesson.TimeFrame.EndTime;
            }
            if(CurrentLesson.equals(NewLesson) || OneIsALecture)
            {
                if(RoomOverLaped && TimeOverLap && !OneIsALecture)
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
                else if(TAOverLap && TimeOverLap && !OneIsALecture)
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
                NewLesson.TimeFrame.StartTime = CurrentLesson.TimeFrame.EndTime;
                NewLesson.TimeFrame.EndTime = NewLesson.TimeFrame .StartTime + NewLesson.TimeFrame.Duration;              
            }
        }
        while(WeekDays.get(OptimalDay).contains(NewLesson))
        {
            NewLesson.TimeFrame.StartTime = MaxEndTime;
            NewLesson.TimeFrame.EndTime = NewLesson.TimeFrame.StartTime + NewLesson.TimeFrame.Duration;
            MaxEndTime = NewLesson.TimeFrame.EndTime;
        }
        return NewLesson.TimeFrame;
    }
    
    public void PrintSchedule()
    {

        for(int i = 0; i <WeekDays.size(); i++)
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