package gestClasse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionClasses {

    private List<String> classes = new ArrayList<>();

    public List<String> getClasses() {
        return classes;
    }

    public void gererClasses(Scanner scanner) {
        System.out.println("\nGestion des classes :");

        System.out.println("Classes disponibles : ");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i));
        }

        System.out.print("Ajouter une nouvelle classe : ");
        String nouvelleClasse = scanner.nextLine();
        classes.add(nouvelleClasse);

        System.out.println("Classe ajoutée avec succès : " + nouvelleClasse);
    }
}
