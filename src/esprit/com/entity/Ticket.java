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
public class Ticket {
    private int id_Ticket;
    private float prix;
    private Date date;
    private String reference;
  //  private Date String;

    public Ticket(int id_Ticket, float prix, Date date) {
        this.id_Ticket = id_Ticket;
        this.prix = prix;
        this.date = date;
        this.reference=reference;
    }

    public Ticket(float prix, Date date) {
        this.prix = prix;
        this.date = date;
        this.reference=reference;
    }

    public Ticket(int aInt, float aFloat, Date date, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_Ticket() {
        return id_Ticket;
    }

    public void setId_Ticket(int id_Ticket) {
        this.id_Ticket = id_Ticket;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
@Override
    public String toString() {
        return "\n Ticket"+ id_Ticket + ", prix=" + prix + ", date=" + date + ", reference=" + reference + "  '}'";
    }}
