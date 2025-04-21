import java.util.Date;

public class RendezVous {
    private Patient patient;
    private Medecin medecin;
    private Date dateRendezVous;
    private String statut;

    public RendezVous(Patient patient, Medecin medecin, Date dateRendezVous) {
        this.patient = patient;
        this.medecin = medecin;
        this.dateRendezVous = dateRendezVous;
        this.statut = "Programmé";
    }

    public Patient getPatient() {
        return patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    public String getStatut() {
        return statut;
    }

    public void annulerRendezVous() {
        this.statut = "Annulé";
    }

    @Override
    public String toString() {
        return "RendezVous [Patient=" + patient.getNom() + " " + patient.getPrenom() + ", Medecin=" + medecin.getNom() + " " + medecin.getPrenom() + ", Date=" + dateRendezVous + ", Statut=" + statut + "]";
    }
}
