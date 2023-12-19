import javafx.scene.paint.Color;

public class SankeyColor {
    static Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW.darker(), Color.PURPLE};

    /*
        You can simply call `getColor(i)` for your specific element
        Therefore every time the color of this element would not change
     */
    public static Color getColor(int index) {
        return colors[index % 5];
    }

}
