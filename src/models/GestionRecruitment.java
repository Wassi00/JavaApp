package models;

import services.InterfaceGestionRecruitment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static services.DbConnection.connection;

public class GestionRecruitment implements InterfaceGestionRecruitment {

    @Override
    public Boolean ajouterEmploye(Employe employee) {
        String query = "INSERT INTO Employe (matricule, nom, prenom, adresse, email, telephone, grade) VALUES (?, ?, ?, ?, ?, ?, ?)";
        if(connection != null) {
            try (
                    PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, employee.getMatricule());
                pstmt.setString(2, employee.getNom());
                pstmt.setString(3, employee.getPrenom());
                pstmt.setString(4, employee.getAdresse());
                pstmt.setString(5, employee.getEmail());
                pstmt.setString(6, employee.getTelephone());
                pstmt.setString(7, employee.getGrade());
                pstmt.executeUpdate();
                System.out.println("employe ajouter avec succes");
                return true;


            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Boolean supprimerEmploye(int matricule) {
        String query = "DELETE FROM Employe WHERE matricule = ?";
        if(connection != null) {
            try (
                    PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, matricule);
                pstmt.executeUpdate();
                System.out.println("employe supprime avec succes");
                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Employe chercherEmploye(int matricule) {
        String query = "SELECT * FROM Employe WHERE matricule = ?";
        if (connection != null) {
            try (
                    PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, matricule);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String adresse = rs.getString("adresse");
                    String email = rs.getString("email");
                    String telephone = rs.getString("telephone");
                    String grade = rs.getString("grade");
                    System.out.println("employe trouve avec succes");
                    return new Employe(matricule, nom, prenom, adresse, email, telephone, grade);
                } else {
                    System.out.println("employe non trouve");
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



    @Override
    public Boolean updateEmploye(int matricule, Employe employee) {
    String query = "UPDATE Employe SET nom = ?, prenom = ?, adresse = ?, email = ?, telephone = ?, grade = ? WHERE matricule = ?";
    if (connection != null) {
        try (
                PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, employee.getNom());
            pstmt.setString(2, employee.getPrenom());
            pstmt.setString(3, employee.getAdresse());
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(5, employee.getTelephone());
            pstmt.setString(6, employee.getGrade());
            pstmt.setInt(7, matricule);
            pstmt.executeUpdate();
            System.out.println("employe mis a jour avec succes");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } else {
        return false;
    }
}
}
