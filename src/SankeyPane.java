import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Map;

public class SankeyPane extends Pane {

    String filename;
    SankeyReader reader;

    double xLeftMost = 75;
    Font defaultFont = new Font("Arial", 18);
    Font labelFont = new Font("Arial", 22);



    // Constructor: takes in the filename
    public SankeyPane(String fn) {
        filename = fn;
        reader = new SankeyReader(fn);
    }


    private void paint() {


        // set Node0 and Text0
        SankeyText text0 = new SankeyText(reader.label + "\n[" + reader.returnSum() + "]",
                xLeftMost, getHeight() / 2, labelFont);
        SankeyNode node0 = new SankeyNode(xLeftMost + text0.width,
                (getHeight() - reader.returnSum()) / 2, reader.returnSum(),
                Color.GREEN.darker());

        getChildren().clear();
        getChildren().addAll(text0, node0);


        double deltaY = (getHeight() - reader.returnSum()) / (reader.data.size() + 1);
        double lowerNodeY = 0;
        double lowerLinkY = node0.xPos;

        for (String str: reader.data.keySet()) {

            double size = reader.data.get(str);
            Color color = SankeyColor.getColor();
            String string = str + "\n[" + size + "]";

            SankeyNode node = new SankeyNode(0.8 * getWidth(), lowerNodeY + deltaY, size, color);
            SankeyLinker linker = new SankeyLinker(xLeftMost + text0.width, lowerLinkY, node, color);
            SankeyText text = new SankeyText(string, 0.8 * getWidth() + 20, lowerNodeY + deltaY + size /2 + 5, defaultFont);

            getChildren().addAll(node, text, linker);

            getChildren().clear();

            lowerLinkY = linker.lowerY;
            lowerNodeY = node.lowerY;
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
}
