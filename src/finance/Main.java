package finance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private BorderPane mainPane = new BorderPane();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainPane.setTop(getTopContent());
        primaryStage.setTitle("Finance");
        primaryStage.setScene(new Scene(mainPane, 300, 275));
        primaryStage.show();
    }

    private Parent getTopContent() throws IOException
    {
        return FXMLLoader.load(getClass().getResource("fxml/Menu.fxml"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
