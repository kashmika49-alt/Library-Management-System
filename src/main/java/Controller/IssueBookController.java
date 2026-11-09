
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

public class IssueBookController {

    Connection connection = dbDBMSconnection.getConnection();

    public void issueBook(String memberName, String bookTitle,
                          LocalDate issueDate, LocalDate dueDate) {

        String SQL = "INSERT INTO issuebooks " +
                "(memberName, bookTitle, issueDate, dueDate) " +
                "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQL);

            preparedStatement.setString(1, memberName);
            preparedStatement.setString(2, bookTitle);
            preparedStatement.setDate(3, Date.valueOf(issueDate));
            preparedStatement.setDate(4, Date.valueOf(dueDate));

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
