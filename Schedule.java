package emotionalSupport;

import java.util.ArrayList;
import java.util.Comparator; 
import java.util.HashMap;
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
 
    ArrayList<TreeSet<Lesson>> WeekDays;
    
    
    public Schedule()
    {
        Fitness = 0;
        DayStart = 8.0f;
        DayEnd = 20.0f;
        WeekDays = new ArrayList<>(5);
        for(int i = 0; i<5; i++)
        {
            WeekDays.add(new TreeSet<>(new SortByTime()));
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
        }
    }
    
    public int FreestDay()
    {
        int Index = 0;
        int Min = 9999;
        for(int i=0; i < 5 ;i++)
        {
           if(WeekDays.get(i).size() < Min)
           {
               Min = WeekDays.get(i).size();
               Index = i;
           }
        }
        
        return Index;
    }
    
    public TimePeriod OptimalTime(int Duration, String MyRoom)
    {
        int OptimalDay = FreestDay();
        TimePeriod Result = new TimePeriod(OpeningTime,OpeningTime + Duration ,Day.GetDay(OptimalDay));
        
        for(Lesson CurrentLesson : WeekDays.get(OptimalDay))
        {
            if(CurrentLesson.TimeFrame.equals(Result))
            {
                Result.StartTime = CurrentLesson.TimeFrame.EndTime;
                Result.EndTime = Result.StartTime + Duration; 
            }
            else if(Result.EndTime <= ClosingTime)
            {
                return Result;
            }
            else
            {
                Result.StartTime = OpeningTime;
                Result.EndTime = OpeningTime + Duration;
            }
        }
        
        return Result;
    }
    
    public void PrintSchedule()
    {
        Day CurrentDay = Day.SUNDAY;
        for(int i = 0; i<5;i++)
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