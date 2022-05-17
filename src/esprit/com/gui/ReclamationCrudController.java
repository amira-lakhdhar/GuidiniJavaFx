/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package esprit.com.gui;

import esprit.com.Imservices.ImReclamation;
import esprit.com.Imservices.ImUtilisateur;
import esprit.com.entity.Reclamation;
import static esprit.com.gui.UtilisateurCrudController.user;
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
 * @author yosr
 */
public class ReclamationCrudController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfreclamation;
    private TableView<Reclamation> TableView;
    private TableColumn<Reclamation, String> nomColumn;
    private TableColumn<Reclamation, String> titreColumn;
    private TableColumn<Reclamation, String> reclamationColumn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button updateButton;
    @FXML
    private Button insertButton;
    @FXML
    private ChoiceBox<String> cbCriteria;
    @FXML
    private TextField tfsearch;
    @FXML
    private Button BtnRetour;
    @FXML
    private TableView<Reclamation> tvreclamation;
    @FXML
    private TableColumn<Reclamation, Integer> colId;
    @FXML
    private TableColumn<Reclamation, String> ColTitre;
    @FXML
    private TableColumn<Reclamation, String> ColReclamation;
    private ImReclamation sp = new ImReclamation();
    @FXML
    private TableColumn<Reclamation, String> ColType;
    @FXML
    private Label lbid;
   
    ImUtilisateur svu=new ImUtilisateur();
    private  ObservableList<String> Critere = FXCollections.observableArrayList("Interface","Code");

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbCriteria.setItems(Critere);
        GetReclamation();
        
    }    

    @FXML
    private void Selection(MouseEvent event) {
         Reclamation reclamation= tvreclamation.getSelectionModel().getSelectedItem();
        tfnom.setText(svu.recherche_user(user.getId()).getNom());
        tftitre.setText(reclamation.getTitre());
        tfreclamation.setText(reclamation.getMessage());
        lbid.setText(String.valueOf(reclamation.getId_r()));
        cbCriteria.setValue(reclamation.getType_r());
    }
    private void Reset(){
        tfnom.setText("");
        tftitre.setText("");
        tfreclamation.setText("");
        lbid.setText("");
        
    }
    

    @FXML
    private void deleteButton(ActionEvent event) {
         
        sp.supprimer(new Reclamation(Integer.parseInt(lbid.getText())));
        GetReclamation();
        Reset();
    }

    @FXML
    private void updateButton(ActionEvent event) {
         ImReclamation sp = new ImReclamation();
        sp.modifier(new Reclamation(Integer.parseInt(lbid.getText()), tfreclamation.getText(),cbCriteria.getValue(),tftitre.getText()));
        GetReclamation();
        Reset();
    }

    @FXML
    private void insertButton(ActionEvent event) {
         ImReclamation sp = new ImReclamation();
        sp.ajouter(new Reclamation(tfreclamation.getText(), user.getId(),cbCriteria.getValue(),tftitre.getText()));
               GetReclamation();
               Reset();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
                  FXMLLoader loader=new FXMLLoader(getClass().getResource("User.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
      
    }
    
    
    public void GetReclamation(){
        
        Reclamation reclamation=new Reclamation();
        reclamation.setId_user(user.getId());
        ObservableList<Reclamation> list = sp.recherche(reclamation);
        
    colId.setCellValueFactory(new PropertyValueFactory<>("id_r")); 
    ColTitre.setCellValueFactory(new PropertyValueFactory<>("Titre"));       
    ColReclamation.setCellValueFactory(new PropertyValueFactory<>("message"));
    ColType.setCellValueFactory(new PropertyValueFactory<>("type_r"));

        
        tvreclamation.setItems(list);
         FilteredList<Reclamation> filteredData = new FilteredList<>(list, b -> true);
		
		tfsearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Reclamation -> {		
				if (newValue == null || newValue.isEmpty()) {
					return true;       
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Reclamation.getMessage().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if (Reclamation.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
				    	 return false; 
			});
		});

		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		

		sortedData.comparatorProperty().bind(tvreclamation.comparatorProperty());
		

		tvreclamation.setItems(sortedData);

    
    }
    
}
