import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SankeyPane extends Pane {

    String filename;
    SankeyReader reader;

    double xLeftMost = 75;
    double ZOOM;
    Font defaultFont = new Font("Arial", 18);
    Font labelFont = new Font("Arial", 22);



    // Constructor: takes in the filename
    public SankeyPane(String fn) {
        filename = fn;
        reader = new SankeyReader(fn);
        ZOOM = 560/reader.returnSum() * 0.6;
    }


    private void paint() {


        // set Node0 and Text0
        SankeyText text0 = new SankeyText(reader.label + "\n[" + reader.returnSum() + "]",
                xLeftMost, getHeight() / 2, labelFont);
        SankeyNode node0 = new SankeyNode(xLeftMost + text0.width,
                (getHeight() - reader.returnSum() * ZOOM) / 2, ZOOM * reader.returnSum(),
                Color.GREEN.darker());

        getChildren().clear();
        getChildren().addAll(text0, node0);


        double deltaY = (getHeight() - reader.returnSum() * ZOOM) / (reader.data.size() + 1) * 0.75;
        double lowerNodeY = 70;
        double lowerLinkY = node0.yPos;

        for (String str: reader.data.keySet()) {

            double size = reader.data.get(str);
            Color color = SankeyColor.getColor();
            String string = str + "\n[" + size + "]";

            SankeyNode node = new SankeyNode(0.8 * getWidth(), lowerNodeY + deltaY, size * ZOOM, color);
            SankeyLinker linker = new SankeyLinker(xLeftMost + text0.width, lowerLinkY, node, color);
            SankeyText text = new SankeyText(string, 0.8 * getWidth() + 20, lowerNodeY + deltaY + size * ZOOM /2, defaultFont);

            getChildren().addAll(node, text, linker);


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
