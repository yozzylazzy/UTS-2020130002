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
public class FXML_DisplayStatusController implements Initializable {

    @FXML
    private TableView<StatusModel> tbvstatusweapon;
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
        ObservableList<StatusModel> data = FXMLDocumentController.dtstatus.Load();
        if (data != null) {
            tbvstatusweapon.getColumns().clear();
            tbvstatusweapon.getItems().clear();
            TableColumn col = new TableColumn("Status_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Statusid"));
            tbvstatusweapon.getColumns().addAll(col);

            col = new TableColumn("STR");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Str"));
            tbvstatusweapon.getColumns().addAll(col);
            col = new TableColumn("INT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Intl"));
            tbvstatusweapon.getColumns().addAll(col);
            col = new TableColumn("DEX");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Dex"));
            tbvstatusweapon.getColumns().addAll(col);
            col = new TableColumn("AGI");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Agi"));
            tbvstatusweapon.getColumns().addAll(col);

            col = new TableColumn("VIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Vit"));
            tbvstatusweapon.getColumns().addAll(col);
            col = new TableColumn("CRIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Crit"));
            tbvstatusweapon.getColumns().addAll(col);
            
            tbvstatusweapon.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvstatusweapon.getScene().getWindow().hide();;
        }
    }


    @FXML
    private void btnawalklik(ActionEvent event) {
        tbvstatusweapon.getSelectionModel().selectFirst();
        tbvstatusweapon.requestFocus();
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
        tbvstatusweapon.getSelectionModel().selectLast();
        tbvstatusweapon.requestFocus();
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
        tbvstatusweapon.getSelectionModel().selectAboveCell();
        tbvstatusweapon.requestFocus();
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
        tbvstatusweapon.getSelectionModel().selectBelowCell();
        tbvstatusweapon.requestFocus();
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
