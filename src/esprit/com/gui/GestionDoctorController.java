/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;


import esprit.com.entity.Doctor;
import esprit.com.Imservices.DoctorServiceImpl;
import esprit.com.utils.AlertBox;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * FXML Controller class
 *
 * @author amira
 */
public class GestionDoctorController implements Initializable {

    @FXML
    private TextField TfName;
    @FXML
    private TextField TfPhone;
    @FXML
    private TextField TfSpeciality;
    @FXML
    private TableView<Doctor> tvdocteur;
    @FXML
    private TableColumn<Doctor, Integer> colId;
    @FXML
    private TableColumn<Doctor, String> colName;
    @FXML
    private TableColumn<Doctor, String> colPhone;
    @FXML
    private Button btnRetour;
    @FXML
    private TableColumn<Doctor, String> colSpeciality;
    @FXML
    private TableColumn<Doctor, String> colLocation;
    @FXML
    private TextField tfrecherche;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField tfLocation;
    private DoctorServiceImpl sv= new DoctorServiceImpl(0);
    @FXML
    private Label lbId;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnimg;
    @FXML
    private ImageView imgview;
    @FXML
    private Label lbnomimg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GetDoctors();

    }    


    @FXML
    private void OnclickRetour(ActionEvent event) {
         Stage stage = (Stage) btnRetour.getScene().getWindow();
    // do what you have to do
    stage.close();
        
    }
    
    
    
     @FXML
    private void OnclickAdd(ActionEvent event) {
        
        if((TfPhone.getText().equals("")) || tfLocation.getText().equals("") || TfName.getText().equals("") || TfSpeciality.getText().equals("") ){
            AlertBox.display("Error", "fill all the blanks please !!!");
           
        } else {
        Doctor doctor = new Doctor(TfPhone.getText(), tfLocation.getText(), TfName.getText(), TfSpeciality.getText()); 
        doctor.setImage(lbnomimg.getText());
        sv.add(doctor);
        AlertBox.display("Succes", "Doctor entity is added! ");  
        GetDoctors();
        Reset();  
        }
            
    }
    
    public void Reset(){
        TfPhone.setText("");
        tfLocation.setText("");
        TfName.setText("");
        TfSpeciality.setText("");
        lbId.setText("");
    }
    
    @FXML
    private void TableClicked(MouseEvent event) {
        imgview.setImage(null);
        Doctor doctor= tvdocteur.getSelectionModel().getSelectedItem();
        TfPhone.setText(doctor.getPhone());
        tfLocation.setText(doctor.getLocation());
        TfName.setText(doctor.getName());
        TfSpeciality.setText(doctor.getSpeciality());
        lbId.setText(String.valueOf(doctor.getId()));
        String img=doctor.getImage().replace("\\", "\\\\");
        Image image = new Image("file:///"+img);
        imgview.setImage(image);
        System.out.println(doctor.getId());
    }
    
    @FXML
    private void OnclickDelete(ActionEvent event) {
        if(lbId.getText().equals("")){
            AlertBox.display("Error", "Choose a doctor please !"); 
        }else {
           Doctor doctor = new Doctor(Integer.parseInt(lbId.getText()));    
           sv.delete(doctor.getId());
           AlertBox.display("Succes", "Docotr deleted !");  
           GetDoctors();
           Reset(); 
        }
    }

    @FXML
    private void OnclickModifier(ActionEvent event) {
        if((TfPhone.getText().equals("")) || tfLocation.getText().equals("") || TfName.getText().equals("") || TfSpeciality.getText().equals("") || lbId.getText().equals("") ){
            AlertBox.display("Error", "fill all the blanks please !!!");
           
        } else {
        Doctor doctor = new Doctor(Integer.parseInt(lbId.getText()),TfPhone.getText(), tfLocation.getText(), TfName.getText(), TfSpeciality.getText());    
        doctor.setImage(lbnomimg.getText());
        sv.update(doctor);
        AlertBox.display("Succes", "Doctor updated !");  
        GetDoctors();
        Reset();  
        }
         
    }

    
    
    public void GetDoctors(){
        
        
        ObservableList<Doctor> list = sv.getAll();
        
    colId.setCellValueFactory(new PropertyValueFactory<>("id")); 
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));       
    colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));       
    colSpeciality.setCellValueFactory(new PropertyValueFactory<>("speciality"));
    colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

        
        tvdocteur.setItems(list);
         FilteredList<Doctor> filteredData = new FilteredList<>(list, b -> true);
		
		tfrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Doctor -> {		
				if (newValue == null || newValue.isEmpty()) {
					return true;       
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Doctor.getName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}else if (Doctor.getPhone().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}else if (Doctor.getLocation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}else if (Doctor.getSpeciality().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else  
				    	 return false; 
			});
		});

		SortedList<Doctor> sortedData = new SortedList<>(filteredData);
		

		sortedData.comparatorProperty().bind(tvdocteur.comparatorProperty());
		

		tvdocteur.setItems(sortedData);

    
    }

    @FXML
    private void insertimg(ActionEvent event) throws IOException {
        FileChooser chooser=new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG FILE","*.jpg"));
        chooser.setTitle("Choose Image");
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        File file=chooser.showOpenDialog(stage);
        if(file !=null){
        String filename=file.getAbsolutePath();
        filename=filename.replace("\\" , "\\\\");
         String rndchars = RandomStringUtils.randomAlphanumeric(16);
            try {
        

               Path save=Paths.get("C:\\Users\\Amir\\Desktop\\Guidini Yosr\\src\\esprit\\com\\Image"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
        String pathbd=save.toString().replace("\\" , "\\\\");
        lbnomimg.setText(pathbd);
            System.out.println(save); 
            } catch (java.nio.file.FileAlreadyExistsException e) {
               Path save=Paths.get("C:\\Users\\Amir\\Desktop\\Guidini Yosr\\src\\esprit\\com\\Image"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
                String pathbd=save.toString().replace("\\" , "\\\\");
        lbnomimg.setVisible(false);
        lbnomimg.setText(pathbd);
            System.out.println(save); 
            }
        
        Image img=new Image("file:///"+filename);
        imgview.setImage(img);
        }
    }

    

    
   
}
