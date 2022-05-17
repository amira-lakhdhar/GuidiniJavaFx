/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.entity.compagnieaerienne;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author mouna try {
            String req = "INSERT INTO compagnieaerienne (nom, email,contact) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(1, t.getNom());
            pst.setString(2, t.getEmail());
            pst.setString(3, t.getContact());
            
            
           pst.executeUpdate();
            System.out.println("compagnieaerienne  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 */
// sna3et class bech n'impplimenti les methdes eli san2tho mn interface ISERVICE w 3adina Utilisateur par parametre
public class Imcompagnieaerienne {
    Connection cnx = ConnectionBd.getInstance().getCnx();
 public boolean emailCon(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public void ajouter(compagnieaerienne t) {
        try {
            String req = "INSERT INTO compagnieaerienne (nom,email,contact) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            if(emailCon(t.getEmail())==false){
              Notifications notificationBuilder = Notifications.create()
                   .title("Error")
                   .text("Ajouter une email vaLide svp!")
                   .graphic(null)
                   .hideAfter(Duration.seconds(3))
                   .position(Pos.TOP_RIGHT)
                     .onAction(new EventHandler<ActionEvent>(){
                       public void handle(ActionEvent event){
                           System.out.println("Clicked on notification");
                       }});
                 
                         notificationBuilder.showError();
            }
            else{
            pst.setString(1, t.getNom());
            pst.setString(2, t.getEmail());
            pst.setString(3, t.getContact());
            
            
            
           pst.executeUpdate();
            System.out.println("compagnieaerienne  ajoutée !");
             Notifications notificationBuilder = Notifications.create()
                   .title("Validation")
                   .text("Ajout avec succés!")
                   .graphic(null)
                   .hideAfter(Duration.seconds(3))
                   .position(Pos.TOP_RIGHT)
                     .onAction(new EventHandler<ActionEvent>(){
                       public void handle(ActionEvent event){
                           System.out.println("Clicked on notification");
                       }});
                 
                         notificationBuilder.showConfirm();
       }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void supprimer(compagnieaerienne t) {
          try {
            String req = "DELETE FROM compagnieaerienne WHERE nom=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.executeUpdate();
            System.out.println("compagnie aerienne suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifier(compagnieaerienne t) {
         try {
            String req = "UPDATE compagnieaerienne SET email=?,contact=? WHERE nom=?";
            PreparedStatement pst = cnx.prepareStatement(req);
             if(emailCon(t.getEmail())==false){
              Notifications notificationBuilder = Notifications.create()
                   .title("Error")
                   .text("Ajouter une email vaide svp!")
                   .graphic(null)
                   .hideAfter(Duration.seconds(3))
                   .position(Pos.TOP_RIGHT)
                     .onAction(new EventHandler<ActionEvent>(){
                       public void handle(ActionEvent event){
                           System.out.println("Clicked on notification");
                       }});
                 
                         notificationBuilder.showError();
            }
            else{
           
            pst.setString(1, t.getEmail());
            pst.setString(2, t.getContact());
             pst.setString(3, t.getNom());
            pst.executeUpdate();
            System.out.println("compagnieaerienne modifiée !");}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public List<compagnieaerienne> afficher() {
        
                List<compagnieaerienne> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM compagnieaerienne";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new compagnieaerienne(rs.getInt(1), rs.getString("nom"), rs.getString("email"),rs.getString("contact")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

    


    public List<compagnieaerienne> recherche(compagnieaerienne t) {
        List<compagnieaerienne> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `compagnieaerienne` WHERE id_ca=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_ca());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                   list.add(new compagnieaerienne(rs.getInt(1), rs.getString("nom"), rs.getString("email"),rs.getString("contact")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    public List<compagnieaerienne> rechercherCompa(String val){
      List<compagnieaerienne> list1= new ArrayList<>();
         List<compagnieaerienne> list2= afficher();
         
         list1= list2.stream().filter(c ->c.getNom().startsWith(val)).collect(Collectors.toList());
        return list1;
               
     }
                public  List<compagnieaerienne> TRICompa(){
      List<compagnieaerienne> list1= new ArrayList<>();
         List<compagnieaerienne> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getNom().compareTo(o2.getNom())).collect(Collectors.toList());
return list1;               
     }
    
    
    
}
