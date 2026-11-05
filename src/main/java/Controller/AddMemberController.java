package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMemberController {
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
 public void addMember(String memberID, String fullName, String email, String phoneNumber, String address){

        String SQL = "INSERT INTO members ( memberId,fullName,email,phoneNumber,address) VALUES (?,?,?,?,?)";
     try {
         PreparedStatement preparedStatement = connection.prepareStatement(SQL);

         preparedStatement.setString(1,memberID);
         preparedStatement.setString(2,fullName);
         preparedStatement.setString(3,email);
         preparedStatement.setString(4, phoneNumber);
         preparedStatement.setString(5,address);


         preparedStatement.executeUpdate();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
}
