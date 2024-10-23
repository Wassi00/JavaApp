package models;

import services.InterfaceGestionRecruitment;

import static models.Data.employees;

public class GestionRecruitment implements InterfaceGestionRecruitment {

    @Override
    public Boolean ajouterEmploye(Employe employee) {
        try{
            employees.add(employee);
            System.out.print("employe ajouter avec succes");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean supprimerEmploye(int matricule) {
        try{
            employees.removeIf(employee -> employee.getMatricule() == matricule);
            System.out.println("employe supprime avec succes");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Employe chercherEmploye(int matricule) {
        try{
                for (Employe employee : employees) {
                    if (employee.getMatricule() == matricule) {
                        return employee;
                    }
                }
                return null;
        } catch (Exception e) {
            return null;
        }
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
