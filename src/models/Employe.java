package models;

import java.util.ArrayList;

public class Employe {
    private int matricule;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    private String grade;

    public Employe(int matricule, String nom, String prenom, String adresse, String email, String telephone, String grade) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.grade = grade;
    };

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "matricule=" + matricule +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
