package gestClasse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionMatieres {

    private List<String> matieres = new ArrayList<>();

    public List<String> getMatieres() {
        return matieres;
    }

    public void gererMatieres(Scanner scanner) {
        System.out.println("\nGestion des matières :");

        System.out.print("Ajouter une nouvelle matière : ");
        String nouvelleMatiere = scanner.nextLine();
        matieres.add(nouvelleMatiere);

        System.out.println("Matière ajoutée avec succès : " + nouvelleMatiere);
    }
}
