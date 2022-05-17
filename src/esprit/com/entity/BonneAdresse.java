/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.util.List;

/**
 *
 * @author Oussama
 */
public class BonneAdresse {
    
    private int id;
    private String nom;
    private String type;
    private float Rate;
    private String Region;

    public BonneAdresse(String nom, String type, String Region) {
        this.nom = nom;
        this.type = type;
        this.Region = Region;
    }

    
    
    public BonneAdresse(int id, String nom, String type, String Region) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.Region = Region;
    }

    
    
    public BonneAdresse(int id, String nom,String type ,float lat, String region) {
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.Rate = lat;
        this.Region=region;
    }
        
    public BonneAdresse( String nom, String lat) {
        this.nom = nom;
        this.Region = lat;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float Rate) {
        this.Rate = Rate;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }
   


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    

    
}
