/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.Date;

/**
 *
 * @author Hung Pham
 */
public class transaction {
    private int id;
    private String phone;
    private String name;
    private int price;
    private Date date;
    private String royalize;
    private int paid;
    private int inDebt;

    public transaction(){
        super();
    }
    
    public transaction(int id, String phone, String name, int price, Date date, String royalize, int paid, int inDebt) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.price = price;
        this.date = date;
        this.royalize = royalize;
        this.paid = paid;
        this.inDebt = inDebt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRoyalize() {
        return royalize;
    }

    public void setRoyalize(String royalize) {
        this.royalize = royalize;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getInDebt() {
        return inDebt;
    }

    public void setInDebt(int inDebt) {
        this.inDebt = inDebt;
    }
     
}
