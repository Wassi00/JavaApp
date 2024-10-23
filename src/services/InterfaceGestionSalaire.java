package services;

public interface InterfaceGestionSalaire {
    public Boolean calculerSalaireNet(int matricule, int nbHeures, double tauxHeure);
    public double calculerSalaireBrut(int matricule, int nbHeures, double tauxHeure);
    public double calculerBonus(int matricule);
    public double calculerSalaireBonus(int matricule);

}
