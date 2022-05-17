/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import esprit.com.Imservices.ImUtilisateur;
import esprit.com.entity.Utilisateur;
import esprit.com.utils.AlertBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yosr
 */
public class SignupController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfpass;
    @FXML
    private TextField tfpassv2;
    @FXML
    private TextField tfAddress;
    @FXML
    private Button btninscrire2;
    @FXML
    private Button btncancel;
    ImUtilisateur svu=new ImUtilisateur();
 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Onclickinscrire(ActionEvent event) {
        if(tfpass.getText().equals(tfpassv2.getText())){
         Utilisateur User=new Utilisateur(tfNom.getText(), tfPrenom.getText(), tfAddress.getText(), tfEmail.getText(), tfpass.getText()); 
         svu.ajouter(User);
         AlertBox.display("Welcome", "Votre Compte a etait cree avec succes");
         try{
        Parent Login = FXMLLoader.load(getClass().getResource("UtilisateurCrud.fxml")); 
        Scene scene = new Scene(Login);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
           }catch(IOException ex){
               System.out.println("erorr");
           }
        
        }else{
            AlertBox.display("Error", "Check your password");
            
        }
        
        
    }

    @FXML
    private void Onclickcancel(ActionEvent event) {
    }
    
}
