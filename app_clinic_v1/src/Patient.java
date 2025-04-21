public class Patient {
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String email;
    private String telephone;

    public Patient(String nom, String prenom, String dateDeNaissance, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.email = email;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Patient [Nom=" + nom + ", Prenom=" + prenom + ", Date de Naissance=" + dateDeNaissance + ", Email=" + email + ", Telephone=" + telephone + "]";
    }
}
