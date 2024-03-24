
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class ReceptionistView {

    public GridPane getView() {
        GridPane gridPane = new GridPane();

        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameTextField, 1, 0);

        // Add more fields like age, address, etc.

        Button saveButton = new Button("Save Patient Info");
        saveButton.setOnAction(event -> {
            // Save patient info logic
            System.out.println("Patient info saved.");
        });

        gridPane.add(saveButton, 1, 2);
        return gridPane;
    }
}