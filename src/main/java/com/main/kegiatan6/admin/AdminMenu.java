package com.main.kegiatan6.admin;

import com.main.kegiatan6.AdminLogin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminMenu extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(700, 500);

        Label adminMenuLabel = new Label("Admin Menu");
        adminMenuLabel.setFont(new Font("System Bold", 48));
        adminMenuLabel.setLayoutX(203);
        adminMenuLabel.setLayoutY(46);

        Button studentListButton = new Button("Student List");
        studentListButton.setFont(new Font("System Bold", 18));
        studentListButton.setLayoutX(262);
        studentListButton.setLayoutY(177);
        studentListButton.setPrefSize(151, 59);

        studentListButton.setOnAction(actionEvent -> {
            ListStudent listStudent = new ListStudent();
            listStudent.start(primaryStage);
        });

        Label studentLabel = new Label("Student");
        studentLabel.setFont(new Font("System Bold", 24));
        studentLabel.setLayoutX(138);
        studentLabel.setLayoutY(189);

        Button addStudentButton = new Button("Add Student");
        addStudentButton.setFont(new Font("System Bold", 18));
        addStudentButton.setLayoutX(435);
        addStudentButton.setLayoutY(177);
        addStudentButton.setPrefSize(151, 59);

        addStudentButton.setOnAction(actionEvent -> {
            StudentAdd studentAdd = new StudentAdd();
            studentAdd.start(primaryStage);
        });

        Button bookListButton = new Button("Book List");
        bookListButton.setFont(new Font("System Bold", 18));
        bookListButton.setLayoutX(262);
        bookListButton.setLayoutY(287);
        bookListButton.setPrefSize(151, 59);

        bookListButton.setOnAction(actionEvent -> {
            ListBook listBook = new ListBook();
            listBook.start(primaryStage);
        });

        Label bookLabel = new Label("Book");
        bookLabel.setFont(new Font("System Bold", 24));
        bookLabel.setLayoutX(138);
        bookLabel.setLayoutY(299);

        Button addBookButton = new Button("Add Book");
        addBookButton.setFont(new Font("System Bold", 18));
        addBookButton.setLayoutX(435);
        addBookButton.setLayoutY(287);
        addBookButton.setPrefSize(151, 59);

        addBookButton.setOnAction(actionEvent -> {
            BookAdd bookAdd = new BookAdd();
            bookAdd.start(primaryStage);
        });

        Button backButton = new Button("Back");
        backButton.setFont(new Font("System Bold", 18));
        backButton.setLayoutX(14);
        backButton.setLayoutY(432);
        backButton.setPrefSize(117, 53);

        backButton.setOnAction(actionEvent -> {
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.start(primaryStage);
        });

        anchorPane.getChildren().addAll(adminMenuLabel, studentListButton, studentLabel, addStudentButton, bookListButton, bookLabel, addBookButton, backButton);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin Menu");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
