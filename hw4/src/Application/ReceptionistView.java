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
import java.util.Random;

public class ReceptionistView {

    private HeartHealthApp app;

    public ReceptionistView(HeartHealthApp app) {
        this.app = app;
    }

    public VBox getView() {
        VBox layout = new VBox(10);

        TextField firstNameTextField = new TextField();
        TextField lastNameTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField phoneNumberTextField = new TextField();
        TextField healthHistoryTextField = new TextField();
        TextField insuranceIdTextField = new TextField();

        layout.getChildren().addAll(
                new Label("First Name:"), firstNameTextField,
                new Label("Last Name:"), lastNameTextField,
                new Label("Email:"), emailTextField,
                new Label("Phone Number:"), phoneNumberTextField,
                new Label("Health History:"), healthHistoryTextField,
                new Label("Insurance ID:"), insuranceIdTextField
        );

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            String patientId = generatePatientId();
            String patientData = String.format(
                    "First Name: %s\nLast Name: %s\nEmail: %s\nPhone Number: %s\nHealth History: %s\nInsurance ID: %s",
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    emailTextField.getText(),
                    phoneNumberTextField.getText(),
                    healthHistoryTextField.getText(),
                    insuranceIdTextField.getText()
            );
            try {
                Files.writeString(Paths.get(patientId + "_PatientInfo.txt"), patientData);
                System.out.println("Saved patient information for ID: " + patientId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Button backToHomeButton = new Button("Back to Home");
        backToHomeButton.setOnAction(event -> app.switchToHomeView());

        layout.getChildren().addAll(saveButton, backToHomeButton);

        return layout;
    }

    private String generatePatientId() {
        return String.format("%05d", new Random().nextInt(100000));
    }
}
