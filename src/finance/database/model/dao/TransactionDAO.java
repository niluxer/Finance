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
                    rs.getString("category"), rs.getString("description"),
                    rs.getDate("date"), rs.getString("type").charAt(0),
                    rs.getDouble("amount") );
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return e;
    }
    
    public Boolean delete(int id) {
        try {
            String query = "delete from transactions where id= ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
  /*  public Boolean insert(Transaction employee) {
        try {
            String query = "insert into transaction "
                    + " (emp_no, birth_date, first_name, last_name, gender, hire_date)"
                    + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setInt(   1, employee.getEmp_no());
            st.setDate(  2, employee.getBirth_date());
            st.setString(3, employee.getFirst_name());
            st.setString(4, employee.getLast_name());
            st.setString(5, String.valueOf(employee.getGender()));
            st.setDate(  6, employee.getHire_date());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        return false;
    }    

    public Boolean update(Employee employee) {
        try {
            String query = "update employees "
                    + " set birth_date = ?, first_name = ?, last_name = ?, gender = ?, hire_date = ?"
                    + " where emp_no=?";
            PreparedStatement st =  conn.prepareStatement(query);

            st.setDate(  1, employee.getBirth_date());
            st.setString(2, employee.getFirst_name());
            st.setString(3, employee.getLast_name());
            st.setString(4, String.valueOf(employee.getGender()));
            st.setDate(  5, employee.getHire_date());
            st.setInt(   6, employee.getEmp_no());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }*/

}
