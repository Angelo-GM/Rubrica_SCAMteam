/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.edu.gastaldiabba.rubrica;

import static it.edu.gastaldiabba.rubrica.LeggiScriviXml.xmlFilePath;
import it.edu.gastaldiabba.rubrica.model.Cliente;
import java.io.File;
import java.io.IOException;
import static java.lang.System.getProperty;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author angis
 */
public class Rubrica extends Application {
    
    ObservableList<Cliente> listaClienti= FXCollections.observableArrayList();
    
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
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dbf.newDocumentBuilder();
            Document document = build.parse(xmlFilePath());
            File f=new File(xmlFilePath());
            if(f.exists()){
            leggiXML(document);
            }
            else{
                LeggiScriviXml.creaXML();
            }
        
        }
        
        catch(ParserConfigurationException | TransformerException | SAXException | IOException ex) {
        
            System.out.println("Errore");
        } 
        launch(args);
    }
    public static void leggiXML(Document document){
      NodeList clienti = document.getElementsByTagName("Cliente");
      for(int i = 0; i < clienti.getLength(); i++) {
       Element cliente = (Element)clienti.item(i);
        String nomeAz = cliente.getElementsByTagName("nomeAzienda").item(0).getTextContent();
        String indirizzo = cliente.getElementsByTagName("indirizzo").item(0).getTextContent();
        String cap = cliente.getElementsByTagName("cap").item(0).getTextContent();
        String citta = cliente.getElementsByTagName("citta").item(0).getTextContent();
        String pIVA = cliente.getElementsByTagName("partitaIVA").item(0).getTextContent();
        String telefono = cliente.getElementsByTagName("telefono").item(0).getTextContent();
        String mail = cliente.getElementsByTagName("mail").item(0).getTextContent();
        String note = cliente.getElementsByTagName("note").item(0).getTextContent();
        String a = cliente.getAttributes().getNamedItem("affidabilita").getNodeValue();
        int aff;
        try{
            aff = Integer.parseInt(a);
        } catch(NumberFormatException e){
            aff = 0;
        }
        Cliente z=new Cliente(nomeAz, indirizzo, cap, telefono, pIVA, citta, mail, aff);
        listaClienti.add(z);
      }

  }
    public static final String xmlFilePath() {
        String p = getProperty("user.dir") + getProperty("file.separator");
        String x = p+"rubrica.xml";
        return x;
    }
    
}
