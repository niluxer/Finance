package finance.database.model;

import java.sql.Date;

public class Transaction {
    private int id;
    private String category;
    private String description;
    private Date date_created;
    private double amount;
    private char type;

    public Transaction() {
    }

    public Transaction(int id, String category, String description, Date date_created, char type, double amount) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.date_created = date_created;
        this.amount = amount;
        this.type = type;
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

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}