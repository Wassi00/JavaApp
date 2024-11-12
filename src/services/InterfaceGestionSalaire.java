package services;

import models.FicheSalaire;

public interface InterfaceGestionSalaire {
    public Boolean calculerSalaireNet(int matricule, int nbHeures, double tauxHeure);
    public double calculerSalaireBrut(int matricule, int nbHeures, double tauxHeure);
    public Boolean supprimerFicheSalaire(int id);
    public FicheSalaire chercherFicheSalaire(int id);

}
