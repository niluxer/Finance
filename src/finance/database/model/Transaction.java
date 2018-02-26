package finance.database.model;

import java.util.Date;

public class Transaction {

    String category;
    String description;
    Date date;
    char type;
    double amount;

    public Transaction(String category, String description, Date date, char type, double amount) {
        this.category = category;
        this.description = description;
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
