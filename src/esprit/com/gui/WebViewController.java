/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

/**
 * FXML Controller class
 *
 * @author iHoussem
 */
public class WebViewController implements Initializable {

    @FXML
    private WebView mapView;
    private WebEngine engine;
    @FXML
    private Button btnRetour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       engine=mapView.getEngine();
        try {
            loadPage();// TODO
//       engine.load("file:///C:\\map\\sample.html");
//        if (engine.getDocument()==null) {
//            System.out.println("saj");
//        }
//        DOMDocument doc =(DOMDocument) engine.getDocument();
//        DOMElement adress=doc.findElement(By.id("pac-input"));
//        DOMInputElement adresss=(DOMInputElement) adress;
//        adress.setTextContent(nom);
//        adress.click();
        } catch (IOException ex) {
            Logger.getLogger(WebViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    public void loadPage() throws IOException{
        File htmlTemplateFile = new File("C:\\map\\index.js");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile);
        String data = "\""+BonneAdresseController.adresses+ " ,Near "+BonneAdresseController.regions+"\"";
        System.out.println(data);
        
        htmlString = htmlString.replace("$data", data);
        File newHtmlFile = new File("C:\\map\\new.js");
        FileUtils.writeStringToFile(newHtmlFile, htmlString);
        engine.load("file:///C:\\map\\sample.html");
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("BonneAdresse.fxml"));
                Parent Ajouter = (Parent)loader.load();
  
                Scene scene = new Scene(Ajouter);     
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }
}
    
   
