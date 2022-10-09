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
public class FXML_InputEfekController implements Initializable {

    @FXML
    private Label lblmatk;
    @FXML
    private Label lblatk;
    @FXML
    private Slider sldmatk;
    @FXML
    private Slider sldatk;
    @FXML
    private TextField txtefekid;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnsimpan;
    @FXML
    private Label lblmdef;
    @FXML
    private Slider sldmdef;
    @FXML
    private Slider slddef;
    @FXML
    private Label lbldef;
    @FXML
    private Label lblmp;
    @FXML
    private Label lblhp;
    @FXML
    private Slider sldmp;
    @FXML
    private Slider sldhp;
    @FXML
    private Slider sldhit;
    @FXML
    private Slider sldaspd;
    @FXML
    private Label lblhit;
    @FXML
    private Label lblaspd;
    @FXML
    private Label lblcspd;
    @FXML
    private Slider sldcspd;
    @FXML
    private Slider sldcrate;
    @FXML
    private Label lblcrate;
    @FXML
    private Label lblcdmg;
    @FXML
    private Slider sldcdmg;

    private boolean editdata = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        updateSlider();
    }

    public void updateSlider() {
        sldatk.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblatk.setText(String.valueOf(newvalue.intValue()) + "%");
        });
        sldmatk.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblmatk.setText(String.valueOf(newvalue.intValue()) + "%");
        });
        sldhp.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblhp.setText(String.valueOf(newvalue.intValue()) + "%");
        });
        sldmp.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblmp.setText(String.valueOf(newvalue.intValue()) + "%");
        });
        sldaspd.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblaspd.setText(String.valueOf(newvalue.intValue()) + "%");
        });
        sldcspd.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblcspd.setText(String.valueOf(newvalue.intValue()) + "%");
        });
        slddef.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lbldef.setText(String.valueOf(newvalue.intValue()) + "%");
        });
        sldmdef.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblmdef.setText(String.valueOf(newvalue.intValue()) + "%");
        });
        sldcrate.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblcrate.setText(String.valueOf(newvalue.intValue()) + "%");
        });
        sldcdmg.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblcdmg.setText(String.valueOf(newvalue.intValue()) + "%");
        });
        sldhit.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblhit.setText(String.valueOf(newvalue.intValue()) + "%");
        });
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void btnresetklik(ActionEvent event) {
        txtefekid.setText("");
        sldatk.setValue(0);
        sldmatk.setValue(0);
        sldhp.setValue(0);
        sldmp.setValue(0);
        slddef.setValue(0);
        sldmdef.setValue(0);
        sldaspd.setValue(0);
        sldcspd.setValue(0);
        sldcrate.setValue(0);
        sldcdmg.setValue(0);
        sldhit.setValue(0);
    }

    @FXML
    private void btnsimpanklik(ActionEvent event) {
        if ((!txtefekid.getText().isEmpty())) {
            EfekModel eq = new EfekModel();
            eq.setEfekid(txtefekid.getText());
            eq.setAtk((int) sldatk.getValue());
            eq.setMatk((int) sldmatk.getValue());
            eq.setCriticaldamage((int) sldcdmg.getValue());
            eq.setCriticalrate((int) sldcrate.getValue());
            eq.setCspd((int) sldcspd.getValue());
            eq.setDef((int) slddef.getValue());
            eq.setHp((int) sldhp.getValue());
            eq.setHit((int) sldhit.getValue());
            eq.setMatk((int) sldmatk.getValue());
            eq.setMdef((int) sldmdef.getValue());
            eq.setMp((int) sldmp.getValue());
            FXMLDocumentController.dtefek.setEfekModel(eq);
            if (editdata) {
                if (FXMLDocumentController.dtefek.update()) {
                    Alert a = new Alert(Alert.AlertType.WARNING, "Data Efek Berhasil Diperbaharui", ButtonType.OK);
                    a.showAndWait();
                    btnexitklik(event);
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Data Efek Gagal Diperbaharui", ButtonType.OK);
                    a.showAndWait();
                }
            } else if (FXMLDocumentController.dtefek.validasi(eq.getEfekid()) <= 0) {
                if (FXMLDocumentController.dtefek.insert()) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Data Efek Berhasil Disimpan", ButtonType.OK);
                    a.showAndWait();
                    btnresetklik(event);
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Data Efek Gagal disimpan", ButtonType.OK);
                    a.showAndWait();
                }
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data Efek Gagal disimpan Krena Sudah Ada", ButtonType.OK);
                a.showAndWait();
                txtefekid.requestFocus();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Efek ID Kosong, Gagal Menyimpan Data Efek!", ButtonType.OK);
            a.showAndWait();
            txtefekid.requestFocus();
        }
    }

    public void execute(EfekModel eq) {
        if (!eq.getEfekid().isEmpty()) {
            editdata = true;
            txtefekid.setText(eq.getEfekid());
            txtefekid.setEditable(false);
            sldatk.setValue(eq.getAtk());
            sldmatk.setValue(eq.getMatk());
            sldhp.setValue(eq.getHp());
            sldmp.setValue(eq.getMp());
            sldaspd.setValue(eq.getAspd());
            sldcspd.setValue(eq.getCspd());
            sldhit.setValue(eq.getHit());
            slddef.setValue(eq.getDef());
            sldmdef.setValue(eq.getMdef());
            sldcrate.setValue(eq.getCriticalrate());
            sldcdmg.setValue(eq.getCriticaldamage());
            btnreset.setDisable(true);
        }
    }

}
