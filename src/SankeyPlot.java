import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Map;


/* This Plot class takes in the fileName from constructor and show the SankeyPlot */
public class SankeyPlot extends Application {
    String fileName;
    Map<String, Double> dataDic;
    String title;
    String label;

    double deltaX = 500;    // The distance from left node to right nodes
    double deltaY = 50;
    double ZOOM = 0.50;
    Font defaultFont = new Font("Arial", 18);
    Font labelFont = new Font("Arial", 22);

    double xInit = 75; // The x-coordinate for the left most part of whole graph
    double yInit;
    double endX = deltaX + xInit;   // The x for end nodes column
    double endY = 25;

    public SankeyPlot(String fn) {
        this.fileName = fn;
    }

    public SankeyPlot() {
        // Test Constructor
        this.fileName = "D:\\Zhu22\\SynologyDrive\\1.2022_Year2\\4.JAVA\\CourseWork3\\data.txt";
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setWidth(1000);
        stage.setHeight(500);
        stage.setTitle(title);
        Scene scene = new Scene(new Group());
        Pane root = new Pane();

        this.yInit = 200;

        // Read in the file data
        SankeyReader reader = new SankeyReader(fileName);
        this.dataDic = reader.data;
        this.title = reader.title;
        this.label = reader.label;


//        this.yInit = stage.getHeight()/2 - reader.returnSum()/2;

        // Iterate to add Nodes and Linkers to root
        SankeyText text0 = new SankeyText(label + "\n[" + reader.returnSum() + "]", xInit - 20, yInit + reader.returnSum() / 2 * ZOOM, labelFont);
        SankeyNode node0 = new SankeyNode(xInit + text0.width, yInit, reader.returnSum() * ZOOM, Color.GREEN.darker());
        root.getChildren().add(text0);
        root.getChildren().add(node0);

        double lowerNodeY = endY;
        double lowerLinkY = yInit;
        for (String str : dataDic.keySet()) {
            // Draw a link and a node

            double size = dataDic.get(str) ;
            Color color = SankeyColor.getColor();
            str = str + "\n[" + size + "]";

            SankeyNode node = new SankeyNode(endX, lowerNodeY + deltaY, size * ZOOM, color);
            SankeyLinker linker = new SankeyLinker(xInit + text0.width, lowerLinkY, node, color);
            SankeyText text = new SankeyText(str, endX + 20, lowerNodeY + deltaY  + size * ZOOM / 2 + 5, defaultFont);


//            SankeyLinker linker = new SankeyLinker(new SankeyNode(xInit + text0.width, lowerLinkY, size, color), node, color);


            root.getChildren().addAll(node, text, linker);

            lowerLinkY = linker.lowerY;
            lowerNodeY = node.lowerY;
        }


        // Show everything
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();

    }


}