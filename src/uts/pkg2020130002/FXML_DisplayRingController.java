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
public class FXML_DisplayRingController implements Initializable {

    @FXML
    private TableView<RingModel> tbvring;
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
        ObservableList<RingModel> data = FXMLDocumentController.dtrings.LoadAll();
        if (data != null) {
            tbvring.getColumns().clear();
            tbvring.getItems().clear();
            TableColumn col = new TableColumn("Ring_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Ringid"));
            tbvring.getColumns().addAll(col);

            col = new TableColumn("Status_Id");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Statusid"));
            tbvring.getColumns().addAll(col);
            col = new TableColumn("Ring_Name");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Ringname"));
            tbvring.getColumns().addAll(col);
            col = new TableColumn("Ring_MDEF");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Ringmdef"));
            tbvring.getColumns().addAll(col);
            tbvring.setItems(data);

            col = new TableColumn("Ring_Rarity");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Ringrarity"));
            tbvring.getColumns().addAll(col);

            col = new TableColumn("STR");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Str"));
            tbvring.getColumns().addAll(col);
            col = new TableColumn("INT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Intl"));
            tbvring.getColumns().addAll(col);
            col = new TableColumn("AGI");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Agi"));
            tbvring.getColumns().addAll(col);
            col = new TableColumn("DEX");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Dex"));
            tbvring.getColumns().addAll(col);
            col = new TableColumn("VIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Vit"));
            tbvring.getColumns().addAll(col);
            col = new TableColumn("CRIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Crit"));
            tbvring.getColumns().addAll(col);
            tbvring.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvring.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void btnawalklik(ActionEvent event) {
        tbvring.getSelectionModel().selectFirst();
        tbvring.requestFocus();
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
        tbvring.getSelectionModel().selectLast();
        tbvring.requestFocus();
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
        tbvring.getSelectionModel().selectAboveCell();
        tbvring.requestFocus();
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
        tbvring.getSelectionModel().selectBelowCell();
        tbvring.requestFocus();
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
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
