
package emotionalSupport;

import java.util.Objects;


public class TimePeriod
{
    // Time Must
    float StartTime;
    float EndTime;
    String Day;

    public TimePeriod(float StartTime, float EndTime, String Day)
    {
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Day = Day;
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
        if(!(this.Day.equals(other.Day)))
        {
            return false;
        }
        else if(this.StartTime < other.StartTime && this.EndTime > other.StartTime)
        {
            return true;
        }
        else if(this.StartTime < other.EndTime && this.EndTime > other.EndTime) 
        {
            return true;
        }
        else if(other.StartTime < this.StartTime && other.EndTime > this.EndTime)
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
        hash = 67 * hash + Objects.hashCode(this.Day);
        return hash;
    }

    
}

