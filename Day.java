/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

/**
 *
 * @author Ahmed Hatem
 */
public enum Day
{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, 
     THURSDAY; 
    
     static Day Days[] = Day.values();
     
     static Day GetDay(int i)
     {
         return Days[i]; 
     }
     
}
