/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class MainMenuController implements Initializable {
    
    
    @FXML
    private JFXButton Quit;

    
    @FXML
    void AddCourse()
    {
       WindowManager.OpenWindow(this, "AddCourses");
    }

    @FXML
    void EditData()
    {    
      WindowManager.OpenWindow(this, "EditData");
    }

    @FXML
    void GenerateTable()
    {
        
       WindowManager.OpenWindow(this, "TableView");
    }
    
    @FXML
    void ViewCourses()
    {
        WindowManager.OpenWindow(this, "ViewCourses");
    }
    
    @FXML
    void Quit()   
    {
      WindowManager.CloseWindow(Quit);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
