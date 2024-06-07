package com.main.kegiatan6.student;

import com.main.kegiatan6.StudentLogin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StudentMenu extends Application {
    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(700, 500);

        Label titleLabel = new Label("Student Menu");
        titleLabel.setFont(new Font("System Bold", 48));
        titleLabel.setLayoutX(189);
        titleLabel.setLayoutY(40);

        Label availableLabel = new Label("Available Books & Borrow Book");
        availableLabel.setFont(new Font("System Bold", 24));
        availableLabel.setLayoutX(168);
        availableLabel.setLayoutY(157);

        Button borrowButton = new Button("Borrow Book");
        borrowButton.setFont(new Font("System Bold", 18));
        borrowButton.setLayoutX(273);
        borrowButton.setLayoutY(203);

        borrowButton.setOnAction(actionEvent -> {
            BookBorrow bookBorrow = new BookBorrow();
            bookBorrow.start(primaryStage);
        });

        Button returnButton = new Button("Return Book");
        returnButton.setFont(new Font("System Bold", 18));
        returnButton.setLayoutX(273);
        returnButton.setLayoutY(354);

        returnButton.setOnAction(actionEvent -> {
            BookReturn bookReturn = new BookReturn();
            bookReturn.start(primaryStage);
        });

        Label borrowedLabel = new Label("Borrowed Book & Return Book");
        borrowedLabel.setFont(new Font("System Bold", 24));
        borrowedLabel.setLayoutX(174);
        borrowedLabel.setLayoutY(309);

        Button backButton = new Button("Back");
        backButton.setFont(new Font("System Bold", 18));
        backButton.setLayoutX(14);
        backButton.setLayoutY(432);

        backButton.setOnAction(actionEvent -> {
            StudentLogin studentLogin = new StudentLogin();
            studentLogin.start(primaryStage);
        });

        anchorPane.getChildren().addAll(
                titleLabel, availableLabel, borrowButton, returnButton,
                borrowedLabel, backButton
        );

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Menu");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
