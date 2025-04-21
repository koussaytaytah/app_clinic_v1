import java.util.ArrayList;
import java.util.List;

public class GestionPatients {
    private  List<Patient> patients;

    public GestionPatients() {
        this.patients = new ArrayList<>();
    }

    public void ajouterPatient(Patient patient) {
        patients.add(patient);
    }

    public void modifierPatient(String email, String nouveauNom, String nouveauPrenom) {
        for (Patient patient : patients) {
            if (patient.getEmail().equals(email)) {
                patient.setNom(nouveauNom);
                patient.setPrenom(nouveauPrenom);
                break;
            }
        }
    }

    public void supprimerPatient(String email) {
        patients.removeIf(patient -> patient.getEmail().equals(email));
    }

    public Patient chercherPatient(String email) {
        for (Patient patient : patients) {
            if (patient.getEmail().equals(email)) {
                return patient;
            }
        }
        return null;
    }

    public void afficherPatients() {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
}
