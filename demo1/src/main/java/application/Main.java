package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String CORRECT_USERNAME = "bintang";
    private static final String CORRECT_PASSWORD = "admin";

    private Scene loginScene; // Menyimpan scene login

    @Override
    public void start(Stage primaryStage) {
        // Create the BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(600, 400);

        // Create the AnchorPane for the bottom section
        AnchorPane bottomAnchorPane = new AnchorPane();
        bottomAnchorPane.setPrefSize(600, 303);
        bottomAnchorPane.setBlendMode(javafx.scene.effect.BlendMode.MULTIPLY);

        // Create the left AnchorPane with background color
        AnchorPane leftAnchorPane = new AnchorPane();
        leftAnchorPane.setLayoutX(1.0);
        leftAnchorPane.setPrefSize(253, 427);
        leftAnchorPane.setStyle("-fx-background-color: #6A5ACD;");

        // Create the TextFields
        TextField usernameField = new TextField();
        usernameField.setLayoutX(375);
        usernameField.setLayoutY(198);
        usernameField.setPrefSize(186, 31);

        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(375);
        passwordField.setLayoutY(244);
        passwordField.setPrefSize(186, 31);

        // Create the Labels
        Label usernameLabel = new Label("Username");
        usernameLabel.setLayoutX(287);
        usernameLabel.setLayoutY(196);
        usernameLabel.setPrefSize(194, 36);
        usernameLabel.setFont(Font.font("Arial Bold", 15));

        Label passwordLabel = new Label("Password");
        passwordLabel.setLayoutX(287);
        passwordLabel.setLayoutY(249);
        passwordLabel.setPrefSize(149, 21);
        passwordLabel.setFont(Font.font("System Bold", 15));

        Label titleLabel = new Label("Jawa Silahkan Login");
        titleLabel.setLayoutX(307);
        titleLabel.setLayoutY(76);
        titleLabel.setPrefSize(348, 120);
        titleLabel.setFont(Font.font("Arial Black", 24));

        // Create the Button
        Button loginButton = new Button("LOGIN");
        loginButton.setLayoutX(432);
        loginButton.setLayoutY(298);
        loginButton.setStyle("-fx-background-color: #6A5ACD;");
        loginButton.setTextFill(Color.WHITE);
        loginButton.setFont(Font.font("Arial Bold", 16));

        // Create the error message label
        Label errorMessageLabel = new Label();
        errorMessageLabel.setLayoutX(375);
        errorMessageLabel.setLayoutY(280);
        errorMessageLabel.setTextFill(Color.RED);
        errorMessageLabel.setFont(Font.font("Arial", 12));
        errorMessageLabel.setVisible(false);

        // Add action to the login button
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Check username and password
            if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                // Clear the fields and hide error message on successful login
                usernameField.clear();
                passwordField.clear();
                errorMessageLabel.setVisible(false);
                primaryStage.setScene(createJawaPageScene(primaryStage));
            } else {
                // Show error message on failed login
                errorMessageLabel.setText("Username / password salah");
                errorMessageLabel.setVisible(true);
            }
        });

        // Add all elements to the bottom AnchorPane
        bottomAnchorPane.getChildren().addAll(
                leftAnchorPane, usernameField, passwordField, usernameLabel, passwordLabel, titleLabel, loginButton, errorMessageLabel
        );

        // Set the bottom AnchorPane to the bottom of the BorderPane
        borderPane.setBottom(bottomAnchorPane);

        // Create the login Scene and set it on the Stage
        loginScene = new Scene(borderPane);
        primaryStage.setTitle("JavaFX Layout");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private Scene createJawaPageScene(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(600, 400);
        anchorPane.setStyle("-fx-background-color: #6A5ACD;");

        Label messageLabel = new Label("Halo mas bintang Sekarang anda menjadi Sobat hitam:)");
        messageLabel.setPrefSize(700, 50);
        messageLabel.setLayoutX(-50);
        messageLabel.setLayoutY(113);
        messageLabel.setTextFill(Color.WHITE);
        messageLabel.setFont(Font.font("Arial Bold", 19));
        messageLabel.setAlignment(javafx.geometry.Pos.CENTER);

        Button balikButton = new Button("Balik");
        balikButton.setPrefSize(100, 40);
        balikButton.setLayoutX(284);
        balikButton.setLayoutY(181);
        balikButton.setStyle("-fx-background-color: #ffffff;");
        balikButton.setTextFill(Color.SLATEBLUE);
        balikButton.setFont(Font.font("Arial Bold", 14));
        balikButton.setOnAction(event -> primaryStage.setScene(loginScene)); // Mengatur loginScene kembali

        anchorPane.getChildren().addAll(messageLabel, balikButton);

        Scene scene = new Scene(anchorPane);
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
