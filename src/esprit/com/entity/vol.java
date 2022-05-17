/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

/**
 *
 * @author mouna
 */
public class vol {
    private int id_vol;
    private String num_vol;
    private String date_vol;
    private String destination;
    private String ville_depart;
    private String type_v;
   
    
    // Affichage ( affichage par id ), modifier  , Id AutoIncrement

    public vol(int id_vol, String num_vol, String date_vol, String destination, String ville_depart, String type_v) {
        this.id_vol = id_vol;
        this.num_vol = num_vol;
        this.date_vol = date_vol;
        this.destination = destination;
        this.ville_depart = ville_depart;
        this.type_v = type_v;
    }

    
// Recherche par id , supprission
    public vol(int id_vol) {
        this.id_vol = id_vol;
    }
// isertion sans id

    public vol(String num_vol, String date_vol, String destination, String ville_depart, String type_v) {
        this.num_vol = num_vol;
        this.date_vol = date_vol;
        this.destination = destination;
        this.ville_depart = ville_depart;
        this.type_v = type_v;
    }
      public vol( String date_vol, String destination, String ville_depart, String type_v) {
        
        this.date_vol = date_vol;
        this.destination = destination;
        this.ville_depart = ville_depart;
        this.type_v = type_v;
    }

    public vol(int aInt, String string, String string0, float aFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public vol(String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_vol() {
        return id_vol;
    }

    public String getNum_vol() {
        return num_vol;
    }

    public String getDate_vol() {
        return date_vol;
    }

    public String getDestination() {
        return destination;
    }

    public String getVille_depart() {
        return ville_depart;
    }

    public String getType_v() {
        return type_v;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public void setNum_vol(String num_vol) {
        this.num_vol = num_vol;
    }

    public void setDate_vol(String date_vol) {
        this.date_vol = date_vol;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public void setType_v(String type_v) {
        this.type_v = type_v;
    }

    @Override
    public String toString() {
        return "vol{" + "id_vol=" + id_vol + ", num_vol=" + num_vol + ", date_vol=" + date_vol + ", destination=" + destination + ", ville_depart=" + ville_depart + ", type_v=" + type_v + '}';
    }
    
    
    
  
    
}
