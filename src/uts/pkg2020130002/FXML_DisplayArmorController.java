/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.pkg2020130002;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_DisplayArmorController implements Initializable {

    @FXML
    private TableView<ArmorModel> tbvarmor;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button akhir;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnhapussiswa;
    @FXML
    private Button btneditsiswa;
    @FXML
    private Button btntambahsiswa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showData();
    }    
    
        public void showData() {
        ObservableList<ArmorModel> data = FXMLDocumentController.dtarmor.LoadAll();
        if (data != null) {
            tbvarmor.getColumns().clear();
            tbvarmor.getItems().clear();
            TableColumn col = new TableColumn("Armor_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Armorid"));
            tbvarmor.getColumns().addAll(col);

            col = new TableColumn("Status_Id");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Statusid"));
            tbvarmor.getColumns().addAll(col);
            col = new TableColumn("Armor_Name");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Armorname"));
            tbvarmor.getColumns().addAll(col);
            col = new TableColumn("Armor_Def");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Armordef"));
            tbvarmor.getColumns().addAll(col);
            tbvarmor.setItems(data);

            col = new TableColumn("Armor_Rarity");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Armorrarity"));
            tbvarmor.getColumns().addAll(col);
 
            col = new TableColumn("STR");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Str"));
            tbvarmor.getColumns().addAll(col);
            col = new TableColumn("INT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Intl"));
            tbvarmor.getColumns().addAll(col);
            col = new TableColumn("AGI");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Agi"));
            tbvarmor.getColumns().addAll(col);
            col = new TableColumn("DEX");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Dex"));
            tbvarmor.getColumns().addAll(col);
            col = new TableColumn("VIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Vit"));
            tbvarmor.getColumns().addAll(col);
            col = new TableColumn("CRIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Crit"));
            tbvarmor.getColumns().addAll(col);
            tbvarmor.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvarmor.getScene().getWindow().hide();;
        }
    }


    @FXML
    private void btnexitklik(ActionEvent event) {
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
    }

    @FXML
    private void btnawalklik(ActionEvent event) {
    }

    @FXML
    private void btnhapusklik(ActionEvent event) {
    }

    @FXML
    private void btneditklik(ActionEvent event) {
    }

    @FXML
    private void btntambahklik(ActionEvent event) {
    }
    
}
