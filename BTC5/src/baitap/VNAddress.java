/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap;

/**
 *
 * @author HP-TGL
 */
public class VNAddress implements AddressValidator{
    private static String [] stateList={
        "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu",
  "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước",
  "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng",
  "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp",
  "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh",
  "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên",
  "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng",
  "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An",
  "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
  "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng",
  "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa",
  "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh",
  "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"
    };
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    
    public VNAddress(){};
    
    public VNAddress(String street, String city, String state, String zipCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

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
    
    @Override
    public boolean validateStreet(String street) {
        return street!=null&& !street.isEmpty();
    }

    @Override
    public boolean validateCity(String city) {
        return city!=null&& !city.isEmpty();
    }

    @Override
    public boolean validateState(String state) {
        if( state==null &&state.isEmpty()){
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
        return zipCode!=null &&zipCode.matches("^\\d{6}$");
    }

    @Override
    public boolean validateCountry(String country) {
        return "VN".equalsIgnoreCase(country);
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
