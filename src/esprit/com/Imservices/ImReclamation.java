/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.entity.Reclamation;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author yosr
 */
// sna3et class bech n'impplimenti les methdes eli san2tho mn interface ISERVICE w 3adina Utilisateur par parametre
public class ImReclamation  {
    Connection cnx = ConnectionBd.getInstance().getCnx();
 
    public void ajouter(Reclamation t) {
        try {
            String req = "INSERT INTO reclamation (message,ID_USER,Titre,type_r) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getMessage());
            pst.setInt(2, t.getId_user());
            pst.setString(3, t.getTitre());
           // pst.setString(4, t.getType_r());
            pst.setString(4,"reclam");
           pst.executeUpdate();
            System.out.println("Reclamation  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void supprimer(Reclamation t) {
          try {
            String req = "DELETE FROM reclamation WHERE id_r=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_r());
            pst.executeUpdate();
            System.out.println("Reclamation suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifier(Reclamation t) {
         try {
            String req = "UPDATE reclamation SET message=?,Titre=?,type_r=? WHERE id_r=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, t.getId_r());
            pst.setString(1, t.getMessage());
            pst.setString(2, t.getTitre());
            pst.setString(3, t.getType_r());
           
            pst.executeUpdate();
            System.out.println("reclamation modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public ObservableList<Reclamation> afficher() {
        
                ObservableList<Reclamation> list = FXCollections.observableArrayList();
        
        try {
            String req = "SELECT * FROM reclamation";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Reclamation(rs.getInt(1), rs.getString("message"), rs.getInt("ID_USER "),rs.getString("type_r")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

    


    public ObservableList<Reclamation> recherche(Reclamation t) {
       ObservableList<Reclamation> list = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM `reclamation` WHERE ID_USER=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_user());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                   list.add(new Reclamation(rs.getInt(1), rs.getString("message"), rs.getString("type_r"),rs.getString("Titre")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    
}
