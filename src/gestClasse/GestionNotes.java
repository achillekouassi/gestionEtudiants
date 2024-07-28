package gestClasse;

import java.util.Scanner;

public class GestionNotes {

    public static void main(String[] args) {
        // Initialisation des gestionnaires
        GestionClasses gestionClasses = new GestionClasses();
        GestionEtudiants gestionEtudiants = new GestionEtudiants(gestionClasses);
        GestionMatieres gestionMatieres = new GestionMatieres();
        GestionNotesEnregistrement gestionNotesEnregistrement = new GestionNotesEnregistrement(gestionClasses, gestionEtudiants, gestionMatieres);
        GestionCalculs gestionCalculs = new GestionCalculs(gestionEtudiants);
        GestionClassement gestionClassement = new GestionClassement(gestionEtudiants, gestionMatieres);
        GestionBulletins gestionBulletins = new GestionBulletins(gestionEtudiants);

        Scanner scanner = new Scanner(System.in);

        // Authentification de l'utilisateur
        System.out.println("Bienvenue ! Veuillez vous connecter en tant qu'administrateur.");
        System.out.print("Identifiant : ");
        String identifiant = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();

        // Vérification des identifiants
        if (!identifiant.equals("admin") || !motDePasse.equals("admin")) {
            System.out.println("Identifiant ou mot de passe incorrect. Fin du programme.");
            return;
        }

        System.out.println("Authentification réussie.");

        // Boucle principale de l'application
        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Gérer les classes");
            System.out.println("2. Gérer les étudiants");
            System.out.println("3. Gérer les matières");
            System.out.println("4. Enregistrer les notes");
            System.out.println("5. Calculer les moyennes");
            System.out.println("6. Établir le classement");
            System.out.println("7. Générer les bulletins");
            System.out.println("8. Quitter");

            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après le nextInt()

            switch (choix) {
                case 1:
                    gestionClasses.gererClasses(scanner);
                    break;
                case 2:
                    gestionEtudiants.gererEtudiants(scanner);
                    break;
                case 3:
                    gestionMatieres.gererMatieres(scanner);
                    break;
                case 4:
                    gestionNotesEnregistrement.enregistrerNotes(scanner);
                    break;
                case 5:
                    gestionCalculs.calculerMoyennes();
                    break;
                case 6:
                    gestionClassement.etablirClassement();
                    break;
                case 7:
                    gestionBulletins.genererBulletins();
                    break;
                case 8:
                    System.out.println("Merci d'avoir utilisé notre application. À bientôt !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
                    break;
            }
        }
    }
}
