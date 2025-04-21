import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainApp extends Application {

    private PatientDAO patientDAO = new PatientDAO();
    private MedecinDAO medecinDAO = new MedecinDAO();
    private RendezVousDAO rendezVousDAO = new RendezVousDAO();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ajouter Patient, Médecin et Rendez-vous");

        // Création des champs pour le Patient
        TextField nomPatient = new TextField();
        nomPatient.setPromptText("Nom Patient");

        TextField prenomPatient = new TextField();
        prenomPatient.setPromptText("Prénom Patient");

        TextField emailPatient = new TextField();
        emailPatient.setPromptText("Email Patient");

        TextField telephonePatient = new TextField();
        telephonePatient.setPromptText("Téléphone Patient");

        DatePicker dateNaissancePatient = new DatePicker();
        dateNaissancePatient.setPromptText("Date de Naissance");

        // Création des champs pour le Médecin
        TextField nomMedecin = new TextField();
        nomMedecin.setPromptText("Nom Médecin");

        TextField prenomMedecin = new TextField();
        prenomMedecin.setPromptText("Prénom Médecin");

        TextField specialiteMedecin = new TextField();
        specialiteMedecin.setPromptText("Spécialité Médecin");

        TextField emailMedecin = new TextField();
        emailMedecin.setPromptText("Email Médecin");

        // Création des champs pour le Rendez-vous
        ComboBox<String> patientComboBox = new ComboBox<>();
        ComboBox<String> medecinComboBox = new ComboBox<>();
        DatePicker dateRendezVous = new DatePicker();
        
        Button ajouterButton = new Button("Ajouter");

        // Remplissage des combobox avec des données (Patient, Médecin)
        loadPatients(patientComboBox);
        loadMedecins(medecinComboBox);

        // Action pour ajouter un patient, un médecin et un rendez-vous
        ajouterButton.setOnAction(e -> {
            String nomPat = nomPatient.getText();
            String prenomPat = prenomPatient.getText();
            String emailPat = emailPatient.getText();
            String telPat = telephonePatient.getText();
            LocalDate dateNaiss = dateNaissancePatient.getValue();
            String dateStr = dateNaiss.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            patientDAO.ajouterPatient(nomPat, prenomPat, dateStr, emailPat, telPat);

            String nomMed = nomMedecin.getText();
            String prenomMed = prenomMedecin.getText();
            String specMed = specialiteMedecin.getText();
            String emailMed = emailMedecin.getText();

            medecinDAO.ajouterMedecin(nomMed, prenomMed, specMed, emailMed);

            // Ajouter un rendez-vous
            String patientSelectionne = patientComboBox.getValue();
            String medecinSelectionne = medecinComboBox.getValue();
            LocalDate dateRdv = dateRendezVous.getValue();

            // Récupérer les ID du patient et du médecin
            int patientId = getPatientId(patientSelectionne);
            int medecinId = getMedecinId(medecinSelectionne);

            Timestamp timestamp = Timestamp.valueOf(dateRdv.atStartOfDay());

            rendezVousDAO.ajouterRendezVous(patientId, medecinId, timestamp);
        });

        // Layout de l'interface
        VBox layout = new VBox(10, 
            new Label("Nom Patient:"), nomPatient, 
            new Label("Prénom Patient:"), prenomPatient, 
            new Label("Email Patient:"), emailPatient,
            new Label("Téléphone Patient:"), telephonePatient,
            new Label("Date de Naissance Patient:"), dateNaissancePatient,
            new Label("Nom Médecin:"), nomMedecin, 
            new Label("Prénom Médecin:"), prenomMedecin, 
            new Label("Spécialité Médecin:"), specialiteMedecin, 
            new Label("Email Médecin:"), emailMedec
        );
    }
}
