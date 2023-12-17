import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;


/* This Class creat a linker band from one node (or a position) to another */

public class SankeyLinker extends Path {
    SankeyNode start;
    SankeyNode end;
    double startX;
    double startY;
    double size;
    double lowerY;
    Color color;

    public SankeyLinker(SankeyNode node1, SankeyNode node2, Color c) {
        this.start = node1;
        this.end = node2;
        this.color = c.deriveColor(0, 1, 1, 0.3);
        this.size = node2.size;
        this.lowerY = node1.lowerY;

        double startX = start.xPos + SankeyNode.NodeWidth;
        double startY = start.yPos;
        double endX = end.xPos;
        double endY = end.yPos;
        double width = endX - startX;   // Width of the curved band

        this.setStroke(Color.TRANSPARENT);  // I don't want stroke to be shown

        this.getElements().add(new MoveTo(startX, startY));
        this.getElements().add(new CubicCurveTo(startX + width / 2, startY, startX + width / 2, endY, endX, endY));
        this.getElements().add(new VLineTo(endY + size));
        this.getElements().add(new CubicCurveTo(startX + width / 2, endY + size, startX + width / 2, startY + size, startX, startY + size));
        this.getElements().add(new VLineTo(startY));

        this.setFill(color);
    }

    public SankeyLinker(double x, double y, SankeyNode node2, Color c) {
        this.color = c.deriveColor(0, 1, 1, 0.3);

        this.startY = y;
        this.startX = x + SankeyNode.NodeWidth;
        this.end = node2;
        this.size = node2.size;
        this.lowerY = this.startY + size;

        double endX = end.xPos;
        double endY = end.yPos;
        double width = endX - startX;   // Width of the curved band

        this.setStroke(Color.TRANSPARENT);  // I don't want stroke to be shown

        this.getElements().add(new MoveTo(startX, startY));
        this.getElements().add(new CubicCurveTo(startX + width / 2, y, startX + width / 2, endY, endX, endY));
        this.getElements().add(new VLineTo(endY + size));
        this.getElements().add(new CubicCurveTo(startX + width / 2, endY + size, startX + width / 2, y + size, startX, y + size));
        this.getElements().add(new VLineTo(y));

        this.setFill(color);
    }

    public void setStartX(double x) {
        this.startX = x;
    }

    public void setStartY(double y) {
        this.startY = y;
    }

}
