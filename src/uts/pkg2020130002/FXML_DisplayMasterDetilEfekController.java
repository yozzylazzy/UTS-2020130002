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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_DisplayMasterDetilEfekController implements Initializable {

    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnubah;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btntambah;
    @FXML
    private Button btnawal;
    @FXML
    private TableView<DetailsetefekModel> tbvdetilsetefek;
    @FXML
    private TableView<EquipmentsetModel> tbvequipmentset;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbvequipmentset.getColumns().clear();
        tbvequipmentset.getItems().clear();

        TableColumn col = new TableColumn("Set_Equip_ID");
        col.setCellValueFactory(new PropertyValueFactory<EquipmentsetModel, String>("Setequipid"));
        tbvequipmentset.getColumns().addAll(col);
        col = new TableColumn("Set_Name");
        col.setCellValueFactory(new PropertyValueFactory<EquipmentsetModel, String>("Setname"));
        tbvequipmentset.getColumns().addAll(col);
        col = new TableColumn("Jumlah_Max");
        col.setCellValueFactory(new PropertyValueFactory<EquipmentsetModel, String>("Jumlahmax"));
        tbvequipmentset.getColumns().addAll(col);

        tbvdetilsetefek.getColumns().clear();
        tbvdetilsetefek.getItems().clear();
        col = new TableColumn("Set_Equip_ID");
        col.setCellValueFactory(new PropertyValueFactory<DetailsetefekModel, String>("Setequipid"));
        tbvdetilsetefek.getColumns().addAll(col);

        col = new TableColumn("Efekid");
        col.setCellValueFactory(new PropertyValueFactory<DetailsetefekModel, String>("Efekid"));
        tbvdetilsetefek.getColumns().addAll(col);

        col = new TableColumn("Item_Set");
        col.setCellValueFactory(new PropertyValueFactory<DetailsetefekModel, String>("Itemset"));
        tbvdetilsetefek.getColumns().addAll(col);
        showData();

    }

    private void showData() {
        ObservableList<EquipmentsetModel> data = FXML_InputMasterDetilEfekController.data.Load();
        if (data != null) {
            tbvequipmentset.setItems(data);
            awalklik(null);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvequipmentset.getScene().getWindow().hide();
        }
    }

    private void showdetil() {
        FXML_InputMasterDetilEfekController.data.getEquipmentsetModel().setSetequipid(
                tbvequipmentset.getSelectionModel().getSelectedItem().getSetequipid());
        ObservableList<DetailsetefekModel> data = FXML_InputMasterDetilEfekController.data.LoadDetil();
        if (data != null) {
            tbvdetilsetefek.setItems(data);
            tbvdetilsetefek.getSelectionModel().selectFirst();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvdetilsetefek.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void keluarklik(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();
    }

    @FXML
    private void akhirklik(ActionEvent event) {
        tbvequipmentset.getSelectionModel().selectLast();
        showdetil();
        tbvequipmentset.requestFocus();
    }

    @FXML
    private void ubahklik(ActionEvent event) {
        EquipmentsetModel s = new EquipmentsetModel();
        s = tbvequipmentset.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputMasterDetilEfek.fxml"));
            Parent root = (Parent) loader.load();
            FXML_InputMasterDetilEfekController isidt = (FXML_InputMasterDetilEfekController) loader.getController();
            isidt.execute(s);
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
        awalklik(event);
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        EquipmentsetModel s = new EquipmentsetModel();
        s = tbvequipmentset.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Mau dihapus?",
                ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtequipset.Delete(s.getSetequipid())) {
                Alert b = new Alert(Alert.AlertType.INFORMATION,
                        "Data berhasil dihapus", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR,
                        "Data gagal dihapus", ButtonType.OK);
                b.showAndWait();
            }
            showData();
            awalklik(event);
        }
    }

    @FXML
    private void sesudahklik(ActionEvent event) {
        tbvequipmentset.getSelectionModel().selectBelowCell();
        showdetil();
        tbvequipmentset.requestFocus();
    }

    @FXML
    private void sebelumklik(ActionEvent event) {
        tbvequipmentset.getSelectionModel().selectAboveCell();
        showdetil();
        tbvequipmentset.requestFocus();
    }

    @FXML
    private void tambahklik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputMasterDetilEfek.fxml"));
            Parent root = (Parent) loader.load();
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
        awalklik(event);
    }

    @FXML
    private void awalklik(ActionEvent event) {
        tbvequipmentset.getSelectionModel().selectFirst();
        showdetil();
        tbvequipmentset.requestFocus();
    }

    @FXML
    private void tbvdetilsetefekklik(MouseEvent event) {
    }

    @FXML
    private void tbvequipmentsetklik(MouseEvent event) {
        showdetil();
    }

}
