/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package esprit.com.guidini;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author yosrs
 */
public class MainGUI extends Application {

    
    /* public void start(Stage stage) throws Exception {
         Parent parent = (Parent) FXMLLoader.load(getClass().getResource(
                "/views/crudGUI.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Game Nation");
        stage.show();
        
    }*/
    @Override
    public void start(Stage stage) throws Exception {

          Parent root = FXMLLoader.load(getClass().getResource("../gui/UtilisateurCrud.fxml"));
      //  Parent root = FXMLLoader.load(getClass().getResource("../gui/ReclamationCrud.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("../gui/AfficherEvent.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}