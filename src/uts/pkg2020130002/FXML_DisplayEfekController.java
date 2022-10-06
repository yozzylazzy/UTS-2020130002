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
public class FXML_DisplayEfekController implements Initializable {

    @FXML
    private TableView<EfekModel> tbvefekequip;
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
        ObservableList<EfekModel> data = FXMLDocumentController.dtefek.Load();
        if (data != null) {
            tbvefekequip.getColumns().clear();
            tbvefekequip.getItems().clear();
            TableColumn col = new TableColumn("Efek_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Efekid"));
            tbvefekequip.getColumns().addAll(col);

            col = new TableColumn("ATK");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Atk"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("MATK");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Matk"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("HP");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Hp"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("MP");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Mp"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("DEF");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Def"));
            tbvefekequip.getColumns().addAll(col);
                        col = new TableColumn("MDEF");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Mdef"));
            tbvefekequip.getColumns().addAll(col);
                        col = new TableColumn("HIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Hit"));
            tbvefekequip.getColumns().addAll(col);
                        col = new TableColumn("ASPD");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Aspd"));
            tbvefekequip.getColumns().addAll(col);
                        col = new TableColumn("CSPD");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Cspd"));
            tbvefekequip.getColumns().addAll(col);
                        col = new TableColumn("Critical_Rate");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Criticalrate"));
            tbvefekequip.getColumns().addAll(col);
                        col = new TableColumn("Critical_Damage");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Criticaldamage"));
            tbvefekequip.getColumns().addAll(col);
            tbvefekequip.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvefekequip.getScene().getWindow().hide();;
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
