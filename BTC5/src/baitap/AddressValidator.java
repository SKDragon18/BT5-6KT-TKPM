/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package baitap;

/**
 *
 * @author HP-TGL
 */
public interface AddressValidator {
    public boolean validateStreet(String street);
    public boolean validateCity(String city);
    public boolean validateState(String state);
    public boolean validateZipCode(String zipCode);
    public boolean validateCountry(String country);
    public boolean validate();
}