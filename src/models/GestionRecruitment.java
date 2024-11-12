package models;

import services.InterfaceGestionRecruitment;

import static models.Data.employees;

public class GestionRecruitment implements InterfaceGestionRecruitment {

    @Override
    public Boolean ajouterEmploye(Employe employee) {
        employees.add(employee);
        return Data.storeEmployee(employee);
    }

    @Override
    public Boolean supprimerEmploye(int matricule) {
            employees.removeIf(employee -> employee.getMatricule() == matricule);
            return Data.deleteEmployee(matricule);
    }

    @Override
    public Employe chercherEmploye(int matricule) {
        return Data.getEmployee(matricule);
    }

    @Override
    public Boolean isExistant(int matricule) {
        try{
            return employees.stream().anyMatch(employee -> employee.getMatricule() == matricule);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateEmploye(int matricule, Employe employee) {
       try {
           for (Employe emp : employees) {
               if (emp.getMatricule() == matricule) {
                   emp.setNom(employee.getNom());
                   emp.setPrenom(employee.getPrenom());
                   emp.setEmail(employee.getEmail());
                   break;
               }
           }
                   return true;
       } catch (Exception e) {
           return false;
       }
    }
}
