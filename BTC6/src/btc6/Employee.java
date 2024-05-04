/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btc6;

/**
 *
 * @author HP-TGL
 */
public class Employee extends User{
    private String role;

    public Employee() {
    }

    public Employee(String role, String username, String password, String name, String sex) {
        super(username, password, name, sex);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public String showInfo() {
        String msg=super.getUsername()+" - "+super.getName()+" - "+super.getSex()+" - "+this.role+"\n";
        return msg;
    }
    
}
