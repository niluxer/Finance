package finance.controllers;

import finance.database.model.Transaction;
import finance.database.model.dao.MySQL;
import finance.database.model.dao.TransactionDAO;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewTransactionController implements Initializable {
    @FXML
    Button btnSave, btnCancel;

    @FXML
    TextField txtCategory, txtDescription, txtAmount;

    @FXML
    DatePicker dpDate;

    @FXML
    RadioButton rbCredit, rbDebit;

    private TransactionDAO transactionDAO = new TransactionDAO(MySQL.getConnection());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSave.setOnAction(eventHandler);
        btnCancel.setOnAction(eventHandler);
    }

    private EventHandler eventHandler = new EventHandler() {
        @Override
        public void handle(Event event) {
            if(event.getSource() == btnSave ){
                Transaction transaction = new Transaction();
                transaction.setCategory(txtCategory.getText());
                transaction.setDescription(txtDescription.getText());
                LocalDate localDate = dpDate.getValue();
                transaction.setDate_created(Date.valueOf(localDate));
                transaction.setAmount(Double.valueOf(txtAmount.getText()));
                if (rbCredit.isSelected()) transaction.setType('C');
                if (rbDebit.isSelected()) transaction.setType('D');
                saveTransaction(transaction);
            } else if(event.getSource() == btnCancel) {

            }
            closeStage();
        }
    };

    private boolean saveTransaction(Transaction transaction)
    {
        return transactionDAO.insert(transaction);
    }

    private void closeStage()
    {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

}
