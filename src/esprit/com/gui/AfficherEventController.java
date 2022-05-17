
package esprit.com.gui;

import esprit.com.Imservices.ImEvenement;
import esprit.com.entity.Evenement;
import esprit.com.utils.ConnectionBd;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.activation.DataSource;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficherEventController implements Initializable {

    @FXML
    private TableView<Evenement> events;
    @FXML
    private TableColumn<Evenement, String> date;
    @FXML
    private TableColumn<Evenement, String> nom;
    @FXML
    private TableColumn<Evenement, String> type;
    @FXML
    private TextField rechercheTF;
    @FXML
    private TextField NomE;
    @FXML
    private DatePicker dateE;
    @FXML
    private ComboBox<String> TypeE;
    @FXML
    private Button addBtn;
    @FXML
    private Button modifBtn;
    private Stage primaryStage1;
    @FXML
    private Button delBtn;
    @FXML
    private Label idLBL;
    private ObservableList<Evenement> listS = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Evenement, Integer> id;
    @FXML
    private TextField tid;
    private AutoCompletionBinding<String> AutoCompletionBinding;
        ArrayList<String> name = new ArrayList();
    @FXML
    private Button rech;
    @FXML
    private Button affBtn;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list=FXCollections.observableArrayList("Festival","Carnaval");
TypeE.setItems(list);
afficher();
 Connection cnx = ConnectionBd.getInstance().getCnx();
        try {
            ResultSet rs8 = cnx.createStatement().executeQuery("SELECT nom_Evenement FROM evenement");
            while(rs8.next()){
                name.add(rs8.getString("nom_Evenement"));
               
            }
        } catch (SQLException ex) {
            
        }
        TextFields.bindAutoCompletion(rechercheTF,name);

// TODO
    }
    

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
    

    @FXML
    private void rowClicked(MouseEvent event) {
    }

    @FXML
    private void rechercheTextChanged(KeyEvent event) {
    }

    @FXML
    private void addE(ActionEvent event) {
         if (controleDeSaisi()) {
        si.ajouter(new Evenement(dateE.getValue().toString(), NomE.getText(), TypeE.getSelectionModel().getSelectedItem()));
        JOptionPane.showMessageDialog(null, "Evenement Ajouté");
        afficher();}

    }
//moatez
    @FXML
    private void modifE(ActionEvent event) throws SQLException {
        Connection cnx = ConnectionBd.getInstance().getCnx();
         if (controleDeSaisi()) {
            //
             
             String value4 = dateE.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
             int id = Integer.parseInt(tid.getText());
             String ty = TypeE.getValue();
             String nom = NomE.getText();
             String req = "UPDATE evenement SET date_Evenement= '"+value4+"',nom_Evenement='"+nom+"',type_Evenement='"+ty+"' WHERE id_E='"+id+"'";
             PreparedStatement pst = cnx.prepareStatement(req);
            pst= cnx.prepareStatement(req);
            pst.execute();
             afficher();
             
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succées");
        alert.setHeaderText(null);
        alert.setContentText("la modification a été effectué avec succées");
        alert.showAndWait();}
    }
   

    @FXML
    private void deleteE(ActionEvent event) throws SQLException {
         
            int i = Integer.parseInt(tid.getText());
            ImEvenement cat = new ImEvenement();

            int s = cat.deleteE(i);
         
            if (s == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("event deleted");
                
                alert.showAndWait();
                events.refresh();
                UpdateE();
            }    
    }
    
   public Evenement gettempEvent(TableColumn.CellEditEvent edittedCell) {
        Evenement test = events.getSelectionModel().getSelectedItem();
        return test;
    }
//moi
    @FXML
    private void affE(ActionEvent event) {
//         Evenement service = new Evenement();
//         ObservableList<Evenement> liste = service.afficher();
        Evenement e = events.getSelectionModel().getSelectedItem();
        DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      // parsing the string to convert it into date
      LocalDate local_date = LocalDate.parse(e.getDate());
        dateE.setValue(local_date);
        NomE.setText(e.getNom_Evenement());
        TypeE.setValue(e.getType_Evenement());
        tid.setText(String.valueOf(e.getId_E()));
          afficher();
//         affBtn.setItems(liste);
//         events.setItems(list);
    }
    
