/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP-TGL
 */
public class SalesRep extends Employee{
    private long id;
    private String ten;
    private static long luongThem=200;

    public SalesRep() {
        super();
    }

    public SalesRep(long id, String ten, long luongCoBan) {
        super(luongCoBan);
        this.id = id;
        this.ten = ten;
    }
    @Override
    public void setID(long id) {
        this.id = id;
    }
    @Override
    public long getID() {
        return id;
    }
    @Override
    public void setTen(String ten){
        this.ten=ten;
    }
    @Override
    public String getTen() {
        return ten;
    }

    @Override
    public long getLuong(long time) {
        return super.getLuongCoBan()+time*luongThem;
    }

    public long getLuongThem() {
        return luongThem;
    }

    public void setLuongThem(long luongThem) {
        this.luongThem = luongThem;
    }
    
    
    
    @Override
    public void saveAndShow(long id, String ten, long luongCoBan) {
        this.id=id;
        this.ten=ten;
        super.setLuongCoBan(luongCoBan);
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return "ID: "+ String.valueOf(this.id)+ " - Ten: "+this.ten+" - Luong co ban: "+String.valueOf(super.getLuongCoBan())+" - Them: "+String.valueOf(this.luongThem);
    }
    
}
