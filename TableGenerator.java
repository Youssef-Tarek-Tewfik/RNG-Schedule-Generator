/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

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
        TotalLessons = 0;
        for(Course CurrentCourse : DataManager.AllCourses.values())
        {
            int LecturesNumber = CurrentCourse.Details.no_of_lecs;
            int SectionsNumeber = CurrentCourse.Details.no_of_sections;
            int LectureHours = (int)CurrentCourse.Details.lec_hrs;
            int SectionHours = (int)CurrentCourse.Details.sec_hrs;
            TotalLessons += LecturesNumber + SectionsNumeber;
            
            for(int j= 0; j <LecturesNumber ; j++)
            {
                TimePeriod LectureTime = NewSchedule.OptimalTime(LectureHours) ;
                String Doctor = CurrentCourse.GetRandomDoctor();
                String Room = CurrentCourse.GetRandomRoom();
                Lesson NewLesson = new Lesson(Doctor, Room, LectureTime, Lesson.LessonType.Lecture, CurrentCourse.name + "Lecture " + (j+1));
                NewSchedule.AddLesson(LectureTime.CurrentDay.ordinal(), NewLesson);
            }
            for(int j= 0; j <SectionsNumeber ; j++)
            {
                TimePeriod SectionTime = NewSchedule.OptimalTime(SectionHours);
                String TA = CurrentCourse.GetRandomTA();
                String Room = CurrentCourse.GetRandomRoom();
                Lesson NewLesson = new Lesson(TA, Room, SectionTime, Lesson.LessonType.Section, CurrentCourse.name + "Section " + (j+1));
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
