package emotionalSupport;

import com.jfoenix.controls.JFXMasonryPane;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

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
    
    @FXML
    private JFXComboBox<String> InstructorFilter;

    @FXML
    private JFXComboBox<String> RoomFilter;

    @FXML
    private JFXComboBox<String> CourseFilter;
    
    @FXML
    private JFXButton Filter;

    @FXML
    private JFXButton Regenerate;
    
    
    ArrayList<JFXMasonryPane>WeekDays;
    
    static Schedule GeneratedSchedule;


    @FXML
    void Filter()
    {
        int DayIndex = 0;
        for(ArrayList<Lesson> CurrentDay : GeneratedSchedule.WeekDays)
        {
            WeekDays.get(DayIndex).getChildren().clear();
            for(Lesson CurrentLesson : CurrentDay)
            {
                String SelectedInstructor = InstructorFilter.getSelectionModel().selectedItemProperty().get();
                String SelectedRoom = RoomFilter.getSelectionModel().selectedItemProperty().get();
                String SelectedCourse = CourseFilter.getSelectionModel().selectedItemProperty().get();
                boolean SameInstructor = CurrentLesson.instructor.equals(SelectedInstructor) || SelectedInstructor.equals("");
                boolean SameRoom = CurrentLesson.room.equals(SelectedRoom) || SelectedRoom.equals("");
                boolean SameCourse = CurrentLesson.CourseName.equals(SelectedCourse) || SelectedCourse.equals("");
                
                if(SameCourse && SameInstructor && SameRoom)
                {
                    AddLessonToDay(CurrentLesson, DayIndex);
                }
            }
            DayIndex++;
         }
    }
    
    @FXML
    private void GenerateTable()
    {
        GeneratedSchedule = TableGenerator.GenerateTable(); 
        GeneratedSchedule.PrintSchedule();
        int DayIndex = 0;
        CourseFilter.getItems().clear();
        InstructorFilter.getItems().clear();
        RoomFilter.getItems().clear();
        FillFilters("", "", "");
        for(ArrayList<Lesson> CurrentDay : GeneratedSchedule.WeekDays)
        {
            WeekDays.get(DayIndex).getChildren().clear();
            for(Lesson CurrentLesson : CurrentDay)
            {
                FillFilters(CurrentLesson.CourseName, CurrentLesson.instructor, CurrentLesson.room);
                AddLessonToDay(CurrentLesson, DayIndex);
            }
            DayIndex++;
         }
        CourseFilter.getSelectionModel().select("");
        InstructorFilter.getSelectionModel().select("");
        RoomFilter.getSelectionModel().select("");
    
    }
    private void AddLessonToDay(Lesson CurrentLesson,int DayIndex)
    {
        JFXButton LessonLabel = new JFXButton(CurrentLesson.toString());
        LessonLabel.setPrefSize(200, 100);
        LessonLabel.textAlignmentProperty().set(TextAlignment.CENTER);
        LessonLabel.setStyle("-fx-background-color: #4527a0;-fx-text-fill:  #ffffff;");
        LessonLabel.setButtonType(JFXButton.ButtonType.FLAT);
        WeekDays.get(DayIndex).getChildren().add(LessonLabel);
    }
    private void FillFilters(String Course,String Instructor, String Room)
    {
        if(!CourseFilter.getItems().contains(Course))
        {
            CourseFilter.getItems().add(Course);
        }
        
        if(!InstructorFilter.getItems().contains(Instructor))
        {
            InstructorFilter.getItems().add(Instructor);
        }
        
        if(!RoomFilter.getItems().contains(Room))
        {
            RoomFilter.getItems().add(Room);
        }
    }
    
    @FXML
    void initialize()
    {
        WarningPane.setPickOnBounds(false);
        WeekDays = new ArrayList<>(5);
        WeekDays.add(Sunday);
        WeekDays.add(Monday);
        WeekDays.add(Tuesday);
        WeekDays.add(Wednesday);
        WeekDays.add(Thursday);
        GenerateTable();
    }
}
