/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package esprit.com.gui;

import esprit.com.Imservices.Imcompagnieaerienne;
import esprit.com.entity.compagnieaerienne;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Malik
 */
public class CompagnieCrudController implements Initializable {
    @FXML
    private TextField tfrech;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfcontact;
    @FXML
    private TableView<compagnieaerienne> TableView;
    @FXML
    private TableColumn<compagnieaerienne, String> nomColumn;
    @FXML
    private TableColumn<compagnieaerienne, String> emailColumn;
    @FXML
    private TableColumn<compagnieaerienne, String> contactColumn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button updateButton;
    @FXML
    private Button insertButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<compagnieaerienne>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT nom , email , contact FROM compagnieaerienne");
            while(rs.next())
            {
                 list.add(new compagnieaerienne(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        


        
        TableView.setItems(list);
        // TODO
        // TODO
    }    
  @FXML
    void rechercher(ActionEvent event) {
          ObservableList<compagnieaerienne> List = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            String text = tfrech.getText();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT nom,email,contact FROM compagnieaerienne WHERE nom='" + text + "'");

            while (rs.next()) {
                List.add(new compagnieaerienne( rs.getString("nom"), rs.getString("email"), rs.getString("contact")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieCrudController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        TableView.setItems(List);
        TableView.refresh();

    }

    public boolean emailCon(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    @FXML
    private void Selection(MouseEvent event) {
         int index = TableView.getSelectionModel().getSelectedIndex();
        if(index<= -1)
        {
            return;
        }
        tfnom.setText(nomColumn.getCellData(index).toString());
        tfemail.setText(emailColumn.getCellData(index).toString());
        tfcontact.setText(contactColumn.getCellData(index).toString());
    }
    

    @FXML
    private void deleteButton(ActionEvent event) {
        if (tfnom.getText().isEmpty()) {
           Notifications notificationBuilder = Notifications.create()
                .title("Error")
                .text("Ajouter un element a supprimer SVP !")
                .graphic(null)
                .hideAfter(Duration.seconds(3))
                .position(Pos.TOP_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent event){
                        System.out.println("Clicked on notification");
                    }});
        notificationBuilder.showError();
            return;}
       
         Imcompagnieaerienne sp = new Imcompagnieaerienne();
        sp.supprimer(new compagnieaerienne(tfnom.getText(), tfemail.getText(),tfcontact.getText()));
         Notifications notificationBuilder = Notifications.create()
                   .title("Validation")
                   .text("Suppression avec succés!")
                   .graphic(null)
                   .hideAfter(Duration.seconds(3))
                   .position(Pos.TOP_RIGHT)
                     .onAction(new EventHandler<ActionEvent>(){
                       public void handle(ActionEvent event){
                           System.out.println("Clicked on notification");
                       }});
                         notificationBuilder.showConfirm();
        ObservableList<compagnieaerienne>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT nom , email , contact FROM compagnieaerienne");
            while(rs.next())
            {
                 list.add(new compagnieaerienne(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        


        
        TableView.setItems(list);
        
        
        
        
          TableView.refresh();
       
                         
    }

    @FXML
    private void updateButton(ActionEvent event) {
        if (tfnom.getText().isEmpty()) {
           Notifications notificationBuilder = Notifications.create()
                .title("Error")
                .text("Ajouter un element a modifier SVP !")
                .graphic(null)
                .hideAfter(Duration.seconds(3))
                .position(Pos.TOP_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent event){
                        System.out.println("Clicked on notification");
                    }});
        notificationBuilder.showError();
            return;}
         Imcompagnieaerienne sp = new Imcompagnieaerienne();
        sp.modifier(new compagnieaerienne(tfnom.getText(), tfemail.getText(),tfcontact.getText()));
         ObservableList<compagnieaerienne>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT nom , email , contact FROM compagnieaerienne");
            while(rs.next())
            {
                 list.add(new compagnieaerienne(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        


        
        TableView.setItems(list);
        
        
        
        
          TableView.refresh();
           Notifications notificationBuilder = Notifications.create()
                   .title("Validation")
                   .text("Modification avec succés!")
                   .graphic(null)
                   .hideAfter(Duration.seconds(3))
                   .position(Pos.TOP_RIGHT)
                     .onAction(new EventHandler<ActionEvent>(){
                       public void handle(ActionEvent event){
                           System.out.println("Clicked on notification");
                       }});
                 
                         notificationBuilder.showConfirm();
    }

    @FXML
    private void insertButton(ActionEvent event) {
        if (tfnom.getText().isEmpty()) {
           Notifications notificationBuilder = Notifications.create()
                .title("Error")
                .text("Ajouter un element a ajouter SVP !")
                .graphic(null)
                .hideAfter(Duration.seconds(3))
                .position(Pos.TOP_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent event){
                        System.out.println("Clicked on notification");
                    }});
        notificationBuilder.showError();
        
            return;}
         Imcompagnieaerienne sp = new Imcompagnieaerienne();
        sp.ajouter(new compagnieaerienne(tfnom.getText(), tfemail.getText(),tfcontact.getText()));
         ObservableList<compagnieaerienne>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT nom , email , contact FROM compagnieaerienne");
            while(rs.next())
            {
                 list.add(new compagnieaerienne(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        


        
        TableView.setItems(list);
        
        
        
        
          TableView.refresh();
          
    }

    @FXML
    private void retour(ActionEvent event) {
          try {

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Acceuil.fxml")));
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
      
    }
    
    
    @FXML
    void reload(ActionEvent event) {
        

    }
    
}
