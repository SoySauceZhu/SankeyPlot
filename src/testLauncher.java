import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class testLauncher extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a circle

        // Create a StackPane to center the circle
        StackPane root = new StackPane();

        // Create the scene
        Scene scene = new Scene(root, 300, 500);

        // Set the stage properties
        primaryStage.setTitle("Circle in Middle");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Center the circle in the middle of the window
        double centerX = scene.getWidth() / 2;
        double centerY = scene.getHeight() / 2;

        SankeyNode circle = new SankeyNode(centerX,centerY,50,Color.GREEN);
        root.getChildren().add(circle);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
