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
public class USAAddress implements AddressValidator{
    private static String[] stateList={"Alabama", "Alaska", "Arizona", "Arkansas"
            , "California", "Colorado", "Connecticut", "Delaware", 
            "Florida", "Georgia", "Hawaii", "Idaho", 
            "Illinois", "Indiana", "Iowa", "Kansas", 
            "Kentucky", "Louisiana", "Maine", "Maryland", 
            "Massachusetts", "Michigan", "Minnesota", "Mississippi", 
            "Missouri", "Montana", "Nebraska", "Nevada", 
            "New Hampshire", "New Jersey", "New Mexico", "New York", 
            "North Carolina", "North Dakota", "Ohio", "Oklahoma", 
            "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", 
            "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", 
            "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public USAAddress(){
    }
    public USAAddress(String street, String city, String state, String zipCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }
    
    @Override
    public boolean validateStreet(String street) {
        return street != null && !street.isEmpty();
    }
    
    @Override
    public boolean validateCity(String city) {
        return city !=null && !city.isEmpty();
    }

    @Override
    public boolean validateState(String state) {
        if (state==null||state.isEmpty()){
            return false;
        }
        for(String x: stateList){
            if(state.equalsIgnoreCase(x)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validateZipCode(String zipCode) {
        return zipCode!=null && zipCode.matches("^\\d{5}(-\\d{4})?$");
    }

    @Override
    public boolean validateCountry(String country) {
        return "USA".equalsIgnoreCase(country);
    }

    @Override
    public boolean validate() {
        if(!validateStreet(this.street)){
            System.out.println("Street wrong");
            return false;
        }
        if(!validateCity(this.city)){
            System.out.println("City wrong");
            return false;
        }
        if(!validateState(this.state)){
            System.out.println("State wrong");
            return false;
        }
        if(!validateZipCode(this.zipCode)){
            System.out.println("Zipcode wrong");
            return false;
        }
        if(!validateCountry(this.country)){
            System.out.println("Country wrong");
            return false;
        }
        return true; 
    }
    
    public String toString(){
        return this.street+", "+this.state+", "+this.city+", "+this.country+", ("+this.zipCode+")";
    }
    
}
