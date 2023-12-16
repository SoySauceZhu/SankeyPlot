import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class test extends Application {

    private Line horizontalLine;
    private Line verticalLine;

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane
        Pane pane = new Pane();

        // Create a test (Cross) using Lines
        createNode();

        // Add the test to the Pane
        pane.getChildren().addAll(horizontalLine, verticalLine);

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);

        // Set stage properties
        primaryStage.setTitle("Resizable test");
        primaryStage.show();

        // Set up listener for window resizing
        scene.widthProperty().addListener((observable, oldValue, newValue) -> updateNodePosition());
        scene.heightProperty().addListener((observable, oldValue, newValue) -> updateNodePosition());

        // Initial placement
        updateNodePosition();
    }

    private void createNode() {
        // Create horizontal line
        horizontalLine = new Line();
        horizontalLine.setStartX(-20);
        horizontalLine.setStartY(0);
        horizontalLine.setEndX(20);
        horizontalLine.setEndY(0);
        horizontalLine.setStroke(Color.BLUE);

        // Create vertical line
        verticalLine = new Line();
        verticalLine.setStartX(0);
        verticalLine.setStartY(-20);
        verticalLine.setEndX(0);
        verticalLine.setEndY(20);
        verticalLine.setStroke(Color.BLUE);
    }

    private void updateNodePosition() {
        // Update the position of the test to be centered in the Scene
        double x = (horizontalLine.getScene().getWidth() - horizontalLine.getEndX() - horizontalLine.getStartX()) / 2.0;
        double y = (verticalLine.getScene().getHeight() - verticalLine.getEndY() - verticalLine.getStartY()) / 2.0;

        horizontalLine.setTranslateX(x);
        horizontalLine.setTranslateY(y);

        verticalLine.setTranslateX(x);
        verticalLine.setTranslateY(y);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
