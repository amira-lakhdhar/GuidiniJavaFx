/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Offre {
    private int id_Offre;
    private String date_Debut;
    private String date_Fin;
    private int remise;

    public Offre(int id_Offre, String date_Debut, String date_Fin, int remise) {
        this.id_Offre = id_Offre;
        this.date_Debut = date_Debut;
        this.date_Fin = date_Fin;
        this.remise = remise;
    }

    public Offre(String date_Debut, String date_Fin, int remise) {
        this.date_Debut = date_Debut;
        this.date_Fin = date_Fin;
        this.remise = remise;
    }

    public int getId_Offre() {
        return id_Offre;
    }

    public void setId_Offre(int id_Offre) {
        this.id_Offre = id_Offre;
    }

    public String getDate_Debut() {
        return date_Debut;
    }

    public void setDate_Debut(String date_Debut) {
        this.date_Debut = date_Debut;
    }

    public String getDate_Fin() {
        return date_Fin;
    }

    public void setDate_Fin(String date_Fin) {
        this.date_Fin = date_Fin;
    }

    public int getRemise() {
        return remise;
    }

    public void setRemise(int remise) {
        this.remise = remise;
    }
   @Override
    public String toString() {
        return "\n Offre"+ id_Offre + ", date_Debut=" + date_Debut + ", date_Fin=" + date_Fin + ", remise=" + remise + '}';
    }}


