package gestClasse;

public class GestionClassement {

    private GestionEtudiants gestionEtudiants;
    private GestionMatieres gestionMatieres;

    public GestionClassement(GestionEtudiants gestionEtudiants, GestionMatieres gestionMatieres) {
        this.gestionEtudiants = gestionEtudiants;
        this.gestionMatieres = gestionMatieres;
    }

    public void etablirClassement() {
        System.out.println("\nÉtablissement du classement :");
        // Implémenter la logique pour établir le classement
    }
}
