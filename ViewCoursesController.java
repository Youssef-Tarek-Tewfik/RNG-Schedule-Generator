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
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Ahmed Hatem
 */
public class ViewCoursesController implements Initializable {

    @FXML
    private JFXListView<JFXCheckBox> Courses;

    @FXML
    private JFXButton DeleteCourse;

    @FXML
    private JFXButton Cancel;
    
    @FXML
    private StackPane WarningPane; 

    @FXML
    void Delete()
    {
        for(JFXCheckBox CurrentCourse : Courses.getItems())
        {
          if(CurrentCourse.isSelected())
          {
            DataManager.AllCourses.remove(CurrentCourse.getText());
          }
        }
        DataManager.WriteCourses("Courses.txt");
        WindowManager.CloseWindow(DeleteCourse);
    }
    
    
    @FXML
    void Edit()
    {
        int Count = 0;
        String CourseName="";
        for(JFXCheckBox CurrentCourse : Courses.getItems())
        {
          if(CurrentCourse.isSelected())
          {
            Count++;
            CourseName = CurrentCourse.getText();
          }
        }
        
        if(Count > 1)
        {
            WindowManager.ShowWarning(WarningPane, "More than one course was selected", "Please select only one course to edit");
        }
        else
        {
            EditCourseController.EditedCourseName = CourseName;
            WindowManager.OpenWindow(this, "EditCourse");
        }
    }
    
    
    @FXML
    private void Cancel()
    {
        WindowManager.CloseWindow(Cancel);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        WarningPane.setDisable(true);
        for(String CurrentCourse : DataManager.AllCourses.keySet())
        {
            Courses.getItems().add(WindowManager.CreateCheckBox(CurrentCourse));
        }
    }    
    
}
