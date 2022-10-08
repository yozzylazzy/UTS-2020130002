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
public class FXML_PilihEfekController implements Initializable {

    @FXML
    private Button btnexit;
    @FXML
    private ComboBox<String> cmbfield;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnpilih;
    @FXML
    private Button btncari;
    @FXML
    private TextField txtisi;
    @FXML
    private TableView<EfekModel> tbvefek;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button akhir;
    @FXML
    private Button btnawal;

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
                "Efek_ID"));
        cmbfield.getSelectionModel().select(0);
        showData("efek_id", "");
    }

    public void showData(String a, String b) {
        ObservableList<EfekModel> data = FXMLDocumentController.dtefek.LookUp(a, b);
        if (data.isEmpty()) {
            data = FXMLDocumentController.dtefek.Load();
            txtisi.setText("");
        }
        if (data != null) {
            tbvefek.getColumns().clear();
            tbvefek.getItems().clear();
            TableColumn col = new TableColumn("Efek_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Efekid"));
            tbvefek.getColumns().addAll(col);

            col = new TableColumn("ATK");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Atk"));
            tbvefek.getColumns().addAll(col);
            col = new TableColumn("MATK");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Matk"));
            tbvefek.getColumns().addAll(col);
            col = new TableColumn("HP");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Hp"));
            tbvefek.getColumns().addAll(col);
            col = new TableColumn("MP");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Mp"));
            tbvefek.getColumns().addAll(col);
            col = new TableColumn("DEF");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Def"));
            tbvefek.getColumns().addAll(col);
            col = new TableColumn("MDEF");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Mdef"));
            tbvefek.getColumns().addAll(col);
            col = new TableColumn("HIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Hit"));
            tbvefek.getColumns().addAll(col);
            col = new TableColumn("ASPD");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Aspd"));
            tbvefek.getColumns().addAll(col);
            col = new TableColumn("CSPD");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Cspd"));
            tbvefek.getColumns().addAll(col);
            col = new TableColumn("Critical_Rate");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Criticalrate"));
            tbvefek.getColumns().addAll(col);
            col = new TableColumn("Critical_Damage");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Criticaldamage"));
            tbvefek.getColumns().addAll(col);
            tbvefek.setItems(data);
        } else {
            Alert x = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            x.showAndWait();
            tbvefek.getScene().getWindow().hide();;
        }
        btnawalklik(null);
        txtisi.requestFocus();
    }

    @FXML
    private void btnawalklik(ActionEvent event) {
        tbvefek.getSelectionModel().selectFirst();
        tbvefek.requestFocus();
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
        tbvefek.getSelectionModel().selectLast();
        tbvefek.requestFocus();
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
        tbvefek.getSelectionModel().selectAboveCell();
        tbvefek.requestFocus();
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
        tbvefek.getSelectionModel().selectBelowCell();
        tbvefek.requestFocus();
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
        int pilihan = tbvefek.getSelectionModel().getSelectedCells().get(0).getRow();
        idhasil = tbvefek.getItems().get(pilihan).getEfekid();
        btnpilih.getScene().getWindow().hide();
    }

    @FXML
    private void batalklik(ActionEvent event) {
        hasil = 0;
        btnbatal.getScene().getWindow().hide();
    }

}
