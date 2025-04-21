import java.util.Date;

public class main {

    public static void main(String[] args) {
        // Création de patients
        Patient patient1 = new Patient("Dupont", "Jean", "01/01/1980", "jean.dupont@mail.com", "0123456789");
        Patient patient2 = new Patient("Martin", "Marie", "12/05/1992", "marie.martin@mail.com", "0987654321");

        // Création de médecins
        Medecin medecin1 = new Medecin("Lemoine", "Pierre", "Cardiologue", "pierre.lemoine@mail.com");
        Medecin medecin2 = new Medecin("Durand", "Claire", "Dentiste", "claire.durand@mail.com");

        // Gestion des patients
        GestionPatients gestionPatients = new GestionPatients();
        gestionPatients.ajouterPatient(patient1);
        gestionPatients.ajouterPatient(patient2);
        System.out.println("Liste des patients après ajout:");
        gestionPatients.afficherPatients();

        // Modification d'un patient
        gestionPatients.modifierPatient("jean.dupont@mail.com", "Dupont", "Jean-Pierre");
        System.out.println("\nListe des patients après modification:");
        gestionPatients.afficherPatients();

        // Suppression d'un patient
        gestionPatients.supprimerPatient("marie.martin@mail.com");
        System.out.println("\nListe des patients après suppression:");
        gestionPatients.afficherPatients();

        // Gestion des médecins
        GestionMedecins gestionMedecins = new GestionMedecins();
        gestionMedecins.ajouterMedecin(medecin1);
        gestionMedecins.ajouterMedecin(medecin2);
        System.out.println("\nListe des médecins après ajout:");
        gestionMedecins.afficherMedecins();

        // Gestion des rendez-vous
        GestionRendezVous gestionRendezVous = new GestionRendezVous();
        RendezVous rdv1 = new RendezVous(patient1, medecin1, new Date());
        RendezVous rdv2 = new RendezVous(patient2, medecin2, new Date());
        gestionRendezVous.ajouterRendezVous(rdv1);
        gestionRendezVous.ajouterRendezVous(rdv2);
        System.out.println("\nListe des rendez-vous après ajout:");
        gestionRendezVous.afficherRendezVous();

        // Modification d'un rendez-vous
        Date nouvelleDate = new Date(System.currentTimeMillis() + 86400000); // Ajouter un jour
        gestionRendezVous.modifierRendezVous(patient1, medecin1, nouvelleDate);
        System.out.println("\nListe des rendez-vous après modification:");
        gestionRendezVous.afficherRendezVous();

        // Annulation d'un rendez-vous
        gestionRendezVous.annulerRendezVous(patient2, medecin2);
        System.out.println("\nListe des rendez-vous après annulation:");
        gestionRendezVous.afficherRendezVous();
    }
}
