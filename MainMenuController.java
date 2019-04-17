/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainMenuController implements Initializable {
    
    
    @FXML
    private JFXButton Quit;

    
    @FXML
    void AddCourse()
    {
        try
        {
            FXMLLoader WindowLoader = new FXMLLoader(getClass().getResource("AddCourses.fxml"));
            Parent root = WindowLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("AddCourse");
            stage.setScene(new Scene(root));
            stage.showAndWait();
                                          
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void EditData()
    {
        try
        {
            FXMLLoader WindowLoader = new FXMLLoader(getClass().getResource("EditData.fxml"));
            Parent root = WindowLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("EditData");
            stage.setScene(new Scene(root));
            stage.showAndWait();
                                          
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
           
    }

    @FXML
    void GenerateTable()
    {

    }
    
    @FXML
    void DeleteCourse()
    {
        
    }
    
    @FXML
    void Quit()   
    {
      Stage stage = (Stage)Quit.getScene().getWindow();      
      stage.close(); 
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
