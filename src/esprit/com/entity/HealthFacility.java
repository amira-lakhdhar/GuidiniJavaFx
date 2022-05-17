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
public abstract class HealthFacility {

    private int id;
    private String phone;
    private String email;
    private String name;
    private String location;
    private Integer score;

    public HealthFacility(int id, String phone, String email, String name, String location, int score) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.location = location;
        this.score= score;
    }

    public HealthFacility(String phone, String email, String name, String location, Integer score) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.location = location;
        this.score = score;
    }

    
    public HealthFacility(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLacation(String lacation) {
        this.location = lacation;
    }

    public HealthFacility() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    
}
