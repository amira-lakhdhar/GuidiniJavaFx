/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

/**
 *
 * @author amira
 */
public abstract class MedicalStaff {

    private int id;
    private String phone;
    private String location;
    private String name;

    public MedicalStaff(int id) {
        this.id = id;
    }

    public MedicalStaff(String phone, String location, String name) {
        this.phone = phone;
        this.location = location;
        this.name = name;
    }
    

    public MedicalStaff(int id, String phone, String location, String name) {
        this.id = id;
        this.phone = phone;
        this.location = location;
        this.name = name;
  
    }
    

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }*/

    public MedicalStaff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String email) {
        this.location = email;
    }
}
