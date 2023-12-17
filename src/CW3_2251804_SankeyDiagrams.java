import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/*  Additional Feature: use a textField to take in the filename then pass it to SankeyPlot*/
public class CW3_2251804_SankeyDiagrams extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SankeyPlot Launcher");


        // Additional feature: text bar
        TextField fileNameField = new TextField();
        Button submitButton = new Button("Generate SankeyPlot");
        Button orderedButton = new Button("Generate SankeyPlot (Ordered)");


        submitButton.setOnAction(actionEvent -> {
            String fileNameFieldText = fileNameField.getText();
            if (fileNameFieldText.isEmpty()) {
                fileNameFieldText = "D:\\Zhu22\\SynologyDrive\\1.2022_Year2\\4.JAVA\\CourseWork3\\data.txt";
            }
            SankeyPlot Plot = new SankeyPlot(fileNameFieldText, false);
            Stage plotStage = new Stage();
            Plot.start(plotStage);
        });

        orderedButton.setOnAction(actionEvent -> {
            String fileNameFieldText = fileNameField.getText();
            if (fileNameFieldText.isEmpty()) {
                fileNameFieldText = "D:\\Zhu22\\SynologyDrive\\1.2022_Year2\\4.JAVA\\CourseWork3\\data.txt";
            }
            SankeyPlot Plot = new SankeyPlot(fileNameFieldText, true);
            Stage plotStage = new Stage();
            Plot.start(plotStage);
        });


        // Create a VBox layout to arrange the components vertically
        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        vbox.getChildren().addAll(fileNameField, submitButton, orderedButton);

        Scene scene = new Scene(vbox, 350, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
