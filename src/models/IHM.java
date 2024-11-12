package models;

import java.util.Scanner;

public class IHM {

    public IHM() {
    }

    public void showMainMenu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("choisissez une des options suivantes: ");
            System.out.println("1. Gérer les employés");
            System.out.println("2. Gérer les fiches de salaire");
            System.out.println("3. Quitter");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    IHMEmploye ihmEmploye = new IHMEmploye();
                    ihmEmploye.showMenu();
                    break;
                case 2:
                    IHMSalaire ihmSalaire = new IHMSalaire();
                    ihmSalaire.showMenu();
                    break;
                case 3:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        } while (choice != 3);
    }


}
