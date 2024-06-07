package com.main.kegiatan6.admin;

import com.main.kegiatan6.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.UUID;

public class BookAdd extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(700, 500);

        Label addBookLabel = new Label("Add Book");
        addBookLabel.setFont(new Font("System Bold", 48));
        addBookLabel.setLayoutX(238);
        addBookLabel.setLayoutY(36);

        Label titleLabel = new Label("Title");
        titleLabel.setFont(new Font(24));
        titleLabel.setLayoutX(72);
        titleLabel.setLayoutY(193);
        titleLabel.setPrefSize(103, 27);

        Label authorLabel = new Label("Author");
        authorLabel.setFont(new Font(24));
        authorLabel.setLayoutX(72);
        authorLabel.setLayoutY(260);
        authorLabel.setPrefSize(103, 27);

        Label stockLabel = new Label("Stock");
        stockLabel.setFont(new Font(24));
        stockLabel.setLayoutX(417);
        stockLabel.setLayoutY(177);
        stockLabel.setPrefSize(103, 27);

        Label categoryLabel = new Label("Category");
        categoryLabel.setFont(new Font(24));
        categoryLabel.setLayoutX(417);
        categoryLabel.setLayoutY(261);
        categoryLabel.setPrefSize(103, 27);

        TextField titleField = new TextField();
        titleField.setFont(new Font(14));
        titleField.setLayoutX(165);
        titleField.setLayoutY(189);
        titleField.setPrefSize(200, 40);

        TextField stockField = new TextField();
        stockField.setFont(new Font(14));
        stockField.setLayoutX(502);
        stockField.setLayoutY(173);
        stockField.setPrefSize(117, 40);

        TextField authorField = new TextField();
        authorField.setFont(new Font(14));
        authorField.setLayoutX(165);
        authorField.setLayoutY(256);
        authorField.setPrefSize(200, 40);

        Button submitButton = new Button("Submit");
        submitButton.setFont(new Font("System Bold", 18));
        submitButton.setLayoutX(258);
        submitButton.setLayoutY(349);
        submitButton.setPrefSize(184, 65);

        Label errorLabel = new Label();
        errorLabel.setFont(new Font(18));
        errorLabel.setTextFill(Color.RED);
        errorLabel.setLayoutX(116);
        errorLabel.setLayoutY(126);

        Button backButton = new Button("Back");
        backButton.setFont(new Font("System Bold", 14));
        backButton.setLayoutX(586);
        backButton.setLayoutY(432);
        backButton.setPrefSize(103, 53);

        backButton.setOnAction(actionEvent -> {
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.start(primaryStage);
        });

        ToggleGroup categoryGroup = new ToggleGroup();

        RadioButton historyRadioButton = new RadioButton("History");
        historyRadioButton.setFont(new Font(18));
        historyRadioButton.setLayoutX(528);
        historyRadioButton.setLayoutY(230);
        historyRadioButton.setPrefSize(100, 30);
        historyRadioButton.setToggleGroup(categoryGroup);
        historyRadioButton.setSelected(true);

        RadioButton storyRadioButton = new RadioButton("Story");
        storyRadioButton.setFont(new Font(18));
        storyRadioButton.setLayoutX(528);
        storyRadioButton.setLayoutY(265);
        storyRadioButton.setPrefSize(100, 30);
        storyRadioButton.setToggleGroup(categoryGroup);

        RadioButton textRadioButton = new RadioButton("Text");
        textRadioButton.setFont(new Font(18));
        textRadioButton.setLayoutX(528);
        textRadioButton.setLayoutY(297);
        textRadioButton.setPrefSize(100, 30);
        textRadioButton.setToggleGroup(categoryGroup);

        submitButton.setOnAction(actionEvent -> {
            errorLabel.setText("");
            String title = titleField.getText();
            String author = authorField.getText();
            String category = ((RadioButton) categoryGroup.getSelectedToggle()).getText();
            if(title.isEmpty()){
                errorLabel.setText("Title empty");
                return;
            }
            if(author.isEmpty()) {
                errorLabel.setText("Author empty");
                return;
            }
            if(stockField.getText().isEmpty()) {
                errorLabel.setText("Stok habis cuy");
                return;
            }
            int stock = 0;
            try {
                stock = Integer.parseInt(stockField.getText());
            }catch (Exception e) {
                errorLabel.setText("Stock sesuai digit bang");
                return;
            }

            String id = generateId();
            User.books.add(new Book(id, title, author, category, stock));
            AdminMenu menuAdmin = new AdminMenu();
            menuAdmin.start(primaryStage);
        });

        anchorPane.getChildren().addAll(addBookLabel, titleLabel, authorLabel, stockLabel, categoryLabel, titleField, stockField, authorField, submitButton, errorLabel, backButton, historyRadioButton, storyRadioButton, textRadioButton);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tambah Buku");
        primaryStage.show();
    }

    private static String generateId() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();

        String formattedID = uuidString.substring(0, 4) + "-" +
                uuidString.substring(9, 13) + "-" +
                uuidString.substring(14, 18);

        return formattedID;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
