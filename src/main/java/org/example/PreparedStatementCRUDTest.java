package org.example;

import java.sql.SQLException;

public class PreparedStatementCRUDTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PreparedStatementCRUD preparedStatementCRUD= new PreparedStatementCRUD();

//        preparedStatementCRUD.save();
        preparedStatementCRUD.getAllStudent();
    }


}
