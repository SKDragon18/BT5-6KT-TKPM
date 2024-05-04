/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btc6;

/**
 *
 * @author HP-TGL
 */
public class UserFactory {
    public User getUser(String type){
        if(type.equals("customer")){
            return new Customer();
        }
        return new Employee();
    }
}
