/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.entity.compagnieaerienne;
import esprit.com.entity.vol;
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
// sna3et class bech n'impplimenti les methdes eli san2tho mn interface ISERVICE w 3adina Utilisateur par parametre
public class Imvol {
    Connection cnx = ConnectionBd.getInstance().getCnx();


    public void ajouter(vol t) {
        try {
            String req = "INSERT INTO vol (num_vol, date_vol,destination,ville_depart,type_v) VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(1, t.getNum_vol());
            pst.setString(2, t.getDate_vol());
            pst.setString(3, t.getDestination());
            pst.setString(4, t.getVille_depart());
            pst.setString(5, t.getType_v());
            
           pst.executeUpdate();
            System.out.println("vol  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void supprimer(vol t) {
          try {
            String req = "DELETE FROM vol WHERE num_vol=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getNum_vol());
            pst.executeUpdate();
            System.out.println("vol suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifier(vol t) {
         try {
            String req = "UPDATE vol SET date_vol=?,destination=?, ville_depart=? , type_v=?  WHERE num_vol=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            
            
            pst.setString(1, t.getDate_vol());
            pst.setString(2, t.getDestination());
            pst.setString(3, t.getVille_depart());
            pst.setString(4, t.getType_v());
            pst.setString(5, t.getNum_vol());
            
            pst.executeUpdate();
            System.out.println("vol modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public List<vol> afficher() {
        
                List<vol> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM vol";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new vol(rs.getInt(1), rs.getString("num_vol"), rs.getString("date_vol"),rs.getString("destination"),rs.getString("ville_depart"),rs.getString("type_v")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }


    public List<vol> recherche(vol t) {
        List<vol> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `vol` WHERE id_vol=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_vol());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                   list.add(new vol(rs.getInt(1), rs.getString("num_vol"), rs.getString("date_vol"),rs.getString("destination"),rs.getString("ville_depart"),rs.getString("type_v")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
     public List<vol> rechercherVol(String val){
      List<vol> list1= new ArrayList<>();
         List<vol> list2= afficher();
         
         list1= list2.stream().filter(c ->c.getDestination().startsWith(val)).collect(Collectors.toList());
        return list1;
               
     }
                public  List<vol> TRIVol(){
      List<vol> list1= new ArrayList<>();
         List<vol> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getDestination().compareTo(o2.getDestination())).collect(Collectors.toList());
return list1;               
     }
    
}
