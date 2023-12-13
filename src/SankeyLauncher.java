import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/*  Additional Feature: use a textField to take in the filename then pass it to SankeyPlot*/
public class SankeyLauncher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Additional feature: text bar
        TextField fileNameField = new TextField();
        Button submitButton = new Button("Generate Plot");

        submitButton.setOnAction(actionEvent -> {
            String fileNameFieldText = fileNameField.getText();
            SankeyPlot Plot = new SankeyPlot(fileNameFieldText);
            Stage plotStage = new Stage();
            Plot.start(plotStage);
        });


        // Create a VBox layout to arrange the components vertically
        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20)); // Padding around the VBox

        // Add textBar and Button to the VBox
        vbox.getChildren().addAll(fileNameField, submitButton);

        // Create a scene and set it on the primary stage
        Scene scene = new Scene(vbox, 300, 150);
        primaryStage.setScene(scene);

        // Set the title of the primary stage
        primaryStage.setTitle("Dynamic Circle App");

        // Show the primary stage
        primaryStage.show();
    }
}
