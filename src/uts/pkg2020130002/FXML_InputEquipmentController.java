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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private Slider sldstr;
    @FXML
    private Slider sldintl;
    @FXML
    private Slider sldvit;
    @FXML
    private Slider sldagi;
    @FXML
    private Label lblstr;
    @FXML
    private Label lblintl;
    @FXML
    private Label lblvit;
    @FXML
    private Label lblagi;
    @FXML
    private Label lbldex;
    @FXML
    private Slider slddex;
    @FXML
    private Slider sldcrit;
    @FXML
    private Label lblcrit;

    private boolean editdata = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sldrarityclick();
    }

    @FXML
    private void btnsimpanklik(ActionEvent event) {
        EquipmentModel eq = new EquipmentModel();
        eq.setEquipmentid(txtequipmentid.getText());
        eq.setEquipmentname(txtequipmentname.getText());
        eq.setEquipmenttype(cmbequipmenttype.getSelectionModel().getSelectedItem());
        eq.setEquipmentrarity((int) sldrarity.getValue());
        eq.setStr((int) sldstr.getValue());
        eq.setIntl((int) sldintl.getValue());
        eq.setAgi((int) sldagi.getValue());
        eq.setCrit((int) sldcrit.getValue());
        eq.setDex((int) slddex.getValue());
        eq.setVit((int) sldvit.getValue());
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
        } else if (FXMLDocumentController.dtequipments.validasi(eq.getEquipmentid()) < 0) {
            if (FXMLDocumentController.dtequipments.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data Equipment Berhasil Disimpan", ButtonType.OK);
                a.showAndWait();
                btnresetklik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data Equipment Gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Equipment Sudah Terdaftar Sebelumnya!", ButtonType.OK);
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
        sldstr.setValue(0);
        sldintl.setValue(0);
        sldagi.setValue(0);
        slddex.setValue(0);
        sldvit.setValue(0);
        sldcrit.setValue(0);
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

    private void sldstrclick(MouseEvent event) {
        sldstr.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblstr.setText(String.valueOf(newvalue.intValue()));
        });
    }

    private void sldintlclick(MouseEvent event) {
        sldintl.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblintl.setText(String.valueOf(newvalue.intValue()));
        });
    }

    private void sldvitclick(MouseEvent event) {
        sldvit.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblvit.setText(String.valueOf(newvalue.intValue()));
        });
    }

    private void sldagiclick(MouseEvent event) {
        sldagi.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblagi.setText(String.valueOf(newvalue.intValue()));
        });
    }

    private void slddexclick(MouseEvent event) {
        slddex.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lbldex.setText(String.valueOf(newvalue.intValue()));
        });
    }

    private void sldcritclick(MouseEvent event) {
        sldcrit.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblcrit.setText(String.valueOf(newvalue.intValue()));
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
            sldstr.setValue(eq.getStr());
            sldintl.setValue(eq.getIntl());
            sldagi.setValue(eq.getAgi());
            slddex.setValue(eq.getDex());
            sldvit.setValue(eq.getVit());
            sldcrit.setValue(eq.getCrit());
            btnreset.setDisable(true);
        }
    }

}
