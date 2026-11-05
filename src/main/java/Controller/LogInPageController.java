package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInPageController {
    Stage mainDashboardStage = new Stage();
    LogInController logInController =new LogInController();

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnActionLogin(ActionEvent event) {

    if (logInController.checkUserNameAndPassword(txtUserName.getText(),txtPassword.getText())) {
        try {
            mainDashboardStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/MainDashboard.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    mainDashboardStage.show();
    }

    public void LogInOnKeyAction(KeyEvent keyEvent) {

    }

//    private boolean CheckLogin(String userName, String password) {
//    if (userName.equals("kashmika") && password.equals("1234")){
//        return true;
//    }
//        return false;
//    }
}
