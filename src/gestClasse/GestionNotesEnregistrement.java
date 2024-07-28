package gestClasse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class GestionNotesEnregistrement {

    private GestionClasses gestionClasses;
    private GestionEtudiants gestionEtudiants;
    private GestionMatieres gestionMatieres;
    private Map<String, Map<String, List<Double>>> notesParMatiereParClasse = new HashMap<>();

    public GestionNotesEnregistrement(GestionClasses gestionClasses, GestionEtudiants gestionEtudiants, GestionMatieres gestionMatieres) {
        this.gestionClasses = gestionClasses;
        this.gestionEtudiants = gestionEtudiants;
        this.gestionMatieres = gestionMatieres;
    }

    public void enregistrerNotes(Scanner scanner) {
        System.out.println("\nEnregistrement des notes :");

        // Sélection de la classe
        List<String> classes = gestionClasses.getClasses();
        System.out.println("Classes disponibles : ");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i));
        }

        System.out.print("Choisir une classe : ");
        int choixClasse = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après le nextInt()

        if (choixClasse < 1 || choixClasse > classes.size()) {
            System.out.println("Choix invalide.");
            return;
        }
        String classeSelectionnee = classes.get(choixClasse - 1);

        // Sélection de la matière
        List<String> matieres = gestionMatieres.getMatieres();
        System.out.println("Matieres disponibles : ");
        for (int i = 0; i < matieres.size(); i++) {
            System.out.println((i + 1) + ". " + matieres.get(i));
        }

        System.out.print("Choisir une matière : ");
        int choixMatiere = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après le nextInt()

        if (choixMatiere < 1 || choixMatiere > matieres.size()) {
            System.out.println("Choix invalide.");
            return;
        }
        String matiereSelectionnee = matieres.get(choixMatiere - 1);

        // Nombre de notes à enregistrer
        System.out.print("Nombre de notes à enregistrer pour " + matiereSelectionnee + " : ");
        int nombreNotes = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après le nextInt()

        // Enregistrement des notes pour chaque étudiant de la classe
        for (Etudiant etudiant : gestionEtudiants.getEtudiants()) {
            if (etudiant.getClasse().equals(classeSelectionnee)) {
                System.out.print("Note pour " + etudiant + " en " + matiereSelectionnee + " : ");
                double note = scanner.nextDouble();
                scanner.nextLine(); // Pour consommer la nouvelle ligne après le nextDouble()

                notesParMatiereParClasse.computeIfAbsent(classeSelectionnee, k -> new HashMap<>())
                        .computeIfAbsent(matiereSelectionnee, k -> new ArrayList<>()).add(note);

                System.out.println("Note enregistrée avec succès.");
            }
        }
    }
}
