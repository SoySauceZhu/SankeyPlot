import javafx.scene.paint.Color;

public class SankeyColor {
    static int count = 0;
//    static Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW.darker(), Color.PURPLE};
    static Color[] colors = {Color.BLUE, Color.YELLOW.darker(), Color.PURPLE};

    public static Color getColor() {
        if (count > 2) {
            count = 0;
        }
        return colors[count++];
    }

}
