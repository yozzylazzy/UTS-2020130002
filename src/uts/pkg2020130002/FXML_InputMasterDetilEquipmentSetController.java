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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_InputMasterDetilEquipmentSetController implements Initializable {

    @FXML
    private TextField txtnamaset;
    @FXML
    private ComboBox<String> cmbequipefek;
    @FXML
    private TextField txtequipmentstats;
    @FXML
    private TableView<EquipmentModel> tbvdetilequip;
    @FXML
    private Button btnclear;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btntambah;
    @FXML
    private TextField txtrarity;
    @FXML
    private TextField txtequipmentid;
    @FXML
    private TextField txtsetequipid;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnexit;
    @FXML
    private ComboBox<String> cmbequiptype;
    @FXML
    private TextField txtequipmentname;
    @FXML
    private Button btnloadequipment;

    
    private boolean editmode = false;
    public static DBEquipmentset data = new DBEquipmentset();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void tbvdetilequipklik(MouseEvent event) {
        
    }

    @FXML
    private void btnclearklik(ActionEvent event) {
        
    }

    @FXML
    private void btnhapusklik(ActionEvent event) {
    }

    @FXML
    private void btntambahklik(ActionEvent event) {
    }

    @FXML
    private void setequipidcek(KeyEvent event) {
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
    private void btnloadequipmentklik(ActionEvent event) {
    }
    
}
