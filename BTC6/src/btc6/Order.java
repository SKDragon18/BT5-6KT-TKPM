/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btc6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP-TGL
 */
public class Order {
    private static int count;
    private int id;
    private String username;
    private List<Book> listBook;
    private float total;
    private Boolean using;
    
    static{
        count=0;
    }

    public Order() {
        this.id=count;
        count+=1;
        this.total=0;
        this.using=true;
    }

    public Order(String username) {
        this.username = username;
        this.listBook=new ArrayList<>();
        this.total=0;
        this.id=count;
        this.using=true;
        count+=1;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public List<Book> getListBook() {
        return listBook;
    }

    public void setListBook(List<Book> listBook) {
        this.listBook = listBook;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Boolean getUsing() {
        return using;
    }

    public void setUsing(Boolean using) {
        this.using = using;
    }
    
    

    public void addBook(Book book){
        if(book == null)return;
        if(book.getBought()){
            System.out.println("Book sold ...!");
            return;
        }
        if(this.listBook.contains(book)){
            System.out.println("Book is ordered ...!");
            return;
        }
        this.listBook.add(book);
        this.total+=book.getValue();
        
    }
    public void deleteBook(Book book){
        if(book == null)return;
        if(!this.listBook.contains(book)){
            System.out.println("Book is not ordered ...!");
            return;
        }
        if(book.getBought()){
            System.out.println("Book is sold ...!");
            return;
        }
        this.listBook.remove(book);
        this.total-=book.getValue();
    }
    public void buyBook(Book book){
        if(book == null)return;
        if(book.getBought()){
            System.out.println("Book sold ...!");
            return;
        }
        book.setBought(true);
    }
    
    public String showInfo(){
        String msg="";
        for(Book x: this.listBook){
            msg=msg+ String.valueOf(x.getId())+", ";
        }
        if(this.using){
            msg+="using ";
        }
        else{
            msg+="used ";
        }
        msg += "total bill: "+String.valueOf(this.total)+"\n";
        return msg;
    }
}
