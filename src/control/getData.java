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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import object.customer;
import object.transaction;

/**
 *
 * @author Hung Pham
 */
public class getData {
    public static PreparedStatement pr = null;
    public static Statement st = null;
    public static ResultSet rs = null;
    public static Connection con = SQLiteConnection.getConnection();
    public static String sql;
    public static DateFormat format;
    public static SimpleDateFormat convert = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy/MM/dd");
    
    public static List<transaction> getTransaction(String startDate, String endDate) throws SQLException, ParseException{
        List<transaction> list = new ArrayList<>();
        
        sql = "select khachhang.sdt, khachhang.tenkh, giaodich.thanhtien, giaodich.ghichu, giaodich.ngay, giaodich.thanhtoan, giaodich.id, giaodich.thanhtien - giaodich.thanhtoan as no from giaodich inner join khachhang on giaodich.sdt = khachhang.sdt where ngay >= ?  and ngay <= ? order by id desc;";
        
        pr = con.prepareStatement(sql);
        pr.setString(1, startDate);
        pr.setString(2, endDate);
        
        rs = pr.executeQuery();
        
        while(rs.next()){
            transaction trans = new transaction();
            trans.setPhone(rs.getString("sdt"));
            trans.setName(rs.getString("tenkh"));
            trans.setPrice(rs.getInt("thanhtien"));
            trans.setRoyalize(rs.getString("ghichu"));
            trans.setPaid(rs.getInt("thanhtoan"));
            trans.setInDebt(rs.getInt("no"));              
            trans.setDate(convertToDate.parse(rs.getString("ngay")));
            trans.setId(rs.getInt("id"));
            
            list.add(trans);
        }
        
        return list;
    }
    public static List <customer> getCustomer(String startDate, String endDate) throws SQLException{
        List<customer> list = new ArrayList<>();
        
        sql = "select khachhang.sdt, khachhang.tenkh, khachhang.diachi, sum(thanhtien) as tongmua, sum(thanhtien) - sum(thanhtoan) as no from giaodich inner join khachhang on khachhang.sdt = giaodich.sdt where ngay >= ? and ngay <= ? group by khachhang.sdt order by tongmua desc;";
        
        pr = con.prepareStatement(sql);
        pr.setString(1, startDate);
        pr.setString(2 , endDate);
        rs = pr.executeQuery();
        
        while(rs.next()){
            customer cus = new customer();
            cus.setPhone(rs.getString("sdt"));
            cus.setName(rs.getString("tenkh"));
            cus.setAddress(rs.getString("diachi"));
            cus.setTotal(rs.getInt("tongmua"));
            cus.setInDebt(rs.getInt("no"));
            
            list.add(cus);
        }
        return list;
    }
    
    public static List <customer> findCustomer(String str, List<customer> listCust) throws SQLException{
        List<customer> list = new ArrayList<>();
        
        for(int i = 0; i < listCust.size(); i++){
            if(VNCharacterUtils.removeAccent((String.valueOf(listCust.get(i).getPhone())+listCust.get(i).getName()).toLowerCase()).contains(VNCharacterUtils.removeAccent(str.toLowerCase()))){
                list.add(listCust.get(i));
            }
        }
        return list;
    }
    
    public static int getTotalRevenue(String startDate, String endDate) throws SQLException{
        int sum = 0;
        
        sql = "select sum(thanhtien) as tongday from giaodich where ngay >= ? and ngay <= ?;";
        
        pr = con.prepareStatement(sql);
        pr.setString(1, startDate);
        pr.setString(2, endDate);
        
        rs = pr.executeQuery();
        
        while(rs.next()){
            sum = rs.getInt("tongday");
        }
        
        return sum;
    }

    public static int getTotalPaid(String startDate, String endDate) throws SQLException{
        int sum = 0;
        
        sql = "select sum(thanhtoan) as tongdaythu from giaodich where ngay >= ? and ngay <= ?;";
        
        pr = con.prepareStatement(sql);
        pr.setString(1, startDate);
        pr.setString(2, endDate);
        
        rs = pr.executeQuery();
        
        while(rs.next()){
            sum = rs.getInt("tongdaythu");
        }
        
        return sum;
    }
    
    public static List<transaction> getHistoryTransaction(String phone, String startDate, String endDate) throws SQLException, ParseException{
        List<transaction> list = new ArrayList<>();
        List<transaction> listTransaction = getTransaction(startDate, endDate);
        for (int i = 0; i < listTransaction.size(); i++) {
            if(listTransaction.get(i).getPhone().equals(phone))
                list.add(listTransaction.get(i));
        }
        return list;
    }
    
    public static int getTotalPrice(List<transaction> listTrans) throws SQLException, ParseException{
        int sum = 0;
        for (int i = 0; i < listTrans.size(); i++) {
            sum = sum + listTrans.get(i).getPrice();
        }
        return sum;
    }

    public static int getTotalPaid(List<transaction> listTrans) throws SQLException, ParseException{
        int sum = 0;
        for (int i = 0; i < listTrans.size(); i++) {
            sum = sum + listTrans.get(i).getPaid();
        }
        return sum;
    }

    public static int getTotalIndebt(List<transaction> listTrans) throws SQLException, ParseException{
        int sum = 0;
        for (int i = 0; i < listTrans.size(); i++) {
            sum = sum + listTrans.get(i).getInDebt();
        }
        return sum;
    }
    
    public static int getCountTransaction() throws SQLException{
        int count = 0;
        sql = "select count(*) from giaodich;";
        
        st = con.createStatement();
        
        rs = st.executeQuery(sql);
        
        while(rs.next()){
            count = rs.getInt("count(*)");
        }
        
        return count;
    }
    
    public static List <customer> getListInfoCustomer() throws SQLException{
        List<customer> list = new ArrayList<>();
        
        sql = "select * from khachhang";
        
        st = con.createStatement();
        rs = st.executeQuery(sql);
        
        while(rs.next()){
            customer cus = new customer();
            cus.setPhone(rs.getString("sdt"));
            cus.setName(rs.getString("tenkh"));
            cus.setAddress(rs.getString("diachi"));
            
            list.add(cus);
        }
        return list;
    }
    
    public static boolean checkPhoneDuplicate(String phone) throws SQLException{
        List<customer> list = getListInfoCustomer();
        for(int i = 0; i < list.size(); i ++){
            if(list.get(i).getPhone().equals(phone)){
                return true;
            }
        }
        return false;
    }
    
}
