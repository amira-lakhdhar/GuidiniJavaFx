/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import static esprit.com.gui.UtilisateurCrudController.user;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Toumi
 */
public class UserController implements Initializable {

    @FXML
    private Label lbName;
    @FXML
    private Button btnGestionReclamation;
    @FXML
    private Button btnModif_Compte;
    @FXML
    private Button btnlogout;
    @FXML
    private Button btnEvenement;
    @FXML
    private Button btnEvenement1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbName.setText(user.getNom()+" "+user.getPrenom());
        
    }    

    @FXML
    private void Onclickrecl(ActionEvent event) throws IOException {
               FXMLLoader loader=new FXMLLoader(getClass().getResource("ReclamationCrud.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show(); 
    }

    @FXML
    private void Onclickmodif(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifUser.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }

    @FXML
    private void Onclicklogout(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("UtilisateurCrud.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }

    @FXML
    private void Onclickevenment(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ResBack_1.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }

    @FXML
    private void fnHotel(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ReservationHotelUser.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }
    
}
