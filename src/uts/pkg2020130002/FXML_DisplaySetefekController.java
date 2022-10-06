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
public class FXML_DisplaySetefekController implements Initializable {

    @FXML
    private TableView<SeteffectModel> tbvsetequip;
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
        ObservableList<SeteffectModel> data = FXMLDocumentController.dtseteq.Load();
        if (data != null) {
            tbvsetequip.getColumns().clear();
            tbvsetequip.getItems().clear();
            TableColumn col = new TableColumn("Set_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Setid"));
            tbvsetequip.getColumns().addAll(col);

            col = new TableColumn("Belt_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Beltid"));
            tbvsetequip.getColumns().addAll(col);
            col = new TableColumn("Necklace_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Necklaceid"));
            tbvsetequip.getColumns().addAll(col);
            col = new TableColumn("Bracelet_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Braceletid"));
            tbvsetequip.getColumns().addAll(col);
            col = new TableColumn("Weapon_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Weaponid"));
            tbvsetequip.getColumns().addAll(col);

            col = new TableColumn("Ring_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Ringid"));
            tbvsetequip.getColumns().addAll(col);
            col = new TableColumn("Armor_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Armorid"));
            tbvsetequip.getColumns().addAll(col);
            
            tbvsetequip.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvsetequip.getScene().getWindow().hide();;
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
