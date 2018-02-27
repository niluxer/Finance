package finance.database.model.dao;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import finance.database.model.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;

public class TransactionDAO {
    ObservableList<Transaction> data = FXCollections.observableArrayList();

    public void initData()
    {
        data.add(new Transaction("Pago de Quincena","2da. Quincena de Febrero", new Date(), 'C',15000));
        data.add(new Transaction("Alimentos","Despensa", new Date(), 'D',1000));
        data.add(new Transaction("Diversion","Casino", new Date(), 'D',2000));
        data.add(new Transaction("Gasolina","Moto", new Date(), 'D',500));
    }

    public TransactionDAO() {
        initData();
    }

    public ObservableList<Transaction> getData() {
        return data;
    }
}
