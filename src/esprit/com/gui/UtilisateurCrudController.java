/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package esprit.com.gui;

import esprit.com.Imservices.ImUtilisateur;
import esprit.com.entity.BCrypt;
import esprit.com.entity.Utilisateur;
import esprit.com.utils.JavaMailUtil;
import esprit.com.utils.AlertBox;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author yosr
 */
public class UtilisateurCrudController implements Initializable {

    @FXML
    private Button btnLogin;

    private static UtilisateurCrudController instance;
    @FXML
    private CheckBox cbRememberMe;
    @FXML
    private Button btSignUp;
    private Object TextFields;
    private BCrypt BCrypt;;
    @FXML
    private Button lostpass;

  

    @FXML
    private TextField txtusername;
    @FXML
    private TextField txtpassword;
    
    public static Utilisateur user;
    ImUtilisateur svu=new ImUtilisateur();

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {

       
      

    }


    @FXML
    private void signUp(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup.fxml"));
            Parent root = loader.load();
            txtusername.getScene().setRoot(root);

        } catch (Exception ex) {
            Logger.getLogger(UtilisateurCrudController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnLoginAction(ActionEvent event) throws IOException {
//        user=svu.selectUserByEmail(txtusername.getText());
//        System.out.println(user.getMotpass());
//        if (user.getId() == 0) {
//
//            AlertBox.display("Not existing account!", "Not existing account! Please verify the entred credentials ! ");
//
//            System.out.println("email wrong");
//        } else if (user.getMotpass().equals("AZESDZRSSFFE/6465484321AZEqsd1564za65qsazeqsd54zSAZETFGVV"+txtpassword.getText())) {
//            AlertBox.display("Welcome ", "Welcome, Back Mr "+user.getRole());
//            if(user.getRole().toLowerCase().equals("user")){
//                FXMLLoader loader=new FXMLLoader(getClass().getResource("User.fxml"));
//                Parent Ajouter = (Parent)loader.load();
//  
//                Scene scene = new Scene(Ajouter);     
//                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//                window.setScene(scene);
//                window.show();
//            }else{
//                FXMLLoader loader=new FXMLLoader(getClass().getResource("Admin.fxml"));
//                Parent Ajouter = (Parent)loader.load();
//  
//                Scene scene = new Scene(Ajouter);     
//                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//                window.setScene(scene);
//                window.show();
//            }
//            
//            
//        }else{
//            AlertBox.display("Error", "Ton mot de passe n'est pas correct");
//        }
//        
        
        
              user=svu.selectUserByEmail(txtusername.getText());
        System.out.println(user.getMotpass());
        if (user.getId() == 0) {

            AlertBox.display("Not existing account!", "Not existing account! Please verify the entred credentials ! ");

            System.out.println("email wrong");
        } else if (user.getMotpass().equals(txtpassword.getText())) {
            AlertBox.display("Welcome ", "Welcome, Back Mr "+user.getRole());
            if(user.getRole().toLowerCase().equals("0")){
                FXMLLoader loader=new FXMLLoader(getClass().getResource("User.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }else{
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Admin.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
            
            
        }else{
            AlertBox.display("Error", "Ton mot de passe n'est pas correct");
        }  
        
    }

    @FXML
    private void passwordRecovery(ActionEvent event) throws MessagingException {
        user=svu.selectUserByEmail(txtusername.getText());
        if (user.getId() == 0) {

            AlertBox.display("Not existing account!", "Not existing account! Please verify the entred credentials ! ");

            System.out.println("email wrong");
        } else
            {
                System.out.println(txtusername.getText());
                JavaMailUtil.sendMail(txtusername.getText(), user);
                AlertBox.display("Succes", "Un email est envoyer a ton email");
            
        }
    }
    

   

}












