import javafx.scene.paint.Color;

public class SankeyColor {
    static int count = 0;
    static Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW.darker(), Color.PURPLE};

    public static Color getColor() {
        return colors[count++ % 5];
    }

    public static Color getColor(int index) {
        return colors[index % 5];
    }

}
