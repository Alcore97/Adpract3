/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultrasophisticatedapp;

import org.me.image.Image;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.ws.WebServiceRef;
import org.me.image.Image;
import org.me.image.ImageWS_Service;
import java.util.ArrayList;
import java.lang.String;

/**
 *
 * @author aleix
 */
public class UltraSophisticatedApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // java.lang.Object a = new Image(); 
       
       System.out.println(" Aplicacio WS \n");
       
       //Inicialitzem alguns valors per defecte. 
       
        String titol = "Undertale";
        String author = "Toby Fox";
        String paraulesclau = "Toriel and Frisk";
        String Fecha = "14/06/2013";
        try{
        int newRegister; 
        
        java.util.List<java.lang.Object> list = new ArrayList<>();
        list = listImages();
        System.out.println("La meva llista es: " + list);
        
        System.out.println("\n Registrem una imatge \n");
            newRegister = registerImage(titol,author,paraulesclau,Fecha); 
           
         System.out.println("\nIntentem llista la nova imatge "+ newRegister+" d'aguna manera:\n");
            list = listImages();
            System.out.println("La meva nova llista es: " + list);
            
            System.out.println("\nModifiquem la imatge nova "+newRegister+" fent:\n");
            modifyImage(newRegister,titol,author,paraulesclau,Fecha); 
        
            System.out.println("\nLListem tota la nova informacio de la imatge amb id:  "+ newRegister+":\n");
            list = listImages();
            System.out.println("La meva nova llista es: " + list);
            
             System.out.println("\nBusquem alguna de les imatges existents:\n");
            //AQUI VA EL QUE FALTA DEL BUSCAR IMATGE TAN COM DE L'APP COM DEL CLIENT
        
        
        }
        catch(java.lang.IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        
    }

    private static java.util.List<java.lang.Object> listImages() {
        org.me.image.ImageWS_Service service = new org.me.image.ImageWS_Service();
        org.me.image.ImageWS port = service.getImageWSPort();
        return port.listImages();
    }

    private static int modifyImage(java.lang.Integer idImag, java.lang.String titulo, java.lang.String author, java.lang.String paraulaclau, java.lang.String fecha) {
        org.me.image.ImageWS_Service service = new org.me.image.ImageWS_Service();
        org.me.image.ImageWS port = service.getImageWSPort();
        return port.modifyImage(titulo,author,paraulaclau,fecha);
    }

   

    private static java.util.List<java.lang.Object> searchByTitle(java.lang.String titol) {
        org.me.image.ImageWS_Service service = new org.me.image.ImageWS_Service();
        org.me.image.ImageWS port = service.getImageWSPort();
        return port.searchByTitle(titol);
    }

    private static java.util.List<java.lang.Object> searchbyAuthor(java.lang.String autor) {
        org.me.image.ImageWS_Service service = new org.me.image.ImageWS_Service();
        org.me.image.ImageWS port = service.getImageWSPort();
        return port.searchbyAuthor(autor);
    }

    private static java.util.List<java.lang.Object> searchbyCreaDate(java.lang.String datacreacio) {
        org.me.image.ImageWS_Service service = new org.me.image.ImageWS_Service();
        org.me.image.ImageWS port = service.getImageWSPort();
        return port.searchbyCreaDate(datacreacio);
    }

    private static Image searchbyId(int idImatge) {
        org.me.image.ImageWS_Service service = new org.me.image.ImageWS_Service();
        org.me.image.ImageWS port = service.getImageWSPort();
        return port.searchbyId(idImatge);
    }

    private static java.util.List<java.lang.Object> searchbyKeywords(java.lang.String paraulaclau) {
        org.me.image.ImageWS_Service service = new org.me.image.ImageWS_Service();
        org.me.image.ImageWS port = service.getImageWSPort();
        return port.searchbyKeywords(paraulaclau);
    }

    private static int registerImage(java.lang.String titulo, java.lang.String author, java.lang.String paraulaclau, java.lang.String fecha) {
        org.me.image.ImageWS_Service service = new org.me.image.ImageWS_Service();
        org.me.image.ImageWS port = service.getImageWSPort();
        return port.registerImage(titulo,author,paraulaclau,fecha);
    }

   
}
