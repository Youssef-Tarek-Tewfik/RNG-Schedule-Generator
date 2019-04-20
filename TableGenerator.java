/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author Ahmed Hatem
 */
public class TableGenerator
{
    static int TotalLessons;
    public static Schedule GenerateTable()
    {
        Schedule NewSchedule = new Schedule();
        ArrayList<Course> ShuffledCourses = new ArrayList<Course>(DataManager.AllCourses.values());
        Collections.shuffle(ShuffledCourses);
        TotalLessons = 0;
        for(Course CurrentCourse : ShuffledCourses)
        {
            int LecturesNumber = CurrentCourse.Details.no_of_lecs;
            int SectionsNumeber = CurrentCourse.Details.no_of_sections;
            int LectureHours = (int)CurrentCourse.Details.lec_hrs;
            CurrentCourse.Reset();
            TotalLessons += LecturesNumber + SectionsNumeber;           
            for(int j= 0; j < LecturesNumber ; j++)
            {
                String Doctor = CurrentCourse.GetFreestDoctor();
                String Room = CurrentCourse.GetFreestRoom();
                TimePeriod LectureTime = NewSchedule.OptimalTime(LectureHours,Room) ;               
                Lesson NewLesson = new Lesson(Doctor, Room, LectureTime, Lesson.LessonType.Lecture, CurrentCourse.name + " Lecture ");
                NewSchedule.AddLesson(LectureTime.CurrentDay.ordinal(), NewLesson);
            }          
          
        }
        
        for(Course CurrentCourse : ShuffledCourses)
        {
            int SectionsNumeber = CurrentCourse.Details.no_of_sections;
            int SectionHours = (int)CurrentCourse.Details.sec_hrs;
            for(int j= 0; j < SectionsNumeber ; j++)
            {
                String TA = CurrentCourse.GetFreestTA();
                String Room = CurrentCourse.GetFreestRoom();
                TimePeriod SectionTime = NewSchedule.OptimalTime(SectionHours,Room);
                Lesson NewLesson = new Lesson(TA, Room, SectionTime, Lesson.LessonType.Section, CurrentCourse.name + " Section " + (j+1));
                NewSchedule.AddLesson(SectionTime.CurrentDay.ordinal(), NewLesson);
            }
        }
        
        
        if(NewSchedule.Fitness != TotalLessons)
        {
            GenerateTable();
        }
        
              
        return NewSchedule; 
    }   
}
