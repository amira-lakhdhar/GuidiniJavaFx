/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;


import esprit.com.entity.Doctor;
import esprit.com.utils.ConnectionBd;
import esprit.com.utils.Criteria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author amira
 */
public class DoctorServiceImpl {

    private Connection connection = ConnectionBd.getInstance().getCnx();

    public DoctorServiceImpl(int aInt) {
    }

 
    public void add(Doctor entity) {
        try {
            String req = "INSERT INTO doctor (name,speciality,phone,location,Image) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSpeciality());
            statement.setString(3, entity.getPhone());
            statement.setString(4, entity.getLocation());
            statement.setString(5, entity.getImage());

            statement.executeUpdate();
            System.out.println("Doctor entity is added!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


    public void update(Doctor entity) {
        try {
            String req = "UPDATE doctor SET name=?, speciality=?, phone=?, location=?, Image=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSpeciality());
            statement.setString(3, entity.getPhone());
            statement.setString(4, entity.getLocation());
            statement.setString(5, entity.getImage());
            statement.setInt(6, entity.getId());
            statement.executeUpdate();
            System.out.println("Doctor updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();

        }
    }


    public void delete(Integer id) {
        try {
            String req = "DELETE FROM Doctor WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Docotr deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


    public ObservableList<Doctor> getAll() {

        ObservableList<Doctor> list = FXCollections.observableArrayList();
        Statement st;
        ResultSet rs;
        try {
            String req = "SELECT * FROM doctor";
             st = connection.createStatement();
             rs = st.executeQuery(req);
            while (rs.next()) {
                Doctor doctor = new Doctor(rs.getInt("id"),rs.getString("phone"),rs.getString("location"),rs.getString("name"),rs.getString("speciality"));
                doctor.setImage(rs.getString("Image"));
                System.out.println(" "+doctor.getLocation()+" "+doctor.getPhone()+" "+doctor.getSpeciality());
                list.add(doctor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }


    public Doctor getById(Integer id) {
        try {
            String req = "SELECT * FROM Docotr where id =?";
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return fromResultSet(result);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Doctor fromResultSet(ResultSet result) {
        Doctor doctor = null;
        try {
            doctor = new Doctor(result.getInt(1));
            doctor.setName(result.getString("name"));
            String Speciality = result.getString("speciality");
            // doctor.setSpeciality(Pharmacy.Hourly.valueOf(Speciality));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return doctor;
    }

 
    public List<Doctor> findByCriteria(Criteria[] critirias) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void TRIdoctor(){
      List<Doctor> list1= new ArrayList<>();
         List<Doctor> list2= getAll();
         
         list1= list2.stream().sorted((o1,o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
         System.out.println(list1);
               
     }

}
