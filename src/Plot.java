import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Map;

/* Plot class under construction:
    1. good init position arrangement
    2. resizing
    3. aesthetic
    4. color random
 */

public class Plot extends Application {
    String fileName;
    dataStruct data = new dataStruct();
    double xLeftMost = 75;
    double xSrcNode;        // Initiated after the SrcText
    double xDistance;
    double ZOOM;
    Font defaultFont = new Font("Arial", 18);
    Font labelFont = new Font("Arial", 22);



    public Plot(String fn) { this.fileName = fn; };
    public Plot() { this.fileName = "D:\\Zhu22\\SynologyDrive\\1.2022_Year2\\4.JAVA\\CourseWork3\\data.txt"; };


    @Override
    public void start(Stage PrimaryStage) {
        // Read in the file data
        SankeyReader reader = new SankeyReader(fileName);
        data.dataDic = reader.data;
        data.title = reader.title;
        data.label = reader.label;

        // Set stage, scene, pane
        PrimaryStage.setWidth(1000);
        PrimaryStage.setHeight(750);
        PrimaryStage.setTitle(data.title);
        Scene scene = new Scene(new Group());
        StackPane root = new StackPane();


    }
}

class dataStruct {
    Map<String, Double> dataDic;     // For Children Nodes: name, size
    String label;
    String title;
}
