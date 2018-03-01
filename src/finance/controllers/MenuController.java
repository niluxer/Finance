package finance.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    Button btnDelete, btnCredit,btnDebit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnCredit.setOnAction(handler);
        btnDebit.setOnAction(handler);
        btnDelete.setOnAction(handler);
    }
    EventHandler <ActionEvent> handler= new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(event.getSource()==btnCredit)
            {
                showNewTransactionStage();

            }
        }
    };

    private void showNewTransactionStage() {
        Stage stage=new Stage();
        stage.setTitle("New Transaction");
        stage.setResizable(false);

        FXMLLoader loader= new FXMLLoader(getClass().getResource("../fxml/newTransaction.fxml"));
        NewTransactionController controller= new NewTransactionController();

        try {
            Parent parent = loader.load();
            loader.setController(controller);
            Scene scene=new Scene(parent,250,200);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
