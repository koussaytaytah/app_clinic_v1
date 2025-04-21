import java.util.ArrayList;
import java.util.List;

public class GestionMedecins {
    private List<Medecin> medecins;

    public GestionMedecins() {
        this.medecins = new ArrayList<>();
    }

    public void ajouterMedecin(Medecin medecin) {
        medecins.add(medecin);
    }

    public void modifierMedecin(String email, String nouveauNom, String nouvelleSpecialite) {
        for (Medecin medecin : medecins) {
            if (medecin.getEmail().equals(email)) {
                medecin.setNom(nouveauNom);
                medecin.setSpecialite(nouvelleSpecialite);
                break;
            }
        }
    }

    public void supprimerMedecin(String email) {
        medecins.removeIf(medecin -> medecin.getEmail().equals(email));
    }

    public Medecin chercherMedecin(String email) {
        for (Medecin medecin : medecins) {
            if (medecin.getEmail().equals(email)) {
                return medecin;
            }
        }
        return null;
    }

    public void afficherMedecins() {
        for (Medecin medecin : medecins) {
            System.out.println(medecin);
        }
    }
}
