package Controller;

import java.sql.*;

public class LogInController {
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
    public void testConnection(){
        System.out.println(connection);
    }

    public boolean checkUserNameAndPassword(String userName, String password) {

        String SQL = "SELECT * FROM users;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String dbUserName = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");

                if (userName.equals(dbUserName) && password.equals(dbPassword)){
                    return true;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false ;
    }
}
