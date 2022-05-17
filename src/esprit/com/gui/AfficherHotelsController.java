/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import esprit.com.Imservices.ServiceHotel;
import esprit.com.entity.Hotel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class AfficherHotelsController implements Initializable {

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
          ObservableList<Hotel> obshotellist=FXCollections.observableArrayList();
    @FXML
    private TableView<Hotel> tablehotel;
    @FXML
    private Button btedit;
    @FXML
    private TextField mNomhotel;
    @FXML
    private TextField madresse;
    @FXML
    private TextField metoile;
    @FXML
    private TextField mnbrchambre;
    @FXML
    private TextField mphoto;
    private Hotel hotel;
    @FXML
    private RadioButton triNomhotel;
    @FXML
    private RadioButton Idnbrc;
    @FXML
    private TextField txtsearch;
    @FXML
    private Button idajout;
    @FXML
    private Button btnQr;
    @FXML
    private Button img;
    @FXML
    private ImageView imageview;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
         
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
       txtsearch.textProperty().addListener((obs, oldText, newText) -> {
                List<Hotel> ae = sH.rechercherHotel(newText);
                tablehotel.getItems().setAll(ae);

        });
    }  
        @FXML

    private void delete(ActionEvent event) throws IOException, SQLException {
                    ServiceHotel sH = new ServiceHotel();
                    Hotel t=new Hotel();

        
      ObservableList obshotellist,a;
    obshotellist=tablehotel.getItems();
      a=tablehotel.getSelectionModel().getSelectedItems();
            t=tablehotel.getSelectionModel().getSelectedItems().get(0);

      sH.supprimer(new Hotel(t.getIdhotel()));

        System.out.println(t);
                System.out.println(a);

        
      a.forEach(obshotellist::remove);
            
            
          // ListCompetition.getItems()
//             competitions = serviceCompetition.AfficherCompetition();
        
        
      
            
        
        
           clearFields();


             
             
    }

    @FXML
    private void onTableItemSelect(MouseEvent event) {
        mNomhotel.opacityProperty();
  hotel = tablehotel.getSelectionModel().getSelectedItem();
      mNomhotel.setText(hotel.getNomhotel());
      madresse.setText(hotel.getAdresse());
     metoile.setText(String.valueOf(hotel.getEtoile()));
      mnbrchambre.setText(String.valueOf(hotel.getNbrChambre()));
      mphoto.setText(hotel.getPhoto());
            //mphoto.setText(hotel.getPhoto());
            

      
    }
     public void clearFields(){
       mNomhotel.clear();
        madresse.clear();
        metoile.clear();
        mnbrchambre.clear();
        mphoto.clear();
    }

    @FXML
    private void onUpdateAgence(ActionEvent event) {
        ServiceHotel sH= new ServiceHotel();
      
       
       hotel.setNomhotel(mNomhotel.getText());
       hotel.setAdresse(madresse.getText());
           hotel.setEtoile(Integer.parseInt(metoile.getText()));

          hotel.setNbrChambre(Integer.parseInt(mnbrchambre.getText()));
                 hotel.setPhoto(mphoto.getText());

       

      
      sH.modifier(new Hotel(hotel.getIdhotel(),mNomhotel.getText(),madresse.getText(),Integer.parseInt(metoile.getText()),Integer.parseInt(mnbrchambre.getText()),mphoto.getText()));
      
     new Alert(Alert.AlertType.INFORMATION,"ok",ButtonType.CLOSE).show();
     clearFields();
     obshotellist.set(tablehotel.getSelectionModel().getFocusedIndex(),hotel);
    }

    @FXML
    private void trierNomhotel(ActionEvent event) {
        ServiceHotel sH= new ServiceHotel();
        Hotel t=new Hotel();
      List<Hotel> a = sH.TRIHotel();
         idnomhotel.setCellValueFactory(new PropertyValueFactory<>("nomhotel"));

         idadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
           idetoile.setCellValueFactory(new PropertyValueFactory<>("etoile"));
             idnbrchambre.setCellValueFactory(new PropertyValueFactory<>("nbrChambre"));
             idphoto.setCellValueFactory(new PropertyValueFactory<>("photo"));


         ObservableList<Hotel> data=FXCollections.observableArrayList(a);
         tablehotel.getItems().setAll(a);            
         System.out.println(t);
    }

    @FXML
    private void triNbrchambre(ActionEvent event) {
         ServiceHotel sH= new ServiceHotel();
        Hotel t=new Hotel();
      List<Hotel> a = sH.TRIHotelNbrchambre();;
         idnomhotel.setCellValueFactory(new PropertyValueFactory<>("nomhotel"));

         idadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
           idetoile.setCellValueFactory(new PropertyValueFactory<>("etoile"));
             idnbrchambre.setCellValueFactory(new PropertyValueFactory<>("nbrChambre"));
             idphoto.setCellValueFactory(new PropertyValueFactory<>("photo"));


         ObservableList<Hotel> data=FXCollections.observableArrayList(a);
         tablehotel.getItems().setAll(a);            
         System.out.println(t);
    }

    @FXML
    private void getview(MouseEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("ajouterHotels.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    @FXML
    private void retourmenu(ActionEvent event) throws IOException {
            
           Parent page2 = FXMLLoader.load(getClass().getResource("menu.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    @FXML
    private void fnQr(ActionEvent event) {
           mNomhotel.opacityProperty();
  hotel = tablehotel.getSelectionModel().getSelectedItem();
      mNomhotel.setText(hotel.getNomhotel());
      madresse.setText(hotel.getAdresse());
     metoile.setText(String.valueOf(hotel.getEtoile()));
      mnbrchambre.setText(String.valueOf(hotel.getNbrChambre()));
      mphoto.setText(hotel.getPhoto());
         String text="Name: "+mNomhotel.getText()+"\n Adress: "+madresse.getText()+"\n NbrEtoile: "+metoile.getText()+"";
       Stage primaryStage=new Stage();
           
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = text;
        int width = 300;
        int height = 300;
        String fileType = "png";
         
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, 300, 300);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
             
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
             
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
             
            System.out.println("Success...");
             
        } catch (WriterException ex) {
           
        }
         
        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
         
        StackPane root = new StackPane();
        root.getChildren().add(qrView);
         
        Scene scene = new Scene(root, 350, 350);
         
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @FXML
    private void addImage(ActionEvent event) {
       FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageview.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }



     




