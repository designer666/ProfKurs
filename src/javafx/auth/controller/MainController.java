package javafx.auth.controller;

import javafx.auth.model.MainModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by IEvgen Boldyr on 02.06.17.
 */

public class MainController {

    @FXML private TextField fldLogin;
    @FXML private TextField fldPassword;

    @FXML
    private void onActionSignInClick() {
        MainModel.printUser(
                fldLogin.getText(), fldPassword.getText());
    }

    @FXML
    private void onActionCancelClick() {
        System.exit(0);
    }
}
