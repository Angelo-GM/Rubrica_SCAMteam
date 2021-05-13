/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.edu.gastaldiabba.rubrica.controller;

import it.edu.gastaldiabba.rubrica.Rubrica;
import it.edu.gastaldiabba.rubrica.model.Cliente;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 *
 * @author angis
 */
public class RubricaController extends Rubrica implements Initializable {
    
    ObservableList<String> filterList= FXCollections
            .observableArrayList("Ragione sociale", "Indirizzo", "CAP", "E-mail", "Telefono", "Partita IVA", "Città", "Affidabilità");
    
    @FXML
    private TextArea src;
    @FXML
    private ComboBox filterBox;
    @FXML
    private AnchorPane sfondo;
    @FXML
    private Button aggiungi;
    @FXML
    private Button rimuovi;
    @FXML
    private Button importa;
    @FXML
    private RadioButton crescente;
    @FXML
    private ToggleGroup OrderGroup;
    @FXML
    private RadioButton decrescente;
    @FXML
    private Button login;
    @FXML
    private Label label;
    @FXML
    private ListView<Cliente> lista;
    private ObservableList<Cliente> itemList;
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        itemList = FXCollections.observableArrayList();
        filterBox.getItems().addAll(filterList);
        
        //genero qualche cliente a caso per testare l'interfaccia
        genItems();
        lista.setItems(itemList);
        lista.setCellFactory((ListView<Cliente> param) -> new ListCell<Cliente>() {
            
            private ImageView imageView = new ImageView("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/32x32/plain/shape_circle.png");
            
            private Label textField = new Label("Text");
            private Label lCitta= new Label("Text");
            private Button btnModifica = new Button("Modifica");
            private Button btnElimina = new Button("Elimina");
            
            private BorderPane bp = new BorderPane(imageView, textField, btnElimina, null,btnModifica);
            private FlowPane fp = new FlowPane(Orientation.HORIZONTAL,imageView, textField, btnElimina, btnModifica, lCitta);

            @Override
            protected void updateItem(Cliente item, boolean empty) {
                setPrefSize(1200, 180);
                fp.setVgap(20);
                fp.setHgap(14);
                if (item == null || empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.getNomeAz());
                    btnElimina.setText("Elimina " + item.getNomeAz());
                    textField.setText(item.getPIVA());
                    lCitta.setText(item.getCitta());
                    setGraphic(fp);
                }
            }
        });

    }
    
        private void genItems() {
        for(int i=0;i<10;i++){
            itemList.add(new Cliente( "Azienda" +i, "idsfasdfs"," casasdfadf","tdsdfdf","IVA", "Genova","m", 3));
        }
    }

    @FXML
    private void aggiungiClicked(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Rubrica.fxml"));
        
        Scene scene = new Scene(root);
       // stage.getIcons().add(new Image(""));
        stage.setTitle("Rubrica");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void importaClicked(ActionEvent event) {
        JFileChooser fc=new JFileChooser();
        
	/*	if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			FileReader read=null;
                        File select = fc.getSelectedFile();
			try{
			    read = new FileReader(select);
			    Scanner s=new Scanner(read);
			    String persona;
		            String[] x;
                            ArrayList ps=new ArrayList();
                                while(s.hasNextLine()){  
                                persona=s.nextLine();
                                x=persona.split(";"); 
                                Cliente z=new Cliente(x[0], x[1], x[2], dn, lingue);
                                ps.add(z);
                            }
                             
			} catch(FileNotFoundException | ArrayIndexOutOfBoundsException ex){
				errorFile.setVisible(true);
			} 
			finally{
				try{
					if(read!=null)	
					read.close();
				} catch(IOException ex){
				System.out.println("errore");
				}
			}
                }*/
    }

    @FXML
    private void rimuoviClicked(ActionEvent event) {
    }
}
