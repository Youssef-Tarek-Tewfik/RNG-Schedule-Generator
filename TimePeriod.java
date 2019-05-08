
package emotionalSupport;

import java.util.Objects;
import java.util.Random;


public class TimePeriod
{
    // Time Must
    int StartTime;
    int EndTime;
    int Duration;
    Day CurrentDay;
    static Random RandomNumber = new Random();
    
    public TimePeriod(int StartTime, int EndTime, Day CurrentDay)
    {
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.CurrentDay = CurrentDay;
        Duration = EndTime - StartTime;
    }
    
    public TimePeriod(int Duration)
    {
        StartTime = Schedule.OpeningTime;
        EndTime = StartTime + Duration;
        this.Duration = Duration;
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

