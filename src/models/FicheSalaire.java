package models;

public class FicheSalaire {
    private int id;
    private String dateF;
    private int nbHeures;
    private double tauxHeures;
    private double montantBrut;
    public static double taxe = 0.4;
    private double montantNet;
    private Employe employe;

    public FicheSalaire(int id, String dateF, int nbHeures, double tauxHeures, double montantBrut, double montantNet) {
        this.id = id;
        this.dateF = dateF;
        this.nbHeures = nbHeures;
        this.tauxHeures = tauxHeures;
        this.montantBrut = montantBrut;
        this.montantNet = montantNet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateF() {
        return dateF;
    }

    public void setDateF(String dateF) {
        this.dateF = dateF;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    public double getTauxHeures() {
        return tauxHeures;
    }

    public void setTauxHeures(double tauxHeures) {
        this.tauxHeures = tauxHeures;
    }

    public double getMontantBrut() {
        return montantBrut;
    }

    public void setMontantBrut(double montantBrut) {
        this.montantBrut = montantBrut;
    }

    public double getTaxe() {
        return taxe;
    }

    public void setTaxe(double taxe) {
        this.taxe = taxe;
    }

    public double getMontantNet() {
        return montantNet;
    }

    public void setMontantNet(double montantNet) {
        this.montantNet = montantNet;
    }


}
