/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.edu.gastaldiabba.rubrica;

import it.edu.gastaldiabba.rubrica.controller.RubricaController;
import it.edu.gastaldiabba.rubrica.model.Cliente;
import java.io.File;
import java.io.IOException;
import static java.lang.System.getProperty;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author angis
 */
public class Rubrica extends Application {
    
    public ObservableList<Cliente> listaClienti= FXCollections
            .observableArrayList();
    
    public ObservableList<Cliente> getListaClienti(){
        return listaClienti;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        try {
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dbf.newDocumentBuilder();
            Document document = build.parse(xmlFilePath());
            File f=new File(xmlFilePath());
            if(f.exists()){
                leggiXML(document);
                
            }
            else{
                creaXML();
                leggiXML(document);
                
            }
        
        }
        
        catch(ParserConfigurationException | TransformerException | SAXException | IOException ex) {
        
            System.out.println("Errore");
        }
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
         
        launch(args);
    }
    public void leggiXML(Document document){
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
            if(aff>=0 && aff<=10){
                System.out.println("Correct");
            }
            else{
                //finestra che segnala errore
            }
        } catch(NumberFormatException e){
            aff = 0;
        }
        System.out.println("lettura corretta");
        Cliente z=new Cliente(nomeAz, indirizzo, cap, telefono, pIVA, citta, mail, aff);
        System.out.println("cliente creato");
        listaClienti.add(z);
        System.out.println("cliente aggiunto alla lista");
      }

  }
    public static final String xmlFilePath() {
        String p = getProperty("user.dir") + getProperty("file.separator");
        String x = p+"rubrica.xml";
        return x;
    }
    public static void creaXML() throws ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException, IOException {
    
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    Document doc = docBuilder.newDocument();
    
    Element rubrica = doc.createElement("Rubrica");
    doc.appendChild(rubrica);
    
    Element cliente = doc.createElement("Cliente");
    Attr a = doc.createAttribute("affidabilita");
    a.setValue("10");
    cliente.setAttributeNode(a);
    rubrica.appendChild(cliente);
    
    Element nomeAzienda = doc.createElement("nomeAzienda");
    nomeAzienda.appendChild(doc.createTextNode("Microsoft"));
    cliente.appendChild(nomeAzienda);
    
    Element indirizzo = doc.createElement("indirizzo");
    indirizzo.appendChild(doc.createTextNode("Oxford Street 26/2"));
    cliente.appendChild(indirizzo);
    
    Element cap = doc.createElement("cap");
    cap.appendChild(doc.createTextNode("03456"));
    cliente.appendChild(cap);
    
    Element citta = doc.createElement("citta");
    citta.appendChild(doc.createTextNode("London"));
    cliente.appendChild(citta);
    
    Element partitaIVA = doc.createElement("partitaIVA");
    partitaIVA.appendChild(doc.createTextNode("010386534576"));
    cliente.appendChild(partitaIVA);
    
    Element telefono = doc.createElement("telefono");
    telefono.appendChild(doc.createTextNode("8034678342"));
    cliente.appendChild(telefono);
    
    Element mail = doc.createElement("mail");
    mail.appendChild(doc.createTextNode("microsoft@billgates.com"));
    cliente.appendChild(mail);
    
    Element note = doc.createElement("note");
    note.appendChild(doc.createTextNode("Note di <nome cliente>"));
    cliente.appendChild(note);
    
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);
    
    StreamResult streamResult = new StreamResult (new File(xmlFilePath()));
    transformer.transform(source, streamResult);
    
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder build = dbf.newDocumentBuilder();
    Document document = build.parse(xmlFilePath());
      
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer t = tf.newTransformer();
    DOMSource src = new DOMSource (doc);
    StreamResult sr = new StreamResult (new File (xmlFilePath()));
    transformer.transform(src, sr);
    }
    
    
   
}
