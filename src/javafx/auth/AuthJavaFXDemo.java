package javafx.auth;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by IEvgen Boldyr on 02.06.17.
 */

public class AuthJavaFXDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AuthJavaFXDemo");
        Parent root = FXMLLoader.load(getClass()
                .getResource("/javafx/auth/view/main.fxml"));
        Scene main = new Scene(root);
        primaryStage.setScene(main);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
