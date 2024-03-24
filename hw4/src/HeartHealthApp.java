import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class HeartHealthApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Heart Health Imaging and Recording System");

        TabPane tabPane = new TabPane();

        Tab receptionistTab = new Tab("Receptionist");
        receptionistTab.setContent(new ReceptionistView().getView());
        receptionistTab.setClosable(false);

        Tab technicianTab = new Tab("Technician");
        technicianTab.setContent(new TechnicianView().getView());
        technicianTab.setClosable(false);

        Tab patientTab = new Tab("Patient");
        patientTab.setContent(new PatientView().getView());
        patientTab.setClosable(false);

        tabPane.getTabs().addAll(receptionistTab, technicianTab, patientTab);

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
