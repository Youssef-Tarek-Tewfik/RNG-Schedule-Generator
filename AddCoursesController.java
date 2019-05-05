/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Ahmed Hatem
 */
public class AddCoursesController implements Initializable {
    
    
    @FXML
    private StackPane WarningPane;
    
    @FXML
    private JFXListView<JFXCheckBox> Doctors;

    @FXML
    private JFXListView<JFXCheckBox> TAs;

    @FXML
    private JFXListView<JFXCheckBox> Rooms;
    
    @FXML
    private JFXButton Cancel;
    
    @FXML
    private JFXTextField LecturesNumberText;

    @FXML
    private JFXTextField LecturesHoursText;

    @FXML
    private JFXTextField SectionsNumberText;

    @FXML
    private JFXTextField SectionHoursText;
    
    
    @FXML
    private JFXTextField Name;
    
    @FXML
    void AddCourse()
    {
       String CourseName = Name.getText();
       if(DataManager.AllCourses.containsKey(CourseName.toLowerCase()))
       {
           WindowManager.ShowWarning(WarningPane, "Duplicate Data", "The Course is already added");
           return;
       }
       int LecturesNumber ,LecturesHours,SectionsNumber,SectionHours;
       ArrayList<String> DoctorNames = new  ArrayList<String>();
       ArrayList<String> TANames = new  ArrayList<String>();
       ArrayList<String> RoomNames = new ArrayList<String>();
       LessonDetails CourseDetails = null;
       try
       {
           LecturesNumber = Integer.parseInt(LecturesNumberText.getText());
           LecturesHours = Integer.parseInt(LecturesHoursText.getText());
           SectionsNumber = Integer.parseInt(SectionsNumberText.getText());
           SectionHours = Integer.parseInt(SectionHoursText.getText());
           CourseDetails = new LessonDetails(LecturesNumber, SectionsNumber, LecturesHours, SectionHours);
       }
       catch(Exception e)
       {
           WindowManager.ShowWarning(WarningPane);
           return;
       }
      
      
        for(JFXCheckBox CurrentTA : TAs.getItems())
        {
          if(CurrentTA.isSelected())
          {
            TANames.add(CurrentTA.getText());
          }
        }

        for(JFXCheckBox CurrentDoctor : Doctors.getItems())
        {
          if(CurrentDoctor.isSelected())
          {
             DoctorNames.add(CurrentDoctor.getText());
          }
        }

        for(JFXCheckBox CurrentRoom : Rooms.getItems())
        {
          if(CurrentRoom.isSelected())
          {
            RoomNames.add(CurrentRoom.getText());
          }
        }

       if(DoctorNames.size() <1 || TANames.size() < 1 || RoomNames.size() < 1)
       {
           DoctorNames.clear();
           TANames.clear();
           RoomNames.clear();
           WindowManager.ShowWarning(WarningPane);
       }
       else
       {
           Course NewCourse = new Course(CourseName, CourseDetails, DoctorNames, TANames, RoomNames);
           DataManager.AllCourses.put(CourseName.toLowerCase(), NewCourse);
           DataManager.AddCourseToFile(NewCourse, "Courses.txt");
           Cancel();
       }     
    }

    
    @FXML
    void Cancel()
    {
      WindowManager.CloseWindow(Cancel);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        WarningPane.setDisable(true);
        WindowManager.IntializeListsData(Doctors, TAs, Rooms);
    }    
    
}
