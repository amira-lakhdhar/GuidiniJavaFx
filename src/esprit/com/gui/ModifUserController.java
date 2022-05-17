/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import esprit.com.Imservices.ImUtilisateur;
import esprit.com.entity.Utilisateur;
import static esprit.com.gui.UtilisateurCrudController.user;
import esprit.com.utils.AlertBox;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Toumi
 */
public class ModifUserController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfAddress;
    @FXML
    private TextField tfpassnew;
    @FXML
    private Button btnpass;
    @FXML
    private Button btnSupprime;
    @FXML
    private Button btnmodif;
    ImUtilisateur svu=new ImUtilisateur();
    @FXML
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfNom.setText(user.getNom());
        tfPrenom.setText(user.getPrenom());
        tfEmail.setText(user.getEmail());
        tfAddress.setText(user.getAdresse());
        
    }    


    @FXML
    private void OnclickSupp(ActionEvent event) throws IOException {
        svu.supprimer(user);
         AlertBox.display("Succes", "Votre Compte a ete supprimer");
            FXMLLoader loader=new FXMLLoader(getClass().getResource("UtilisateurCrud.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }

    @FXML
    private void Onclickpass(ActionEvent event) {
        if(tfpassnew.getText().equals("")){
            AlertBox.display("Errer", "Ecrire quelque chose ");
        }else{
            Utilisateur u=new Utilisateur(user.getId());
            u.setMotpass(tfpassnew.getText());
            svu.modifierpass(u);
            AlertBox.display("Succes", "Votre Mot de passe a ete modifer");
            tfpassnew.setText("");
        }
        
        
        
    }

    

    @FXML
    private void OnclickModif(ActionEvent event) throws IOException {
        if(tfNom.getText().equals("") || tfPrenom.getText().equals("") || tfAddress.getText().equals("") || tfEmail.getText().equals("")){
            AlertBox.display("Erreur", "Remplir Tous les champs s'il vous plait");
        }else{
            Utilisateur u=new Utilisateur(user.getId(),tfNom.getText(), tfPrenom.getText(), tfAddress.getText(), tfEmail.getText());
            
            svu.modifier(u);
            user.setNom(u.getNom());
            user.setPrenom(u.getPrenom());
            user.setEmail(u.getEmail());
            user.setAdresse(u.getAdresse());
            AlertBox.display("Succes", "Votre Compte a ete mis a jour");
           if(user.getRole().toLowerCase().equals("user")){
             FXMLLoader loader=new FXMLLoader(getClass().getResource("User.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
        }else {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Admin.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
        }
        }
        
    }

    @FXML
    private void OnclickRetour(ActionEvent event) throws IOException {
         if(user.getRole().toLowerCase().equals("user")){
             FXMLLoader loader=new FXMLLoader(getClass().getResource("User.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
        }else {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Admin.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
        }
    }
    
}
