package Application;
//Mai Gaye
//1224369094
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HeartHealthApp extends Application {

    private Stage primaryStage;
    private Scene homeScene;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Heart Health Imaging and Recording System");

        // Main layout with vertical box layout and spacing
        VBox homeLayout = new VBox(10);
        homeLayout.setAlignment(Pos.CENTER); // Center the contents of the VBox

        // Title label
        Label titleLabel = new Label("Heart Health Imaging and Recording System");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Buttons to navigate to different views
        Button goToReceptionistButton = new Button("Patient Intake");
        Button goToTechnicianButton = new Button("CT Scan View");
        Button goToPatientButton = new Button("Patient View");

        // Set the button style to blue background
        String buttonStyle = "-fx-background-color: #007bff; -fx-text-fill: white;";
        goToReceptionistButton.setStyle(buttonStyle);
        goToTechnicianButton.setStyle(buttonStyle);
        goToPatientButton.setStyle(buttonStyle);

        // Add title and buttons to the home layout
        homeLayout.getChildren().addAll(titleLabel, goToReceptionistButton, goToTechnicianButton, goToPatientButton);

        // Set action for each button to switch scenes
        goToReceptionistButton.setOnAction(event -> switchToReceptionistView());
        goToTechnicianButton.setOnAction(event -> switchToTechnicianView());
        goToPatientButton.setOnAction(event -> switchToPatientView());

        // Create the home scene with the layout and size
        homeScene = new Scene(homeLayout, 800, 600);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }

    void switchToHomeView() {
        primaryStage.setScene(homeScene);
    }

    private void switchToReceptionistView() {
        ReceptionistView receptionistView = new ReceptionistView(this);
        Scene receptionistScene = new Scene(receptionistView.getView(), 1000, 800);
        primaryStage.setScene(receptionistScene);
    }

    private void switchToTechnicianView() {
        TechnicianView technicianView = new TechnicianView(this);
        Scene technicianScene = new Scene(technicianView.getView(), 1000, 800);
        primaryStage.setScene(technicianScene);
    }

    private void switchToPatientView() {
        PatientView patientView = new PatientView(this);
        Scene patientScene = new Scene(patientView.getView(), 1000, 600);
        primaryStage.setScene(patientScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
