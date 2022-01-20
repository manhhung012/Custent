/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import object.customer;
import object.transaction;

/**
 *
 * @author Hung Pham
 */
public class setData {
    public static PreparedStatement pr = null;
    public static Statement st = null;
    public static ResultSet rs = null;
    public static Connection con = SQLiteConnection.getConnection();
    public static String sql;
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    
    public static int insertTransaction(transaction trans) throws SQLException, ParseException{
        sql = "insert into giaodich values (?,?,?,?,?,?)";
        
        pr = con.prepareStatement(sql);
        pr.setString(1, trans.getPhone());
        pr.setString(2, trans.getRoyalize());
        pr.setString(3, format.format(trans.getDate()));
        pr.setInt(4, trans.getPrice());
        pr.setInt(5, trans.getPaid());
        pr.setInt(6, trans.getId());
        
        int conf = pr.executeUpdate();
        
        return conf;
    }
    
    public static int insertCustomer(customer cus) throws SQLException{
        sql = "insert into khachhang values (?,?,?)";
        
        pr = con.prepareStatement(sql);
        pr.setString(1, cus.getPhone());
        pr.setString(2, cus.getName());
        pr.setString(3, cus.getAddress());
        int conf = pr.executeUpdate();
        
        return conf;
    }
    
    public static int updateTransaction(transaction trans) throws SQLException{
        int conf = 0;
        sql = "update giaodich set ghichu = ?, thanhtien = ?, thanhtoan = ? WHERE id = ?;";
        
        pr = con.prepareStatement(sql);
        pr.setString(1, trans.getRoyalize());
        pr.setInt(2, trans.getPrice());
        pr.setInt(3, trans.getPaid());
        pr.setInt(4, trans.getId());
        
        conf = pr.executeUpdate();
        
        return conf;
    }
}
