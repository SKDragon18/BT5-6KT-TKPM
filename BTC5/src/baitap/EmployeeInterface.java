/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package baitap;

/**
 *
 * @author HP-TGL
 */
public interface EmployeeInterface {
    long luongCoBan=10000;
    void saveAndShow(long id, String ten);
    long getID();
    String getTen();
    void setID(long id);
    void setTen(String ten);
    long getLuong(long time);
    String toString();
}
