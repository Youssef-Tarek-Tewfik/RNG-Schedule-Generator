/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 *
 * @author Ahmed Hatem
 */
public class TableGenerator
{
    static int TotalLessons;
    static Random RandomNumber;
    public static Schedule GenerateTable()
    {
        RandomNumber = new Random();
        Schedule NewSchedule = new Schedule();
        ArrayList<Course> ShuffledCourses = new ArrayList<Course>(DataManager.AllCourses.values());
        Collections.shuffle(ShuffledCourses);
        TotalLessons = 0;
        for(Course CurrentCourse : ShuffledCourses)
        {
            int LecturesNumber = CurrentCourse.Details.no_of_lecs;
            int SectionsNumeber = CurrentCourse.Details.no_of_sections;
            int LectureHours = (int)CurrentCourse.Details.lec_hrs;
            TotalLessons += LecturesNumber + SectionsNumeber;
            ArrayList<Integer> AddedLectures = new ArrayList<Integer>();
            int RandomLecture = 0;
            for(int j= 0; j < LecturesNumber ; j++)
            {
                String Doctor = CurrentCourse.GetRandomDoctor();
                String Room = CurrentCourse.GetRandomRoom();
                while(AddedLectures.contains(RandomLecture))
                {
                    RandomLecture = RandomNumber.nextInt(SectionsNumeber);                   
                }
                AddedLectures.add(RandomLecture);
                Lesson NewLesson = new Lesson(Doctor, Room, new TimePeriod(LectureHours), Lesson.LessonType.Lecture, CurrentCourse.name,RandomLecture+1);
                TimePeriod LectureTime = NewSchedule.SetOptimalTime(NewLesson);
                NewSchedule.AddLesson(LectureTime.CurrentDay.ordinal(), NewLesson);
            }          
          
        }
        
        for(Course CurrentCourse : ShuffledCourses)
        {
            int SectionsNumeber = CurrentCourse.Details.no_of_sections;
            int SectionHours = (int)CurrentCourse.Details.sec_hrs;
            ArrayList<Integer> AddedSections = new ArrayList<Integer>();
            int RandomSection = 0;
            for(int j= 0; j < SectionsNumeber ; j++)
            {
                String TA = CurrentCourse.GetRandomTA();
                String Room = CurrentCourse.GetRandomRoom();
                while(AddedSections.contains(RandomSection))
                {
                    RandomSection = RandomNumber.nextInt(SectionsNumeber);                   
                }
                AddedSections.add(RandomSection);
                Lesson NewLesson = new Lesson(TA, Room, new TimePeriod(SectionHours), Lesson.LessonType.Section, CurrentCourse.name,RandomSection+1);
                TimePeriod SectionTime =  NewSchedule.SetOptimalTime(NewLesson);
                NewSchedule.AddLesson(SectionTime.CurrentDay.ordinal(), NewLesson);
            }
        }
       
        if(TotalLessons != NewSchedule.Fitness)
        {
            System.err.println("Failed");
        }
        return NewSchedule; 
    }   
}
