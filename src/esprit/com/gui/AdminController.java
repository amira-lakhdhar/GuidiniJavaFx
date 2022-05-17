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
public class AdminController implements Initializable {

    @FXML
    private Label lbName;
    @FXML
    private Button btnModif_Compte;
    @FXML
    private Button btnlogout;
    @FXML
    private Button GestionMedical;
    @FXML
    private Button BtnVoyage;
    @FXML
    private Button btnevenement;
    @FXML
    private Button btnAdress;
    @FXML
    private Button btnEtab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      lbName.setText(user.getNom()+" "+user.getPrenom());
      
        // TODO
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
    private void Onclickedmedical(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ACCUEIL.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }

    @FXML
    private void OnclickVoyage(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
        
    }

    @FXML
    private void OnclickEvenment(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("afficherEvent.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
        
    }

    @FXML
    private void fnAdress(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("BonneAdresse.fxml"));
                Parent Ajouter = (Parent)loader.load();
 
                Scene scene = new Scene(Ajouter);     
                Stage window = new Stage();
                window.setScene(scene);
                window.show();
    }

    @FXML
    private void fnEtab(ActionEvent event) throws IOException {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("menu.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }
    
 
    
}
