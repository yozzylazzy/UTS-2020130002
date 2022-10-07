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
public class FXML_DisplayNecklaceController implements Initializable {

    @FXML
    private TableView<NecklaceModel> tbvneklaces;
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
        ObservableList<NecklaceModel> data = FXMLDocumentController.dtnecklaces.LoadAll();
        if (data != null) {
            tbvneklaces.getColumns().clear();
            tbvneklaces.getItems().clear();
            TableColumn col = new TableColumn("Necklace_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Necklaceid"));
            tbvneklaces.getColumns().addAll(col);

            col = new TableColumn("Status_Id");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Statusid"));
            tbvneklaces.getColumns().addAll(col);
            col = new TableColumn("Necklace_Name");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Necklacename"));
            tbvneklaces.getColumns().addAll(col);
            col = new TableColumn("Necklace_MDEF");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Necklacemdef"));
            tbvneklaces.getColumns().addAll(col);
            tbvneklaces.setItems(data);

            col = new TableColumn("Necklace_Rarity");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Beltrarity"));
            tbvneklaces.getColumns().addAll(col);

            col = new TableColumn("STR");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Str"));
            tbvneklaces.getColumns().addAll(col);
            col = new TableColumn("INT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Intl"));
            tbvneklaces.getColumns().addAll(col);
            col = new TableColumn("AGI");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Agi"));
            tbvneklaces.getColumns().addAll(col);
            col = new TableColumn("DEX");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Dex"));
            tbvneklaces.getColumns().addAll(col);
            col = new TableColumn("VIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Vit"));
            tbvneklaces.getColumns().addAll(col);
            col = new TableColumn("CRIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Crit"));
            tbvneklaces.getColumns().addAll(col);
            tbvneklaces.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvneklaces.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void btnawalklik(ActionEvent event) {
        tbvneklaces.getSelectionModel().selectFirst();
        tbvneklaces.requestFocus();
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
        tbvneklaces.getSelectionModel().selectLast();
        tbvneklaces.requestFocus();
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
        tbvneklaces.getSelectionModel().selectAboveCell();
        tbvneklaces.requestFocus();
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
        tbvneklaces.getSelectionModel().selectBelowCell();
        tbvneklaces.requestFocus();
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
