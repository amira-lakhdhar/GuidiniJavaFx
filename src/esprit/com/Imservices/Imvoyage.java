/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.entity.compagnieaerienne;
import esprit.com.entity.vol;
import esprit.com.entity.voyage;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mouna
 */
public class Imvoyage {
    Connection cnx = ConnectionBd.getInstance().getCnx();

    
    public void ajouter(voyage t) {
 try {
            String req = "INSERT INTO voyage (localisation,description,prix) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(1, t.getLocalisation());
            pst.setString(2, t.getDescription());
            pst.setString(3, t.getPrix());
           
            
           pst.executeUpdate();
            System.out.println("voyage  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }


    public void supprimer(voyage t) {
 
          try {
            String req = "DELETE FROM voyage WHERE localisation=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getLocalisation());
            pst.executeUpdate();
            System.out.println("voyage suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    


    public void modifier(voyage t) {
try {
            String req = "UPDATE voyage SET description=?,prix=?  WHERE localisation=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            
           
            pst.setString(1, t.getDescription());
            pst.setString(2, t.getPrix());
             pst.setString(3, t.getLocalisation());
            
            
            pst.executeUpdate();
            System.out.println("voyage modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }


    public List<voyage> afficher() {
    List<voyage> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM voyage";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new voyage(rs.getInt(1), rs.getString("localisation"), rs.getString("description"), rs.getString("prix")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list; }


    public List<voyage> recherche(voyage t) {
 List<voyage> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `voyage` WHERE id_v=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_v());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                   list.add(new voyage(rs.getInt(1), rs.getString("localisation"), rs.getString("description"), rs.getString("prix")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }    
    public List<voyage> rechercherCompa(String val){
      List<voyage> list1= new ArrayList<>();
         List<voyage> list2= afficher();
         
         list1= list2.stream().filter(c ->c.getLocalisation().startsWith(val)).collect(Collectors.toList());
        return list1;
               
     }
                public  List<voyage> TRICompa(){
      List<voyage> list1= new ArrayList<>();
         List<voyage> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getLocalisation().compareTo(o2.getLocalisation())).collect(Collectors.toList());
return list1;               
     }


}
    

