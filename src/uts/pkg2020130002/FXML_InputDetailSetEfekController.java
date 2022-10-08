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
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_InputDetailSetEfekController implements Initializable {

    @FXML
    private TextField txtsetequipid;
    @FXML
    private Button btnloadsetequipid;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnexit;
    @FXML
    private Slider slditemset;
    @FXML
    private Label lblitemset;
    @FXML
    private Button btnloadefekid;
    @FXML
    private TextField txtefekid;

    private boolean editdata = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        slditemset.valueProperty().addListener((observable, odlval, newval) -> {
            lblitemset.setText(String.valueOf(newval.intValue()));
        });
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
    private void btnloadefekidclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_PilihEfek.fxml"));
            Parent root = (Parent) loader.load();
            FXML_PilihEfekController isidt = (FXML_PilihEfekController) loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
            if (isidt.getHasil() == 1) {
                txtefekid.setText(isidt.getIdHasil());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnsimpanklik(ActionEvent event) {
        DetailsetefekModel eqsetefek = new DetailsetefekModel();
        eqsetefek.setSetequipid(txtsetequipid.getText());
        eqsetefek.setEfekid(txtefekid.getText());
        FXMLDocumentController.dtdetailsetefek.setDetailsetefekModel(eqsetefek);
        if (editdata) {
            if (FXMLDocumentController.dtdetailsetefek.update()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Data Detail Set Efek Berhasil Diperbaharui", ButtonType.OK);
                a.showAndWait();
                btnexitklik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data Detail Set Efek Gagal Diperbaharui", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtdetailsetefek.validasi(eqsetefek.getSetequipid(), eqsetefek.getEfekid()) <= 0) {
            if (FXMLDocumentController.dtdetailsetefek.insert()) {
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
        txtefekid.setText("");
        txtsetequipid.setText("");
        slditemset.setValue(0);
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    public void execute(DetailsetefekModel eq) {
        if (!eq.getSetequipid().isEmpty() && !eq.getEfekid().isEmpty()) {
            editdata = true;
            txtsetequipid.setText(eq.getSetequipid());
            txtefekid.setText(eq.getEfekid());
            btnreset.setDisable(true);
        }
    }

}
