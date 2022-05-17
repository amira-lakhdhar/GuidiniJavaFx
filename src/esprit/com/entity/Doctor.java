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
public class Doctor extends MedicalStaff {

    private String speciality;
    private String Image;

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public Doctor(int id, String phone, String location, String name,String speciality) {
        super( id,  phone,  location,  name);
        this.speciality=speciality;
    }
    public Doctor(int id){
        super(id);
    }
    public Doctor( String phone, String location, String name,String speciality) {
        super( phone,  location,  name);
        this.speciality=speciality;
    }
    

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    
    

}
