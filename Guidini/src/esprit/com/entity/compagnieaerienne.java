/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.sql.Date;

/**
 *
 * @author mouna
 */


public class compagnieaerienne {
    private int id_ca;
    private String nom;
    private String email;
    private String contact;
   
   
    
    // Affichage ( affichage par id ), modifier  , Id AutoIncrement

    public compagnieaerienne(int id_ca, String nom, String email, String contact) {
        this.id_ca = id_ca;
        this.nom = nom;
        this.email = email;
        this.contact = contact;
    }
    

    public compagnieaerienne(String nom, String email, String contact) {
        
        this.nom = nom;
        this.email = email;
        this.contact = contact;
    }

    

    
// Recherche par id , supprission
    public compagnieaerienne(int id_ca) {
        this.id_ca = id_ca;
    }
// isertion sans id

    public compagnieaerienne(String string, int aInt, String string0, Date date, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getId_ca() {
        return id_ca;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public void setId_ca(int id_ca) {
        this.id_ca = id_ca;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "compagnieaerienne{" + "id_ca=" + id_ca + ", nom=" + nom + ", email=" + email + ", contact=" + contact + '}';
    }

}