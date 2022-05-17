/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import esprit.com.Imservices.ImEvenement;
import esprit.com.Imservices.ReservService;
import esprit.com.entity.Evenement;
import esprit.com.entity.Reservere;
import esprit.com.utils.ConnectionBd;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReserverController implements Initializable {

    @FXML
    private TableView<Evenement> events;
    @FXML
    private TableColumn<Evenement, String> date;
    @FXML
    private TableColumn<Evenement, String> nom;
    @FXML
    private TableColumn<Evenement, String> type;
    @FXML
    private TableColumn<Evenement, Integer> id;
    @FXML
    private DatePicker dater;
    @FXML
    private ComboBox<String> com1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        com1.setPromptText("Les Evenements");
        ResultSet rs1 = null;
            
          
            try {
                Connection cnx = ConnectionBd.getInstance().getCnx();
                rs1 = cnx.createStatement().executeQuery("SELECT nom_Evenement FROM evenement");
            } catch (SQLException ex) {
                
            }
            try {
                while (rs1.next()) {  // loop
                    
                    // Now add the comboBox addAll statement
                    com1.getItems().addAll(rs1.getString("nom_Evenement"));
                    
                }} catch (SQLException ex) {
                  
                }
            afficher();
        // TODO
    }    

    @FXML
    private void rowClicked(MouseEvent event) {
    }

    @FXML
    private void AjouterR(ActionEvent event) {
        if(controleDeSaisi()){
          ResultSet rs6 = null;
      
        Connection cnx = ConnectionBd.getInstance().getCnx();
        String j =com1.getValue();
        String date = dater.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ReservService sr = new ReservService();
        
        sr.Ajouter(new Reservere(date,1,j));
        
       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("réeservation ajoutée");
                
                alert.showAndWait();
    }}
 ImEvenement si = new ImEvenement();
        List<Evenement> list = new ArrayList();
                   
public void afficher(){
        list = si.afficher();
    ObservableList<Evenement> list1 =FXCollections.observableArrayList(list);
   id.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("id_E")); 
nom.setCellValueFactory(new PropertyValueFactory<Evenement, String>("nom_Evenement"));
date.setCellValueFactory(new PropertyValueFactory<Evenement, String>("date_Evenement"));
type.setCellValueFactory(new PropertyValueFactory<Evenement, String>("type_Evenement"));
events.setItems(list1);
}
     private boolean controleDeSaisi() {  

        if (com1.getItems().isEmpty() || dater.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Veuillez bien remplir tous les champs !");
            return false;
        

            
            
           
        }
        return true;
    }
       
       public static void showAlert(Alert.AlertType type, String title, String header, String text) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();

    }
    
}
