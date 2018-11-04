package login;

import Admin.AdminController;
import Students.StudentsController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

        @FXML
         private Label dbstatus;
        @FXML
         private TextField username;
        @FXML
         private PasswordField password;
        @FXML
         private ComboBox<options> combobox;
        @FXML
         private Button loginButton;

    public void initialize(URL url, ResourceBundle rb) {
        if(this.loginModel.isDatabaseConnected()){
            this.dbstatus.setText("Connected");
        }else{
            this.dbstatus.setText("Not Connected to the Database");
        }

        this.combobox.setItems(FXCollections.observableArrayList(options.values()));
    }
    @FXML
    public void Login(ActionEvent event){

    }
    public void studentLogin(){
        try{
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Students.studentFXML.fxml").openStream());

            StudentsController studentsController = (StudentsController)loader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Student Dashboard");
            userStage.setResizable(false);
            userStage.show();

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void adminLogin(){
        try{
            Stage adminStage = new Stage();
            FXMLLoader adminLoader = new FXMLLoader();
            Pane adminroot = (Pane)adminLoader.load(getClass().getResource("/Admin/Admin.fxml").openStream());
            AdminController adminController = (AdminController)adminLoader.getController();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
