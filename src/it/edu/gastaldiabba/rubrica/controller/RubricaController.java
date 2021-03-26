/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.edu.gastaldiabba.rubrica.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

/**
 *
 * @author angis
 */
public class RubricaController implements Initializable {
    
    ObservableList<String> filterList= FXCollections
            .observableArrayList("Ragione sociale", "Indirizzo", "CAP", "E-mail", "Telefono", "Partita IVA", "Città", "Affidabilità");
    @FXML
    private TextArea src;
    @FXML
    private ComboBox filterBox;
    @FXML
    private AnchorPane sfondo;
    @FXML
    private ScrollPane lista;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        filterBox.getItems().addAll(filterList);
    }    
    
}
