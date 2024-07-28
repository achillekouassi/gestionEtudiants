package gestClasse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class GestionEtudiants {

    private List<Etudiant> etudiants = new ArrayList<>();
    private GestionClasses gestionClasses;

    public GestionEtudiants(GestionClasses gestionClasses) {
        this.gestionClasses = gestionClasses;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void gererEtudiants(Scanner scanner) {
        System.out.println("\nGestion des étudiants :");

        System.out.print("Nom de l'étudiant : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom de l'étudiant : ");
        String prenom = scanner.nextLine();

        System.out.println("Classes disponibles : ");
        List<String> classes = gestionClasses.getClasses();
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i));
        }
        System.out.print("Choisir la classe de l'étudiant : ");
        int choixClasse = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après le nextInt()

        if (choixClasse < 1 || choixClasse > classes.size()) {
            System.out.println("Choix invalide.");
            return;
        }
        String classe = classes.get(choixClasse - 1);

        Etudiant nouvelEtudiant = new Etudiant(nom, prenom, classe);
        etudiants.add(nouvelEtudiant);

        System.out.println("Étudiant ajouté avec succès : " + nouvelEtudiant);
    }
}
