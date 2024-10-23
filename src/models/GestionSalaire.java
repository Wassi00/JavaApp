package models;

import services.InterfaceGestionSalaire;

import java.time.LocalDate;

import static models.Data.employees;
import static models.Data.salaires;
import static models.FicheSalaire.taxe;

public class GestionSalaire implements InterfaceGestionSalaire {

    @Override
    public Boolean calculerSalaireNet(int matricule, int nbHeures, double tauxHeure) {
        try {
            int id = matricule + LocalDate.now().getMonthValue();
            double salaireBrut = calculerSalaireBrut(matricule, nbHeures, tauxHeure);
            double salaireNet = salaireBrut*(1-taxe);
            String dateF = LocalDate.now().toString();
            Employe employee = employees.stream()
                    .filter(emp -> emp.getMatricule() == matricule)
                    .findFirst()  // Get the first match
                    .orElse(null);
            FicheSalaire ficheSalaire = new FicheSalaire(id, dateF, nbHeures, tauxHeure, salaireBrut, salaireNet);
            salaires.add(ficheSalaire);
            System.out.println("Salaire de l'employé "+employee.getNom()+" "+employee.getPrenom()+ " " + salaireNet);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public double calculerSalaireBrut(int matricule, int nbHeures, double tauxHeure) {
        double salaireBrut = (double)nbHeures*tauxHeure;
        return salaireBrut;
    }

    @Override
    public double calculerBonus(int matricule) {
        return 0;
    }

    @Override
    public double calculerSalaireBonus(int matricule) {
        return 0;
    }

    public void supprimerFicheSalaire(int id) {
        FicheSalaire ficheSalaire = salaires.stream()
                .filter(fiche -> fiche.getId() == id)
                .findFirst()  // Get the first match
                .orElse(null);
        salaires.remove(ficheSalaire);
        System.out.println("fiche supprimée");
    }

    public FicheSalaire chercherFicheSalaire(int id) {
        FicheSalaire ficheSalaire = salaires.stream()
                .filter(fiche -> fiche.getId() == id)
                .findFirst()  // Get the first match
                .orElse(null);
        return ficheSalaire;
    }
}
