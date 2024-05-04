/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btc6;

/**
 *
 * @author HP-TGL
 */
public abstract class Book {
    private static int count;
    private int id;
    private String title;
    private String author;
    private String genre;
    private double value;
    private Boolean bought;
    
    static{
        count= 0;
    }
    
    public Book() {
        this.id=count;
        count+=1;
        this.bought=false;
    }

    public Book(String title, String author, String genre, double value) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.value=value;
        this.bought=false;
        this.id=count;
        count+=1;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Boolean getBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }

    
    
    
    public abstract String showInfo();

    
}
