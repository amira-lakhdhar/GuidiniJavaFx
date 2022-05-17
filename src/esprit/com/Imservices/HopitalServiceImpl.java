/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;


import esprit.com.entity.Hopital;
import esprit.com.entity.Pharmacy;
import esprit.com.utils.ConnectionBd;
import esprit.com.utils.Criteria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.stream.Collectors;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author amira
 */
public class HopitalServiceImpl {

    private Connection connection = ConnectionBd.getInstance().getCnx();


    public void add(Hopital entity) {
        try {
            String req = "INSERT INTO hospital (name,location,score,phone,email) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getLocation());
            statement.setInt(3, entity.getScore());
            statement.setString(4, entity.getPhone());
            statement.setString(5, entity.getEmail());

            statement.executeUpdate();

            System.out.println("Hopital entity is added!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


    public void delete(Integer id) {

        try {
            String req = "DELETE FROM hospital WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("hopital deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();

        }
    }


    public void update(Hopital entity) {
        try {
            String req = "UPDATE hospital SET nom=?,location=?,score=? , phone=? , email=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getLocation());
            statement.setInt(3, entity.getScore());

            statement.setString(4, entity.getPhone());
            statement.setString(5, entity.getEmail());
            statement.setInt(6, entity.getId());

            statement.executeUpdate();
            System.out.println("hopital updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();

        }
    }

    public List<Hopital> getAll() {

        List<Hopital> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM hospital";
            PreparedStatement pst = connection.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Hopital hopital = fromResultSet(result);
                list.add(hopital);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

 
    public Hopital getById(Integer id) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Hopital fromResultSet(ResultSet result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public List<Hopital> findByCriteria(Criteria[] critirias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void TRIhopital(){
      List<Hopital> list1= new ArrayList<>();
         List<Hopital> list2= getAll();
         
         list1= list2.stream().sorted((o1,o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
        boolean list;
         System.out.println(list1);
     }
}
               

