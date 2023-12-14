import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class testLauncher extends Application {


    @Override
    public void start(Stage PrimaryStage) {
        Pane pane = new Pane();

        PrimaryStage.setWidth(1000);
        PrimaryStage.setHeight(500);
        PrimaryStage.setTitle("Hello U");

        final SankeyNode[] node = {new SankeyNode(500, 200, 100, Color.RED)};
        final SankeyLinker[] linker = {new SankeyLinker(50, 100, node[0], Color.GREEN)};

        pane.getChildren().addAll(node[0], linker[0]);

        final Scene[] scene = {new Scene(pane, 1000, 500)};
        PrimaryStage.setScene(scene[0]);

        PrimaryStage.show();
        scene[0].widthProperty().addListener((observable, oldValue, newValue) -> {
            node[0] = new SankeyNode(500 + newValue.doubleValue() - oldValue.doubleValue(), 200,100,Color.RED);
            linker[0] = new SankeyLinker(50, 100, node[0], Color.GREEN);

            pane.getChildren().addAll(node[0], linker[0]);

            scene[0] = new Scene(pane, 1000, 500);
            PrimaryStage.setScene(scene[0]);

            PrimaryStage.show();
        });

    }



}
