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
            return Data.storeSalary(ficheSalaire);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public double calculerSalaireBrut(int matricule, int nbHeures, double tauxHeure) {
        double salaireBrut = (double)nbHeures*tauxHeure;
        return salaireBrut;
    }


    public Boolean supprimerFicheSalaire(int id) {
        return Data.deleteSalary(id);
    }

    public FicheSalaire chercherFicheSalaire(int id) {
        return Data.getSalary(id);
    }
}
