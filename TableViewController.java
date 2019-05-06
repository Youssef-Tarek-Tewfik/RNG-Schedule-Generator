package emotionalSupport;

import com.jfoenix.controls.JFXMasonryPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TableViewController {

    @FXML
    private JFXMasonryPane Sunday;

    @FXML
    private JFXMasonryPane Monday;

    @FXML
    private JFXMasonryPane Tuesday;

    @FXML
    private JFXMasonryPane Wednesday;

    @FXML
    private JFXMasonryPane Thursday;
    
    @FXML
    private StackPane WarningPane;
    
    ArrayList<JFXMasonryPane>WeekDays;
    
    private void GenerateTable()
    {
       Schedule.SetWorkingHours(8, 20);
       Schedule GeneratedSchedule = TableGenerator.GenerateTable(); 
       if(TableGenerator.Failed)
       {
          WindowManager.ShowWarning(WarningPane, "Table Generation Failed", "Faild to generate the table due to lack of time");
       }
       else
       {
         GeneratedSchedule.PrintSchedule();
         int DayIndex = 0;
         for(ArrayList<Lesson> CurrentDay : GeneratedSchedule.WeekDays)
         {
             for(Lesson CurrentLesson : CurrentDay)
             {
                 Label LessonLabel = new Label(CurrentLesson.toString());
                 LessonLabel.setPrefSize(200, 100);
                 LessonLabel.textAlignmentProperty().set(TextAlignment.CENTER);
                 LessonLabel.setStyle("-fx-background-color: #4527a0;-fx-text-fill:  #ffffff;");
                 WeekDays.get(DayIndex).getChildren().add(LessonLabel);
             }
             DayIndex++;
          }
       }
    }
    
    
    
    
    @FXML
    void initialize()
    {
        WeekDays = new ArrayList<>(5);
        WeekDays.add(Sunday);
        WeekDays.add(Monday);
        WeekDays.add(Tuesday);
        WeekDays.add(Wednesday);
        WeekDays.add(Thursday);
        GenerateTable();
    }
}
