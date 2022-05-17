/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

/**
 *
 * @author yosr
 */
public class Reclamation {
    private int id_r;
    private String message;
    private int id_user;
    private String type_r;
    private String Titre;

  

    public Reclamation(int id_r, String message, int id_user, String type_r, String Titre) {
        this.id_r = id_r;
        this.message = message;
        this.id_user = id_user;
        this.type_r = type_r;
        this.Titre = Titre;
    }

    public Reclamation(int id_r, String message, String type_r, String Titre) {
        this.id_r = id_r;
        this.message = message;
        this.type_r = type_r;
        this.Titre = Titre;
    }
    
    
    
    
    
    
    
    // Affichage ( affichage par id ), modifier  , Id AutoIncrement

    public Reclamation(int id_r, String message, int date_r, String type_r) {
        this.id_r = id_r;
        this.message = message;
        this.id_user = date_r;
        this.type_r = type_r;
        
    }

    public Reclamation() {
    }
    
// Recherche par id , suppression
    
    public Reclamation(int id_r) {
        this.id_r = id_r;
    }

    public Reclamation(String message, int id_user, String type_r, String Titre) {
        this.message = message;
        this.id_user = id_user;
        this.type_r = type_r;
        this.Titre = Titre;
    }
// isertion sans id
    public Reclamation(String message, int id_user, String type_r) {
        this.message = message;
        this.id_user = id_user;
        this.type_r = type_r;
    }

    public int getId_r() {
        return id_r;
    }

    public void setId_r(int id_r) {
        this.id_r = id_r;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }


    public String getType_r() {
        return type_r;
    }

    public void setType_r(String type_r) {
        this.type_r = type_r;
    }
    
      public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    

    @Override
    public String toString() {
        return "\n Reclamation"+ id_r + ", message=" + message + ", nomR=" + id_user + ", type_r=" + type_r + '}';
    }

    
    
}
