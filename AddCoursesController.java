/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    void AddCourse()
    {
       int LecturesNumber ,LecturesHours,SectionsNumber,SectionHours;
       try
       {
           LecturesNumber = Integer.parseInt(LecturesNumberText.getText());
           LecturesHours = Integer.parseInt(LecturesHoursText.getText());
           SectionsNumber = Integer.parseInt(SectionsNumberText.getText());
           SectionHours = Integer.parseInt(SectionHoursText.getText());
       }
       catch(Exception e)
       {
           WarningPane.setDisable(false);
           JFXDialogLayout WarningLayout = new JFXDialogLayout();
           WarningLayout.setHeading(new Text("Missing Data"));
           WarningLayout.setBody(new Text("Please fill all the required data"));
           //WarningLayout.setStyle(Name);
           JFXDialog Warning = new JFXDialog(WarningPane, WarningLayout, JFXDialog.DialogTransition.CENTER, true);
           //Warning.
           JFXButton Okay = new JFXButton("Ok");
           Okay.setButtonType(JFXButton.ButtonType.RAISED);
           Okay.setStyle("-fx-background-color: #4527a0;-fx-text-fill:  #ffffff;");
           Okay.setPadding(new Insets(10, 15, 10, 15));
           
           Okay.setOnAction(new EventHandler<ActionEvent>()
           {
               @Override
               public void handle(ActionEvent event)
               {
                   Warning.close();
                   WarningPane.setDisable(true);
               }
           });
           
           WarningLayout.setActions(Okay);
           Warning.show();
       }
       //Course 
        
      for(JFXCheckBox CurrentTA : TAs.getItems())
      {
          if(CurrentTA.isSelected())
          {
              System.out.println(CurrentTA.getText());
              DataManager.AllTeachingAssistants.remove(CurrentTA.getText());
          }
      }
      
      for(JFXCheckBox CurrentDoctor : Doctors.getItems())
      {
          if(CurrentDoctor.isSelected())
          {
              DataManager.AllDoctors.remove(CurrentDoctor.getText());
          }
      }
      
      for(JFXCheckBox CurrentRoom : Rooms.getItems())
      {
          if(CurrentRoom.isSelected())
          {
              DataManager.AllRooms.remove(CurrentRoom.getText());
          }
      }
      
      //DataManager.AllCourses.put(key, value)
    }

    @FXML
    void Cancel()
    {
      Stage stage = (Stage) Cancel.getScene().getWindow();      
      stage.close();  
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        for(Doctor CurrentDoctor :DataManager.AllDoctors.values() )
      {
        JFXCheckBox DoctorCheckBox = new JFXCheckBox(CurrentDoctor.getName());
        Paint CheckedColor = javafx.scene.paint.Color.web("#4527a0");
        DoctorCheckBox.setCheckedColor(CheckedColor);
        Doctors.getItems().add(DoctorCheckBox);   
      }
      
      for(TeachingAssistant CurrentTA : DataManager.AllTeachingAssistants.values())
      {
        JFXCheckBox TACheckBox = new JFXCheckBox(CurrentTA.getName());
        Paint CheckedColor = javafx.scene.paint.Color.web("#4527a0");
        TACheckBox.setCheckedColor(CheckedColor);
        TAs.getItems().add(TACheckBox);   
      }
      
      for(Room CurrentRoom : DataManager.AllRooms.values())
      {
        JFXCheckBox CheckBox = new JFXCheckBox(CurrentRoom.getName());
        Paint CheckedColor = javafx.scene.paint.Color.web("#4527a0");
        CheckBox.setCheckedColor(CheckedColor);
        Rooms.getItems().add(CheckBox);   
      }
      WarningPane.setDisable(true);
    }    
    
}
