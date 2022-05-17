/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.entity.Ticket;
import esprit.com.entity.Evenement;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ImEvenement {

    Connection cnx = ConnectionBd.getInstance().getCnx();


    public void ajouter(Evenement t) {
        try {
            String req = "INSERT INTO evenement ( date_Evenement,nom_Evenement,type_Evenement) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getDate_Evenement());
            pst.setString(2, t.getNom_Evenement());
            pst.setString(3, t.getType_Evenement());
//            pst.setInt(4, t.getId_Offre());
            pst.executeUpdate();
            System.out.println("evenement  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void supprimer(Evenement t) {
        try {
//            String req = "DELETE FROM evenement WHERE id_E=?";
            String req = "DELETE FROM evenement WHERE id_E=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,t.getId_E());
            pst.executeUpdate();
            System.out.println("evenement suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifier(Evenement t) {
        try {
            String req = "UPDATE evenement SET date_Evenement=?,nom_Evenement=?,type_Evenement=? WHERE id_E=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, t.getId_E());
            pst.setString(2, t.getNom_Evenement());
            pst.setString(3, t.getType_Evenement());
     pst.setString(1, t.getDate());

            pst.executeUpdate();
            System.out.println("evenement modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public List<Evenement> afficher() {

        List<Evenement> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM evenement";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Evenement(rs.getInt(1), rs.getString("date_Evenement"), rs.getString("nom_Evenement"), rs.getString("type_Evenement")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public List<Evenement> recherche(Evenement t) {
        List<Evenement> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `evenement` WHERE id_E=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_E());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Evenement(rs.getInt(1), rs.getString("date_Evenement"), rs.getString("nom_Evenement"), rs.getString("type_Evenement")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Evenement> Tri() {
        List<Evenement> evenement = new ArrayList<>();

        String req = "SELECT * from evenementORDER BY nbre_etoiles";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Evenement p = new Evenement();
                p.setId_E(rs.getInt("id"));
                p.setdate_Evenement(rs.getString(2));
                p.setnom_Evenement(rs.getString(3));
                p.settype_Evenement(rs.getString(4));
                evenement.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return evenement;
    }
     public int deleteE(int id_E) throws SQLException {
        int i = 0;
        try {
            Statement ste = cnx.createStatement();
            String sql = "delete from evenement where id_E=" + id_E;
            i = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            
        }
        return i;
    }

}
