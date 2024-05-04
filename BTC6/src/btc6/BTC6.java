/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package btc6;

import java.util.Scanner;

/**
 *
 * @author HP-TGL
 */
public class BTC6 {

    /**
     * @param args the command line arguments
     */
    
    public static void addBook(Scanner scanner, QuerySingleton manager){
        String title, author, genre, type;
        double value;
        int mount;
        System.out.print("Type: ");
        type=scanner.nextLine();
        System.out.print("Title: ");
        title=scanner.nextLine();
        System.out.print("Author: ");
        author=scanner.nextLine();
        System.out.print("Genre: ");
        genre=scanner.nextLine();
        System.out.print("Value: ");
        value=scanner.nextDouble();
        System.out.print("Mount: ");
        mount=scanner.nextInt();
        scanner.nextLine();
        manager.addBook(title,author,genre,value,mount,type);
    }
    public static void updateBook(Scanner scanner, QuerySingleton manager){
        String title, author, genre;
        double value;
        int id;
        System.out.print("Id: ");
        id=scanner.nextInt();
        System.out.print("Title: ");
        scanner.nextLine();
        title=scanner.nextLine();
        System.out.print("Author: ");
        author=scanner.nextLine();
        System.out.print("Genre: ");
        genre=scanner.nextLine();
        System.out.print("Value: ");
        value=scanner.nextDouble();
        manager.updateBook(id, title, author, genre, value);
    }
    public static void registerUser(Scanner scanner, QuerySingleton manager, int levelRole){
        String username, password, name, sex, type;
        System.out.print("Type: ");
        type=scanner.nextLine();
        if(levelRole<2&&!type.equals("customer")){
            System.out.println("Bạn không thể đăng ký tài khoản khác customer !!!");
            return;
        }
        System.out.print("Username: ");
        username=scanner.nextLine();
        System.out.print("Password: ");
        password=scanner.nextLine();
        System.out.print("Name: ");
        name=scanner.nextLine();
        System.out.print("Sex: ");
        sex=scanner.nextLine();
        
        manager.registerUser(username, password, name, sex,type);
    }
    public static void updateUser(Scanner scanner, QuerySingleton manager, User user){
        String username, password, name, sex, type;

        System.out.print("Password: ");
        password=scanner.nextLine();
        System.out.print("Name: ");
        name=scanner.nextLine();
        System.out.print("Sex: ");
        sex=scanner.nextLine();
        manager.updateUser(user, password, name, sex);
    }
    public static void main(String[] args) {
        //Biến cục bộ
        User user1;
        int levelRole;
        Order order =null;
        String message;
        QuerySingleton manager = QuerySingleton.getQuerySingleton();
        Scanner scanner = new Scanner (System.in);
        //User
        System.out.println("Khởi tạo người dùng đầu tiên: ");
        manager.registerUser("trangialong", "123", "Trần Gia Long", "nam","employee");
        user1=manager.getUser("trangialong", "123");
        levelRole=manager.checkRole(user1);
        System.out.println("Thông tin khởi tạo: "+user1.showInfo());
        //Khởi tạo sách
        manager.addBook("Harry Potter and The lost kingdom", "J.K.Rowling", "fantasy", 100000, 10,"internation");
        manager.addBook("Tuổi trẻ đáng giá bao nhiêu", "Rosie Nguyễn", "nation", 90000, 10,"nation");
        
        while(true){
            //Sách trong cửa hàng
            System.out.println("Danh sách sách có trong cửa hàng: ");
            manager.showBookShop();
            //Nhập thông điệp
            System.out.print("Mời nhập lệnh: ");
            message = scanner.nextLine();
            //Close program
            if(message.equals(".")){
                break;
            }
            //Manage book
            if(message.equals("add book")){
                if(levelRole>1){
                    addBook(scanner,manager);
                }
                continue;
            }
            if(message.equals("update book")){
                if(levelRole>1){
                    updateBook(scanner,manager);
                }
                continue;
            }
            if(message.equals("delete book")){
                if(levelRole>1){
                    System.out.print("Id book delete: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    manager.deleteBook(id);
                }
                continue;
            }
            //Manage user
            if(message.equals("login")){
                String username;
                String password;
                System.out.print("Username: ");
                username=scanner.nextLine();
                System.out.print("Password: ");
                password=scanner.nextLine();
                user1=manager.getUser(username,password);
                if(user1 == null){
                    System.out.println("Không đúng!");
                    continue;
                }
                System.out.println("Thông tin tài khoản: ");
                System.out.print(user1.showInfo());
                order = manager.getOrderByUsername(username);
                levelRole=manager.checkRole(user1);
                System.out.println("Level Role: "+String.valueOf(levelRole));
                continue;
            }
            if(message.equals("register user")){
                registerUser(scanner,manager,levelRole);
                continue;
            }
            if(message.equals("update user")){
                updateUser(scanner, manager, user1);
            }
            
            //Buy and search
            if(message.equals("search")){
                System.out.print("Mời nhập tựa sách muốn tìm: ");
                message=scanner.nextLine();
                manager.showBookListByName(message);
                continue;
            }
            if(message.equals("add cart")){
                String []idListString=scanner.nextLine().split(" ");
                int []idList=new int [idListString.length];
                for(int i =0 ;i<idListString.length;i++){
                    idList[i]=Integer.parseInt(idListString[i]);
                }
                //Cart chỉ khởi tạo ở bước mua
                order=manager.addBook(order,user1.getUsername(), idList);
                continue;
            }
            if(message.equals("cancel")){
                String []idListString=scanner.nextLine().split(" ");
                int []idList=new int [idListString.length];
                for(int i =0 ;i<idListString.length;i++){
                    idList[i]=Integer.parseInt(idListString[i]);
                }
                manager.cancel(order,idList);
                continue;
            }
            if(message.equals("buy")){
                order=manager.buyBook(order,user1.getUsername());
                continue;
            }
            //Show order
            if(message.equals("show")){
                manager.showOrder(order);
                continue;
            }
            if(message.equals("show all orders")){
                manager.showOrderByUsername(user1.getUsername());
                continue;
            }
            
        }
        
    }
    
}
