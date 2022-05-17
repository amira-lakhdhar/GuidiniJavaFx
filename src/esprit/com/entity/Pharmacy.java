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
public class Pharmacy extends HealthFacility {

    
    public enum Hourly {
        night,
        day;
    }
    private Hourly hourly;

    public Pharmacy(int id) {
        super(id);
    }

    public Pharmacy() {
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly type) {
        this.hourly = type;
    }
    public Pharmacy(int id, String phone, String email, String name, String location, int score){
        super( id,  phone,  email,  name,  location,  score);
    }
    public Pharmacy( String phone, String email, String name, String location, int score){
        super(phone,  email,  name,  location,  score);
    }
    

    @Override
    public String toString() {
        return "id: " + this.getId() + ", name: " + this.getName() + ", hourly: " + this.getHourly().toString()
                + "Phone: " + this.getPhone()
                + "";
    }

}
