/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.pkg2020130002;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_DisplayEquipmentController implements Initializable {

    @FXML
    private Button btntambahsiswa;
    @FXML
    private Button btneditsiswa;
    @FXML
    private Button btnhapussiswa;
    @FXML
    private Button btnawal;
    @FXML
    private Button akhir;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnexit;
    @FXML
    private TableView<EquipmentModel> tbvequipment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showData();
    }

    public void showData() {
        ObservableList<EquipmentModel> data = FXMLDocumentController.dtequipments.Load();
        if (data != null) {
            tbvequipment.getColumns().clear();
            tbvequipment.getItems().clear();
            TableColumn col = new TableColumn("Equipment_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmentid"));
            tbvequipment.getColumns().addAll(col);

            col = new TableColumn("Equipment_Type");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmenttype"));
            tbvequipment.getColumns().addAll(col);
            col = new TableColumn("Equipment_Name");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmentname"));
            tbvequipment.getColumns().addAll(col);
            col = new TableColumn("Equipment_Rarity");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Equipmentrarity"));
            tbvequipment.getColumns().addAll(col);
            col = new TableColumn("Equipment Efek ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Efekid"));
            tbvequipment.getColumns().addAll(col);
            tbvequipment.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvequipment.getScene().getWindow().hide();
        }
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
        tbvequipment.getScene().getWindow().hide();
    }

    @FXML
    private void btntambahklik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputEquipment.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
            showData();
            btnawalklik(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
        showData();
        btnawalklik(event);
    }

    @FXML
    private void btneditklik(ActionEvent event) {
        EquipmentModel eq = new EquipmentModel();
        eq = tbvequipment.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputEquipment.fxml"));
            Parent root = (Parent) loader.load();
            FXML_InputEquipmentController isidt = loader.getController();
            isidt.execute(eq);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showData();
        btnawalklik(event);
    }

    @FXML
    private void btnhapusklik(ActionEvent event) {
        EquipmentModel eq = new EquipmentModel();
        eq = tbvequipment.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Ingin Menghapus data ke-" + eq + "?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            // System.out.print(s);
            if (FXMLDocumentController.dtequipments.Delete(eq.getEquipmentid())) {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Data berhasil dihapus", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Data gagal dihapus", ButtonType.OK);
                b.showAndWait();
            }
            showData();
        }
    }

}
