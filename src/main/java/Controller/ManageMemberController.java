
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class ManageMemberController {

    Connection connection = dbDBMSconnection.getConnection();

    public void manageMembers(String searchName,
                              TableView<ObservableList<String>> table) {

        String SQL = "SELECT * FROM members WHERE fullname LIKE ?";

        try {

            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQL);

            preparedStatement.setString(1, "%" + searchName + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<ObservableList<String>> data =
                    FXCollections.observableArrayList();

            while (resultSet.next()) {

                ObservableList<String> row =
                        FXCollections.observableArrayList();

                row.add(resultSet.getString("memberId"));
                row.add(resultSet.getString("fullName"));
                row.add(resultSet.getString("phoneNumber"));
                row.add(resultSet.getString("email"));

                data.add(row);
            }

            table.setItems(data);

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
