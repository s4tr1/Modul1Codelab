package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class jawapage extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create the AnchorPane
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(600, 400);
        anchorPane.setStyle("-fx-background-color: #6A5ACD;");

        // Create the Label
        Label messageLabel = new Label("Halo mas bintang Sekarang anda menjadi Sobat hitam:)");
        messageLabel.setPrefSize(700, 50);
        messageLabel.setLayoutX(-50);
        messageLabel.setLayoutY(113);
        messageLabel.setTextFill(Color.WHITE);
        messageLabel.setFont(Font.font("Arial Bold", 19));
        messageLabel.setAlignment(javafx.geometry.Pos.CENTER);

        // Create the Button
        Button balikButton = new Button("Balik");
        balikButton.setPrefSize(100, 40);
        balikButton.setLayoutX(284);
        balikButton.setLayoutY(181);
        balikButton.setStyle("-fx-background-color: #ffffff;");
        balikButton.setTextFill(Color.SLATEBLUE);
        balikButton.setFont(Font.font("Arial Bold", 14));

        // Add elements to the AnchorPane
        anchorPane.getChildren().addAll(messageLabel, balikButton);

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(anchorPane);
        primaryStage.setTitle("JavaFX Layout");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Add listeners to make the layout responsive
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double width = newVal.doubleValue();

            // Adjust label and button layout positions based on the new width
            messageLabel.setLayoutX((width - messageLabel.getPrefWidth()) / 2);
            balikButton.setLayoutX((width - balikButton.getPrefWidth()) / 2);
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double height = newVal.doubleValue();

            // Adjust label and button layout positions based on the new height
            messageLabel.setLayoutY(height * 0.25);
            balikButton.setLayoutY(height * 0.45);
        });

        // Initial layout adjustments
        double initialWidth = primaryStage.getWidth();
        double initialHeight = primaryStage.getHeight();

        messageLabel.setLayoutX((initialWidth - messageLabel.getPrefWidth()) / 2);
        balikButton.setLayoutX((initialWidth - balikButton.getPrefWidth()) / 2);

        messageLabel.setLayoutY(initialHeight * 0.25);
        balikButton.setLayoutY(initialHeight * 0.45);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
