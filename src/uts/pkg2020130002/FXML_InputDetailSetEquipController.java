/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.pkg2020130002;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_InputDetailSetEquipController implements Initializable {

    @FXML
    private Button btnexit;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnloadsetequipid;
    @FXML
    private Button btnloadequipid;
    @FXML
    private TextField txtequipmentid;
    @FXML
    private TextField txtsetequipid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnsimpanklik(ActionEvent event) {
        DetailequipsetModel eqsetdetail = new DetailequipsetModel();
        eqsetdetail.setSetequipid(txtsetequipid.getText());
        eqsetdetail.setEquipmentid(txtequipmentid.getText());
        FXMLDocumentController.dtdetailequipset.setDetailequipsetModel(eqsetdetail);
        if (FXMLDocumentController.dtdetailequipset.validasi(eqsetdetail.getSetequipid(), eqsetdetail.getEquipmentid()) <= 0) {
            if (FXMLDocumentController.dtdetailequipset.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data Detail Set Efek Berhasil Disimpan", ButtonType.OK);
                a.showAndWait();
                btnresetklik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data Detail Set Efek Equipment Gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Set Detail Set Efek Gagal Disimpan", ButtonType.OK);
            a.showAndWait();
            txtsetequipid.requestFocus();
        }
    }

    @FXML
    private void btnresetklik(ActionEvent event) {
        txtequipmentid.setText("");
        txtsetequipid.setText("");
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void btnloadsetequipidclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_PilihEquipmentSet.fxml"));
            Parent root = (Parent) loader.load();
            FXML_PilihEquipmentSetController isidt = (FXML_PilihEquipmentSetController) loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
            if (isidt.getHasil() == 1) {
                txtsetequipid.setText(isidt.getIdHasil());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnloadequipidclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_PilihEquipment.fxml"));
            Parent root = (Parent) loader.load();
            FXML_PilihEquipmentController isidt = (FXML_PilihEquipmentController) loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
            if (isidt.getHasil() == 1) {
                txtequipmentid.setText(isidt.getIdHasil());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
