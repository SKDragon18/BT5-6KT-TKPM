/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkginterface.pkgabstract;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Administrator
 */
interface SalaryCaculator{
    BigDecimal getSalary(int hours);
    void display(int hours);
}
//    private String loai;
//    private BigDecimal salary;
//    private BigDecimal overtimeSalary;
abstract class Employee implements SalaryCaculator{
    public Employee() {
    }
}
class CategoryA extends Employee{
    private String loai = "A";
    private BigDecimal salary = BigDecimal.valueOf(2000);
    private BigDecimal overtimeSalary = BigDecimal.valueOf(15);
    
    @Override
    public BigDecimal getSalary(int hours){
        return overtimeSalary.multiply(BigDecimal.valueOf(hours)).add(salary);
    }
    @Override
    public void display(int hours){
        System.err.println(loai+getSalary(hours));
    };
}
class CategoryB extends Employee{
    private String loai = "B";
    private BigDecimal salary = BigDecimal.valueOf(2000);
    private BigDecimal overtimeSalary = BigDecimal.valueOf(15);

    @Override
    public BigDecimal getSalary(int hours){
        return overtimeSalary.multiply(BigDecimal.valueOf(hours)).add(salary);
    }
    @Override
        public void display(int hours){
        System.err.println(loai+getSalary(hours));
    };
}
class CategoryC extends Employee{
    private String loai = "C";
    private BigDecimal salary = BigDecimal.valueOf(2000);
    private BigDecimal overtimeSalary = BigDecimal.valueOf(15);

    @Override
    public BigDecimal getSalary(int hours){
        return overtimeSalary.multiply(BigDecimal.valueOf(hours)).add(salary);
    }
    @Override
        public void display(int hours){
        System.err.println(loai+ " " +getSalary(hours));
    };
}

interface Search {
    int findBook(List<Book> books, Book target);
}

// Lớp Book
class Book {
    private String title;
    private String author;
    // Các thuộc tính khác và phương thức khởi tạo

    // Getters và Setters
    public String getTitle() {
        return title;
    }

    // Phương thức equals để so sánh hai sách
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book other = (Book) obj;
            return this.title.equals(other.getTitle());
        }
        return false;
    }
}

// Lớp BinarySearch
class BinarySearch implements Search {
    @Override
    public int findBook(List<Book> books, Book target) {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
        int low = 0;
        int high = books.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Book midVal = books.get(mid);
            int cmp = midVal.getTitle().compareTo(target.getTitle());
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // sách được tìm thấy
            }
        }
        return -1; // không tìm thấy sách
    }
}

// Lớp LinearSearch
class LinearSearch implements Search {
    @Override
    public int findBook(List<Book> books, Book target) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(target)) {
                return i; // sách được tìm thấy
            }
        }
        return -1; // không tìm thấy sách
    }
}
public class InterfaceAbstract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SalaryCaculator caculator = new CategoryC();
        caculator.display(4);
    }
}
