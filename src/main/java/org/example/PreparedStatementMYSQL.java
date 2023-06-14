package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementMYSQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner= new Scanner(System.in);
        System.out.println("enter Id");
        int id= scanner.nextInt();
        System.out.println("enter name of student");
        scanner.nextLine();
        String name= scanner.nextLine();
        System.out.println("enter phone number");
        String phone= scanner.nextLine();

        // load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // establish the connections
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");

        // create prepared statement
        PreparedStatement statement= connection.prepareStatement("insert into student values(?,?,?)");
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setString(3,phone);


        int rows = statement.executeUpdate();

        System.out.println("rows affected"+rows);

        connection.close();
    }
}
