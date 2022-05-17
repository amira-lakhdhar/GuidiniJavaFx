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
public class voyage {
    
    private int id_v;
    private String localisation;
    private String description;
    private String prix;

    public voyage(int id_v, String localisation, String description, String prix) {
        this.id_v = id_v;
        this.localisation = localisation;
        this.description = description;
        this.prix = prix;
    }
    // Recherche par id , supprission
   
    public voyage(String localisation, String description, String prix) {
        this.localisation = localisation;
        this.description = description;
        this.prix = prix;
    }

    public int getId_v() {
        return id_v;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getDescription() {
        return description;
    }

    public String getPrix() {
        return prix;
    }

    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "voyage{" + "id_v=" + id_v + ", localisation=" + localisation + ", description=" + description + ", prix=" + prix + '}';
    }
    
   
}
