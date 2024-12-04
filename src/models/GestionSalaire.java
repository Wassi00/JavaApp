package models;

import services.InterfaceGestionSalaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static services.DbConnection.*;
import static models.FicheSalaire.taxe;

public class GestionSalaire implements InterfaceGestionSalaire {

    @Override
    public Boolean calculerSalaireNet(int matricule, int nbHeures, double tauxHeure) {
        try {
            int id = matricule + LocalDate.now().getMonthValue();
            double salaireBrut = calculerSalaireBrut(matricule, nbHeures, tauxHeure);
            double salaireNet = salaireBrut*(1-taxe);
            String dateF = LocalDate.now().toString();
            Employe employee;
            String query = "SELECT * FROM Employe WHERE matricule = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, matricule);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    employee = new Employe(
                        rs.getInt("matricule"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("adresse"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("grade")
                    );
                } else {
                    employee = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                employee = null;
            }
            FicheSalaire ficheSalaire = new FicheSalaire(id, dateF, nbHeures, tauxHeure, salaireBrut, salaireNet);
            String query2 = "INSERT INTO FicheSalaire (id, dateF, nbHeures, tauxHeures, montantBrut, montantNet) VALUES (?, ?, ?, ?, ?, ?)";
            if(connection != null) {
                try (
                        PreparedStatement pstmt = connection.prepareStatement(query2)) {
                    pstmt.setInt(1, ficheSalaire.getId());
                    pstmt.setString(2, ficheSalaire.getDateF());
                    pstmt.setInt(3, ficheSalaire.getNbHeures());
                    pstmt.setDouble(4, ficheSalaire.getTauxHeures());
                    pstmt.setDouble(5, ficheSalaire.getMontantBrut());
                    pstmt.setDouble(6, ficheSalaire.getMontantNet());
                    pstmt.executeUpdate();
                    System.out.println("fiche de salaire ajouter avec succes");
                    return true;

                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            } else {
                return false;
            }
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
        String query = "DELETE FROM FicheSalaire WHERE id = ?";
        if(connection != null) {
            try (
                    PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                System.out.println("fiche de salaire supprime avec succes");
                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public FicheSalaire chercherFicheSalaire(int id) {
        String query = "SELECT * FROM FicheSalaire WHERE id = ?";
        if(connection != null) {
            try (
                    PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("fiche de salaire trouve avec succes");
                    return new FicheSalaire(id, rs.getString("dateF"), rs.getInt("nbHeures"), rs.getDouble("tauxHeures"), rs.getDouble("montantBrut"), rs.getDouble("montantNet"));
                } else {
                    System.out.println("fiche de salaire non trouve");
                    return null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}
