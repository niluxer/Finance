package finance.controllers;

import finance.database.model.Transaction;
import finance.database.model.dao.MySQL;
import finance.database.model.dao.TransactionDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TableView<Transaction> tblTransactions;
    @FXML
    Button btnDelete, btnCredit,btnDebit;

    TransactionDAO transactionDAO = new TransactionDAO(MySQL.getConnection());

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        btnCredit.setOnAction(handler);
        btnDebit.setOnAction(handler);
        btnDelete.setOnAction(handler);

        initTableTransactions();
    }

    private void initTableTransactions(){
        tblTransactions.setItems(transactionDAO.fetchAll());
    }

    EventHandler<ActionEvent> handler= new EventHandler<ActionEvent>() {
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
            parent.getStylesheets().add("/finance/resources/css/DarkTheme2.css");
            Scene scene=new Scene(parent,330,200);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                reloadData();
            }
        });
    }

    private void reloadData()
    {
        tblTransactions.getItems().clear();
        tblTransactions.setItems(transactionDAO.fetchAll());
    }
}
