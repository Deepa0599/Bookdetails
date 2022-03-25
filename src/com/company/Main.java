package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int options;
        while (true){
            System.out.println("1. Add students");
            System.out.println("2. View all students");
            System.out.println("3. Delete a students");
            System.out.println("4. Exit");
            System.out.println("select an option");
            options =sc.nextInt();
            switch (options){

                case 1:
                    String name,admissionno,rollno,college;
                    System.out.println("Enter name");
                    name = sc.next();
                    System.out.println("Enter admissionno");
                    admissionno = sc.next();
                    System.out.println("Enter rollno");
                    rollno = sc.next();
                    System.out.println("Enter college");
                    college = sc.next();


                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `students`( `Name`,`Rollno`,`AdmissionNo`,`College`) VALUES('"+name+"',"+rollno+","+admissionno+",'"+college+"')");
                        System.out.println("Inserted Succesfully");

                    }
                    catch (Exception object){
                        System.out.println(object);
                    }




                    break;

                case 2:


                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college1?autoReconnect=true&useSSL=false","root","");
                        Statement  stmt = con.createStatement();
                        ResultSet rs=stmt.executeQuery("SELECT`id`,`Name`,`Rollno`,`AdmissionNo`,`College`FROM`students`WHERE 1");
                        while (rs.next())
                        {
                            System.out.println("Name: "+rs.getString("Name"));
                            System.out.println("Rollno: "+rs.getInt("Rollno"));
                            System.out.println("AdmisionNo: "+rs.getInt("AdmissionNo"));
                            System.out.println("College: "+rs.getString("College"));
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }


                    break;




                case 3:

                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        int admno;
                        System.out.println("Enter the admission no to be deleted");
                        admno = sc.nextInt();

                        stmt.executeUpdate("DELETE FROM `student` WHERE `AdmissionNo`= " + admno);
                        System.out.println("delected ");


                    }
                    catch(Exception e){
                        System.out.println(e);

                    }



                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}
