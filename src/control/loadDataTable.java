/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import object.customer;
import object.transaction;

/**
 *
 * @author Hung Pham
 */
public class loadDataTable {
    public static SimpleDateFormat convert = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy/MM/dd");
    public static DecimalFormat numFormatCur = new DecimalFormat("###,###,###,###.##đ");
    
    public static void loadDataTransaction(List<transaction> list, JTable tb){
        DefaultTableModel model = new DefaultTableModel();
        String col[] = {
          "STT","Số Điện Thoại","Tên Khách Hàng","Hàng hoá","Ngày Mua","Thành Tiền","Thanh Toán","Còn Nợ"
        };
        
        model.setColumnIdentifiers(col);
        for(int i = 0; i<list.size(); i++){
            Object[] row = {i+1,list.get(i).getPhone(),list.get(i).getName(),list.get(i).getRoyalize(),convert.format(list.get(i).getDate()),numFormatCur.format(list.get(i).getPrice()),numFormatCur.format(list.get(i).getPaid()),numFormatCur.format(list.get(i).getInDebt())};
                    model.addRow(row);
            }
                
        tb.setModel(model);
        MyTableModel(tb,7);
        MyTableModelCelL(tb, 5, 7, JLabel.RIGHT);
        MyTableModelCelL(tb, 6, 7, JLabel.RIGHT);
        MyTableModelCelL(tb, 7, 7, JLabel.RIGHT);
        MyTableModelCelL(tb, 1, 7, JLabel.CENTER);
        MyTableModelCelL(tb, 4, 7, JLabel.CENTER);
        tb.getColumnModel().getColumn(3).setPreferredWidth(180);
        tb.getColumnModel().getColumn(2).setPreferredWidth(100);
        tb.getColumnModel().getColumn(4).setPreferredWidth(60);
        tb.getColumnModel().getColumn(0).setPreferredWidth(25);
        
        
        tb.getTableHeader().setFont(new Font("Tahome",Font.BOLD,12));
        ((DefaultTableCellRenderer)tb.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tb.getTableHeader().setOpaque(false);
        tb.getTableHeader().setBackground(new Color(52, 152, 219));
        tb.getTableHeader().setForeground(Color.WHITE);
        
        tb.setDefaultEditor(Object.class, null);
    }
    
    public static void loadDataCustomer(List<customer> list, JTable tb){
        DefaultTableModel model = new DefaultTableModel();
        String col[] = {
          "STT","Số Điện Thoại","Tên Khách Hàng","Địa chỉ","Tổng mua","Nợ"
        };
        
        model.setColumnIdentifiers(col);
        
        for(int i = 0; i<list.size(); i++){
            Object[] row = {i+1,list.get(i).getPhone(),list.get(i).getName(),list.get(i).getAddress(),numFormatCur.format(list.get(i).getTotal()),numFormatCur.format(list.get(i).getInDebt())};
            model.addRow(row);
            }
        tb.setModel(model);
        MyTableModel(tb,5);
        MyTableModelCelL(tb, 4, 5,JLabel.RIGHT);
        MyTableModelCelL(tb, 5, 5,JLabel.RIGHT);
        MyTableModelCelL(tb, 1, 5,JLabel.CENTER);
        tb.getColumnModel().getColumn(3).setPreferredWidth(150);
        tb.getColumnModel().getColumn(2).setPreferredWidth(85);
        tb.getColumnModel().getColumn(4).setPreferredWidth(60);
        tb.getColumnModel().getColumn(5).setPreferredWidth(60);
        tb.getColumnModel().getColumn(1).setPreferredWidth(20);
        tb.getColumnModel().getColumn(0).setPreferredWidth(2);

        
        tb.getTableHeader().setFont(new Font("Tahome",Font.BOLD,12));
        tb.getTableHeader().setOpaque(false);
        tb.getTableHeader().setBackground(new Color(52, 152, 219));
        tb.getTableHeader().setForeground(Color.WHITE);
        ((DefaultTableCellRenderer)tb.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tb.setSelectionBackground(new java.awt.Color(0, 204, 153));
        
        tb.setDefaultEditor(Object.class, null);
    }
    
    public static void loadDataTransactionOfCustomer(List<transaction> list, JTable tb){
        DefaultTableModel model = new DefaultTableModel();
        String col[] = {
          "STT","Hàng hoá","Ngày Mua","Thành Tiền","Thanh Toán","Còn Nợ"
        };
        
        model.setColumnIdentifiers(col);
        for(int i = 0; i<list.size(); i++){
            Object[] row = {i+1,list.get(i).getRoyalize(),convert.format(list.get(i).getDate()),numFormatCur.format(list.get(i).getPrice()),numFormatCur.format(list.get(i).getPaid()),numFormatCur.format(list.get(i).getInDebt())};
                    model.addRow(row);
            }
        tb.setModel(model);
        MyTableModel(tb,5);
        MyTableModelCelL(tb, 5, 5,JLabel.RIGHT);
        MyTableModelCelL(tb, 4, 5,JLabel.RIGHT);
        MyTableModelCelL(tb, 3, 5,JLabel.RIGHT);
        MyTableModelCelL(tb, 2, 5,JLabel.CENTER);
        tb.getColumnModel().getColumn(1).setPreferredWidth(180);
        tb.getColumnModel().getColumn(0).setPreferredWidth(25);
        
        tb.getTableHeader().setFont(new Font("Tahome",Font.BOLD,12));
        ((DefaultTableCellRenderer)tb.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tb.getTableHeader().setOpaque(false);
        tb.getTableHeader().setBackground(new Color(52, 152, 219));
        tb.getTableHeader().setForeground(Color.WHITE);
        
        tb.setDefaultEditor(Object.class, null);
    }
    
    public static void MyTableModel(JTable tb, int col){
        tb.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
        @Override
        public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row, int column){
            JLabel component = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Color c = Color.BLACK;
            Object text = tb.getValueAt(row, col);
            if(text !=null&&!"0đ".equals(text.toString())) c = Color.RED;
            component.setForeground(c);
            return component;
        }
        });
    }
    
    public static void MyTableModelCelL(JTable tb, int col, int valueCol, int direction){
        tb.getColumnModel().getColumn(col).setCellRenderer(new DefaultTableCellRenderer(){
        @Override
        public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row, int column){
            JLabel component = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Color c = Color.BLACK;
            Object text = tb.getValueAt(row, valueCol);
            if(text !=null&&!"0đ".equals(text.toString())) c = Color.RED;
            component.setForeground(c);
            component.setHorizontalAlignment(direction);
            return component;
        }   
        });
    }
}
