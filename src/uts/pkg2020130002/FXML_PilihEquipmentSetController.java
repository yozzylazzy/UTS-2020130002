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
public class FXML_PilihEquipmentSetController implements Initializable {

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
    private String idsethasil = "";
    @FXML
    private TableView<EquipmentsetModel> tbvequipmentset;

    public int getHasil() {
        return (hasil);
    }

    public String getIdHasil() {
        return (idsethasil);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbfield.setItems(FXCollections.observableArrayList(
                "Set_Equip_ID", "Set_Name"));
        cmbfield.getSelectionModel().select(0);
        showData("set_equip_id", "");
    }

    public void showData(String a, String b) {
        ObservableList<EquipmentsetModel> data = FXMLDocumentController.dtequipset.LookUp(a, b);
        if (data.isEmpty()) {
            data = FXMLDocumentController.dtequipset.Load();
            txtisi.setText("");
        }
        if (data != null) {
            tbvequipmentset.getColumns().clear();
            tbvequipmentset.getItems().clear();
            TableColumn col = new TableColumn("Set_Equip_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Setequipid"));
            tbvequipmentset.getColumns().addAll(col);

            col = new TableColumn("Set_Name");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Setname"));
            tbvequipmentset.getColumns().addAll(col);

            tbvequipmentset.setItems(data);
        } else {
            Alert x = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            x.showAndWait();
            tbvequipmentset.getScene().getWindow().hide();;
        }
        btnawalklik(null);
        txtisi.requestFocus();
    }

    @FXML
    private void btnawalklik(ActionEvent event) {
        tbvequipmentset.getSelectionModel().selectFirst();
        tbvequipmentset.requestFocus();
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
        tbvequipmentset.getSelectionModel().selectLast();
        tbvequipmentset.requestFocus();
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
        tbvequipmentset.getSelectionModel().selectAboveCell();
        tbvequipmentset.requestFocus();
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
        tbvequipmentset.getSelectionModel().selectBelowCell();
        tbvequipmentset.requestFocus();
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
        int pilihan = tbvequipmentset.getSelectionModel().getSelectedCells().get(0).getRow();
        idsethasil = tbvequipmentset.getItems().get(pilihan).getSetequipid();
        btnpilih.getScene().getWindow().hide();
    }

    @FXML
    private void batalklik(ActionEvent event) {
        hasil = 0;
        btnbatal.getScene().getWindow().hide();
    }

}
