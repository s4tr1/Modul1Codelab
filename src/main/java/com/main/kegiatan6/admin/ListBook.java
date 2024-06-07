package com.main.kegiatan6.admin;

import com.main.kegiatan6.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ListBook extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(700, 500);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setLayoutX(15);
        scrollPane.setLayoutY(86);
        scrollPane.setPrefSize(670, 400);

        TableView<Book> tableView = new TableView<>();
        tableView.setPrefSize(670, 400);

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

        tableView.getColumns().addAll(column5, column2, column3, column4, column1  );
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Book> bookData = FXCollections.observableArrayList(User.books);
        tableView.setItems(bookData);

        scrollPane.setContent(tableView);

        Label bookListLabel = new Label("Book List");
        bookListLabel.setFont(new Font("System Bold", 36));
        bookListLabel.setLayoutX(255);
        bookListLabel.setLayoutY(20);

        Button backButton = new Button("Balik");
        backButton.setFont(new Font("System Bold", 14));
        backButton.setLayoutX(579);
        backButton.setLayoutY(14);
        backButton.setPrefSize(105, 45);

        backButton.setOnAction(actionEvent -> {
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.start(primaryStage);
        });

        anchorPane.getChildren().addAll(bookListLabel, backButton, scrollPane);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book List");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
