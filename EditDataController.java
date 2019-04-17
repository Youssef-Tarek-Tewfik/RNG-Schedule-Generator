package emotionalSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jfoenix.controls.*;
import emotionalSupport.*;
import java.awt.Color;
import javafx.scene.paint.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.stage.Modality;
/**
 *
 * @author Ahmed Hatem
 */




public class EditDataController implements Initializable {
    
    
    @FXML
    private JFXButton Save;

    @FXML
    private JFXListView<JFXCheckBox> Doctors;

    @FXML
    private JFXListView<JFXCheckBox> TeachingAssistants;

    @FXML
    private JFXListView<JFXCheckBox> Courses;

    @FXML
    private JFXListView<JFXCheckBox> Rooms;

    @FXML
    private JFXButton AddDoctor;

    @FXML
    private JFXButton AddCourse;

    @FXML
    private JFXButton AddRoom;


    @FXML
    public void AddTA()
    {
        try
        {
            FXMLLoader WindowLoader = new FXMLLoader(getClass().getResource("AddInstructor.fxml"));
            Parent root = WindowLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("AddTA");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            
            TeachingAssistant NewTA = new TeachingAssistant(AddInstructorController.getInstructor());
                                
            if(NewTA != null)
            {
                System.out.println(NewTA.toString());
                JFXCheckBox InstructorCheckBox = new JFXCheckBox(NewTA.getName());
                Paint CheckedColor = javafx.scene.paint.Color.web("#4527a0");
                InstructorCheckBox.setCheckedColor(CheckedColor);
                TeachingAssistants.getItems().add(InstructorCheckBox); 
                DataManager.AllTeachingAssistants.put(NewTA.getName(), NewTA);
            }
                   
            
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        
    }
    
    
    @FXML
    public void AddInstructor()
    {
        try
        {
            FXMLLoader WindowLoader = new FXMLLoader(getClass().getResource("AddInstructor.fxml"));
            Parent root = WindowLoader.load();
            Stage stage = new Stage(); 
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("AddDoctor");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            
            Doctor NewDoctor = new Doctor(AddInstructorController.getInstructor());
                              
            if(NewDoctor != null)
            {
                System.out.println(NewDoctor.toString());
                JFXCheckBox InstructorCheckBox = new JFXCheckBox(NewDoctor.getName());
                Paint CheckedColor = javafx.scene.paint.Color.web("#4527a0");
                InstructorCheckBox.setCheckedColor(CheckedColor);
                Doctors.getItems().add(InstructorCheckBox); 
                DataManager.AllDoctors.put(NewDoctor.getName(), NewDoctor);
            }
                   
            
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        
    }
    
    @FXML
    public void Close()
    {
      for(JFXCheckBox CurrentTA : TeachingAssistants.getItems())
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
      DataManager.ReWriteAllData();
      Stage stage = (Stage)Doctors.getScene().getWindow();      
      stage.close();   
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       DataManager.Intialize();
       DataManager.ReadData();

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
        TeachingAssistants.getItems().add(TACheckBox);   
      }
       
       
    }    
    
}
