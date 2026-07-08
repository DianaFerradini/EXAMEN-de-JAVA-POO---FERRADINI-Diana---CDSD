package view;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Vehicule;

public final class MainView {
private static final Scanner scanner = new Scanner(System.in);

    private MainView() {}

    public static int menu() {
        System.out.println("1. Ajouter un véhicule");
        System.out.println("2. Afficher tous les véhicules de la flotte");
        System.out.println("3. Afficher le(s) véhicule(s) avec le moins de kilomètres (idéal pour les longs trajets)");
        System.out.println("4. Afficher le tarif moyen de location journalier");
        System.out.println("5. Quitter");
        System.out.println("Choix : ");
        String ligne = scanner.nextLine();
        int choix = Integer.parseInt(ligne);
        return choix;
    }

    public static Vehicule saisieVehicule() {
        String marque = saisieChaine("Marque : ");
        String modele = saisieChaine("Modèle : ");
        int kilometrage = saisieEntier("Kilométrage : ", 0);
        double tarifJournalier = saisieDouble("Tarif journalier : ", 0);
        return new Vehicule(marque, modele, kilometrage, tarifJournalier);
    }

    public static void afficherVehicules(ArrayList<Vehicule> vehicules) {
        if (vehicules.isEmpty()) {
            System.out.println("Le parc automobile est actuellement vide");
        } else {
            for (Vehicule vehicule : vehicules) {
                System.out.println(vehicule);
            }
        }
    }

    public static void afficherTarifMoyenLocation(double tarifMoyenLocation) {
        System.out.println( "Tarif moyen : " + tarifMoyenLocation + " FCFA / jour");
    }

    public static String saisieChaine(String msg) {
        String chaine = "";
        do {
            System.out.println(msg);
            chaine = scanner.nextLine();
        } while (chaine.isEmpty());
        return chaine;
    }

    public static int saisieEntier(String msg, int min) {
        int entier;
        do {
            System.out.println(msg);
            String ligne = scanner.nextLine();
            entier = Integer.parseInt(ligne);
        } while (entier < min);
        //validité : entier >= min
        return entier;
    }

    public static double saisieDouble(String msg, int min) {
        double reel;
        do {
            System.out.println(msg);
            String ligne = scanner.nextLine();
            reel = Double.parseDouble(ligne);
        } while (reel <= min);
        //validité : reel > min
        return reel;
    }
}
