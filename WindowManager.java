/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotionalSupport;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.fxml.FXMLLoader;
import com.jfoenix.controls.JFXCheckBox;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import com.jfoenix.controls.JFXListView;

/**
 *
 * @author Ahmed Hatem
 */
public abstract class WindowManager
{
    public static void ShowWarning(StackPane WarningPane)
    {
        ShowWarning(WarningPane,"Missing Data", "Please fill all the required data");
    }
    
    public static void ShowWarning(StackPane WarningPane,String Heading , String Message)
    {       
           WarningPane.setDisable(false);
           JFXDialogLayout WarningLayout = new JFXDialogLayout();
           WarningLayout.setHeading(new Text(Heading));
           WarningLayout.setBody(new Text(Message));
           //WarningLayout.setStyle(Name);
           JFXDialog Warning = new JFXDialog(WarningPane, WarningLayout, JFXDialog.DialogTransition.CENTER, true);
           //Warning.
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
                   WarningPane.setDisable(true);
               }
           });
           
           WarningLayout.setActions(Okay);
           Warning.show();
    }
    
    public static void OpenWindow(Object CurrentWindow,String WindowName)
    {
        try
        {
            FXMLLoader WindowLoader = new FXMLLoader(CurrentWindow.getClass().getResource(WindowName + ".fxml"));
            Parent root = WindowLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(WindowName);
            stage.setScene(new Scene(root));
            stage.showAndWait();
                                          
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    public static JFXCheckBox CreateCheckBox(String Name)
    {
        JFXCheckBox CheckBox = new JFXCheckBox(Name);
        CheckBox.setCheckedColor(Paint.valueOf("#4527a0"));
        return CheckBox;
    }
    public static void IntializeListsData(JFXListView<JFXCheckBox> Doctors,JFXListView<JFXCheckBox> TAs,JFXListView<JFXCheckBox> Rooms)
    {
      for(Doctor CurrentDoctor :DataManager.AllDoctors.values() )
      {
        Doctors.getItems().add(CreateCheckBox(CurrentDoctor.getName()));   
      }
      
      for(TeachingAssistant CurrentTA : DataManager.AllTeachingAssistants.values())
      {
        TAs.getItems().add(CreateCheckBox(CurrentTA.getName()));   
      }
      
      for(Room CurrentRoom : DataManager.AllRooms.values())
      {
        Rooms.getItems().add(CreateCheckBox(CurrentRoom.getName()));   
      }
    }
    
    public static void CloseWindow(JFXButton Close)
    {
      Stage stage = (Stage)Close.getScene().getWindow();      
      stage.close();
    }
}
