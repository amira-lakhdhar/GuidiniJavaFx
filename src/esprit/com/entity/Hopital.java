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
public class Hopital extends HealthFacility {

    public Hopital(int id) {
        super(id);
    }
    public Hopital( String phone, String email, String name, String location, int score){
        super(phone,  email,  name,  location,  score);
    }
    public Hopital(int id, String phone, String email, String name, String location, int score){
        super( id,  phone,  email,  name,  location,  score);
    }
}
