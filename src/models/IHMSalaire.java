package models;

import java.util.Scanner;

public class IHMSalaire {
    static Scanner sc = new Scanner(System.in);

    static GestionSalaire gestionSalaire = new GestionSalaire();

    int choice = 0;

    public void showMenu() {
        do{
            System.out.println("choisissez une des options suivantes: ");
            System.out.println("1. Ajouter une fiche de salaire");
            System.out.println("2. supprimer une fiche de salaire");
            System.out.println("3. chercher une fiche de salaire");
            System.out.println("4. quitter");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 : this.entrerFicheSalaire(); break;
                case 2 : this.supprimerFicheSalaire(); break;
                case 3 : this.chercherFicheSalaire(); break;
                default: break;
            }
        }while(choice != 4);
    }

    public void entrerFicheSalaire() {
        System.out.println("Entrer le matricule de l'employe");
        int matricule = sc.nextInt();
        System.out.println("Entrer le nombre d'heures");
        int nbHeures = sc.nextInt();
        System.out.println("Entrer le taux horaire");
        double tauxHeure = sc.nextDouble();
        gestionSalaire.calculerSalaireNet(matricule, nbHeures, tauxHeure);
    }

    public void supprimerFicheSalaire() {
        System.out.println("saisir l'id de la fiche de salaire a supprimer: ");
        int id = sc.nextInt();
        gestionSalaire.supprimerFicheSalaire(id);
    }

    public void chercherFicheSalaire() {
        System.out.println("saisir l'id de la fiche de salaire: ");
        int id = sc.nextInt();
        FicheSalaire ficheSalaire = gestionSalaire.chercherFicheSalaire(id);
        System.out.println(ficheSalaire.toString());
    }
}
