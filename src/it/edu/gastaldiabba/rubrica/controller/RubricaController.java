/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.edu.gastaldiabba.rubrica.controller;

import it.edu.gastaldiabba.rubrica.Rubrica;
import it.edu.gastaldiabba.rubrica.model.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
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
    private Button salva;
    @FXML
    private Button rimuovi;
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
}
