package com.company;


import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.Statement;
        import java.util.Scanner;

public class bookdetail {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int options;
        while (true){
            System.out.println("1. Add Books");
            System.out.println("2. View all Books detals");
            System.out.println("3. Exit");
            System.out.println("select an option");
            options= sc.nextInt();
            switch (options){
                case 1:
                    String bookname,auther,publisher,distributor,price;
                    System.out.println("Enter Bookname");
                    bookname= sc.next();
                    System.out.println("Enter Name of Author");
                    auther= sc.next();
                    System.out.println("Enter Name Of Publisher");
                    publisher= sc.next();
                    System.out.println("Enter Name of Distributor");
                    distributor=sc.next();
                    System.out.println("Enter Price of book");
                    price= sc.next();

                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `book`(`bookName`,`author`,`publisher`,`distributor`,`price`) VALUES ('"+bookname+"','"+auther+"','"+publisher+"','"+distributor+"',"+price+")");
                        System.out.println("Inserted Succesfully");
                    }
                    catch (Exception e){
                        System.out.println(e);

                    }
                case 2:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","");
                        Statement  stmt = con.createStatement();
                        ResultSet rs=stmt.executeQuery("SELECT`id`,`BookName`,`Author`,`Publisher`,`Distributor`,`Price`FROM`book`WHERE 1");
                        while (rs.next()){
                            System.out.println("BookName: "+rs.getString("bookName"));
                            System.out.println("AuthorName: "+rs.getString("author"));
                            System.out.println("publisherName: "+rs.getString("publisher"));
                            System.out.println("DistributorName: "+rs.getString("distributor"));
                            System.out.println("Price: "+rs.getInt("price"));
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                case 3:
                    System.out.println("Exit option selected");
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}