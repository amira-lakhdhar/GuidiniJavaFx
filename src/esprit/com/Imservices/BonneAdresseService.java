/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.entity.BonneAdresse;
import esprit.com.utils.ConnectionBd;
import esprit.com.utils.Criteria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oussama
 */
public class BonneAdresseService  {

    
    private Connection cnx = ConnectionBd.getInstance().getCnx();
    
    
 
    public void add(BonneAdresse bonneAdresse) {
               try {
            String req = "INSERT INTO bonne_adresse (nom,type,region) VALUES (?,?,?)";
            PreparedStatement statement = cnx.prepareStatement(req);
            statement.setString(1, bonneAdresse.getNom());
            statement.setString(2, bonneAdresse.getType());
            statement.setString(3, bonneAdresse.getRegion());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   
    public void update(BonneAdresse bonneAdresse) {
               try {
            String req = "UPDATE bonne_adresse SET nom=?,type=?,region=? WHERE id=?";
            PreparedStatement statement = cnx.prepareStatement(req);
            statement.setString(1, bonneAdresse.getNom());
            statement.setString(2, bonneAdresse.getType());
            statement.setString(3, bonneAdresse.getRegion());
            statement.setInt(4, bonneAdresse.getId());

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();

        }
    }


    public void delete(Integer id) {
        try {
            String req = "DELETE FROM bonne_adresse WHERE id=?";
            PreparedStatement statement = cnx.prepareStatement(req);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }


    public List<BonneAdresse> getAll() {
         List<BonneAdresse> bonneAdresseList = new ArrayList<>();

        try {
            String req = "SELECT * FROM bonne_adresse";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                bonneAdresseList.add(new BonneAdresse(rs.getInt(1), rs.getString(2),rs.getString(3), 5, rs.getString(4) ));
                
            }
                      

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return bonneAdresseList;
    }


    public BonneAdresse getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public List<BonneAdresse> findByCriteria(Criteria[] critirias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
