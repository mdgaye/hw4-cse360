package Application;
//Mai Gaye
//1224369094

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TechnicianView {

    private HeartHealthApp app;

    public TechnicianView(HeartHealthApp app) {
        this.app = app;
    }

    public VBox getView() {
        VBox layout = new VBox(10);

        TextField patientIdTextField = new TextField();
        TextField agatstonScoreTextField = new TextField();
        TextField lmTextField = new TextField();
        TextField ladTextField = new TextField();
        TextField lcxTextField = new TextField();
        TextField rcaTextField = new TextField();
        TextField pdaTextField = new TextField();

        layout.getChildren().addAll(
                new Label("Patient ID:"), patientIdTextField,
                new Label("Total Agatston Score:"), agatstonScoreTextField,
                new Label("LM:"), lmTextField,
                new Label("LAD:"), ladTextField,
                new Label("LCX:"), lcxTextField,
                new Label("RCA:"), rcaTextField,
                new Label("PDA:"), pdaTextField
        );

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            String ctScanData = String.format(
                    "Total Agatston Score: %s\nLM: %s\nLAD: %s\nLCX: %s\nRCA: %s\nPDA: %s",
                    agatstonScoreTextField.getText(),
                    lmTextField.getText(),
                    ladTextField.getText(),
                    lcxTextField.getText(),
                    rcaTextField.getText(),
                    pdaTextField.getText()
            );
            try {
                Files.writeString(Paths.get(patientIdTextField.getText() + "CTResults.txt"), ctScanData);
                System.out.println("Saved CT scan data for ID: " + patientIdTextField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Button backToHomeButton = new Button("Back to Home");
        backToHomeButton.setOnAction(event -> app.switchToHomeView());

        layout.getChildren().addAll(saveButton, backToHomeButton);

        return layout;
    }
}
