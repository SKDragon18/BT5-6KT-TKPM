/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btc6;

/**
 *
 * @author HP-TGL
 */
public class BookFactory {
    //Method factory
    public Book getBook(String type){
        if(type.equals("nation")){
            return new NationalBook();
        }
        return new InternationalBook();
    }
}
