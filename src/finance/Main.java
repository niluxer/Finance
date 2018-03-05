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
        //Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        mainPane.setTop(getTopContent());
        mainPane.setCenter(getCenterContent());
        mainPane.getStylesheets().add("/finance/resources/css/DarkTheme2.css");

        primaryStage.setTitle("Finance");
        Scene scene = new Scene(mainPane, 300, 275);
        //scene.getStylesheets().add("/finance/resources/css/controlStyle2.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true);
    }

    private Parent getTopContent() throws IOException
    {
        return FXMLLoader.load(getClass().getResource("fxml/Menu.fxml"));
    }

    private Parent getCenterContent() throws IOException
    {
        return FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
