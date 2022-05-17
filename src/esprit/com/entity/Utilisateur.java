/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yosr
 */
public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String motpass;
    private String role;

    public Utilisateur(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Utilisateur(String nom, String prenom, String adresse, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
    }

    public Utilisateur(int id, String nom, String prenom, String adresse, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
    }
    

    public Utilisateur(String nom, String prenom, String adresse, String email, String motpass) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motpass = motpass;
    }
    
    // Affichage ( affichage par id ), modifier  , Id AutoIncrement

    public Utilisateur(int id, String nom, String prenom, String adresse, String email, String motpass, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motpass = motpass;
        this.role = role;
    }
// Recherche par id , supprission
    public Utilisateur(int id) {
        this.id = id;
    }
// isertion sans id
    public Utilisateur(String nom, String prenom, String adresse, String email, String motpass, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motpass = motpass;
        this.role = role;
    }

    public Utilisateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMotpass() {
        return motpass;
    }

    public void setMotpass(String motpass) {
        this.motpass = motpass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "\n Utilisateur"+ id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", motpass=" + motpass + ", role=" + role + '}';
    }
    
    public boolean verifyEmail(String email) throws SQLException {
        ArrayList<Utilisateur> usersList = new ArrayList();
        Statement st = cnx2.createStatement();
        String requete = "SELECT * FROM fos_user where fos_user.email = '" + email + "'";
        ResultSet rs = st.executeQuery(requete);
        while (rs.next()) {
            Utilisateur u = new Utilisateur();
            u.setId(rs.getInt("id"));
            u.setNom(rs.getString(30));
            u.setPrenom(rs.getString(30));
            u.setAdresse(rs.getString(30));
            u.setEmail(rs.getString(30));
            u.setMotpass(rs.getString(30));
            u.setRole(rs.getString(30));
            
            usersList.add(u);
        }
        if (usersList.size() > 0) {
            return true;
        }
        return false;
    }

    private static class Statement {

        public Statement() {
        }

        private ResultSet executeQuery(String requete) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class cnx2 {

        private static Statement createStatement() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public cnx2() {
        }
    }
  
    
}
