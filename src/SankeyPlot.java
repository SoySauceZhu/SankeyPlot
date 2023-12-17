import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



/* SankeyPlot class under construction:
    1. good init position arrangement
    2. resizing
    3. aesthetic
    4. color random
 */

public class SankeyPlot extends Application {

    String fileName;
    Boolean order;

    public SankeyPlot(String fn, Boolean bool) {
        // Constructor to take in filename, ordered handler
        fileName = fn;
        order = bool;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        SankeyReader reader = new SankeyReader(fileName);
        Pane root = new SankeyPane(fileName, order);
        Scene scene = new Scene(root, 1000, 750);
        primaryStage.setTitle(reader.title);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

