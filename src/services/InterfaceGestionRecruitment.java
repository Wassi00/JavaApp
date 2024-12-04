package services;

import models.Employe;

public interface InterfaceGestionRecruitment {
    public Boolean ajouterEmploye(Employe employee);
    public Boolean supprimerEmploye(int matricule);
    public Employe chercherEmploye(int matricule);
    public Boolean updateEmploye(int matricule, Employe employee);
}
