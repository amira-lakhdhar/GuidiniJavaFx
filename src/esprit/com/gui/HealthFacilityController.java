/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import esprit.com.Imservices.HopitalServiceImpl;
import esprit.com.Imservices.PharmacyServiceImpl;
import esprit.com.entity.Hopital;
import esprit.com.entity.Pharmacy;
import esprit.com.entity.Pharmacy.Hourly;
import esprit.com.utils.AlertBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class HealthFacilityController implements Initializable {

   
    @FXML
    private TextField TfName;
    @FXML
    private TextField TfPhone;
    @FXML
    private TextField TfEmail;
    @FXML
    private Button BtnAdd;
    @FXML
    private TableView<Pharmacy> tvHealthFacility;
    @FXML
    private TableColumn<Pharmacy, String> colName;
    @FXML
    private TableColumn<Pharmacy, String> colPhone;
    @FXML
    private TableColumn<Pharmacy, String> colEmail;
    @FXML
    private TableColumn<Pharmacy, String> colLocation;
    @FXML
    private TableColumn<Pharmacy, Integer> colScore;
    @FXML
    private TableColumn<Pharmacy, String> colHourly;
    @FXML
    private Button btnDelete;
    @FXML
    private Button BtnModify;
    @FXML
    private Label lbhourly;
    private  ObservableList<String> Type = FXCollections.observableArrayList("Pharmacy","Hospital");
    private  ObservableList<String> Hourlys = FXCollections.observableArrayList("Day","Night");
    @FXML
    private ComboBox<String> ComboxHourly;
    @FXML
    private ComboBox<String> ComboxType;
    
    private PharmacyServiceImpl svph=new PharmacyServiceImpl();
    
    private HopitalServiceImpl svhop=new HopitalServiceImpl();
    @FXML
    private TableColumn<Pharmacy, String> colId;
    @FXML
    private TextField tfrecherche;
    @FXML
    private TextField tfLocation;
    @FXML
    private TextField tfScore;
    @FXML
    private Label lbId;
    @FXML
    private Button btnRetour;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    ComboxHourly.setItems(Hourlys);
    ComboxType.setItems(Type);
    //ComboxType.setValue("Pharmacy");
    //GetHealthFacility();
    }    

    @FXML
    private void OnModifyClicked(ActionEvent event) throws SQLException {
        if((TfPhone.getText().equals("")) || TfEmail.getText().equals("") || TfName.getText().equals("") || tfLocation.getText().equals("")|| tfScore.getText().equals("") ){
            AlertBox.display("Error", "fill all the blanks please !!!");
           
        } else {
            if(ComboxType.getValue().equals("Pharmacy")){
                Pharmacy pharmacy = new Pharmacy(Integer.parseInt(lbId.getText()),TfPhone.getText(), TfEmail.getText(), TfName.getText() , tfLocation.getText(), Integer.parseInt(tfScore.getText())); 
                pharmacy.setHourly(Hourly.valueOf(ComboxHourly.getValue().toLowerCase()));
               svph.update(pharmacy);
               String msg="Pharmacy updated ";
               //               SendSMS(msg);
               AlertBox.display("Succes", "Pharmacy updated ! ");
               GetHealthFacility();
                Reset();  
            }else{
               Hopital hopital = new Hopital(Integer.parseInt(lbId.getText()),TfPhone.getText(), TfEmail.getText(), TfName.getText() , tfLocation.getText(), Integer.parseInt(tfScore.getText())); 
               svhop.update(hopital);
               String msg="hopital updated";
               SendSMS(msg);
               AlertBox.display("Succes", "hopital updated !");
               
                GetHealthFacility();
               Reset();   
            }
        
        }
        
    }

    @FXML
    private void OnClicktv(MouseEvent event) {
         Pharmacy pharmacy= tvHealthFacility.getSelectionModel().getSelectedItem();
        TfPhone.setText(pharmacy.getPhone());
        tfLocation.setText(pharmacy.getLocation());
        TfName.setText(pharmacy.getName());
        TfEmail.setText(pharmacy.getEmail());
        tfScore.setText(String.valueOf(pharmacy.getScore()));
        
        lbId.setText(String.valueOf(pharmacy.getId()));
        System.out.println(pharmacy.getId());
        if(ComboxType.getValue().equals("Pharmacy")){
            ComboxHourly.setValue(pharmacy.getHourly().toString());
        }
        
    }

    @FXML
    private void OndeleteClicked(ActionEvent event) throws SQLException {
        if((TfPhone.getText().equals("")) || TfEmail.getText().equals("") || TfName.getText().equals("") || tfLocation.getText().equals("")|| lbId.getText().equals("") ){
            AlertBox.display("Error", "Choose someone Please !!!");
           
        } else {
            if(ComboxType.getValue().equals("Pharmacy")){
                Pharmacy pharmacy = new Pharmacy(Integer.parseInt(lbId.getText())); 
               svph.delete(pharmacy.getId());
               String msg="Pharmacy Deleted";
              // SendSMS(msg);
               AlertBox.display("Succes", "Pharmacy Deleted ! ");  
               GetHealthFacility();
                Reset();  
            }else{
               Hopital hopital = new Hopital(Integer.parseInt(lbId.getText())); 
               svhop.delete(hopital.getId());
               String msg="hopital Deleted";
               SendSMS(msg);
               AlertBox.display("Succes", "hopital Deleted !");  
                GetHealthFacility();
               Reset();   
            }
        
        }
    }

    @FXML
    private void OnaddClicked(ActionEvent event) throws SQLException {
        if((TfPhone.getText().equals("")) || TfEmail.getText().equals("") || TfName.getText().equals("") || tfLocation.getText().equals("")|| tfScore.getText().equals("") ){
            AlertBox.display("Error", "fill all the blanks please !!!");
           
        } else {
            if(ComboxType.getValue().equals("Pharmacy")){
                
                Pharmacy pharmacy = new Pharmacy(TfPhone.getText(), TfEmail.getText(), TfName.getText() , tfLocation.getText(), Integer.parseInt(tfScore.getText())); 
                pharmacy.setHourly(Hourly.valueOf(ComboxHourly.getValue().toLowerCase()));
               svph.add(pharmacy);
               String msg="Pharmacy is added";
               // SendSMS(msg);
               
               AlertBox.display("Succes", "Pharmacy entity is added! ");  
               GetHealthFacility();
                Reset();  
                
            }else{
               Hopital hopital = new Hopital(TfPhone.getText(), TfEmail.getText(), TfName.getText() , tfLocation.getText(), Integer.parseInt(tfScore.getText())); 
               svhop.add(hopital);
               String msg="Hospital entity is added";
               SendSMS(msg);
               AlertBox.display("Succes", "Hospital entity is added! ");  
                GetHealthFacility();
               Reset();   
            }
        
        }
        
    }

    @FXML
    private void OnclickType(ActionEvent event) {
        if(ComboxType.getValue().equals("Hospital")){
         colHourly.setVisible(false);
         ComboxHourly.setVisible(false);
         lbhourly.setVisible(false);
         GetHealthFacility();
        }else{
         colHourly.setVisible(true);
         ComboxHourly.setVisible(true);
         lbhourly.setVisible(true);
         GetHealthFacility();
        }
    }
    
    public void Reset(){
        TfPhone.setText("");
        tfLocation.setText("");
        TfName.setText("");
        TfEmail.setText("");
        tfScore.setText("");
        ComboxHourly.setValue("");
        lbId.setText("");
    }
    
    public void GetHealthFacility(){
        
        if(ComboxType.getValue().equals("Pharmacy")){
            ObservableList<Pharmacy> list = svph.getAll();
        
    colId.setCellValueFactory(new PropertyValueFactory<>("id")); 
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));       
    colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));       
    colHourly.setCellValueFactory(new PropertyValueFactory<>("Hourly"));
    colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
    colScore.setCellValueFactory(new PropertyValueFactory<>("score"));
    colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        
        tvHealthFacility.setItems(list);
        
         FilteredList<Pharmacy> filteredData = new FilteredList<>(list, b -> true);
		
		tfrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Pharmacy -> {		
				if (newValue == null || newValue.isEmpty()) {
					return true;       
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Pharmacy.getName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}else if (Pharmacy.getPhone().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}else if (Pharmacy.getLocation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}else if (Pharmacy.getHourly().equals(lowerCaseFilter)) {
					return true;
				}else if (Pharmacy.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else  
				    	 return false; 
			});
		});

		SortedList<Pharmacy> sortedData = new SortedList<>(filteredData);
		

		sortedData.comparatorProperty().bind(tvHealthFacility.comparatorProperty());
		

		tvHealthFacility.setItems(sortedData);
        }else
        {
            ObservableList<Pharmacy> list = svph.getAllHospital();
        
    colId.setCellValueFactory(new PropertyValueFactory<>("id")); 
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));       
    colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
    colScore.setCellValueFactory(new PropertyValueFactory<>("score"));
    colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        
        tvHealthFacility.setItems(list);
        
         FilteredList<Pharmacy> filteredData = new FilteredList<>(list, b -> true);
		
		tfrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Hospital -> {		
				if (newValue == null || newValue.isEmpty()) {
					return true;       
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Hospital.getName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}else if (Hospital.getPhone().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}else if (Hospital.getLocation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}else if (Hospital.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else  
				    	 return false; 
			});
		});

		SortedList<Pharmacy> sortedData = new SortedList<>(filteredData);
		

		sortedData.comparatorProperty().bind(tvHealthFacility.comparatorProperty());
		

		tvHealthFacility.setItems(sortedData);
        }
        

    
    }

    @FXML
    private void OnclickRetour(ActionEvent event) {
        Stage stage = (Stage) btnRetour.getScene().getWindow();
       stage.close();
    }
    
    public void SendSMS(String msg) throws SQLException
    {
        
        Twilio.init("AC6f15ff6996e9b275c9ffb80f38aad3f4","a299126b8eb9775e7443eef50e52dbc9");
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(TfPhone.getText()),
                new com.twilio.type.PhoneNumber("+14123079450"),
                "Hello, "+TfName.getText()+" ,Your "+msg)
            .create();

        System.out.println(message.getSid());
    }
                 
                 
    
    
}
