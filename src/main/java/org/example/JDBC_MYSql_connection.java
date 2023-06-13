package org.example;

import java.sql.*;

public class JDBC_MYSql_connection {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //establish the connections
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");

        // create statement
        Statement statement= connection.createStatement();

        // processs the result
        //statement.execute("insert into student values(1,'neha mete', '9112612719')");

        ResultSet resultSet=  statement.executeQuery("select * from student");

        while(resultSet.next()){
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));

        }
        // close the connection
        connection.close();



    }
}
