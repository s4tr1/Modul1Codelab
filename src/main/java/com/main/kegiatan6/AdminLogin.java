package com.main.kegiatan6;

import com.main.kegiatan6.admin.AdminMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminLogin extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(700, 500);

        Label adminLoginLabel = new Label("Login Ketua Jomok");
        adminLoginLabel.setFont(new Font("System Bold", 36));
        adminLoginLabel.setLayoutX(241);
        adminLoginLabel.setLayoutY(73);

        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(new Font(24));
        usernameLabel.setLayoutX(164);
        usernameLabel.setLayoutY(195);

        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(new Font(24));
        passwordLabel.setLayoutX(167);
        passwordLabel.setLayoutY(253);

        TextField usernameField = new TextField();
        usernameField.setLayoutX(287);
        usernameField.setLayoutY(195);
        usernameField.setPrefSize(250, 35);

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

        Button loginAsStudentButton = new Button("Login as Student");
        loginAsStudentButton.setFont(new Font("System Bold", 14));
        loginAsStudentButton.setLayoutX(550);
        loginAsStudentButton.setLayoutY(432);
        loginAsStudentButton.setPrefSize(136, 53);

        loginButton.setOnAction(actionEvent -> {
            errorLabel.setText("");
            String username = usernameField.getText();
            String password = passwordField.getText();
            if(username.isEmpty()) {
                errorLabel.setText("Username empty");
                return;
            }
            if(password.isEmpty()) {
                errorLabel.setText("Password empty");
                return;
            }
            if(username.equals("ireng") && password.equals("ngawi")) {
                AdminMenu menuAdmin = new AdminMenu();
                menuAdmin.start(primaryStage);
            }else {
                errorLabel.setText("Username sama password nya salah wak .");
            }
        });

        loginAsStudentButton.setOnAction(actionEvent -> {
            StudentLogin studentLogin = new StudentLogin();
            studentLogin.start(primaryStage);
        });

        anchorPane.getChildren().addAll(adminLoginLabel, usernameLabel, passwordLabel, usernameField, passwordField, loginButton, errorLabel, loginAsStudentButton);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin Jomok");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
