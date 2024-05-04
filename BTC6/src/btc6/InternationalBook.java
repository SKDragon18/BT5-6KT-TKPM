/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btc6;

/**
 *
 * @author HP-TGL
 */
public class InternationalBook extends Book{
    private String translator;

    public InternationalBook() {
    }

    public InternationalBook(String title, String author, String genre,double value, String translator) {
        
        super(title, author, genre,value);
        this.translator=translator;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }
    
    @Override
    public String showInfo() {
        String msg= super.getTitle()+" - "+super.getAuthor()+" - "+ super.getGenre()+" - "+getTranslator();
        if(super.getBought()){
            msg+=" - Sold\n";
        }
        else{
            msg+=" - Available\n";
        }
        return msg;
    }
}
