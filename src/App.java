import java.util.ArrayList;

import entity.Vehicule;
import service.VehiculeService;
import view.MainView;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        do {
            choix = MainView.menu();
            switch (choix) {
                case 1: //Ajouter un véhicule
                    boolean success;
                    do {
                        Vehicule vehicule = MainView.saisieVehicule();
                        success = VehiculeService.add(vehicule);
                        if (success) {
                            System.out.println("Succès !");
                        } else {
                            System.out.println("Veuillez saisir des valeurs positives");
                        }
                    } while (!success);
                    break;

                case 2: //Afficher tous les véhicules de la flotte
                    ArrayList<Vehicule> vehicules = VehiculeService.getAll();
                    MainView.afficherVehicules(vehicules);
                    break;

                case 3: //Afficher le(s) véhicule(s) avec le moins de kilomètres
                    vehicules = VehiculeService.vehiculesAvecMoinsDeKm();
                    MainView.afficherVehicules(vehicules);
                    break;

                case 4: //Afficher le tarif moyen de location
                    double tarifMoyenLocation = VehiculeService.tarifMoyenLocation();
                    MainView.afficherTarifMoyenLocation(tarifMoyenLocation);
                    break;

                case 5:
                    System.out.println("Au revoir");
                    break;
            
                default:
                    System.out.println("Veuillez faire un choix compris entre 1 et 5");
                    break;
                }
        } while (choix != 5);
    }
}
