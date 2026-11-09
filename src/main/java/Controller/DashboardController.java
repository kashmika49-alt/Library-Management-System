package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardController {
    Connection connection = dbDBMSconnection.getConnection();
    public void totalBooks(){
        String SQL = " select count(*) from books;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int count = resultSet.getInt(1);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
