package emotionalSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Ahmed Hatem
 */
public class AddInstructorController implements Initializable {

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

    static String Type;

    @FXML
    void AddInstructor()
    {
        String Name, Email, Phone;
        Name = NameText.getText().trim();
        Email = EmailText.getText();
        Phone = PhoneText.getText();

        if (!Phone.matches("\\d+") || Phone.length() < 11)
        {
            WindowManager.ShowWarning(WarningPane, "Wrong Phone", "Please enter a correct phone number");
        }
        else if (Name.trim().equals("") || Phone.trim().equals("") || Email.trim().equals(""))
        {
            WindowManager.ShowWarning(WarningPane);
        }
        else if (Type.equals("TA") && DataManager.AllTeachingAssistants.containsKey(Name.toLowerCase()))
        {
            WindowManager.ShowWarning(WarningPane, "Duplicate Data", "The TA is Already Added");
        }
        else if (Type.equals("Doctor") && DataManager.AllDoctors.containsKey(Name.toLowerCase()))
        {
            WindowManager.ShowWarning(WarningPane, "Duplicate Data", "The Doctor is Already Added");
        } else {
            NewInstructor = new Instructor(Name, Email, Phone);
            WindowManager.CloseWindow(Add);
        }

    }

    @FXML
    void Cancel()
    {
        NewInstructor = null;
        WindowManager.CloseWindow(Cancel);
    }

    public static Instructor getInstructor()
    {
        return NewInstructor;
    }

    public static void SetType(String InstructorType)
    {
        Type = InstructorType;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

}
