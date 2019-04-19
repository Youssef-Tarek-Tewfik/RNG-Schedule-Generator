package emotionalSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jfoenix.controls.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
        AddInstructorController.SetType("TA");
        WindowManager.OpenWindow(this, "AddInstructor");
                                            
        if(AddInstructorController.getInstructor() != null)
        {
            TeachingAssistant NewTA = new TeachingAssistant(AddInstructorController.getInstructor());
            TeachingAssistants.getItems().add(WindowManager.CreateCheckBox(NewTA.getName())); 
            DataManager.AllTeachingAssistants.put(NewTA.getName().toLowerCase(), NewTA);
        }
        
    }
    
    
    @FXML
    public void AddDoctor()
    {
        AddInstructorController.SetType("Doctor");
        WindowManager.OpenWindow(this, "AddInstructor");
                                   
        if(AddInstructorController.getInstructor() != null)
        {
            Doctor NewDoctor =  new Doctor(AddInstructorController.getInstructor());
            Doctors.getItems().add(WindowManager.CreateCheckBox(NewDoctor.getName())); 
            DataManager.AllDoctors.put(NewDoctor.getName().toLowerCase(), NewDoctor);
        }
    }
    
    @FXML
    public void AddRoom()
    {
        WindowManager.OpenWindow(this, "AddRoom");
        
        Room NewRoom = AddRoomController.GetNewRoom();
                              
        if(NewRoom != null)
        {
            Rooms.getItems().add(WindowManager.CreateCheckBox(NewRoom.getName())); 
            DataManager.AllRooms.put(NewRoom.getName().toLowerCase(), NewRoom);
        }
    }
    
    @FXML
    public void Close()
    {
      for(JFXCheckBox CurrentTA : TeachingAssistants.getItems())
      {
        if(CurrentTA.isSelected())
        {
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
      
      DataManager.ReWriteAllData();
      WindowManager.CloseWindow(Save);
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        WindowManager.IntializeListsData(Doctors, TeachingAssistants, Rooms);
    }    
    
}
