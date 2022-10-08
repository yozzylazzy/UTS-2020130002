/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.pkg2020130002;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_InputArmorController implements Initializable {

    @FXML
    private TextField txtarmoridtxtarmorname;
    @FXML
    private TextField txtarmorid;
    @FXML
    private TextField txtstatusid;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnexit;
    @FXML
    private Slider sldrarity;
    @FXML
    private Label lblrarity;
    @FXML
    private TextField txtarmordef;
    @FXML
    private Button btnloadstat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnsimpanklik(ActionEvent event) {
    }

    @FXML
    private void btnresetklik(ActionEvent event) {
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
    }

    @FXML
    private void btnloadstatklik(ActionEvent event) {
    }
    
}
