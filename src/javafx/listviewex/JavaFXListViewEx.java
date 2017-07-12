package javafx.listviewex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by IEvgen Boldyr on 07.06.17.
 */
public class JavaFXListViewEx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ListViewEx");
        Parent root = FXMLLoader.load(getClass()
                .getResource("/javafx/listviewex/main.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


}
