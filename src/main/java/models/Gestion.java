package models;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Gestion {
	// création de la table users
    public void creerTableUsers() {
        String sql = "CREATE TABLE IF NOT EXISTS USERS (" +
                "LOGIN VARCHAR(32) PRIMARY KEY, " +
                "MDP VARCHAR(32))";

        try (Connection connection = ConnectionDatabase.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Table users créée avec succès !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //verifier si le user connecté est valide
    public boolean validateUser(String login, String mdp) {
        String sql = "SELECT * FROM USERS WHERE LOGIN = ? AND MDP = ?";

        try (Connection connection = ConnectionDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, login);
            statement.setString(2, mdp);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // création de la table cafes
    public void creerTableCafes() {
        String sql = "CREATE TABLE IF NOT EXISTS CAFES (" +
                "NOM_CAFE VARCHAR(32) PRIMARY KEY, " +
                "FO_ID INT, " +
                "PRIX FLOAT, " +
                "VENTES INT)";

        try (Connection connection = ConnectionDatabase.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Table cafes créée avec succès !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //ajout cafe
    public void ajouterCafe(String nomCafe, int foId, float prix, int ventes) {
        String sql = "INSERT INTO CAFES (NOM_CAFE, FO_ID, PRIX, VENTES) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nomCafe);
            statement.setInt(2, foId);
            statement.setFloat(3, prix);
            statement.setInt(4, ventes);

            statement.executeUpdate();
            System.out.println("Café ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
  //afficher la liste des cafes 
    public List afficherCafeList(){
        String sql = "SELECT * FROM CAFES";
        List<Cafe> listeCafes = new ArrayList<>();
        try (Connection connection = ConnectionDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Cafe cafe= new Cafe();
            	cafe.setNom(rs.getString("NOM_CAFE"));
                cafe.setFournisseur(rs.getInt("FO_ID"));
                cafe.setPrix(rs.getFloat("PRIX"));
                cafe.setVentes(rs.getInt("VENTES"));
                listeCafes.add(cafe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeCafes;
    }

    //afficher les details dune cafe donné par son nom
    public void afficherCafe(String nomCafe) {
        String sql = "SELECT * FROM CAFES WHERE NOM_CAFE = ?";

        try (Connection connection = ConnectionDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nomCafe);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                System.out.println("Nom: " + rs.getString("NOM_CAFE"));
                System.out.println("FO_ID: " + rs.getInt("FO_ID"));
                System.out.println("Prix: " + rs.getFloat("PRIX"));
                System.out.println("Ventes: " + rs.getInt("VENTES"));
            } else {
                System.out.println("Café non trouvé.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //modifer nbr de ventes de cafe fournis par x:
    public void modifierVentes(int foId, int nouvellesVentes) {
        String sql = "UPDATE CAFES SET VENTES = ? WHERE FO_ID = ?";

        try (Connection connection = ConnectionDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, nouvellesVentes);
            statement.setInt(2, foId);

            int a = statement.executeUpdate();
            if (a > 0) {
                System.out.println("Ventes modifiées avec succès !");
            } else {
                System.out.println("Aucun café trouvé pour le fournisseur donné.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //supprimer un cafe de la liste
    public void supprimerCafe(String nomCafe) {
    	if (nomCafe != null && !nomCafe.trim().isEmpty()) {
            try (Connection connection = ConnectionDatabase.getConnection()) {
                String sql = "DELETE FROM CAFES WHERE NOM_CAFE = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nomCafe);
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Café supprimé avec succès : " + nomCafe);
                } else {
                    System.out.println("Aucun café trouvé avec le nom : " + nomCafe);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nom de café invalide pour la suppression.");
        }
    }
    
    
    
    
    
    
    
    
    //gestion viennoiserie
 // création de la table cafes
    public void creerTableViennoiseries() {
        String sql = "CREATE TABLE IF NOT EXISTS VIENNOISERIES (" +
                "NOM_VIENNOISERIES VARCHAR(32) PRIMARY KEY, " +
                "FO_ID INT, " +
                "PRIX FLOAT, " +
                "VENTES INT)";

        try (Connection connection = ConnectionDatabase.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Table cafes créée avec succès !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    //ajoiter viennoiserie
    public void ajouterViennoiserie(String nomViennoiserie, int foId, float prix, int ventes) {
        String sql = "INSERT INTO VIENNOISERIES (NOM_VIENNOISERIES, FO_ID, PRIX, VENTES) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nomViennoiserie);
            statement.setInt(2, foId);
            statement.setFloat(3, prix);
            statement.setInt(4, ventes);

            statement.executeUpdate();
            System.out.println("Viennoiserie ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
  //afficher la liste des viennoiserie 
    public List afficherViennoiseriesList(){
        String sql = "SELECT * FROM VIENNOISERIES";
        List<Viennoiserie> listeViennoiseries = new ArrayList<>();
        try (Connection connection = ConnectionDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Viennoiserie viennoiserie= new Viennoiserie();
            	viennoiserie.setNom(rs.getString("NOM_VIENNOISERIES"));
            	viennoiserie.setFournisseur(rs.getInt("FO_ID"));
            	viennoiserie.setPrix(rs.getFloat("PRIX"));
            	viennoiserie.setVentes(rs.getInt("VENTES"));
            	listeViennoiseries.add(viennoiserie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeViennoiseries;
    }
    
    
    
    //supprimer viennoiserie
  //supprimer un viennoiserie de la liste
    public void supprimerViennoiserie(String nomViennoiserie) {
    	if (nomViennoiserie != null && !nomViennoiserie.trim().isEmpty()) {
            try (Connection connection = ConnectionDatabase.getConnection()) {
                String sql = "DELETE FROM VIENNOISERIES WHERE NOM_VIENNOISERIES = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nomViennoiserie);
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Viennoiserie supprimé avec succès : " + nomViennoiserie);
                } else {
                    System.out.println("Viennoiserie café trouvé avec le nom : " + nomViennoiserie);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nom de café invalide pour la suppression.");
        }
    }
}
