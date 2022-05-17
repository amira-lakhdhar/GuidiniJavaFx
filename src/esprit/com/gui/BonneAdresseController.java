/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;


import esprit.com.entity.BoiteDeNuit;
import esprit.com.entity.BonneAdresse;
import esprit.com.entity.Musee;
import esprit.com.entity.Restaurant;
import esprit.com.Imservices.BonneAdresseService;
import esprit.com.utils.AlertBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.ComboBox;
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
 * @author amira
 */
public class BonneAdresseController implements Initializable {

   
    @FXML
    private TextField TfNom;
    @FXML
    private Button BtnAdd;
    @FXML
    private TableView<BonneAdresse> tableBonneAdresse;
    @FXML
    private TableColumn<BonneAdresse, String> colNom;
    @FXML
    private TableColumn<BonneAdresse, String> colType;
    @FXML
    private Button btnDelete;
    @FXML
    private Button BtnModify;

    private  ObservableList<String> Type = FXCollections.observableArrayList("Boite de nuit","Musee","Restaurant");
    @FXML
    private ComboBox<String> ComboxType;
    @FXML
    private TableColumn<BonneAdresse, String> colId;
    @FXML
    private TextField tfrecherche;

    
    private BonneAdresseService bonneAdresseService;
    @FXML
    private TextField tfRegion;
    @FXML
    private TableColumn<BonneAdresse, String> colRegion;
    @FXML
    private TableColumn<BonneAdresse, Float> colRate;
    @FXML
    private Label lbType;
    @FXML
    private Button BtnMap;
    @FXML
    private Button BtnRetour;
    public static String regions;
    public static String adresses;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboxType.setItems(Type);
         GetBonneAdresse();
         
    }    

    @FXML
    private void OnModifyClicked(ActionEvent event) throws SQLException {
        if((TfNom.getText().equals("")) ||
                tfRegion.getText().equals("")   ){
            AlertBox.display("Error", "fill all the blanks please !!!");
           
        }  else {
                 bonneAdresseService = new BonneAdresseService();
                BonneAdresse bonneAdresseTable = tableBonneAdresse.getSelectionModel().getSelectedItem();
  
                BonneAdresse bonneAdresse = new BonneAdresse(bonneAdresseTable.getId(),TfNom.getText(), ComboxType.getValue().toString(), tfRegion.getText() );
               bonneAdresseService.update(bonneAdresse);

                  AlertBox.display("Succes", "Bonne Adresse modifiee ");  
                  GetBonneAdresse();
                   Reset();  
            
        
        }
        
    }

    @FXML
    private void OnClicktv(MouseEvent event) {
         BonneAdresse bonneAdresse = tableBonneAdresse.getSelectionModel().getSelectedItem();
         
        TfNom.setText(bonneAdresse.getNom());
        tfRegion.setText(String.valueOf(bonneAdresse.getRegion()));

        ComboxType.setValue(bonneAdresse.getType());
        
    }

    @FXML
    private void OndeleteClicked(ActionEvent event) throws SQLException {

        if((TfNom.getText().equals("")) ){
            AlertBox.display("Error", "il faut choisir une adresse ");
           
        } else {
            
                BonneAdresse bonneAdresse = tableBonneAdresse.getSelectionModel().getSelectedItem();
                bonneAdresseService = new BonneAdresseService();
                bonneAdresseService.delete(bonneAdresse.getId());

               AlertBox.display("Succes", "Adresse suprimee! ");  
               GetBonneAdresse();
                Reset();  
            
        
        }
    }

    @FXML
    private void OnaddClicked(ActionEvent event) throws SQLException {
        if((TfNom.getText().equals("")) ||
                tfRegion.getText().equals("") ){
            AlertBox.display("Error", "fill all the blanks please !!!");
           
        } else {
            bonneAdresseService = new BonneAdresseService();
                if(ComboxType.getValue().equals("Boite de nuit")){
                    BoiteDeNuit boiteDeNuit = new BoiteDeNuit(TfNom.getText(),tfRegion.getText());
                    bonneAdresseService.add(boiteDeNuit);
                }else if(ComboxType.getValue().equals("Musee")){
                    Musee musee = new Musee(TfNom.getText(), tfRegion.getText());
                    System.out.println(musee);
                    bonneAdresseService.add(musee);
                }else if(ComboxType.getValue().equals("Restaurant")){
                    Restaurant restaurant = new Restaurant(TfNom.getText(), tfRegion.getText());
                    bonneAdresseService.add(restaurant);
                }  
                
                  AlertBox.display("Succes", "Bonne Adresse ajoutee ");  
                  GetBonneAdresse();
                   Reset();  
            
        
        }
        
    }

    
    public void Reset(){
        TfNom.setText("");
        tfRegion.setText("");
        ComboxType.setValue("");
    }

    public void GetBonneAdresse(){
        
        bonneAdresseService = new BonneAdresseService();
      ObservableList<BonneAdresse> list = FXCollections.observableArrayList(bonneAdresseService.getAll());
        

    colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));       
    colType.setCellValueFactory(new PropertyValueFactory<>("type"));
    colRegion.setCellValueFactory(new PropertyValueFactory<>("region"));
    colRate.setCellValueFactory(new PropertyValueFactory<>("rate"));

    tableBonneAdresse.setItems(list);
        
         FilteredList<BonneAdresse> filteredData = new FilteredList<>(list, b -> true);
		
		tfrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Hospital -> {		
				if (newValue == null || newValue.isEmpty()) {
					return true;       
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Hospital.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}else if (Hospital.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else  
				    	 return false; 
			});
		});

		SortedList<BonneAdresse> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tableBonneAdresse.comparatorProperty());
		tableBonneAdresse.setItems(sortedData);
        
    }

    @FXML
    private void fnVoireMap(ActionEvent event) throws IOException {
        regions=tfRegion.getText();
        adresses=TfNom.getText();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("WebView.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
        
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Admin.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }


    
}
