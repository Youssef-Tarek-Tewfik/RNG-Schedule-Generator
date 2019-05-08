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
import javafx.scene.layout.StackPane;


public class MainMenuController implements Initializable {
    
    
    @FXML
    private JFXButton Quit;
    
    @FXML
    private StackPane WarningPane;

    
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
       Schedule.SetWorkingHours(8, 20);
       TableViewController.GeneratedSchedule = TableGenerator.GenerateTable(); 
       if(TableGenerator.Failed)
       {
          WindowManager.ShowWarning(WarningPane, "Table Generation Failed", "Faild to generate the table due to lack of time");
       }
       else
       {
         WindowManager.OpenWindow(this, "TableView");
       }
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
