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
    private JFXButton EditCourse;

    @FXML
    private JFXButton Close;

    @FXML
    void Cancel()
    {
        for(JFXCheckBox CurrentCourse : Courses.getItems())
        {
          if(CurrentCourse.isSelected())
          {
            DataManager.AllCourses.remove(CurrentCourse.getText());
          }
        }
        DataManager.WriteCourses("Courses.txt");
        WindowManager.CloseWindow(Close);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        for(String CurrentCourse : DataManager.AllCourses.keySet())
        {
            Courses.getItems().add(WindowManager.CreateCheckBox(CurrentCourse));
        }
    }    
    
}
