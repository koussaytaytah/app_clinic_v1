import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestionRendezVous {
    private List<RendezVous> rendezVousList;

    public GestionRendezVous() {
        this.rendezVousList = new ArrayList<>();
    }

    public void ajouterRendezVous(RendezVous rendezVous) {
        rendezVousList.add(rendezVous);
    }

    public void modifierRendezVous(Patient patient, Medecin medecin, Date nouvelleDate) {
        for (RendezVous rdv : rendezVousList) {
            if (rdv.getPatient().equals(patient) && rdv.getMedecin().equals(medecin)) {
                rdv.getDateRendezVous().setTime(nouvelleDate.getTime());
                break;
            }
        }
    }

    public void annulerRendezVous(Patient patient, Medecin medecin) {
        for (RendezVous rdv : rendezVousList) {
            if (rdv.getPatient().equals(patient) && rdv.getMedecin().equals(medecin)) {
                rdv.annulerRendezVous();
                break;
            }
        }
    }

    public RendezVous chercherRendezVous(Patient patient, Medecin medecin) {
        for (RendezVous rdv : rendezVousList) {
            if (rdv.getPatient().equals(patient) && rdv.getMedecin().equals(medecin)) {
                return rdv;
            }
        }
        return null;
    }

    public void afficherRendezVous() {
        for (RendezVous rdv : rendezVousList) {
            System.out.println(rdv);
        }
    }
}
