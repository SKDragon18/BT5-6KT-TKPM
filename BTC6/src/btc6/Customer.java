/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btc6;

/**
 *
 * @author HP-TGL
 */
public class Customer extends User{
    private String address;
    private String phone;

    public Customer() {
    }

    public Customer(String address, String phone, String username, String password, String name, String sex) {
        super(username, password, name, sex);
        this.address = address;
        this.phone = phone;
    }
    
    

    
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String showInfo() {
        String msg=super.getUsername()+" - "+super.getName()+" - "+super.getSex()+" - "+this.address+" - "+ this.phone+"\n";
        return msg;
    }
    
}
