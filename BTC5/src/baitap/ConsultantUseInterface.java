/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap;

/**
 *
 * @author HP-TGL
 */
public class ConsultantUseInterface implements EmployeeInterface{
    private long id;
    private String ten;
    private static long luongThem=100;

    public ConsultantUseInterface(){
        
    }
    public ConsultantUseInterface(long id, String ten) {
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
        return luongCoBan+time*luongThem;
    }

    public long getLuongThem() {
        return luongThem;
    }

    public void setLuongThem(long luongThem) {
        this.luongThem = luongThem;
    }
    
    
    
    @Override
    public void saveAndShow(long id, String ten) {
        this.id=id;
        this.ten=ten;
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return "ID: "+ String.valueOf(this.id)+ " - Ten: "+this.ten+" - Luong co ban: "+String.valueOf(luongCoBan)+" - Them: "+String.valueOf(this.luongThem);
    }
}
