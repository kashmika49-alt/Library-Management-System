package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbDBMSconnection {
    public static Connection getConnection(){
        Connection connection;

        {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/library_management_system",
                        "root",
                        "Kashmika@2006");



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
