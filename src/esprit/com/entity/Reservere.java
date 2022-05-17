/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import javafx.scene.control.TableColumn;

/**
 *
 * @author user
 */
public class Reservere {
    public int idr;
    public String date;
    public int id;
    public String nom;

   
 

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Reservere(int idr, String date, int id, String nom) {
        this.idr = idr;
        this.date = date;
        this.id = id;
        this.nom = nom;
    }

    public Reservere(String date, int id, String nom) {
        this.date = date;
       
        this.id = id;
        this.nom = nom;
    }

    public Reservere(int idr,String date, String nom,int id) {
        this.idr=idr;
        this.date = date;
       
        this.nom = nom;
        this.id=id;
    }
    
}
