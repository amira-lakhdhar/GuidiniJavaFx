/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import esprit.com.Imservices.Imvol;
import esprit.com.entity.compagnieaerienne;
import esprit.com.entity.vol;
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
 * @author mouna
 */
public class VolCrudController implements Initializable {

   @FXML
    private TextField tfrech;
    @FXML
    private TextField tfnumvol;
    @FXML
    private TextField tfdatevol;
    @FXML
    private TextField tfdestination;
    @FXML
    private TextField tfvilledepart;
    @FXML
    private TextField tftypevol;
    @FXML
    private TableView<vol> TableView;
    @FXML
    private TableColumn<vol, String> numvolColumn;
    @FXML
    private TableColumn<vol, String> datevolColumn;
    @FXML
    private TableColumn<vol, String> destinationColumn;
    @FXML
    private TableColumn<vol, String> villedepartColumn;
    @FXML
    private TableColumn<vol, String> typevolColumn;
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
        // TODO
          ObservableList<vol>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT num_vol , date_vol, destination, ville_depart, type_v contact FROM vol");
            while(rs.next())
            {
                 list.add(new vol(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        numvolColumn.setCellValueFactory(new PropertyValueFactory<>("num_vol"));
        datevolColumn.setCellValueFactory(new PropertyValueFactory<>("date_vol"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
        villedepartColumn.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
          typevolColumn.setCellValueFactory(new PropertyValueFactory<>("type_v"));
          
        


        
        TableView.setItems(list);
    }    

    @FXML
    private void selection(MouseEvent event) {
         int index = TableView.getSelectionModel().getSelectedIndex();
        if(index<= -1)
        {
            return;
        }
        tfnumvol.setText(numvolColumn.getCellData(index).toString());
        tfdatevol.setText(datevolColumn.getCellData(index).toString());
        tfdestination.setText(destinationColumn.getCellData(index).toString());
         tfvilledepart.setText(villedepartColumn.getCellData(index).toString());
          tftypevol.setText(typevolColumn.getCellData(index).toString());
          
    }

    @FXML
    private void deleteButton(ActionEvent event) {
           if (tfnumvol.getText().isEmpty()) {
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
         Imvol sp = new Imvol();
        sp.supprimer(new vol(tfnumvol.getText(), tfdatevol.getText(),tfdestination.getText(),tfvilledepart.getText(),tftypevol.getText()));
         ObservableList<vol>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT num_vol , date_vol, destination, ville_depart, type_v contact FROM vol");
            while(rs.next())
            {
                 list.add(new vol(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        numvolColumn.setCellValueFactory(new PropertyValueFactory<>("num_vol"));
        datevolColumn.setCellValueFactory(new PropertyValueFactory<>("date_vol"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
        villedepartColumn.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
          typevolColumn.setCellValueFactory(new PropertyValueFactory<>("type_v"));
          
        


        
        TableView.setItems(list);
                        
    }

    @FXML
    private void updateButton(ActionEvent event) {
        if (tfnumvol.getText().isEmpty()) {
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
         Imvol sp = new Imvol();
        sp.modifier(new vol(tfnumvol.getText(), tfdatevol.getText(),tfdestination.getText(),tfvilledepart.getText(),tftypevol.getText()));
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
                          ObservableList<vol>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT num_vol , date_vol, destination, ville_depart, type_v contact FROM vol");
            while(rs.next())
            {
                 list.add(new vol(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        numvolColumn.setCellValueFactory(new PropertyValueFactory<>("num_vol"));
        datevolColumn.setCellValueFactory(new PropertyValueFactory<>("date_vol"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
        villedepartColumn.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
          typevolColumn.setCellValueFactory(new PropertyValueFactory<>("type_v"));
        TableView.setItems(list);
      TableView.refresh();
    }

    @FXML
    private void insertButton(ActionEvent event) {
        if (tfnumvol.getText().isEmpty()) {
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
        Imvol sp = new Imvol();
        sp.ajouter(new vol(tfnumvol.getText(), tfdatevol.getText(),tfdestination.getText(),tfvilledepart.getText(),tftypevol.getText()));
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
                          ObservableList<vol>  list = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT num_vol , date_vol, destination, ville_depart, type_v contact FROM vol");
            while(rs.next())
            {
                 list.add(new vol(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compagnieaerienne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        numvolColumn.setCellValueFactory(new PropertyValueFactory<>("num_vol"));
        datevolColumn.setCellValueFactory(new PropertyValueFactory<>("date_vol"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
        villedepartColumn.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
          typevolColumn.setCellValueFactory(new PropertyValueFactory<>("type_v"));
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
    private void rechercher(ActionEvent event) {
         ObservableList<vol> List = FXCollections.observableArrayList();
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            String text = tfrech.getText();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT num_vol,date_vol,destination,ville_depart,type_v FROM vol WHERE num_vol='" + text + "'");

            while (rs.next()) {
                List.add(new vol( rs.getString("num_vol"), rs.getString("date_vol"), rs.getString("destination"),rs.getString("ville_depart"),rs.getString("type_v")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieCrudController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       numvolColumn.setCellValueFactory(new PropertyValueFactory<>("num_vol"));
        datevolColumn.setCellValueFactory(new PropertyValueFactory<>("date_vol"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
        villedepartColumn.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
          typevolColumn.setCellValueFactory(new PropertyValueFactory<>("type_v"));


        
        TableView.setItems(List);
        TableView.refresh();
    }
    
}
