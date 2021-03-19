/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.edu.gastaldiabba.rubrica;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author angis
 */
public class Rubrica extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/Rubrica.fxml"));
        
        Scene scene = new Scene(root);
       // stage.getIcons().add(new Image(""));
        stage.setTitle("Rubrica");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
         
            LeggiScriviXml.creaXML();
        
        }
        
        catch(ParserConfigurationException | TransformerException | SAXException | IOException ex) {
        
            System.out.println("Errore");
        } 
        launch(args);
    }
    
}
