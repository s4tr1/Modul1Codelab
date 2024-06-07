package com.main.kegiatan6.admin;

import com.main.kegiatan6.User;
import com.main.kegiatan6.student.Student;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StudentAdd extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(700, 500);

        Label titleLabel = new Label("Tambah Mahasiswa");
        titleLabel.setFont(new Font("System Bold", 48));
        titleLabel.setLayoutX(223);
        titleLabel.setLayoutY(54);

        Label nameLabel = new Label("Name");
        nameLabel.setFont(new Font(24));
        nameLabel.setLayoutX(50);
        nameLabel.setLayoutY(183);
        nameLabel.setPrefSize(103, 27);

        Label nimLabel = new Label("NIM");
        nimLabel.setFont(new Font(24));
        nimLabel.setLayoutX(50);
        nimLabel.setLayoutY(263);
        nimLabel.setPrefSize(103, 27);

        Label facultyLabel = new Label("Faculty");
        facultyLabel.setFont(new Font(24));
        facultyLabel.setLayoutX(354);
        facultyLabel.setLayoutY(183);
        facultyLabel.setPrefSize(103, 27);

        Label programLabel = new Label("Program");
        programLabel.setFont(new Font(24));
        programLabel.setLayoutX(354);
        programLabel.setLayoutY(263);
        programLabel.setPrefSize(103, 27);

        TextField nameField = new TextField();
        nameField.setLayoutX(123);
        nameField.setLayoutY(183);
        nameField.setPrefSize(200, 35);

        TextField facultyField = new TextField();
        facultyField.setLayoutX(451);
        facultyField.setLayoutY(183);
        facultyField.setPrefSize(200, 35);

        TextField nimField = new TextField();
        nimField.setLayoutX(123);
        nimField.setLayoutY(263);
        nimField.setPrefSize(200, 35);

        TextField programField = new TextField();
        programField.setLayoutX(451);
        programField.setLayoutY(263);
        programField.setPrefSize(200, 35);

        Button submitButton = new Button("Submit");
        submitButton.setFont(new Font("System Bold", 24));
        submitButton.setLayoutX(279);
        submitButton.setLayoutY(334);
        submitButton.setPrefSize(183, 70);

        Label errorLabel = new Label();
        errorLabel.setFont(new Font(18));
        errorLabel.setTextFill(Color.RED);
        errorLabel.setLayoutX(104);
        errorLabel.setLayoutY(137);

        Button backButton = new Button("Back");
        backButton.setFont(new Font("System Bold", 18));
        backButton.setLayoutX(582);
        backButton.setLayoutY(432);
        backButton.setPrefSize(103, 53);

        submitButton.setOnAction(actionEvent -> {
            String name = nameField.getText();
            String nim = nimField.getText();
            String faculty = facultyField.getText();
            String program = programField.getText();

            if(name.isEmpty()) {
                errorLabel.setText("Name empty");
                return;
            }
            if(nim.isEmpty()) {
                errorLabel.setText("NIM empty");
                return;
            }
            if(faculty.isEmpty()) {
                errorLabel.setText("Faculty empty");
                return;
            }
            if(program.isEmpty()) {
                errorLabel.setText("Program empty");
            }

            if(nim.length() != 15) {
                errorLabel.setText("NIM must be 15 digits");
                return;
            }

            if(!nim.matches("\\d+")) {
                errorLabel.setText("NIM must be digits");
                return;
            }

            User.students.add(new Student(name, nim, faculty, program));
            AdminMenu menuAdmin = new AdminMenu();
            menuAdmin.start(primaryStage);
        });

        backButton.setOnAction(actionEvent -> {
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.start(primaryStage);
        });

        anchorPane.getChildren().addAll(
                titleLabel, nameLabel, nimLabel, facultyLabel, programLabel,
                nameField, facultyField, nimField, programField, submitButton,
                errorLabel, backButton
        );

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add Student");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
