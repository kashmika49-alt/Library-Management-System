package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInPageController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnActionLogin(ActionEvent event) {

    }

//    private boolean CheckLogin(String userName, String password) {
//    if (userName.equals("kashmika") && password.equals("1234")){
//        return true;
//    }
//        return false;
//    }
}
