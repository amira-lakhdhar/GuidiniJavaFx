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
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ResBack_1Controller implements Initializable {

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
    private DatePicker dater;
    private ComboBox<String> com1;
    @FXML
    private Label tid;
    @FXML
    private Button bReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             
        afiicher();
    }    

    @FXML
    private void rowClicked(MouseEvent event) {
    }
    ReservService si = new ReservService();
        List<Evenement> list = new ArrayList();
     public void afiicher(){
        list = si.afficherv2();
    ObservableList<Evenement> list1 =FXCollections.observableArrayList(list);
   id.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("id_E")); 
nom.setCellValueFactory(new PropertyValueFactory<Evenement, String>("nom_Evenement"));
date.setCellValueFactory(new PropertyValueFactory<Evenement, String>("date_Evenement"));
type.setCellValueFactory(new PropertyValueFactory<Evenement, String>("type_Evenement"));
events.setItems(list1);
    events.setItems(list1);
    }

    private void AjouterR(ActionEvent event) {
        ResultSet rs6 = null;
      
        Connection cnx = ConnectionBd.getInstance().getCnx();
        String j =(String) com1.getValue();
        String date = dater.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ReservService sr = new ReservService();
        
        sr.Ajouter(new Reservere(date,1,j));
        
       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("réeservation ajoutée");
                afiicher() ;
                alert.showAndWait();
    }


    @FXML
    private void bReturn(ActionEvent event) throws IOException {
        
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } 
    

   

         
    }
    

