/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import esprit.com.Imservices.ServiceHotel;
import esprit.com.entity.Hotel;
import static esprit.com.gui.UtilisateurCrudController.user;
import esprit.com.utils.AlertBox;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amir
 */
public class ReservationHotelUserController implements Initializable {

    @FXML
    private TableView<Hotel> tablehotel;
    @FXML
    private TableColumn<Hotel, Integer> idhotel;
    @FXML
    private TableColumn<Hotel, String> idnomhotel;
    @FXML
    private TableColumn<Hotel, String> idadresse;
    @FXML
    private TableColumn<Hotel, Integer> idetoile;
    @FXML
    private TableColumn<Hotel, Integer> idnbrchambre;
    @FXML
    private TableColumn<Hotel, String> idphoto;
    @FXML
    private Button btnReserver;
    ObservableList<Hotel> obshotellist=FXCollections.observableArrayList();
    @FXML
    private Label lbtest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceHotel sH = new ServiceHotel();
        sH.afficher().stream().forEach((p) -> {obshotellist.add(p);});
        
      // col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
      // idhotel.setCellValueFactory(new PropertyValueFactory<>("idhotel"));
      idnomhotel.setCellValueFactory(new PropertyValueFactory<>("nomhotel"));
       idadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        idetoile.setCellValueFactory(new PropertyValueFactory<>("etoile"));
       idnbrchambre.setCellValueFactory(new PropertyValueFactory<>("nbrChambre"));
        idphoto.setCellValueFactory(new PropertyValueFactory<>("photo"));
        
       tablehotel.setItems(obshotellist);
       
        // TODO
    }    

    @FXML
    private void onTableItemSelect(MouseEvent event) {
        lbtest.setText("j");
    }

    @FXML
    private void retourmenu(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("User.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }

    @FXML
    private void FnReserver(ActionEvent event) {
        if (lbtest.getText()== "") {

            AlertBox.display("ERORR!", "Choisie un hotel ! ");

     
        }else{
            AlertBox.display("OK!", "votre Reservation a été enregistré avec success ! ");
        }
    }
    
}
