# MySQL_JDBC_Connection

Five steps to conect with MySQL with JDBC API
      
      
      1. // load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        2.//establish the connections
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");

        3. // create statement
        Statement statement= connection.createStatement();

        4. // processs the result
        statement.execute("insert into student values(1,'neha mete', '9112612719')");

        ResultSet resultSet=  statement.executeQuery("select * from student");
       
        5. // close the connection
        connection.close();
