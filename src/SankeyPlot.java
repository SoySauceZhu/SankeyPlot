import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



/* myPlot class under construction:
    1. good init position arrangement
    2. resizing
    3. aesthetic
    4. color random
 */

public class myPlot extends Application {

    String fileName = "D:\\Zhu22\\SynologyDrive\\1.2022_Year2\\4.JAVA\\CourseWork3\\data.txt";

    @Override
    public void start(Stage primaryStage) {

        SankeyReader reader = new SankeyReader(fileName);
        Pane root = new myPane(fileName);
        Scene scene = new Scene(root, 1000, 750);
        primaryStage.setTitle(reader.title);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}

