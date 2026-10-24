package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.ArrayList;

public class MainDashboardController {
    public static Member[] members = new Member[100];
    public static int memberCount = 0 ;
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
    private ChoiceBox<?> SelectBook;

    @FXML
    private ChoiceBox<?> SelectMember;

    @FXML
    private TableView<?> TableBorrowingHistory;

    @FXML
    private TableColumn<?, ?> TableColoumnEmail;

    @FXML
    private TableColumn<?, ?> TableColoumnMemberId;

    @FXML
    private TableColumn<?, ?> TableColoumnMemberName;

    @FXML
    private TableColumn<?, ?> TableColoumnPhoneNumber;

    @FXML
    private TableView<?> TableManageMembers;

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
    void DragMember(MouseEvent event) {

    }

    @FXML
    void btnActionAddBook(ActionEvent event) {

        String bookId = txtBookId.getText();
        String bookTitle = txtBookTitle.getText();
        String author = txtAuthor.getText();
        String category = txtCategory.getText();
        String publishedYear = txtPublishedYear.getText();
        String qty = txtQuantity.getText();


    }

    @FXML
    void btnActionAddMember(ActionEvent event) {
        String memberID = txtMemberId.getText();
        String fullName = txtFullName.getText();
        String email = txtEmail.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String address = txtAddress.getText();



    }

    @FXML
    void btnActionIssueBook(ActionEvent event) {

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

    }

}
