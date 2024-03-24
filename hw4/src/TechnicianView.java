import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class TechnicianView {

    public GridPane getView() {
        GridPane gridPane = new GridPane();

        Label scanResultLabel = new Label("CT Scan Result:");
        TextField scanResultTextField = new TextField();
        gridPane.add(scanResultLabel, 0, 0);
        gridPane.add(scanResultTextField, 1, 0);

        // Add more fields as necessary

        Button saveButton = new Button("Save CT Scan Data");
        saveButton.setOnAction(event -> {
            // Save CT scan data logic
            System.out.println("CT scan data saved.");
        });

        gridPane.add(saveButton, 1, 1);
        return gridPane;
    }
}
