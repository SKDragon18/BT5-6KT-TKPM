/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btc6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HP-TGL
 */
public class QuerySingleton {
    private static QuerySingleton query;
    private static List<User> userList;
    private static List<Order> orderList;
    private static List<Book> bookList;
    
    private QuerySingleton(){
        userList=new ArrayList<>();
        bookList=new ArrayList<>();
        orderList=new ArrayList<>();
    }
    
    public static QuerySingleton getQuerySingleton(){
        if(query == null){
            query=new QuerySingleton();
        }
        return query;
    }
    
    //Getter

    public static List<User> getUserList() {
        return userList;
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static List<Book> getBookList() {
        return bookList;
    }
    
    
    //User
    public int checkRole(User user){
        if(user.getClass().equals(Customer.class)){
            return 1;
        }
        else if(user.getClass().equals(Employee.class)){
            if(((Employee)user).getRole().equals("admin")){
                return 3;
            }
            return 2;
        }
        return 0;
    }
    public User getUser(String username, String password){
        for(User x: userList){
            if(x.getUsername().equals(username)){
                if(x.getPassword().equals(password)){
                    return x;
                }
            }
        }
        return null;
    }
    
    public synchronized void registerUser(String username, String password, String name, String sex, String type){
        UserFactory userFactory = new UserFactory();
        Scanner scanner = new Scanner (System.in);
        User user = userFactory.getUser(type);
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSex(sex);
        
        if(user.getClass().equals(Employee.class)){
            String role;
            System.out.println("Role: ");
            role=scanner.nextLine();
            ((Employee)user).setRole(role);
        }
        else{
            String address, phone;
            System.out.println("Address: ");
            address=scanner.nextLine();
            System.out.println("Phone: ");
            phone=scanner.nextLine();
            ((Customer)user).setAddress(address);
            ((Customer)user).setPhone(phone);
        }
        userList.add(user);
        
    }
    public synchronized User updateUser(User user, String password, String name, String sex){
        Scanner scanner = new Scanner (System.in);
        user.setPassword(password);
        user.setName(name);
        user.setSex(sex);
        if(user.getClass().equals(Customer.class)){
            String address, phone;
            System.out.println("Address: ");
            address=scanner.nextLine();
            System.out.println("Phone: ");
            phone=scanner.nextLine();
            ((Customer)user).setAddress(address);
            ((Customer)user).setPhone(phone);
        }
        return user;
    }
    
    //Book
    public synchronized void addBook(String title, String author, String genre, double value, int mount, String type){
        BookFactory bookFactory = new BookFactory();
        String translator=null;
        if(!type.equals("nation")){
                System.out.println("Phát hiện international book, mời nhập người phiên dịch cuốn '"+title+"' : ");
                Scanner scanner = new Scanner (System.in);
                translator = scanner.nextLine();
            }
        for(int i=0;i<mount;i++){
            Book book= bookFactory.getBook(type);
            book.setAuthor(author);
            book.setGenre(genre);
            book.setTitle(title);
            book.setValue(value);
            if(book.getClass().equals(InternationalBook.class)){
                ((InternationalBook)book).setTranslator(translator);
            }
            bookList.add(book);
        }
    }
    
    public synchronized void updateBook(int id, String title, String author, String genre, double value){
        Book book = searchBook(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setValue(value);
        if(book.getClass().equals(InternationalBook.class)){
                System.out.println("Người phiên dịch cuốn '"+title+"' : ");
                Scanner scanner = new Scanner (System.in);
                String translator = scanner.nextLine();
                ((InternationalBook)book).setTranslator(translator);
            }
    }
    
    public synchronized void deleteBook(int id){
        Book book = searchBook(id);
        bookList.remove(book);
    }
    
    
    
    public Book searchBook(int id){
        for (Book x: bookList){
            if(x.getId()==id){
                return x;
            }
        }
        return null;
    }
    
    public List<Book> searchBookByName(String name){
        List<Book> listTemp=new ArrayList<>();
        for (Book x: bookList){
            if(x.getTitle().contains(name)){
                listTemp.add(x);
            }
        }
        return listTemp;
    }
    
    public void showBookShop(){
        List<String> titleList = new ArrayList<>();
        List<Integer> mountList=new ArrayList<>();
        List<Book> listTemp=new ArrayList<>();
        for (Book x: bookList){
            if(!x.getBought()){
                listTemp.add(x);
            }
        }
        for (Book x: listTemp){
            if(!titleList.contains(x.getTitle())){
                titleList.add(x.getTitle());
                int count=0;
                for(Book y: listTemp){
                    if(y.getTitle().equals(x.getTitle())){
                        count+=1;
                    }
                }
                mountList.add(count);
            }
        }
        for(int i=0;i<titleList.size();i++){
            System.out.print(String.valueOf(i+1)+". ");
            System.out.print(titleList.get(i)+" - mount: ");
            System.out.println(mountList.get(i));
        }
    }
    public void showBookListByName(String title){
        List<Book> listTemp = searchBookByName(title);
        for(Book x: listTemp){
            System.out.print(String.valueOf(x.getId())+". - ");
            System.out.print(x.showInfo());
        }
    }
    
    public void showOrder(Order order){
        if(order == null){
            System.out.println("Order is not inited!...");
            return;
        }
        List<Book> listTemp = order.getListBook();
        for(Book x: listTemp){
            System.out.print(String.valueOf(x.getId())+". - ");
            System.out.print(x.showInfo());
        }
    }
    
    public void showOrderByUsername(String username){
        List<Order> listTemp = new ArrayList<>();
        for(Order order: orderList){
            if(order.getUsername().equals(username)){
                listTemp.add(order);
            }
        }
        for(Order order: listTemp){
            System.out.print(order.showInfo());
        }
    }
    
    //Order
    public Order getOrderByUsername(String username){
        for(Order x: orderList){
            if(x.getUsername().equals(username)&&x.getUsing()){
                return x;
            }
        }
        return null;
    }
    public synchronized Order buyBook(Order order, String username){
        int key=0;
        if(order==null){
            System.out.println("Error: Cart is not inited ...!");
            return order;
        }
        for(Book book: order.getListBook()){
            if(book.getBought()){
                System.out.println("Phát hiện sách "+book.getTitle()+" đã bán !");
                key=1;
            }
        }
        if(key==1){
            Order temp= new Order(username);
            for(Book book: order.getListBook()){
                if(!book.getBought()){
                    temp.addBook(book);
                }
            }
            orderList.add(temp);
            orderList.remove(order);
            order=null;
            System.out.println("Đã loại bỏ những sách đã được bán cho khách khác! Mời thực hiện lại thao tác mua!");
            return temp;
        }
        for(Book book: order.getListBook()){
            order.buyBook(book);
        }
        order.setUsing(false);
        order =new Order(username);
        orderList.add(order);
        return order;
    }
    public synchronized Order addBook(Order order, String username, int []idList){
        
        if(order==null){
            order=new Order(username);
            orderList.add(order);
        }
        for(int x: idList){
            Book book= searchBook(x);
            order.addBook(book);
        }
        return order;
    }
    public synchronized void cancel(Order order, int[]idList){
        if(order==null){
            System.out.println("Error: Cart is not inited ...!");
            return;
        }
        for(int x: idList){
            Book book= searchBook(x);
            order.deleteBook(book);
        }
        if(order.getListBook().size()==0){
            orderList.remove(order);
        }
    }
}
