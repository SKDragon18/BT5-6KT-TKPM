/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap;

/**
 *
 * @author HP-TGL
 */
public abstract class Employee {
    private long luongCoBan;

    public Employee() {
    }

    public Employee(long luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public long getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(long luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    
    public abstract void saveAndShow(long id, String ten, long luongCoBan);
    public abstract long getID();
    public abstract String getTen();
    public abstract void setID(long id);
    public abstract void setTen(String ten);
    public abstract long getLuong(long time);
    public abstract String toString();
}
