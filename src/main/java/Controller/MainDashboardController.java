package Controller;
import javafx.scene.control.ChoiceBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class MainDashboardController {

    AddMemberController addMemberController = new AddMemberController();
    AddBokkController addBokkController = new AddBokkController();
    IssueBookController issueBookController = new IssueBookController();
    ReturnBookController returnBookController = new ReturnBookController();
    ManageMemberController manageMemberController = new ManageMemberController();
    BorrowingHistory borrowingHistory = new BorrowingHistory();

    @FXML
    private DatePicker DateBorrowedDate;

    @FXML
    private DatePicker DateDueDate;

    @FXML
    private DatePicker DateDueDateR;

    @FXML
    private DatePicker DateIssueDate;

    @FXML
    private DatePicker DateReturnDate;

    @FXML
    private ChoiceBox<String> SelectBook;

    @FXML
    private ChoiceBox<String> SelectMember;

    @FXML
    private TableView<ObservableList<String>> TableBorrowingHistory;

    @FXML
    private TableView<ObservableList<String>> TableManageMembers;

    @FXML
    private TableColumn<ObservableList<String>, String> TableColumnMemberId;

    @FXML
    private TableColumn<ObservableList<String>, String> TableColumnMemberName;

    @FXML
    private TableColumn<ObservableList<String>, String> TableColumnPhoneNumber;

    @FXML
    private TableColumn<ObservableList<String>, String> TableColumnEmail;
//Borrowing book table-----------------------------------------------------------------------------------------------
@FXML
private TableColumn<ObservableList<String>, String> TableColumnBookTitle;

    @FXML
    private TableColumn<ObservableList<String>, String> TableColumnDueDate;

    @FXML
    private TableColumn<ObservableList<String>, String> TableColumnIssueDate;

    @FXML
    private TableColumn<ObservableList<String>, String> TableColumnMemberIdB;
//----------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnClearAddBook;

    @FXML
    private Button btnIssueBook;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtBorrowedBook;

    @FXML
    private TextField txtCategory;

    @FXML
    private Label txtCurrentlyBorrowedBooks;

    @FXML
    private Label CurrentlyBorrowedBooks_Dashboard;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtMemberName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtPublishedYear;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtSearch;

    @FXML
    private Label txtTotalBooks;

    @FXML
    private Label txtTotalMembers;

    @FXML
    private Label TotalMembers_Dashboard;


    @FXML
    private Label TotalBooks_Dashboard;

    @FXML
    void DragMember(MouseEvent event) {

    }
  //  @FXML
   // private Tab IssueBook_Tab;


    @FXML
    public void initialize() {

        TableColumnMemberId.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().get(0)
                )
        );

        TableColumnMemberName.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().get(1)
                )
        );

        TableColumnPhoneNumber.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().get(2)
                )
        );

        TableColumnEmail.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().get(3)
                )
        );

        // Borrowing History Table

        TableColumnMemberIdB.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().get(0)
                )
        );

        TableColumnBookTitle.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().get(1)
                )
        );

        TableColumnIssueDate.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().get(2)
                )
        );

        TableColumnDueDate.setCellValueFactory(
                cell -> new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().get(3)
                )
        );
    }



    public void loadMembers() {

        String SQL = "SELECT fullname FROM members";

        try {
            Connection connection = dbDBMSconnection.getConnection();

            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            SelectMember.getItems().clear();

            while (rs.next()) {
                SelectMember.getItems().add(rs.getString("fullname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void loadBooks() {

        String SQL = "SELECT bookTitle FROM books";

        if (SelectBook == null) {
            System.out.println("SelectBook ChoiceBox is not connected!");
            return;
        }

        try (Connection connection = dbDBMSconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL);
             ResultSet rs = ps.executeQuery()) {

            SelectBook.getItems().clear();

            while (rs.next()) {

                String bookTitle = rs.getString("bookTitle");

                SelectBook.getItems().add(bookTitle);

            }

            System.out.println("Books loaded successfully!");

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }


    @FXML
    void btnActionAddBook(ActionEvent event) {
        addBokkController.addBook(txtBookId.getText(),txtBookTitle.getText(),txtAuthor.getText(),txtCategory.getText(),txtPublishedYear.getText(),txtQuantity.getText());
        Connection connection = dbDBMSconnection.getConnection();
        String SQL = "select count(*) from books;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
               int count = resultSet.getInt(1);
               TotalBooks_Dashboard.setText(String.valueOf(count));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnActionAddMember(ActionEvent event) {
        addMemberController.addMember(txtMemberId.getText(),txtFullName.getText(),txtEmail.getText(),txtPhoneNumber.getText(),txtAddress.getText());
        Connection connection = dbDBMSconnection.getConnection();
        String SQL = "select count(*) from members;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int count = resultSet.getInt(1);
                TotalMembers_Dashboard.setText(String.valueOf(count));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @FXML
    void btnActionIssueBook(ActionEvent event) {
    issueBookController.issueBook(SelectMember.getValue(),SelectBook.getValue(),DateIssueDate.getValue(),DateDueDate.getValue());
        Connection connection = dbDBMSconnection.getConnection();
        String SQL = "select count(*) from returnbooks;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int count = resultSet.getInt(1);
                CurrentlyBorrowedBooks_Dashboard.setText(String.valueOf(count));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @FXML
    void btnActionLogOut(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/LogInPage.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }


    @FXML
    void btnActionSeacrh(ActionEvent event) {

        manageMemberController.manageMembers(
                txtSearch.getText(),
                TableManageMembers
        );

    }


    public void btnClearAddBookOnAction(ActionEvent actionEvent) {
    }

    public void BtnloadBooks(ActionEvent actionEvent) {

        loadMembers();

        }

    public void btnLoadMember(ActionEvent actionEvent) {
        loadBooks();
    }

    public void btnOnActionReturnBooks(ActionEvent actionEvent) {
        returnBookController.returnBook(txtBorrowedBook.getText(), txtMemberName.getText(), DateBorrowedDate.getValue(), DateDueDateR.getValue(), DateReturnDate.getValue());
    }

    public void btnOnActionBorrowingHistory(ActionEvent actionEvent) {
    borrowingHistory.borrowingHistory(TableBorrowingHistory);
    }
}
