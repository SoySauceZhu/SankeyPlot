import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.text.DecimalFormat;

public class SankeyPane extends Pane {
    /*
    Create a Pane for SankeyPlot
    1. read in file
    2. add root node, text
    3. add branch node, linkers, texts

    Additional Feature:
    buttons to change the data order in reader, then paint() pane
     */

    String filename;
    SankeyReader reader;

    double xLeftMost = 50;
    double ZOOM;
    Font defaultFont = new Font("Arial", 18);
    Font labelFont = new Font("Arial", 22);


    // Constructor: takes in the filename
    public SankeyPane(String fn) {
        filename = fn;
        reader = new SankeyReader(fn);
        ZOOM = 560 / reader.returnSum() * 0.6;
    }


    private void paint() {
        // Additional Feature: sorting buttons
        Button ascend = getButtonAscend(10, getHeight() - 35);
        Button descend = getButtonDescend(90, getHeight() - 35);
        Button random = getButtonRandom(180, getHeight() - 35);


        // set Node0 and Text0, add to `this` pane
        double sum = reader.returnSum();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedString = decimalFormat.format(sum);

        SankeyText text0 = new SankeyText(reader.label + "\n[" + formattedString + "]",
                xLeftMost - 10, getHeight() / 2, labelFont);
        SankeyNode node0 = new SankeyNode(xLeftMost + text0.width,
                (getHeight() - reader.returnSum() * ZOOM) / 2, ZOOM * reader.returnSum(),
                Color.GREEN.darker());

        getChildren().clear();
        getChildren().addAll(random, descend, ascend, text0, node0);


        // init position configuration of branch linker, nodes and text
        double deltaY = (getHeight() - reader.returnSum() * ZOOM) / (reader.data.size() + 1) * 0.75;
        double lowerNodeY = 70;
        double lowerLinkY = node0.yPos;
        int index = 0;


        // iterate to create branch nodes texts linkers, add to pane
        for (String str : reader.data.keySet()) {

            double size = reader.data.get(str);
            Color color = SankeyColor.getColor(index);
            String string = str + "\n[" + size + "]";

            SankeyNode node = new SankeyNode(0.8 * getWidth(), lowerNodeY + deltaY, size * ZOOM, color);
            SankeyLinker linker = new SankeyLinker(xLeftMost + text0.width, lowerLinkY, node, color);
            SankeyText text = new SankeyText(string, 0.8 * getWidth() + 20, lowerNodeY + deltaY + size * ZOOM / 2, defaultFont);

            getChildren().addAll(node, text, linker);


            // update the position
            lowerLinkY = linker.lowerY;
            lowerNodeY = node.lowerY;
            index++;
        }
    }

    @Override
    public void setWidth(double x) {
        super.setWidth(x);
        paint();
    }

    @Override
    public void setHeight(double x) {
        super.setHeight(x);
        paint();
    }

    // Private method: return a button that includes additional Feature, descending sorting
    private Button getButtonDescend(double x, double y) {
        Button descend = new Button("Descending");
        descend.setLayoutX(x);
        descend.setLayoutY(y);
        descend.setOnAction(actionEvent -> {
            reader.toDescend();
            paint();
        });
        return descend;
    }

    // Private method: return a button that includes additional Feature, ascending sorting
    private Button getButtonAscend(double x, double y) {
        // Additional Feature: ascending sorting
        Button ascend = new Button("Ascending");
        ascend.setLayoutX(x);
        ascend.setLayoutY(y);
        ascend.setOnAction(actionEvent -> {
            reader.toAscend();
            paint();
        });
        return ascend;
    }

    // Private method: return a button that includes additional Feature, random order
    private Button getButtonRandom(double x, double y) {
        // Additional Feature: shuffle 
        Button bt = new Button("Shuffle");
        bt.setLayoutY(y);
        bt.setLayoutX(x);
        bt.setOnAction(actionEvent -> {
            reader.toRandom();
            paint();
        });
        return bt;
    }
}
