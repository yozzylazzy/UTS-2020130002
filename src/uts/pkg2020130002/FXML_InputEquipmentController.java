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
import javafx.scene.control.ComboBox;
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
public class FXML_InputEquipmentController implements Initializable {

    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnexit;
    @FXML
    private Slider sldrarity;
    @FXML
    private Label lblrarity;
    @FXML
    private TextField txtequipmentname;
    @FXML
    private TextField txtequipmentid;
    @FXML
    private ComboBox<String> cmbequipmenttype;

    private boolean editdata = false;
    @FXML
    private TextField txtefekid;
    @FXML
    private Button btnloadefek;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbequipmenttype.setItems(FXMLDocumentController.dtequipments.LoadEquipmentType());
        sldrarityclick();
    }

    @FXML
    private void btnsimpanklik(ActionEvent event) {
        if (!txtequipmentid.getText().isEmpty() && !txtequipmentname.getText().isEmpty() && (cmbequipmenttype.getSelectionModel().getSelectedItem() != null)) {
            EquipmentModel eq = new EquipmentModel();
            eq.setEquipmentid(txtequipmentid.getText());
            eq.setEquipmentname(txtequipmentname.getText());
            eq.setEquipmenttype(cmbequipmenttype.getSelectionModel().getSelectedItem());
            eq.setEquipmentrarity((int) sldrarity.getValue());
            eq.setEfekid(txtefekid.getText());
            FXMLDocumentController.dtequipments.setEquipmentModel(eq);
            if (editdata) {
                if (FXMLDocumentController.dtequipments.update()) {
                    Alert a = new Alert(Alert.AlertType.WARNING, "Data Equipment Berhasil Diperbaharui", ButtonType.OK);
                    a.showAndWait();
                    btnexitklik(event);
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Data Equipment Gagal Diperbaharui", ButtonType.OK);
                    a.showAndWait();
                }
            } else if (FXMLDocumentController.dtequipments.validasi(eq.getEquipmentid()) <= 0) {
                if (FXMLDocumentController.dtequipments.insert()) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Data Equipment Berhasil Disimpan", ButtonType.OK);
                    a.showAndWait();
                    btnresetklik(event);
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Equipment Gagal Disimpan", ButtonType.OK);
                    a.showAndWait();
                }
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data Equipment Sudah Ada!", ButtonType.OK);
                a.showAndWait();
                txtequipmentid.requestFocus();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "DATA EQUIPMENT TIDAK LENGKAP!!!", ButtonType.OK);
            a.showAndWait();
            txtequipmentid.requestFocus();
        }
    }

    @FXML
    private void btnresetklik(ActionEvent event) {
        txtequipmentid.setText("");
        txtequipmentname.setText("");
        cmbequipmenttype.getSelectionModel().select(null);
        sldrarity.setValue(0);
        txtefekid.setText("");
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    private void sldrarityclick() {
        sldrarity.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblrarity.setText(String.valueOf(newvalue.intValue()));
        });
    }

    public void execute(EquipmentModel eq) {
        if (!eq.getEquipmentid().isEmpty()) {
            editdata = true;
            txtequipmentid.setText(eq.getEquipmentid());
            txtequipmentid.setEditable(false);
            txtequipmentname.setText(eq.getEquipmentname());
            cmbequipmenttype.getSelectionModel().select(eq.getEquipmenttype());
            sldrarity.setValue(eq.getEquipmentrarity());
            txtefekid.setText(eq.getEfekid());
            btnreset.setDisable(true);
        }
    }

    @FXML
    private void btnloadefekklik(ActionEvent event) {
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
}
