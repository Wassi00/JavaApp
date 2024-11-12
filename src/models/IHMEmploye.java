package models;

import services.InterfaceGestionRecruitment;

import java.util.Scanner;

public class IHMEmploye {
    static Scanner sc = new Scanner(System.in);

    static InterfaceGestionRecruitment gestionEmploye = new GestionRecruitment();

    int choice = 0;

    public void showMenu(){
        do{
            System.out.println("choisissez une des options suivantes: ");
            System.out.println("1. Ajouter un employe");
            System.out.println("2. supprimer un employe");
            System.out.println("3. chercher un employe");
            System.out.println("4. quitter");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 : this.entrerEmploye(); break;
                case 2 : this.supprimerEmploye(); break;
                case 3 : this.chercherEmploye(); break;
                default: break;
            }
        }while(choice != 4);
    }


    public void entrerEmploye(){
        System.out.println("Entrer le nom de l'employe");
        String nom = sc.nextLine();
        System.out.println("Entrer le prenom de l'employe");
        String prenom = sc.nextLine();
        System.out.println("saisir le matricule: ");
        int matricule = sc.nextInt();
        sc.nextLine();
        Employe employe = new Employe(matricule, nom, prenom, "fes", "hihf@efef.djjf", "066666666", "superviseur");
        gestionEmploye.ajouterEmploye(employe);
    }

    public void supprimerEmploye(){
        System.out.println("saisir le matricule de l'employe a supprimer: ");
        int matricule = sc.nextInt();
        gestionEmploye.supprimerEmploye(matricule);
    }

    public void chercherEmploye(){
        System.out.println("saisir le matricule de l'employe: ");
        int matricule = sc.nextInt();
        Employe employe = gestionEmploye.chercherEmploye(matricule);
        System.out.println(employe.toString());
    }
}
