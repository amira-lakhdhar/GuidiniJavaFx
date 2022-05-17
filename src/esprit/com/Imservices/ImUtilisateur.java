/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.entity.BCrypt;
import esprit.com.entity.Utilisateur;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yosr
 */
// sna3et class bech n'impplimenti les methdes eli san2tho mn interface ISERVICE w 3adina Utilisateur par parametre
public class ImUtilisateur {
    Connection cnx = ConnectionBd.getInstance().getCnx();


//    public void ajouter(Utilisateur t) {
//        try {
//            String encryptedPW = "AZESDZRSSFFE/6465484321AZEqsd1564za65qsazeqsd54zSAZETFGVV"+t.getMotpass();
//            String req = "INSERT INTO utilisateur (nom, prenom,adresse,email,motpass,role) VALUES (?,?,?,?,?,'user')";
//            PreparedStatement pst = cnx.prepareStatement(req);
//            pst.setString(1, t.getNom());
//            pst.setString(2, t.getPrenom());
//            pst.setString(3, t.getAdresse());
//            pst.setString(4, t.getEmail());
//            pst.setString(5, encryptedPW);
//           pst.executeUpdate();
//            System.out.println("utilisateur  ajoutée !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    public void supprimer(Utilisateur t) {
//          try {
//            String req = "DELETE FROM utilisateur WHERE id=?";
//            PreparedStatement pst = cnx.prepareStatement(req);
//            pst.setInt(1, t.getId());
//            pst.executeUpdate();
//            System.out.println("utilisatuer suprimée !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//
//    public void modifier(Utilisateur t) {
//         try {
//            String req = "UPDATE utilisateur SET nom=?,prenom=?,adresse=?, email=? WHERE id=?";
//            PreparedStatement pst = cnx.prepareStatement(req);
//            pst.setInt(5, t.getId());
//            pst.setString(1, t.getNom());
//            pst.setString(2, t.getPrenom());
//            pst.setString(3, t.getAdresse());
//            pst.setString(4, t.getEmail());
//            pst.executeUpdate();
//            System.out.println("utilisateur modifiée !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    
//    public void modifierpass(Utilisateur t) {
//         try {
//            String req = "UPDATE utilisateur SET motpass=?WHERE id=?";
//            PreparedStatement pst = cnx.prepareStatement(req);
//            pst.setInt(2, t.getId());
//            String Cryptedpass="AZESDZRSSFFE/6465484321AZEqsd1564za65qsazeqsd54zSAZETFGVV"+t.getMotpass();
//
//            pst.setString(1, Cryptedpass);
//
//            pst.executeUpdate();
//            System.out.println("utilisateur modifiée !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//
//
//    public List<Utilisateur> afficher() {
//        
//                List<Utilisateur> list = new ArrayList<>();
//        
//        try {
//            String req = "SELECT * FROM utilisateur";
//            PreparedStatement pst = cnx.prepareStatement(req);
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()) {
//                list.add(new Utilisateur(rs.getInt(1), rs.getString("nom"), rs.getString("prenom"),rs.getString("adresse"),rs.getString("email"),rs.getString("motpass"),rs.getString("role")));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//        return list;
//    }
//
//    
//
//
//    public List<Utilisateur> recherche(Utilisateur t) {
//        List<Utilisateur> list = new ArrayList<>();
//        try {
//            String req = "SELECT * FROM `utilisateur` WHERE id=? ";
//            PreparedStatement pst = cnx.prepareStatement(req);
//            pst.setInt(1, t.getId());
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()) {
//                   list.add(new Utilisateur(rs.getInt(1), rs.getString("nom"), rs.getString("prenom"),rs.getString("adresse"),rs.getString("email"),rs.getString("motpass"),rs.getString("role")));
//
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return list;
//    }
//    
//      public Utilisateur recherche_user(int t) {
//          Utilisateur user = new Utilisateur(t);
//        try {
//            String req = "SELECT * FROM `utilisateur` WHERE id=? ";
//            PreparedStatement pst = cnx.prepareStatement(req);
//            pst.setInt(1, t);
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()) {
//                 user.setNom(rs.getString("nom"));
//                 user.setPrenom(rs.getString("prenom"));
//                 user.setAdresse(rs.getString("adresse"));
//                 user.setEmail(rs.getString("email"));
//                 user.setMotpass(rs.getString("motpass"));
//                 user.setRole(rs.getString("motpass"));
//                 
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return user;
//    }
//      
//      public Utilisateur selectUserByEmail(String email) {
//         Utilisateur u = new Utilisateur();
//        try {
//            Statement st = cnx.createStatement();
//            String requete = "SELECT * FROM utilisateur where email='"+email+"'";
//            ResultSet rs = st.executeQuery(requete);
//            while (rs.next()) {
//                u.setId(rs.getInt("id"));
//                u.setNom(rs.getString(2));
//                u.setPrenom(rs.getString(3));
//                u.setAdresse(rs.getString(4));
//                u.setEmail(rs.getString(5));
//                u.setMotpass(rs.getString(6));
//                u.setRole(rs.getString(7));
//              
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return u;
//        
//    }
//     
    
    
        public void ajouter(Utilisateur t) {
        try {
            String encryptedPW = "AZESDZRSSFFE/6465484321AZEqsd1564za65qsazeqsd54zSAZETFGVV"+t.getMotpass();
            String req = "INSERT INTO user (nom, prenom,adresse,email,motpass,role) VALUES (?,?,?,?,?,'user')";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getEmail());
            pst.setString(5, encryptedPW);
           pst.executeUpdate();
            System.out.println("utilisateur  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(Utilisateur t) {
          try {
            String req = "DELETE FROM user WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("utilisatuer suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifier(Utilisateur t) {
         try {
            String req = "UPDATE user SET nom=?,prenom=?,adresse=?, email=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(5, t.getId());
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getEmail());
            pst.executeUpdate();
            System.out.println("utilisateur modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifierpass(Utilisateur t) {
         try {
            String req = "UPDATE user SET motpass=?WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(2, t.getId());
            String Cryptedpass="AZESDZRSSFFE/6465484321AZEqsd1564za65qsazeqsd54zSAZETFGVV"+t.getMotpass();

            pst.setString(1, Cryptedpass);

            pst.executeUpdate();
            System.out.println("utilisateur modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }



    public List<Utilisateur> afficher() {
        
                List<Utilisateur> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM user";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Utilisateur(rs.getInt(1), rs.getString("nom"), rs.getString("prenom"),rs.getString("adresse"),rs.getString("email"),rs.getString("motpass"),rs.getString("role")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

    


    public List<Utilisateur> recherche(Utilisateur t) {
        List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `user` WHERE id=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                   list.add(new Utilisateur(rs.getInt(1), rs.getString("nom"), rs.getString("prenom"),rs.getString("adresse"),rs.getString("email"),rs.getString("motpass"),rs.getString("role")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
      public Utilisateur recherche_user(int t) {
          Utilisateur user = new Utilisateur(t);
        try {
            String req = "SELECT * FROM `user` WHERE id=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                 user.setNom(rs.getString("nom"));
                 user.setPrenom(rs.getString("prenom"));
                 user.setAdresse(rs.getString("adresse"));
                 user.setEmail(rs.getString("email"));
                 user.setMotpass(rs.getString("motpass"));
                 user.setRole(rs.getString("motpass"));
                 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
      
      public Utilisateur selectUserByEmail(String email) {
         Utilisateur u = new Utilisateur();
        try {
            Statement st = cnx.createStatement();
            String requete = "SELECT * FROM user where email='"+email+"'";
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setAdresse(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setMotpass(rs.getString(6));
                u.setRole(rs.getString(7));
              
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u;
        
    }
     
    
}
