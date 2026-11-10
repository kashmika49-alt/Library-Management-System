package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReturnBookController {
    Connection connection = dbDBMSconnection.getConnection();

    public void returnBook(String borrowedBook, String memberName, LocalDate BorrowedDate,LocalDate DueDate,LocalDate ReturnDate){
String SQL = "INSERT INTO returnbooks(borrowedBook,memberName,BorrowedDate,DueDate,ReturnDate) Values (?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement =  connection.prepareStatement(SQL);

            preparedStatement.setString(1,borrowedBook);
            preparedStatement.setString(2,memberName);
            preparedStatement.setDate(3, Date.valueOf(BorrowedDate));
            preparedStatement.setDate(4, Date.valueOf(DueDate));
            preparedStatement.setDate(5,Date.valueOf(ReturnDate));

        preparedStatement.executeUpdate();
        preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
