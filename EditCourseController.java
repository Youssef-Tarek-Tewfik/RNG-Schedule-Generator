package emotionalSupport;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class EditCourseController {

    @FXML
    private JFXListView<JFXCheckBox> Doctors;

    @FXML
    private JFXListView<JFXCheckBox> TAs;

    @FXML
    private JFXListView<JFXCheckBox> Rooms;

    @FXML
    private JFXTextField Name;

    @FXML
    private JFXTextField LecturesNumberText;

    @FXML
    private JFXTextField SectionsNumberText;

    @FXML
    private JFXTextField LecturesHoursText;

    @FXML
    private JFXTextField SectionHoursText;

    @FXML
    private JFXTextField PriorityText;

    @FXML
    private JFXButton Cancel;

    @FXML
    private StackPane WarningPane;
    
    static String EditedCourseName;
    
    @FXML
    void Cancel()
    {
        WindowManager.CloseWindow(Cancel);
    }

    @FXML
    void Save()
    {
       DataManager.AllCourses.remove(EditedCourseName);
       String CourseName = Name.getText();
       int LecturesNumber ,LecturesHours,SectionsNumber,SectionHours,Priority;
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
           Priority = Integer.parseInt(PriorityText.getText());
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
           Course NewCourse = new Course(CourseName, CourseDetails, DoctorNames, TANames, RoomNames,Priority);
           DataManager.AllCourses.put(CourseName.toLowerCase(), NewCourse);
           DataManager.WriteCourses("Courses.txt");
           Cancel();
       } 
    }
    
    
    private void FillOldData()
    {
        Course OldCourse = DataManager.AllCourses.get(EditedCourseName);
        Name.setText(OldCourse.name);
        LecturesNumberText.setText(String.valueOf(OldCourse.Details.no_of_lecs));
        LecturesHoursText.setText(String.valueOf(OldCourse.Details.lec_hrs));
        SectionsNumberText.setText(String.valueOf(OldCourse.Details.no_of_sections));
        SectionHoursText.setText(String.valueOf(OldCourse.Details.sec_hrs));
        PriorityText.setText(String.valueOf(OldCourse.Priority));
        
        
        for(String Doctor : DataManager.AllDoctors.keySet())
        {
            JFXCheckBox Current = WindowManager.CreateCheckBox(Doctor);
            if(OldCourse.Doctors.contains(Doctor))
            {
                Current.setSelected(true);
            }
            Doctors.getItems().add(Current);
        }
        
        for(String TA : DataManager.AllTeachingAssistants.keySet())
        {
            JFXCheckBox Current = WindowManager.CreateCheckBox(TA);
            if(OldCourse.TAs.contains(TA))
            {
                Current.setSelected(true);
            }
            TAs.getItems().add(Current);
        }
        
        for(String Room : DataManager.AllRooms.keySet())
        {
            JFXCheckBox Current = WindowManager.CreateCheckBox(Room);
            if(OldCourse.Rooms.contains(Room))
            {
                Current.setSelected(true);
            }
            Rooms.getItems().add(Current);
        }
    }
    
    @FXML
    void initialize()
    {
        WarningPane.setDisable(true);
        FillOldData();
    }
}
