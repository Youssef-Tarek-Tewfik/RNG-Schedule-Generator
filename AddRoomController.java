/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.StackPane;
/**
 * FXML Controller class
 *
 * @author Ahmed Hatem
 */
public class AddRoomController implements Initializable {
    
    
    @FXML
    private StackPane WarningPane;
    
    @FXML
    private JFXTextField NameText;
    
    @FXML
    private JFXTextField CapacityText;

    @FXML
    private JFXButton Add;

    @FXML
    private JFXButton Cancel;
    
    @FXML
    private JFXComboBox<String> RoomType;
    
    static Room NewRoom;
    
    @FXML
    void AddRoom()
    {
      String Name;
      int Capacity = 0;
      boolean ValidCapacity;
      Name = NameText.getText();
      
      try
      {
        Capacity = Integer.parseInt(CapacityText.getText());
        ValidCapacity = true;
      }
      catch(Exception e)
      {
          ValidCapacity = false;
      }     
      
      if( Name.trim().equals("") || !ValidCapacity )
      {    
        WindowManager.ShowWarning(WarningPane);
      }
      else if(DataManager.AllRooms.containsKey(Name.toLowerCase()))
      {
          WindowManager.ShowWarning(WarningPane, "Duplicate Data", "The room is already added");
      }
      else
      {
          NewRoom = new Room(Name, Capacity);
          WindowManager.CloseWindow(Add);
      }
      
    }

    @FXML
    void Cancel()
    {
      NewRoom = null;
      WindowManager.CloseWindow(Cancel);
    }
    
    public static Room GetNewRoom()
    {
        return NewRoom;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        RoomType.getItems().add("Hall");
        RoomType.getItems().add("Lab");
        
    }    
    
}
