import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class PatientView {

    public GridPane getView() {
        GridPane gridPane = new GridPane();

        Label patientIdLabel = new Label("Patient ID:");
        TextField patientIdTextField = new TextField();
        Button searchButton = new Button("Search");

        gridPane.add(patientIdLabel, 0, 0);
        gridPane.add(patientIdTextField, 1, 0);
        gridPane.add(searchButton, 2, 0);

        searchButton.setOnAction(event -> {
            // Search and display patient data logic
            System.out.println("Displaying patient data.");
        });

        // Result display area can be added here

        return gridPane;
    }
}
