/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap;

/**
 *
 * @author HP-TGL
 */
public class BaiTap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Test USA Address: ");
        USAAddress record1= new USAAddress("123 Wall Street","New York City","New York","90210","USA");
        System.out.println(record1.toString());
        if(record1.validate()){
            System.out.println("USAAddress confirm");
        }
        else{
            System.out.println("USAAddress not confirm");
        }
        System.out.print("Test VN Address: ");
        VNAddress record2= new VNAddress("123 Nguyễn Trãi Phường 2 Quận 5","Thành phố Hồ Chí Minh","TP Hồ Chí Minh","700000","VN");
        System.out.println(record2.toString());
        if(record2.validate()){
            System.out.println("VNAddress confirm");
        }
        else{
            System.out.println("VNAddress not confirm");
        }
        
        Employee newEmployee = new SalesRep(1,"Hùng",10000);
        Employee newEmployee2 = new Consultant(1,"Hào",10000);
        newEmployee.saveAndShow(1,"Hùng",20000);
        newEmployee2.saveAndShow(1,"Hào",30000);
        System.out.println(String.valueOf(newEmployee.getLuong(100)));
        System.out.println(String.valueOf(newEmployee2.getLuong(100)));
        SalesRepUseInterface newEmployee3 = new SalesRepUseInterface(1, "Hùng");
        ConsultantUseInterface newEmployee4 = new ConsultantUseInterface(1,"Hào");
        newEmployee3.saveAndShow(1,"Hùng");
        newEmployee4.saveAndShow(1,"Hào");
        System.out.println(String.valueOf(newEmployee.getLuong(100)));
        System.out.println(String.valueOf(newEmployee2.getLuong(100)));
        //So sánh
        // Sử dụng abstract ở lớp cơ sở có thể thay đổi một thuộc tính (ngoài final) ở đây là thuộc tính (luongCoBan)
        // Sử dụng interface không thể thay đổi thuộc tính trong interface (vì mặc định là final và không thể thay đổi)
        // Khi sử dụng abstract ở lớp cơ sở ta phải trích xuất thuộc tính trong lớp cơ sở thông qua một hàm public trong lớp
        // Khi sử dụng interface, ta có thể truy xuất trực tiếp thuộc tính vì nó ở chế độ (public final static)
        // Khi sử dụng lớp trừu tượng, ta có thể sử dụng chính lớp đó để khai báo và khởi tạo cho đối tượng
        // Không thể sử dụng interface để khai báo và khởi tạo cho đối tượng.
    }
    
}
