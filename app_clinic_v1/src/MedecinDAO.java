import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedecinDAO {

    public void ajouterMedecin(String nom, String prenom, String specialite, String email) {
        String query = "INSERT INTO Medecin (nom, prenom, specialite, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, specialite);
            stmt.setString(4, email);

            stmt.executeUpdate();
            System.out.println("Médecin ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
