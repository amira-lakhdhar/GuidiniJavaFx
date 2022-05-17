/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.entity.Pharmacy;
import esprit.com.utils.ConnectionBd;
import esprit.com.utils.Criteria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author amira
 */
public class PharmacyServiceImpl {

    private Connection connection = ConnectionBd.getInstance().getCnx();

  
    public void add(Pharmacy entity) {
        try {
            String req = "INSERT INTO pharmacy (name,email,location,phone,hourly,score) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getEmail());
            statement.setString(3, entity.getLocation());
            statement.setString(4, entity.getPhone());
            statement.setString(5, entity.getHourly().toString());
            statement.setInt(6, entity.getScore());

            statement.executeUpdate();
            System.out.println("Pharmacy entity is added!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


    public void update(Pharmacy entity) {
        try {
            String req = "UPDATE pharmacy SET name=?,location=?,score=?, hourly=? , phone=? , email=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getLocation());
            statement.setInt(3, entity.getScore());
            statement.setString(4, entity.getHourly().toString());
            statement.setString(5, entity.getPhone());
            statement.setString(6, entity.getEmail());
            statement.setInt(7, entity.getId());
            statement.executeUpdate();
            System.out.println("pharmacy updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();

        }
    }


    public void delete(Integer id) {
        try {
            String req = "DELETE FROM pharmacy WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("pharmacy deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


    public ObservableList<Pharmacy> getAll() {

        ObservableList<Pharmacy> list =  FXCollections.observableArrayList();

        try {
            String req = "SELECT * FROM pharmacy";
            PreparedStatement pst = connection.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Pharmacy pharmacy = fromResultSet(result);
                list.add(pharmacy);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }


    public Pharmacy getById(Integer id) {
        try {
            String req = "SELECT * FROM pharmacy where id =?";
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

    private Pharmacy fromResultSet(ResultSet result) {
        Pharmacy pharmacy = null;
        try {
            pharmacy = new Pharmacy(result.getInt(1));
            pharmacy.setEmail(result.getString("email"));
            pharmacy.setLacation(result.getString("location"));
            pharmacy.setName(result.getString("name"));
            pharmacy.setPhone(result.getString("phone"));
            pharmacy.setScore(result.getInt("score"));

            String hourly = result.getString("hourly");
            pharmacy.setHourly(Pharmacy.Hourly.valueOf(hourly));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pharmacy;
    }


    public List<Pharmacy> findByCriteria(Criteria[] critirias) {
        List<Pharmacy> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM pharmacy where id =?";
            PreparedStatement statement = connection.prepareStatement(req);
            //statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Pharmacy pharmacy = fromResultSet(result);
                list.add(pharmacy);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    
    
     public ObservableList<Pharmacy> getAllHospital() {

        ObservableList<Pharmacy> list =  FXCollections.observableArrayList();

        try {
            String req = "SELECT * FROM hospital";
            PreparedStatement pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Pharmacy pharmacy = new Pharmacy(rs.getInt("id"),rs.getString("phone"),rs.getString("email"),rs.getString("name"),rs.getString("location"),rs.getInt("score"));
                list.add(pharmacy);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
