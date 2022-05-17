/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package esprit.com.gui;

import esprit.com.Imservices.Imvoyage;
import esprit.com.entity.compagnieaerienne;
import esprit.com.entity.vol;
import esprit.com.entity.voyage;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class VoyageController implements Initializable {
     @FXML
    private TextField tfrech;
    @FXML
    private TextField tflocalisation;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfprix;
    @FXML
    private TableView<voyage> TableView;
    @FXML
    private TableColumn<voyage, String> localisationColumn;
    @FXML
    private TableColumn<voyage, String>  descriptionColumn;
    @FXML
    private TableColumn<voyage, String>  prixColumn;
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
          ObservableList<voyage>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT localisation , description, prix FROM voyage");
            while(rs.next())
            {
                 list.add(new voyage(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        localisationColumn.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
       
          
        


        
        TableView.setItems(list);
        // TODO
        // TODO
    }    

    @FXML
    private void selection(MouseEvent event) {
         int index = TableView.getSelectionModel().getSelectedIndex();
        if(index<= -1)
        {
            return;
        }
        tflocalisation.setText(localisationColumn.getCellData(index).toString());
        tfdescription.setText(descriptionColumn.getCellData(index).toString());
        tfprix.setText(prixColumn.getCellData(index).toString());
    
    }

    @FXML
    private void deleteButton(ActionEvent event) {
         if (tflocalisation.getText().isEmpty()) {
           Notifications notificationBuilder = Notifications.create()
                .title("Error")
                .text("Ajouter un voyage a supprimer SVP !")
                .graphic(null)
                .hideAfter(Duration.seconds(3))
                .position(Pos.TOP_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent event){
                        System.out.println("Clicked on notification");
                    }});
        notificationBuilder.showError();
            return;}
        Imvoyage sp = new Imvoyage();
        sp.supprimer(new voyage(tflocalisation.getText(), tfdescription.getText(),tfprix.getText()));
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
      ObservableList<voyage>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT localisation , description, prix FROM voyage");
            while(rs.next())
            {
                 list.add(new voyage(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        localisationColumn.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TableView.setItems(list);
                  TableView.refresh();
    }

    @FXML
    private void updateButton(ActionEvent event) {
        if (tflocalisation.getText().isEmpty()) {
           Notifications notificationBuilder = Notifications.create()
                .title("Error")
                .text("Ajouter un voyage a modifier SVP !")
                .graphic(null)
                .hideAfter(Duration.seconds(3))
                .position(Pos.TOP_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent event){
                        System.out.println("Clicked on notification");
                    }});
        notificationBuilder.showError();
            return;}
             Imvoyage sp = new Imvoyage();
        sp.modifier(new voyage(tflocalisation.getText(), tfdescription.getText(),tfprix.getText()));
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
                          ObservableList<voyage>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT localisation , description, prix FROM voyage");
            while(rs.next())
            {
                 list.add(new voyage(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        localisationColumn.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TableView.setItems(list);
                          TableView.refresh();


    }

    @FXML
    private void insertButton(ActionEvent event) {
        if (tflocalisation.getText().isEmpty()) {
           Notifications notificationBuilder = Notifications.create()
                .title("Error")
                .text("Ajouter un voyage SVP !")
                .graphic(null)
                .hideAfter(Duration.seconds(3))
                .position(Pos.TOP_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent event){
                        System.out.println("Clicked on notification");
                    }});
        notificationBuilder.showError();
            return;}
             Imvoyage sp = new Imvoyage();
        sp.ajouter(new voyage(tflocalisation.getText(), tfdescription.getText(),tfprix.getText()));
         Notifications notificationBuilder = Notifications.create()
                   .title("Validation")
                   .text("Ajout avec succés!")
                   .graphic(null)
                   .hideAfter(Duration.seconds(3))
                   .position(Pos.TOP_RIGHT)
                     .onAction(new EventHandler<ActionEvent>(){
                       public void handle(ActionEvent event){
                           System.out.println("Clicked on notification");
                       }});
                 
                         notificationBuilder.showConfirm();
                          ObservableList<voyage>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT localisation , description, prix FROM voyage");
            while(rs.next())
            {
                 list.add(new voyage(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        localisationColumn.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
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
     void reload(ActionEvent event) {
         ObservableList<voyage>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT localisation , description, prix FROM voyage");
            while(rs.next())
            {
                 list.add(new voyage(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        localisationColumn.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TableView.setItems(list);
                          TableView.refresh();
    }
     @FXML
     void rechercher(ActionEvent event) {
          ObservableList<voyage> List = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            String text = tfrech.getText();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT localisation,description,prix FROM voyage WHERE localisation='" + text + "'");

            while (rs.next()) {
                List.add(new voyage( rs.getString("localisation"), rs.getString("description"), rs.getString("prix")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieCrudController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      localisationColumn.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));

        
        TableView.setItems(List);
        TableView.refresh();

    }

    
}
