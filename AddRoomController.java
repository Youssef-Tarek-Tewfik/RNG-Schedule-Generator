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
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
           JFXDialogLayout WarningLayout = new JFXDialogLayout();
           WarningLayout.setHeading(new Text("Missing Data"));
           WarningLayout.setBody(new Text("Please fill all the required data"));
           //WarningLayout.setStyle(Name);
           JFXDialog Warning = new JFXDialog(WarningPane, WarningLayout, JFXDialog.DialogTransition.CENTER, true);
           
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
               }
           });
           
           WarningLayout.setActions(Okay);
           Warning.show();
           
      }
      else
      {
          NewRoom = new Room(Name, Capacity);
          Stage stage = (Stage) Add.getScene().getWindow();      
          stage.close();   
      }
      
    }

    @FXML
    void Cancel()
    {
      NewRoom = null;
      Stage stage = (Stage) Cancel.getScene().getWindow();      
      stage.close();   
    }
    
    public static Room GetNewRoom()
    {
        return NewRoom;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
