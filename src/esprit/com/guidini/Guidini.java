

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.guidini;
import esprit.com.Imservices.ImReclamation;
import esprit.com.Imservices.ImUtilisateur;
import esprit.com.entity.Utilisateur;
import esprit.com.utils.ConnectionBd;
/**
 *
 * @author yosr
 */
public class Guidini {
public static void main(String[] args) {

         ImUtilisateur im = new ImUtilisateur();
         ImReclamation ic = new ImReclamation ();
        
         //   for (int i = 0; i < 10; i++) {

           // }
           
         im.ajouter(new Utilisateur("test nom","test prenom","test adresse","test email","test motpass","test role"));
                  
                         
                //  im.supprimer(new Utilisateur(2));
                
       // im.modifier(new Utilisateur(3,"test nom3","test prenom3","test adresse","test email","test motpass","test role"));
       
         //   System.out.println(im.afficher());
         
                     // System.out.println(im.recherche(new Utilisateur(3)));
                     
                     
                     // _________________________ Table Utilisateur ______________________________________

        }
        }
