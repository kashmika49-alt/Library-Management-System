package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBokkController {
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
    public void addBook(String bookId, String bookTitle, String author, String category, String publishedYear, String quantity){
        String SQL = "INSERT INTO books(bookId,bookTitle,author,category,publishedYear,quantity) values (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1,bookId);
            preparedStatement.setString(2,bookTitle);

            preparedStatement.setString(3,author);
            preparedStatement.setString(4,category);
            preparedStatement.setString(5,publishedYear);
            preparedStatement.setString(6,quantity);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
