import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class SankeyText extends Text {
    double xPos;    // left
    double yPos;    // upper

    double width;
    double height;

    Color color = Color.BLACK;  // default color is BLACK


    public SankeyText(String str, double x, double y, Font font) {
        xPos = x;
        yPos = y;
        this.setText(str);
        this.setFont(font);
        this.setFill(color);
        this.setX(x);
        this.setY(y);
        width = this.getLayoutBounds().getWidth();
        height = this.getLayoutBounds().getHeight();

    }


    public static class EndText extends Text {
        public EndText(String content, double x, double y, Color color) {
            Font font = new Font("Arial", 20);
            this.setText(content);
            this.setX(x);
            this.setY(y);
            this.setFont(font);
            this.setFill(color);
        }
    }

    public static class FrontText extends Text {
        public FrontText(String content, double x, double y, Color color) {
            Font font = new Font("Arial", 26);
            this.setText(content);
            double width = this.getLayoutBounds().getWidth();
            double height = this.getLayoutBounds().getHeight();
            this.setX(x - width);
            this.setY(y + height);
            this.setFill(Color.BLACK);

        }
    }

}