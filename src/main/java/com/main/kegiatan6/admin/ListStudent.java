package com.main.kegiatan6.admin;

import com.main.kegiatan6.User;
import com.main.kegiatan6.student.Student;
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

public class ListStudent extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(700, 500);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setLayoutX(15);
        scrollPane.setLayoutY(86);
        scrollPane.setPrefSize(670, 400);

        TableView<Student> tableView = new TableView<>();
        tableView.setPrefSize(670, 400);

        TableColumn<Student, String> column1 = new TableColumn<>("Name");
        column1.setPrefWidth(140);
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Student, String> column2 = new TableColumn<>("NIM");
        column2.setPrefWidth(80);
        column2.setCellValueFactory(new PropertyValueFactory<>("nim"));
        TableColumn<Student, String> column3 = new TableColumn<>("Faculty");
        column3.setPrefWidth(80);
        column3.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        TableColumn<Student, String> column4 = new TableColumn<>("Program");
        column4.setPrefWidth(80);
        column4.setCellValueFactory(new PropertyValueFactory<>("program"));

        tableView.getColumns().addAll(column1, column2, column3, column4);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Student> studentData = FXCollections.observableArrayList(User.students);
        tableView.setItems(studentData);

        scrollPane.setContent(tableView);

        Label studentListLabel = new Label("Mahasiswa");
        studentListLabel.setFont(new Font("System Bold", 36));
        studentListLabel.setLayoutX(227);
        studentListLabel.setLayoutY(23);

        Button backButton = new Button("Kembali");
        backButton.setFont(new Font("System Bold", 14));
        backButton.setLayoutX(579);
        backButton.setLayoutY(14);
        backButton.setPrefSize(105, 45);

        backButton.setOnAction(actionEvent -> {
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.start(primaryStage);
        });

        anchorPane.getChildren().addAll(studentListLabel, backButton, scrollPane);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("List Mahasiswa");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
