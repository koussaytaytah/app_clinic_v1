import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO {

    public void ajouterPatient(String nom, String prenom, String dateDeNaissance, String email, String telephone) {
        String query = "INSERT INTO Patient (nom, prenom, date_de_naissance, email, telephone) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, dateDeNaissance);
            stmt.setString(4, email);
            stmt.setString(5, telephone);

            stmt.executeUpdate();
            System.out.println("Patient ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
