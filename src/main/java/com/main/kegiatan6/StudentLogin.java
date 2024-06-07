package com.main.kegiatan6;

import com.main.kegiatan6.admin.Book;
import com.main.kegiatan6.student.Student;
import com.main.kegiatan6.student.StudentMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StudentLogin extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(700, 500);

        Label studentLoginLabel = new Label("Jawa silahkan Login");
        studentLoginLabel.setFont(new Font("System Bold", 36));
        studentLoginLabel.setLayoutX(231);
        studentLoginLabel.setLayoutY(74);

        Label nimLabel = new Label("NIM");
        nimLabel.setFont(new Font(24));
        nimLabel.setLayoutX(167);
        nimLabel.setLayoutY(195);

        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(new Font(24));
        passwordLabel.setLayoutX(167);
        passwordLabel.setLayoutY(253);

        TextField nimField = new TextField();
        nimField.setLayoutX(287);
        nimField.setLayoutY(195);
        nimField.setPrefSize(250, 35);

        TextField passwordField = new TextField();
        passwordField.setLayoutX(287);
        passwordField.setLayoutY(253);
        passwordField.setPrefSize(250, 35);

        Button loginButton = new Button("Login");
        loginButton.setFont(new Font("System Bold", 18));
        loginButton.setLayoutX(270);
        loginButton.setLayoutY(350);
        loginButton.setPrefSize(159, 53);

        Label errorLabel = new Label();
        errorLabel.setFont(new Font(18));
        errorLabel.setTextFill(Color.RED);
        errorLabel.setLayoutX(178);
        errorLabel.setLayoutY(147);

        loginButton.setOnAction(actionEvent -> {
            errorLabel.setText("");
            String nim = nimField.getText();
            String password = passwordField.getText();
            if(nim.isEmpty()) {
                errorLabel.setText("NIM isi dulu lah.");
                return;
            }
            if(password.isEmpty()) {
                errorLabel.setText("Password isi dulu pintar.");
                return;
            }

            boolean find = false;
            for (int i = 0; i < User.students.size(); i++) {
                if(nim.equals(User.students.get(i).getNim())) {
                    find = true;
                    if(nim.equals(password)) {
                        User.loginStudent = nim;
                        StudentMenu menuStudent = new StudentMenu();
                        menuStudent.start(primaryStage);
                    }else {
                        errorLabel.setText("password mu salah cak.");
                    }
                }
            }
            if(!find) {
                errorLabel.setText("terdeteksi bukan jawa.");
            }
        });

        Button loginAsAdminButton = new Button("Login Admin");
        loginAsAdminButton.setFont(new Font("System Bold", 14));
        loginAsAdminButton.setLayoutX(560);
        loginAsAdminButton.setLayoutY(432);
        loginAsAdminButton.setPrefSize(126, 53);

        loginAsAdminButton.setOnAction(actionEvent -> {
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.start(primaryStage);
        });

        anchorPane.getChildren().addAll(studentLoginLabel, nimLabel, passwordLabel, nimField, passwordField, loginButton, errorLabel, loginAsAdminButton);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CRUD Jomok");
        primaryStage.show();
    }

    public static void addTempStudent(){
        User.students.add(new Student("radan", "202210370311208",  "Teknik", "Informatika"));
        User.students.add(new Student("katak salto", "201910330211809", "FEB", "Bisnis"));
        User.students.add(new Student("ini nama", "202010370321210", "FIKES", "Kedokteran Mesin"));
    }

    public static void addTempBooks() {
        User.books.add(new Book("388c-e681-9152", "Ambatron & Rusdi", "author", "History", 4));
        User.books.add(new Book("ed90-be30-5cdb", "title", "author", "Story",0));
        User.books.add(new Book("d95e-0c4a-9523", "title", "author", "Text", 1));
    }

    public static void main(String[] args) {
        launch(args);
        addTempStudent();
        addTempBooks();
    }
}
