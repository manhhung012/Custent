/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author Hung Pham
 */
public class customer {
    private String phone;
    private String name;
    private String address;
    private int total;
    private int inDebt;
    
    public customer(){
        super();
    }

    public customer(String phone, String name, String address, int total, int inDebt) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.inDebt = inDebt;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getInDebt() {
        return inDebt;
    }

    public void setInDebt(int inDebt) {
        this.inDebt = inDebt;
    }
    
}