//    @FXML
//    private void affE(ActionEvent event) {
//        Evenement service = new Evenement();
//
//        ObservableList<Evenement> liste = service.AfficherEvenement();
//
//        Cid.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
//        Cnom.setCellValueFactory(new PropertyValueFactory<>("nomEvent"));
//        Cdate.setCellValueFactory(new PropertyValueFactory<>("date"));
//        tvAficher.setItems(liste);
//
//    }
    
    

  
    
    private void bReturn(ActionEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AjouterEvent.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } 
     private boolean controleDeSaisi() {  

        if (NomE.getText().isEmpty() || TypeE.getItems().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Veuillez bien remplir tous les champs !");
            return false;
        } else {

            if (!Pattern.matches("[A-z]*", NomE.getText())) {
                showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Vérifiez le Nom ! ");
                NomE.requestFocus();
                NomE.selectEnd();
                return false;
            } 
           
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

    @FXML
    private void search(ActionEvent event) throws SQLException {
        Connection cnx = ConnectionBd.getInstance().getCnx();
      
        String value9 = rechercheTF.getText();
      
            PreparedStatement ps = cnx.prepareStatement("select * from evenement where nom_Evenement Like'"+value9+"'");
            
            ResultSet rs5 = ps.executeQuery();
            
            while (rs5.next()){   
                
                listS.add(new Evenement( rs5.getInt(1),rs5.getString(2), rs5.getString(3), rs5.getString(4)));               
            }
        id.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("id_E"));
        date.setCellValueFactory(new PropertyValueFactory<>("date_Evenement"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom_Evenement"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_Evenement"));
       

         events.setItems(listS);
        rechercheTF.setText("");
    }

    @FXML
    private void refresh(ActionEvent event) {
         list = si.afficher();
    ObservableList<Evenement> list1 =FXCollections.observableArrayList(list);
   id.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("id_E")); 
nom.setCellValueFactory(new PropertyValueFactory<Evenement, String>("nom_Evenement"));
date.setCellValueFactory(new PropertyValueFactory<Evenement, String>("date_Evenement"));
type.setCellValueFactory(new PropertyValueFactory<Evenement, String>("type_Evenement"));
events.setItems(list1);
    }

    @FXML
    private void BPDF(ActionEvent event) {
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(this.primaryStage1); 
            
    Node root = this.events;
    
           job.printPage(root);
           job.endJob();
    }
    }

    @FXML
    private void TOWORD(ActionEvent event) throws FileNotFoundException, IOException {
         XWPFDocument document = new XWPFDocument();
       FileOutputStream out = new FileOutputStream(new File("/demo.docx"));
       XWPFParagraph paragraph = document.createParagraph();
       XWPFRun run = paragraph.createRun();
        
           
            
            LocalDate value2 = dateE.getValue();
            String value3 = NomE.getText();
            String value4 = TypeE.getValue();
           
            String s1 = "";
            s1= s1.concat("     NOM EVENEMENT:"     ).concat("      ").concat(value3.toString()).concat("     TYPE:     ").concat(value4).concat("      DATE:         ").concat(value2.toString());
       run.setText(s1);
       document.write(out);
       out.close();
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("DOCUMENT ENREGISTRE");
                
                alert.showAndWait();
    }
    public void UpdateE(){
        list = si.afficher();
    ObservableList<Evenement> list1 =FXCollections.observableArrayList(list);
   id.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("id_E")); 
nom.setCellValueFactory(new PropertyValueFactory<Evenement, String>("nom_Evenement"));
date.setCellValueFactory(new PropertyValueFactory<Evenement, String>("date_Evenement"));
type.setCellValueFactory(new PropertyValueFactory<Evenement, String>("type_Evenement"));
events.setItems(list1);
    }

    private void move(ActionEvent event) throws IOException {
        
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ResBack_1.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        /*
         Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
            Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource(""));/* Exception */
       
    }

    @FXML
    private void Onclickretour(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Admin.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }
}
