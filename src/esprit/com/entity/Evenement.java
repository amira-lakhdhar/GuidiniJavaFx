/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.com.entity;

import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class Evenement {
private int id_E;
private String date_Evenement;
private String nom_Evenement;
private String type_Evenement;
//private int id_Offre;
// Affichage ( affichage par id ), modifier  , Id AutoIncrement

    public Evenement() {
    }

    public Evenement(int id_E) {
        this.id_E = id_E;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_E=" + id_E + ", date_Evenement=" + date_Evenement + ", nom_Evenement=" + nom_Evenement + ", type_Evenement=" + type_Evenement + '}';
    }
    

//zffichage
    public Evenement(int id_E, String date_Evenement, String nom_Evenement, String type_Evenement) {
        this.id_E = id_E;
        this.date_Evenement = date_Evenement;
        this.nom_Evenement = nom_Evenement;
        this.type_Evenement = type_Evenement;
//      this.id_Offre = id_Offre;
    }
//saisie
    public Evenement(String date_Evenement, String nom_Evenement, String type_Evenement) {
        this.date_Evenement = date_Evenement;
        this.nom_Evenement = nom_Evenement;
        this.type_Evenement = type_Evenement;
//        this.id_Offre = id_Offre;
    }

    public Evenement(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   


    public int getId_E() {
        return id_E;
    }
 public String getDate() {
        return date_Evenement;
    }
    public void setId_E(int id_E) {
        this.id_E = id_E;
    }

    public String getDate_Evenement() {
        return date_Evenement;
    }

    public void setDate_Evenement(String date_Evenement) {
        this.date_Evenement = date_Evenement;
    }

    public String getNom_Evenement() {
        return nom_Evenement;
    }

    public void setNom_Evenement(String nom_Evenement) {
        this.nom_Evenement = nom_Evenement;
    }


    public String getType_Evenement() {
        return type_Evenement;
    }

    public void setType_Evenement(String type_Evenement) {
        this.type_Evenement = type_Evenement;
    }

//    public int getId_Offre() {
//        return id_Offre;
//    }

//    public void setId_Offre(int id_Offre) {
//        this.id_Offre = id_Offre;
//    }

    public String getdate_Evenement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getnom_Evenement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String gettype_Evenement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setdate_Evenement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setnom_Evenement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void settype_Evenement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void nom_Evenement(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ObservableList<Evenement> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

}
