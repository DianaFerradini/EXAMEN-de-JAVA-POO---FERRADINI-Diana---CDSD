package service;

import java.util.ArrayList;

import entity.Vehicule;

public final class VehiculeService {
    private static ArrayList<Vehicule> flotte = new ArrayList<Vehicule>();
    private static int compteur = 0;

    private VehiculeService() {}

    public static boolean add(Vehicule vehicule) {
        if (vehicule.getKilometrage() < 0) {
            return false;
        } else {
            if (vehicule.getTarifJournalier() <= 0) {
                return false;
            } else {
                compteur++;
                vehicule.setId(compteur);
                flotte.add(vehicule);
                return true;
            }
        }
    }

    public static ArrayList<Vehicule> getAll() {
        return flotte;
    }

    public static ArrayList<Vehicule> vehiculesAvecMoinsDeKm() {
        int min;
        if (flotte.isEmpty()) {
            return new ArrayList<>();
        } else {
            min = flotte.get(0).getKilometrage();
            for (int i = 1; i < flotte.size(); i++) {
                int kmCourant = flotte.get(i).getKilometrage();
                if (kmCourant < min) {
                    min = kmCourant;
                }
            }
            ArrayList<Vehicule> moinsDeKm = new ArrayList<Vehicule>();
            for (Vehicule vehicule : flotte) {
                if (vehicule.getKilometrage() == min) {
                    moinsDeKm.add(vehicule);
                }
            }
            return moinsDeKm;
        }
    }

    public static double tarifMoyenLocation() {
        if (flotte.isEmpty()) {
            return 0;
        } else {
            double total = 0;
            for (Vehicule vehicule : flotte) {
                total += vehicule.getTarifJournalier();
            }
            return total / flotte.size();    
        }
    }
}
