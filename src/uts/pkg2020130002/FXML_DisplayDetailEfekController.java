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
public class FXML_DisplayDetailEfekController implements Initializable {

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
    private TableView<DetailefekModel> tbvdetilefek;
    @FXML
    private TableView<SetcountModel> tbvsetcount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbvsetcount.getColumns().clear();
        tbvsetcount.getItems().clear();

        TableColumn col = new TableColumn();
        col = new TableColumn("Set_Equip_ID");
        col.setCellValueFactory(new PropertyValueFactory<SetcountModel, String>("Setequipid"));
        tbvsetcount.getColumns().addAll(col);
        col = new TableColumn("Jumlah");
        col.setCellValueFactory(new PropertyValueFactory<EquipmentsetModel, String>("Jumlah"));
        tbvsetcount.getColumns().addAll(col);

        tbvdetilefek.getColumns().clear();
        tbvdetilefek.getItems().clear();
        col = new TableColumn("Set_Equip_ID");
        col.setCellValueFactory(new PropertyValueFactory<DetailefekModel, String>("Setequipid"));
        tbvdetilefek.getColumns().addAll(col);

        col = new TableColumn("Jumlah");
        col.setCellValueFactory(new PropertyValueFactory<DetailefekModel, String>("Jumlah"));
        tbvdetilefek.getColumns().addAll(col);

        col = new TableColumn("Efek_ID");
        col.setCellValueFactory(new PropertyValueFactory<DetailsetefekModel, String>("Efekid"));
        tbvdetilefek.getColumns().addAll(col);

        col = new TableColumn("Efek_Type");
        col.setCellValueFactory(new PropertyValueFactory<DetailsetefekModel, String>("Efektype"));
        tbvdetilefek.getColumns().addAll(col);

        col = new TableColumn("Efek_Value");
        col.setCellValueFactory(new PropertyValueFactory<DetailsetefekModel, String>("Efekvalue"));
        tbvdetilefek.getColumns().addAll(col);

        showData();
    }

    public void showData() {
        ObservableList<SetcountModel> data = FXML_InputDetailEfekController.data.Load();
        if (data != null) {
            tbvsetcount.setItems(data);
            awalklik(null);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvsetcount.getScene().getWindow().hide();
        }
    }

    public void showdetil() {
        FXML_InputDetailEfekController.data.getSetcountModel().setSetequipid(
                tbvsetcount.getSelectionModel().getSelectedItem().getSetequipid());
         FXML_InputDetailEfekController.data.getSetcountModel().setJumlah(
                tbvsetcount.getSelectionModel().getSelectedItem().getJumlah());
        ObservableList<DetailefekModel> data = FXML_InputDetailEfekController.data.LoadDetil();
        if (data != null) {
            tbvdetilefek.setItems(data);
            tbvdetilefek.getSelectionModel().selectFirst();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvdetilefek.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void keluarklik(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();
    }

    @FXML
    private void akhirklik(ActionEvent event) {
        tbvsetcount.getSelectionModel().selectLast();
        showdetil();
        tbvsetcount.requestFocus();
    }

    @FXML
    private void ubahklik(ActionEvent event) {
        SetcountModel s = new SetcountModel();
        s = tbvsetcount.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputDetailEfek.fxml"));
            Parent root = (Parent) loader.load();
            FXML_InputDetailEfekController isidt = (FXML_InputDetailEfekController) loader.getController();
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
        SetcountModel s = new SetcountModel();
        s = tbvsetcount.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Mau dihapus?",
                ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtsetcount.Delete(s.getSetequipid(), s.getJumlah())) {
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
        tbvsetcount.getSelectionModel().selectBelowCell();
        showdetil();
        tbvsetcount.requestFocus();
    }

    @FXML
    private void sebelumklik(ActionEvent event) {
        tbvsetcount.getSelectionModel().selectAboveCell();
        showdetil();
        tbvsetcount.requestFocus();
    }

    @FXML
    private void tambahklik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputDetailEfek.fxml"));
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
        tbvsetcount.getSelectionModel().selectFirst();
        showdetil();
        tbvsetcount.requestFocus();
    }

    @FXML
    private void tbvdetailefekklik(MouseEvent event) {

    }

    @FXML
    private void tbvsetcountklik(MouseEvent event) {
        showdetil();
    }

}
