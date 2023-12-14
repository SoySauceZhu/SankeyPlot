import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class test extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane
        Pane pane = new Pane();

        // Set the window size
        double windowWidth = 600;
        double windowHeight = 400;

        // Create circles
        Circle circle1 = new Circle(20, Color.BLUE);
        Circle circle2 = new Circle(20, Color.RED);

        // Add circles to the pane
        pane.getChildren().addAll(circle1, circle2);

        // Create a scene and set it on the stage
        Scene scene = new Scene(pane, windowWidth, windowHeight);
        primaryStage.setScene(scene);

        // Set stage properties
        primaryStage.setTitle("Dynamic Circles");
        primaryStage.show();

        // Set up listeners for window resizing
        scene.widthProperty().addListener((observable, oldValue, newValue) -> updateCirclePositions(circle1, circle2, scene));
        scene.heightProperty().addListener((observable, oldValue, newValue) -> updateCirclePositions(circle1, circle2, scene));

        // Initial placement
        updateCirclePositions(circle1, circle2, scene);
    }

    private void updateCirclePositions(Circle circle1, Circle circle2, Scene scene) {
        double trisectionPoint1 = scene.getWidth() / 3.0;
        double trisectionPoint2 = 2 * scene.getWidth() / 3.0;

        circle1.setCenterX(trisectionPoint1);
        circle1.setCenterY(scene.getHeight() / 2.0);

        circle2.setCenterX(trisectionPoint2);
        circle2.setCenterY(scene.getHeight() / 2.0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
