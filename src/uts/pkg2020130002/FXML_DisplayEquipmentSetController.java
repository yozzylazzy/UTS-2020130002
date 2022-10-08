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
public class FXML_DisplayEquipmentSetController implements Initializable {

    @FXML
    private TableView<EquipmentsetModel> tbvequipset;
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
        ObservableList<EquipmentsetModel> data = FXMLDocumentController.dtequipset.Load();
        if (data != null) {
            tbvequipset.getColumns().clear();
            tbvequipset.getItems().clear();

            TableColumn col = new TableColumn("Set_Equip_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentsetModel, String>("Setequipid"));
            tbvequipset.getColumns().addAll(col);

            col = new TableColumn("Set_Name");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentsetModel, String>("Setname"));
            tbvequipset.getColumns().addAll(col);

            tbvequipset.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvequipset.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void btnawalklik(ActionEvent event) {
        tbvequipset.getSelectionModel().selectFirst();
        tbvequipset.requestFocus();
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
        tbvequipset.getSelectionModel().selectLast();
        tbvequipset.requestFocus();
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
        tbvequipset.getSelectionModel().selectAboveCell();
        tbvequipset.requestFocus();
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
        tbvequipset.getSelectionModel().selectBelowCell();
        tbvequipset.requestFocus();
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void btntambahklik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputEquipmentSet.fxml"));
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
        EquipmentsetModel eq = new EquipmentsetModel();
        eq = tbvequipset.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputEquipmentSet.fxml"));
            Parent root = (Parent) loader.load();
            FXML_InputEquipmentSetController isidt = loader.getController();
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
        EquipmentsetModel eq = new EquipmentsetModel();
        eq = tbvequipset.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Ingin Menghapus data ke-" + eq + "?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            // System.out.print(s);
            if (FXMLDocumentController.dtequipset.Delete(eq.getSetequipid())) {
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
