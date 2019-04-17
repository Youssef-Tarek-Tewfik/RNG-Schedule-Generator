/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed Hatem
 */
public class AddCoursesController implements Initializable {

    @FXML
    private JFXListView<JFXCheckBox> Doctors;

    @FXML
    private JFXListView<JFXCheckBox> TAs;

    @FXML
    private JFXListView<JFXCheckBox> Rooms;
    
    @FXML
    private JFXButton Cancel;

    @FXML
    void AddCourse()
    {
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
    }    
    
}
