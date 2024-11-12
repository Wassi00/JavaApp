package models;

import java.sql.*;
import java.util.ArrayList;

public class Data {
    public static ArrayList<Employe> employees = new ArrayList<Employe>();
    public static ArrayList<FicheSalaire> salaires = new ArrayList<FicheSalaire>();
    public static Connection connection = null;

    public Data() {
        connectToDatabase();
    }
    public void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "root2024";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
            // Perform database operations here

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Boolean storeEmployee(Employe employee) {
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

    //function to delete employee from database
    public static Boolean deleteEmployee(int matricule) {
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

    //function that retrieves an employee from database and returns it
    public static Employe getEmployee(int matricule) {
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

    //function to store salary in database
    public static Boolean storeSalary(FicheSalaire ficheSalaire) {
        String query = "INSERT INTO FicheSalaire (id, dateF, nbHeures, tauxHeures, montantBrut, montantNet) VALUES (?, ?, ?, ?, ?, ?)";
        if(connection != null) {
            try (
                    PreparedStatement pstmt = connection.prepareStatement(query)) {
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
    }

    //function to delete salary from database
    public static Boolean deleteSalary(int id) {
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

    //function that retrieves a salary from database and returns it
    public static FicheSalaire getSalary(int id) {
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
