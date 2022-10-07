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
public class FXML_DisplayBeltController implements Initializable {

    @FXML
    private TableView<BeltModel> tbvbelt;
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
        ObservableList<BeltModel> data = FXMLDocumentController.dtbelts.LoadAll();
        if (data != null) {
            tbvbelt.getColumns().clear();
            tbvbelt.getItems().clear();
            TableColumn col = new TableColumn("Belt_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Beltid"));
            tbvbelt.getColumns().addAll(col);

            col = new TableColumn("Status_Id");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Statusid"));
            tbvbelt.getColumns().addAll(col);
            col = new TableColumn("Belt_Name");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Beltname"));
            tbvbelt.getColumns().addAll(col);
            col = new TableColumn("Belt_Health");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Belthealth"));
            tbvbelt.getColumns().addAll(col);
            tbvbelt.setItems(data);

            col = new TableColumn("Belt_Rarity");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Beltrarity"));
            tbvbelt.getColumns().addAll(col);
 
            col = new TableColumn("STR");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Str"));
            tbvbelt.getColumns().addAll(col);
            col = new TableColumn("INT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Intl"));
            tbvbelt.getColumns().addAll(col);
            col = new TableColumn("AGI");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Agi"));
            tbvbelt.getColumns().addAll(col);
            col = new TableColumn("DEX");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Dex"));
            tbvbelt.getColumns().addAll(col);
            col = new TableColumn("VIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Vit"));
            tbvbelt.getColumns().addAll(col);
            col = new TableColumn("CRIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Crit"));
            tbvbelt.getColumns().addAll(col);
            tbvbelt.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvbelt.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void btnawalklik(ActionEvent event) {
        tbvbelt.getSelectionModel().selectFirst();
        tbvbelt.requestFocus();
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
        tbvbelt.getSelectionModel().selectLast();
        tbvbelt.requestFocus();
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
        tbvbelt.getSelectionModel().selectAboveCell();
        tbvbelt.requestFocus();
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
        tbvbelt.getSelectionModel().selectBelowCell();
        tbvbelt.requestFocus();
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
