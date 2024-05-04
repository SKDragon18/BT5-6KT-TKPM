/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btc6;

/**
 *
 * @author HP-TGL
 */
public class NationalBook extends Book{
    public NationalBook(){
        
    }
    public NationalBook(String title, String author, String genre, double value) {
        
        super(title, author, genre, value);
    }
    @Override
    public String showInfo() {
        String msg= super.getTitle()+" - "+super.getAuthor()+" - "+ super.getGenre();
        if(super.getBought()){
            msg+=" - Sold\n";
        }
        else{
            msg+=" - Available\n";
        }
        return msg;
    }
    
}
