
package emotionalSupport;

import java.util.Objects;
import java.util.Random;


public class TimePeriod
{
    // Time Must
    float StartTime;
    float EndTime;
    Day CurrentDay;
    static Random RandomNumber = new Random();
    
    public TimePeriod(float StartTime, float EndTime, Day CurrentDay)
    {
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.CurrentDay = CurrentDay;
    }
    
    public static TimePeriod RandomTimeFrame(int Duration)
    {
       int StartBound = Schedule.ClosingTime - Duration;
       int Start = RandomNumber.nextInt((StartBound - Schedule.OpeningTime) + 1) + Schedule.OpeningTime;
       int End = Start + Duration;
       int RandomDay = RandomNumber.nextInt(5);
       return new TimePeriod(Start, End, Day.GetDay(RandomDay));
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimePeriod other = (TimePeriod) obj;
        if(!(this.CurrentDay.equals(other.CurrentDay)))
        {
            return false;
        }
        else if(this.StartTime < other.EndTime && other.StartTime < this.EndTime)
        {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 67 * hash + Float.floatToIntBits(this.StartTime);
        hash = 67 * hash + Float.floatToIntBits(this.EndTime);
        hash = 67 * hash + Objects.hashCode(this.CurrentDay);
        return hash;
    }

    
}

