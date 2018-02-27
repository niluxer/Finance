package finance.controllers;

import finance.database.model.Transaction;
import finance.database.model.dao.TransactionDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TableView<Transaction> tblTransactions;
    TransactionDAO transactionDAO = new TransactionDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTableTransactions();
    }

    private void initTableTransactions(){
        tblTransactions.setItems(transactionDAO.getData());
    }
}
