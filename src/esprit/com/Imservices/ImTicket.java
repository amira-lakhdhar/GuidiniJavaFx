/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.entity.Ticket;
import esprit.com.entity.Offre;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ImTicket {
    Connection cnx = ConnectionBd.getInstance().getCnx();

    public ImTicket() {
    }

   
    public void ajouter(Ticket t) {
try {
            String req = "INSERT INTO Ticket ( prix,date,reference) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setFloat(1, t.getPrix());
            pst.setDate(2,  t.getDate());
            pst.setString(3, t.getReference());
            pst.executeUpdate();
            System.out.println("Ticket  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void supprimer(Ticket t) {
        try {
    String req = "DELETE FROM Ticket WHERE id_Ticket=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_Ticket());
            pst.executeUpdate();
            System.out.println("Ticket suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }


    public void modifier(Ticket t) {
try {
            String req = "UPDATE Ticket SET prix=?,date=?,reference=? WHERE id_Ticket=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setFloat(1, t.getPrix());
            pst.setDate(2, t.getDate());
            pst.setInt(3, t.getId_Ticket());
            pst.setString(4, t.getReference());
            pst.executeUpdate(); 
            System.out.println("ticket modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }    

    public List<Ticket> afficher() {
List<Ticket> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM Ticket";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                   list.add(new Ticket(rs.getInt(1), rs.getFloat("prix"), rs.getDate("date"),rs.getString("reference")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
         return list;
    }


    public List<Ticket> recherche(Ticket t) {
List<Ticket> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `Ticket` WHERE id_Ticket=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_Ticket());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                   list.add(new Ticket(rs.getInt(1), rs.getFloat("prix"), rs.getDate("date"),rs.getString("reference")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }        }










   
   
    


