package esprit.com.Imservices;
import esprit.com.entity.Offre;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ImOffre {
    Connection cnx = ConnectionBd.getInstance().getCnx();


    public void ajouter(Offre t) {
        try {
            String req = "INSERT INTO offre ( date_Debut,date_Fin,remise) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, (String) t.getDate_Debut());
            pst.setString(2, (String) t.getDate_Fin());
            pst.setInt(3, (int) t.getRemise());
            pst.executeUpdate();
            System.out.println("offre  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ImOffre() {
    }


    public void supprimer(Offre t) {
       try {
            String req = "DELETE FROM offre WHERE id_Offre=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_Offre());
            pst.executeUpdate();
            System.out.println("offre suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void modifier(Offre t) {
 try {
            String req = "UPDATE offre SET date_Debut=?,date_fin=?,remise=? WHERE id_Offre=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, t.getId_Offre());
            pst.setString(1, t.getDate_Debut());
            pst.setString(2, t.getDate_Fin());
            pst.setInt(3, t.getRemise());
            pst.executeUpdate(); 
            System.out.println("offre modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }


    public List<Offre> afficher() {
List<Offre> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM offre";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Offre(rs.getInt(1), rs.getString("date_Debut"), rs.getString("date_Fin"),rs.getInt("remise")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
         return list;
    }
    

    public List<Offre> recherche(Offre t) {
List<Offre> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `offre` WHERE id=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_Offre());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                   list.add(new Offre(rs.getInt(1), rs.getString("date_Debut"), rs.getString("date_Fin"),rs.getInt("remise")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }    }
    
