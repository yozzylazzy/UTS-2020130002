/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.pkg2020130002;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_InputEquipmentSetController implements Initializable {

    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnexit;
    @FXML
    private TextField txtsetequipmentid;
    @FXML
    private TextField txtname;

    private boolean editdata = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnsimpanklik(ActionEvent event) {
        EquipmentsetModel eqset = new EquipmentsetModel();
        eqset.setSetequipid(txtsetequipmentid.getText());
        eqset.setSetname(txtname.getText());
        FXMLDocumentController.dtequipset.setEquipmentsetModel(eqset);
        if (editdata) {
            if (FXMLDocumentController.dtequipset.update()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Data Set Equipment Berhasil Diperbaharui", ButtonType.OK);
                a.showAndWait();
                btnexitklik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data Set Equipment Gagal Diperbaharui", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtequipset.validasi(eqset.getSetequipid()) <= 0) {
            if (FXMLDocumentController.dtequipset.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data Set Equipment Berhasil Disimpan", ButtonType.OK);
                a.showAndWait();
                btnresetklik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data Set Equipment Gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Set Equipment Gagal Disimpan", ButtonType.OK);
            a.showAndWait();
            txtsetequipmentid.requestFocus();
        }
    }

    @FXML
    private void btnresetklik(ActionEvent event) {
        txtname.setText("");
        txtsetequipmentid.setText("");
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    public void execute(EquipmentsetModel eq) {
        if (!eq.getSetequipid().isEmpty()) {
            editdata = true;
            txtsetequipmentid.setEditable(false);
            txtsetequipmentid.setText(eq.getSetequipid());
            txtname.setText(eq.getSetname());
            btnreset.setDisable(true);
        }
    }
}
