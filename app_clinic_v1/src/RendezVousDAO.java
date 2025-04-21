import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class RendezVousDAO {

    public void ajouterRendezVous(int patientId, int medecinId, Timestamp dateRendezVous) {
        String query = "INSERT INTO rendezvous (patient_id, medecin_id, date_rendezvous) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, patientId);
            stmt.setInt(2, medecinId);
            stmt.setTimestamp(3, dateRendezVous);

            stmt.executeUpdate();
            System.out.println("Rendez-vous ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
