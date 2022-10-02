/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.pkg2020130002;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showData();
    }

    public void showData() {
        ObservableList<EquipmentModel> data = FXMLDocumentController.dtweapons.Load();
        if (data != null) {
            tbvweapons.getColumns().clear();
            tbvweapons.getItems().clear();
            TableColumn col = new TableColumn("Weapon_Id");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Weaponid"));
            tbvweapons.getColumns().addAll(col);

            col = new TableColumn("Status_Id");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Statusid"));
            tbvweapons.getColumns().addAll(col);
            col = new TableColumn("Weapon_Name");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Weaponname"));
            tbvweapons.getColumns().addAll(col);
            col = new TableColumn("Weapon_Atk");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Weaponatk"));
            tbvweapons.getColumns().addAll(col);
            tbvweapons.setItems(data);

            col = new TableColumn("Weapon_Rarity");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Weaponrarity"));
            tbvweapons.getColumns().addAll(col);
            tbvweapons.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvweapons.getScene().getWindow().hide();;
        }
    }

}
