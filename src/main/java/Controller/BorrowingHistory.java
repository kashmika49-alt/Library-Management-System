
package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowingHistory {

    public void borrowingHistory(
            TableView<ObservableList<String>> table) {

        String SQL = "SELECT memberName, bookTitle, issueDate, dueDate FROM issuebooks";

        ObservableList<ObservableList<String>> data =
                FXCollections.observableArrayList();

        try (Connection connection = dbDBMSconnection.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                ObservableList<String> row =
                        FXCollections.observableArrayList();

                row.add(resultSet.getString("memberName"));
                row.add(resultSet.getString("bookTitle"));
                row.add(resultSet.getString("issueDate"));
                row.add(resultSet.getString("dueDate"));

                data.add(row);
            }

            table.setItems(data);

            System.out.println("Borrowing history loaded successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
