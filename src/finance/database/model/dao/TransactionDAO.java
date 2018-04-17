package finance.database.model.dao;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import finance.database.model.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author niluxer
 */
public class TransactionDAO {


    public ObservableList<Transaction> fetchAll() {
        ObservableList<Transaction> transactions = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM transaction limit 1000";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Transaction p = null;
            while(rs.next()) {
                p = new Transaction(
                        rs.getInt("id"),
                        rs.getString("category"), rs.getString("description"),
                        rs.getDate("date_created"), rs.getString("type").charAt(0),
                        rs.getDouble("amount") );
                transactions.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return transactions;
    }

    Connection conn;
    public TransactionDAO(Connection conn)
    {
        this.conn = conn;
    }

    public List<Transaction> findAll() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        try {
            String query = "SELECT * FROM transactions limit 1000";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Transaction p = null;
            while(rs.next()) {
                p = new Transaction(
                        rs.getInt("id"),
                        rs.getString("category"), rs.getString("description"),
                        rs.getDate("date_created"), rs.getString("type").charAt(0),
                        rs.getDouble("amount") );
                transactions.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return transactions;
    }

    public Transaction fetch(String no_emp) {
        ResultSet rs = null;
        Transaction e = null;
        try {
            String query = "SELECT * FROM employees where id = '" + no_emp + "'";
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
            e = new Transaction(
                    rs.getInt("id"),
                    rs.getString("category"), rs.getString("description"),
                    rs.getDate("date_created"), rs.getString("type").charAt(0),
                    rs.getDouble("amount") );
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return e;
    }
    
    public Boolean delete(int id) {
        try {
            String query = "delete from transaction where id= ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Boolean insert(Transaction transaction) {
        try {
            String query = "insert into transaction "
                    + " (category, description, date_created, amount, type)"
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, transaction.getCategory());
            st.setString(2, transaction.getDescription());
            st.setDate(  3, transaction.getDate_created());
            st.setDouble(4, transaction.getAmount());
            st.setString(5, String.valueOf(transaction.getType()));
            st.execute();
            //data.add(transaction);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

    public Boolean update(Transaction transaction) {
        try {
            String query = "update transaction "
                    + " set category = ?, description = ?, date_created = ?, amount = ?, type = ?"
                    + " where id=?";
            System.out.println(query + "updating....");
            PreparedStatement st =  conn.prepareStatement(query);

            st.setString(1, transaction.getCategory());
            st.setString(2, transaction.getDescription());
            st.setDate(  3, transaction.getDate_created());
            st.setDouble(4, transaction.getAmount());
            st.setString(5, String.valueOf(transaction.getType()));
            st.setInt(6, transaction.getId());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

}
