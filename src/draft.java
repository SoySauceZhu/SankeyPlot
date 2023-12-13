import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class draft extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label sizeLabel = new Label();

        // Create a stack pane to hold the label
        StackPane root = new StackPane();
        root.getChildren().add(sizeLabel);

        // Create a scene and set it in the stage
        Scene scene = new Scene(root, 400, 400);

        // Update the label text when the window is resized
        primaryStage.widthProperty().addListener((obs, oldWidth, newWidth) ->
                updateLabel(sizeLabel, primaryStage.getWidth(), primaryStage.getHeight()));

        primaryStage.heightProperty().addListener((obs, oldHeight, newHeight) ->
                updateLabel(sizeLabel, primaryStage.getWidth(), primaryStage.getHeight()));

        primaryStage.setScene(scene);

        // Set the stage title and show it
        primaryStage.setTitle("Stage Size Display");
        primaryStage.show();
    }

    private void updateLabel(Label label, double width, double height) {
        label.setText("Width: " + String.format("%.2f", width) + "  Height: " + String.format("%.2f", height));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
