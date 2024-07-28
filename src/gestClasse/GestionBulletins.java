package gestClasse;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestionBulletins {

    private GestionEtudiants gestionEtudiants;

    public GestionBulletins(GestionEtudiants gestionEtudiants) {
        this.gestionEtudiants = gestionEtudiants;
    }

    public void genererBulletins() {
        System.out.println("\nGénération des bulletins :");

        for (Etudiant etudiant : gestionEtudiants.getEtudiants()) {
            String bulletin = "Bulletin de " + etudiant + "\n";
            // Ajoute des détails au bulletin ici

            try (FileWriter writer = new FileWriter("bulletins/" + etudiant.getNom() + "_" + etudiant.getPrenom() + ".txt")) {
                writer.write(bulletin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
