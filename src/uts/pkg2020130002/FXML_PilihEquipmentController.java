/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.pkg2020130002;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_PilihEquipmentController implements Initializable {

    @FXML
    private TableView<EquipmentModel> tbvequipment;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button akhir;
    @FXML
    private Button btnawal;
    @FXML
    private TextField txtisi;
    @FXML
    private Button btncari;
    @FXML
    private Button btnpilih;
    @FXML
    private Button btnbatal;
    @FXML
    private ComboBox<String> cmbfield;
    @FXML
    private Button btnexit;

    private int hasil = 0;
    private String idhasil = "";

    public int getHasil() {
        return (hasil);
    }

    public String getIdHasil() {
        return (idhasil);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbfield.setItems(FXCollections.observableArrayList(
                "Equipment_ID", "Equipment_Name", "Equipment_Type", "Equipment_Rarity"));
        cmbfield.getSelectionModel().select(0);
        showData("equipment_id", "");
    }

    public void showData(String a, String b) {
        ObservableList<EquipmentModel> data = FXMLDocumentController.dtequipments.LookUp(a, b);
        if (data.isEmpty()) {
            data = FXMLDocumentController.dtequipments.Load();
            txtisi.setText("");
        }
        if (data != null) {
            tbvequipment.getColumns().clear();
            tbvequipment.getItems().clear();
            TableColumn col = new TableColumn("Equipment_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmentid"));
            tbvequipment.getColumns().addAll(col);

            col = new TableColumn("Equipment_Name");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmentname"));
            tbvequipment.getColumns().addAll(col);
            col = new TableColumn("Equipment_Type");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmenttype"));
            tbvequipment.getColumns().addAll(col);
            col = new TableColumn("Equipment_Rarity");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmentrarity"));
            tbvequipment.getColumns().addAll(col);
            tbvequipment.setItems(data);
        } else {
            Alert x = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            x.showAndWait();
            tbvequipment.getScene().getWindow().hide();;
        }
        btnawalklik(null);
        txtisi.requestFocus();
    }

    @FXML
    private void btnawalklik(ActionEvent event) {
        tbvequipment.getSelectionModel().selectFirst();
        tbvequipment.requestFocus();
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
        tbvequipment.getSelectionModel().selectLast();
        tbvequipment.requestFocus();
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
        tbvequipment.getSelectionModel().selectAboveCell();
        tbvequipment.requestFocus();
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
        tbvequipment.getSelectionModel().selectBelowCell();
        tbvequipment.requestFocus();
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void cariklik(ActionEvent event) {
        showData(cmbfield.getSelectionModel().getSelectedItem(), txtisi.getText());
    }

    @FXML
    private void pilihklik(ActionEvent event) {
        hasil = 1;
        int pilihan = tbvequipment.getSelectionModel().getSelectedCells().get(0).getRow();
        idhasil = tbvequipment.getItems().get(pilihan).getEquipmentid();
        btnpilih.getScene().getWindow().hide();
    }

    @FXML
    private void batalklik(ActionEvent event) {
        hasil = 0;
        btnbatal.getScene().getWindow().hide();
    }

}
