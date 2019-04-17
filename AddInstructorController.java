package emotionalSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import emotionalSupport.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed Hatem
 */
public class AddInstructorController implements Initializable
{
         
   @FXML
    private JFXTextField NameText;

    @FXML
    private JFXTextField IDText;

    @FXML
    private JFXTextField EmailText;

    @FXML
    private JFXTextField PhoneText;

    @FXML
    private JFXButton Add;

    @FXML
    private JFXButton Cancel;
    
    @FXML
    private StackPane WarningPane;
    
    static Instructor NewInstructor;
    
    @FXML
    void AddInstructor()
    {     
      String Name, Email,Phone;
      Name = NameText.getText().trim();
      Email = EmailText.getText();
      Phone = PhoneText.getText();
      
      if( Name.trim().equals("") ||  Phone.trim().equals("") || Email.trim().equals(""))
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
          NewInstructor = new Instructor(Name, Email, Phone);
          Stage stage = (Stage) Add.getScene().getWindow();      
          stage.close();   
      }
      
    }

    @FXML
    void Cancel()
    {
      NewInstructor = null;
      Stage stage = (Stage) Cancel.getScene().getWindow();      
      stage.close();   
    }

    public static Instructor getInstructor()
    {
        return NewInstructor;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //CurrentWindow = (Stage) Cancel.getScene().getWindow();
    }    
    
}
