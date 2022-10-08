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
public class FXML_DisplayUtamaController implements Initializable {

    @FXML
    private TableView<EquipmentModel> tbvweapons;
    @FXML
    private Button btntambahsiswa;
    @FXML
    private Button btneditsiswa;
    @FXML
    private Button btnhapussiswa;
    @FXML
    private Button btnawal;
    @FXML
    private Button akhir;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnexit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showData();
    }

    public void showData() {
        ObservableList<EquipmentModel> data = FXMLDocumentController.dtequipments.Load();
        if (data != null) {
            tbvweapons.getColumns().clear();
            tbvweapons.getItems().clear();
            TableColumn col = new TableColumn("Equipment_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmentid"));
            tbvweapons.getColumns().addAll(col);

            col = new TableColumn("Equipment_Type");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmenttype"));
            tbvweapons.getColumns().addAll(col);
            col = new TableColumn("Equipment_Name");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmentname"));
            tbvweapons.getColumns().addAll(col);
            col = new TableColumn("Equipment_Rarity");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Equipmentrarity"));
            tbvweapons.getColumns().addAll(col);
            tbvweapons.setItems(data);
            col = new TableColumn("STR");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Str"));
            tbvweapons.getColumns().addAll(col);
            col = new TableColumn("INT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Intl"));
            tbvweapons.getColumns().addAll(col);
            col = new TableColumn("AGI");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Agi"));
            tbvweapons.getColumns().addAll(col);
            col = new TableColumn("DEX");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Dex"));
            tbvweapons.getColumns().addAll(col);
            col = new TableColumn("VIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Vit"));
            tbvweapons.getColumns().addAll(col);
            col = new TableColumn("CRIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Crit"));
            tbvweapons.getColumns().addAll(col);
            tbvweapons.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvweapons.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void btnawalklik(ActionEvent event) {
        tbvweapons.getSelectionModel().selectFirst();
        tbvweapons.requestFocus();
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
        tbvweapons.getSelectionModel().selectLast();
        tbvweapons.requestFocus();
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
        tbvweapons.getSelectionModel().selectAboveCell();
        tbvweapons.requestFocus();
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
        tbvweapons.getSelectionModel().selectBelowCell();
        tbvweapons.requestFocus();
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        tbvweapons.getScene().getWindow().hide();
    }

    @FXML
    private void btntambahklik(ActionEvent event) {
    }

    @FXML
    private void btneditklik(ActionEvent event) {
    }

    @FXML
    private void btnhapusklik(ActionEvent event) {
    }
    
}
