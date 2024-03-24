package Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PatientView {

    private HeartHealthApp app;

    public PatientView(HeartHealthApp app) {
        this.app = app;
    }

    public VBox getView() {
        VBox layout = new VBox(10);

        Label idLabel = new Label("Enter your Patient ID:");
        TextField idTextField = new TextField();
        Button searchButton = new Button("Search");
        Label greetingLabel = new Label();
        VBox resultsLayout = new VBox(5);

        searchButton.setOnAction(event -> {
            String patientId = idTextField.getText().trim();
            Path patientInfoPath = Paths.get(patientId + "_PatientInfo.txt");
            Path ctResultsPath = Paths.get(patientId + "CTResults.txt");

            greetingLabel.setText("");  // Clear previous greeting/message
            resultsLayout.getChildren().clear();  // Clear previous results

            if (patientId.isEmpty()) {
                greetingLabel.setText("Please enter a Patient ID.");
                return;
            }

            try {
                if (Files.exists(patientInfoPath)) {
                    List<String> patientInfoLines = Files.readAllLines(patientInfoPath);
                    String patientName = patientInfoLines.stream()
                                                         .filter(line -> line.startsWith("First Name:"))
                                                         .findFirst()
                                                         .map(line -> line.split(":", 2)[1].trim())
                                                         .orElse("Unknown");

                    greetingLabel.setText("Hello " + patientName);

                    if (Files.exists(ctResultsPath) && !Files.readString(ctResultsPath).isEmpty()) {
                        List<String> ctResultsLines = Files.readAllLines(ctResultsPath);
                        ctResultsLines.forEach(line -> resultsLayout.getChildren().add(new Label(line)));
                    } else {
                        resultsLayout.getChildren().add(new Label("No CT scan data available yet."));
                    }
                } else {
                    greetingLabel.setText("Incorrect patient ID or no such patient available.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                greetingLabel.setText("Error reading files.");
            }
        });

        Button backToHomeButton = new Button("Back to Home");
        backToHomeButton.setOnAction(event -> app.switchToHomeView());

        layout.getChildren().addAll(idLabel, idTextField, searchButton, greetingLabel, resultsLayout, backToHomeButton);

        return layout;
    }
}
