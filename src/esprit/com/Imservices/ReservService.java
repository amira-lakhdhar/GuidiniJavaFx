/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.entity.Evenement;
import esprit.com.entity.Reservere;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ReservService {
    Connection cnx = ConnectionBd.getInstance().getCnx();


    public void Ajouter(Reservere t) {
        try{
        String requete = "INSERT INTO reservere(idr,date,id,nom) VALUES (?,?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setInt(1, t.getIdr());
        pst.setString(2, t.getDate());
        pst.setInt(3, t.getId());
         pst.setString(4, t.getNom());
        
        pst.executeUpdate();
        System.out.println("Reservation ajouté !");
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }
    }
        public List<Reservere> Afficher() {
         List<Reservere> list = new ArrayList<>();
        try{
        String requete = "SELECT * FROM reservere";
        PreparedStatement pst = cnx.prepareStatement(requete);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            list.add(new Reservere(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
        }
        System.out.println("Reservation !");
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
        }
        return list;
    }
     
        public List<Evenement> afficherv2() {

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
}
