import javafx.scene.paint.Color;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;

/*
    This Class exploit path to draw a rectangle as node
    Mind that the xPos and yPos is the coordinate of upper-left point of the node
*/


public class SankeyNode extends Path {

    /* All these properties are public, yet not suppose to be lvalue */
    public static double NodeWidth = 10;    // 10 pixels
    public double xPos;
    public double yPos;
    public double size;
    public double lowerY;
    Color color;


    public SankeyNode(double x, double y, double s, Color c) {
        this.xPos = x;
        this.yPos = y;
        this.size = s;
        this.color = c;
        this.lowerY = yPos + size;

        this.setStroke(Color.TRANSPARENT);
        this.getElements().add(new MoveTo(xPos, yPos));
        this.getElements().add(new HLineTo(xPos + SankeyNode.NodeWidth));
        this.getElements().add(new VLineTo(yPos + size));
        this.getElements().add(new HLineTo(xPos));
        this.getElements().add(new VLineTo(yPos));
        this.setFill(color);
    }

    public void setxPos(double x) {
        this.xPos = x;
    }

    public void setyPos(double y) {
        this.yPos = y;
    }

}
