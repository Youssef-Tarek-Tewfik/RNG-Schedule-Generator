package emotionalSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import emotionalSupport.Doctor;
import emotionalSupport.Instructor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed Hatem
 */
public class AddInstructorController implements Initializable
{
         
    @FXML
    private JFXTextField Name;
    @FXML
    private JFXTextField ID;
    @FXML
    private JFXTextField Email;
    @FXML
    private JFXTextField Phone;
    @FXML
    private JFXButton Add;
    @FXML
    private JFXButton Cancel;
    
    static Instructor NewInstructor;
    
    @FXML
    void AddInstructor()
    {
      NewInstructor = new Instructor(ID.getText(), Name.getText(), Email.getText(), Phone.getText());
      Stage stage = (Stage) Add.getScene().getWindow();      
      stage.close();   
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
