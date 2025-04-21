import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login extends Application {

    private static final String CORRECT_PASSWORD = "admin123"; // Mot de passe simple pour exemple

    @Override
    public void start(Stage primaryStage) {
        // Création des éléments de l'interface
        Label label = new Label("Entrez votre mot de passe");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Se connecter");

        // Ajouter une action au bouton de connexion
        loginButton.setOnAction(e -> {
            // Vérifier si le mot de passe est correct
            if (passwordField.getText().equals(CORRECT_PASSWORD)) {
                // Mot de passe correct, ouvrir l'écran principal
                // Assurez-vous d'avoir une classe MainApp avec la méthode start()
                try {
                    new MainApp().start(new Stage()); // Démarrage de l'application principale
                    primaryStage.close(); // Fermer la fenêtre de login
                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Erreur lors du démarrage de l'application principale.");
                    alert.show();
                }
            } else {
                // Mot de passe incorrect
                Alert alert = new Alert(Alert.AlertType.ERROR, "Mot de passe incorrect.");
                alert.show();
            }
        });

        // Création du layout
        VBox layout = new VBox(10, label, passwordField, loginButton);
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Lancement de l'application JavaFX
        launch(args);
    }
}
