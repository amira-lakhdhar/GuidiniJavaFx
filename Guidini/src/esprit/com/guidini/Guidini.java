/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.guidini;
import esprit.com.Imservices.Imcompagnieaerienne;
import esprit.com.Imservices.Imvol;
import esprit.com.Imservices.Imvoyage;
import esprit.com.entity.vol;
import esprit.com.utils.ConnectionBd;
/**
 *
 * @author mouna
 */
public class Guidini {
public static void main(String[] args) {

         Imvol im = new Imvol();
         Imcompagnieaerienne ic = new Imcompagnieaerienne ();
         Imvoyage iv = new Imvoyage () ;
         //   for (int i = 0; i < 10; i++) {

           // }
           
         im.ajouter(new vol("test num_vol","test date_vol","test destination","test ville_depart","test type_v"));
                  
                         
                //  im.supprimer(new vol(2));
                
       // im.modifier(new vol(3,"test num_vol3","test date_vol3","test destination","test ville_depart","test type_v"));
       
         //   System.out.println(im.afficher());
         
                     // System.out.println(im.recherche(new vol(3)));
                     
                     
                     // _________________________ Table vol ______________________________________

        }
        }
