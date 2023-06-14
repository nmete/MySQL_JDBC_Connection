package org.example;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementCRUD {
     public void save() throws SQLException, ClassNotFoundException {
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

     public void delete() throws ClassNotFoundException, SQLException {
         Scanner scanner= new Scanner(System.in);
         System.out.println("enter Id");
         int id= scanner.nextInt();

         // load and register driver
         Class.forName("com.mysql.cj.jdbc.Driver");

         // establish the connections
         Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");

         // create prepared statement
         PreparedStatement statement= connection.prepareStatement("delete from student where id=?");
         statement.setInt(1,id);

         statement.executeUpdate();

         connection.close();
     }

     public void getAllStudent() throws ClassNotFoundException, SQLException {
         // load and register driver
         Class.forName("com.mysql.cj.jdbc.Driver");

         // establish the connections
         Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");

         // create prepared statement
         PreparedStatement statement= connection.prepareStatement("select * from student");
         ResultSet resultSet= statement.executeQuery();

         while(resultSet.next()){
             System.out.println(resultSet.getInt(1));
             System.out.println(resultSet.getString(2));
             System.out.println(resultSet.getString(3));
             System.out.println("==========================================");
         }
     }
}
