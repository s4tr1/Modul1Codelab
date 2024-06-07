package com.main.kegiatan6.student;

import com.main.kegiatan6.User;
import com.main.kegiatan6.admin.Book;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BookBorrow extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(700, 500);

        Label titleLabel = new Label("Borrow Book");
        titleLabel.setFont(new Font("System Bold", 24));
        titleLabel.setLayoutX(276);
        titleLabel.setLayoutY(14);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(10);
        scrollPane.setLayoutY(113);
        scrollPane.setPrefSize(679, 369);

        TableView<Book> tableView = new TableView<>();
        tableView.setPrefSize(679, 369);

        TableColumn<Book, String> column1 = new TableColumn<>("ID Book");
        column1.setPrefWidth(140);
        column1.setCellValueFactory(new PropertyValueFactory<>("id_buku"));
        TableColumn<Book, String> column2 = new TableColumn<>("Title");
        column2.setPrefWidth(80);
        column2.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Book, String> column3 = new TableColumn<>("Author");
        column3.setPrefWidth(80);
        column3.setCellValueFactory(new PropertyValueFactory<>("author"));
        TableColumn<Book, String> column4 = new TableColumn<>("Category");
        column4.setPrefWidth(80);
        column4.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<Book, String> column5 = new TableColumn<>("Stock");
        column5.setPrefWidth(80);
        column5.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tableView.getColumns().addAll(column1, column2, column3, column4, column5);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Book> bookData = FXCollections.observableArrayList();
        for(Book book: User.books) {
            if(book.getStock() > 0) {
                bookData.add(book);
            }
        }
        tableView.setItems(bookData);

        scrollPane.setContent(tableView);

        Label inputLabel = new Label("Input Book ID:");
        inputLabel.setFont(new Font(14));
        inputLabel.setLayoutX(169);
        inputLabel.setLayoutY(71);

        Label errorLabel = new Label();
        errorLabel.setFont(new Font(14));
        errorLabel.setTextFill(Color.RED);
        errorLabel.setLayoutX(453);
        errorLabel.setLayoutY(22);
        errorLabel.setPrefSize(234, 17);

        TextField bookIdField = new TextField();
        bookIdField.setLayoutX(265);
        bookIdField.setLayoutY(63);
        bookIdField.setPrefSize(170, 35);

        Button borrowButton = new Button("Borrow");
        borrowButton.setFont(new Font("System Bold", 14));
        borrowButton.setLayoutX(453);
        borrowButton.setLayoutY(58);
        borrowButton.setPrefSize(124, 45);

        Button backButton = new Button("Back");
        backButton.setFont(new Font("System Bold", 11));
        backButton.setLayoutX(10);
        backButton.setLayoutY(9);
        backButton.setPrefSize(89, 45);

        backButton.setOnAction(actionEvent -> {
            StudentMenu studentMenu = new StudentMenu();
            studentMenu.start(primaryStage);
        });

        borrowButton.setOnAction(actionEvent -> {
            errorLabel.setText("");
            String inputID = bookIdField.getText();
            if(inputID.isEmpty()) {
                errorLabel.setText("ID empty");
                return;
            }

            boolean find = false;
            for(Book book: User.books) {
                if(book.getId_buku().equals(inputID)) {
                    find = true;
                    if(book.getStock() > 0) {
                        book.setStock(book.getStock()-1);
                        int indexBorrowBooks = -1;
                        for (int i = 0; i < User.borrowBooks.size(); i++) {
                            if(User.borrowBooks.get(i).getFirst().equals(User.loginStudent)) {
                                indexBorrowBooks = i;
                                break;
                            }
                        }
                        book.setDuration(7);
                        if(indexBorrowBooks < 0) {
                            ArrayList<String> temp = new ArrayList<>();
                            temp.add(User.loginStudent);
                            temp.add(book.getId_buku());
                            User.borrowBooks.add(temp);
                        }else {
                            User.borrowBooks.get(indexBorrowBooks).add(book.getId_buku());
                        }
                        start(primaryStage);
                    }
                }
            }

            if(!find) {
                errorLabel.setText("Book ID not found");
            }
        });

        anchorPane.getChildren().addAll(bookIdField,
                titleLabel, scrollPane, inputLabel, errorLabel, borrowButton, backButton
        );

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Borrow Book");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
