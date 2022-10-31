/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.pkg2020130002;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
public class FXML_InputEfekController implements Initializable {

    @FXML
    private TextField txtefekid;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnsimpan;

    private boolean editdata = false;
    @FXML
    private Label lblsldvalue;
    @FXML
    private Slider sldvalue;
    @FXML
    private ComboBox<String> cmbefektype;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbefektype.setItems(FXCollections.observableArrayList(
                "ATK", "MATK", "DEF", "MDEF"));
        cmbefektype.getSelectionModel().select(0);
        updateSlider();
    }

    public void updateSlider() {
        sldvalue.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            lblsldvalue.setText(String.valueOf(newvalue.intValue() * 100));
        });
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void btnresetklik(ActionEvent event) {
        txtefekid.setText("");
        cmbefektype.getSelectionModel().select(null);
        sldvalue.setValue(0);

    }

    @FXML
    private void btnsimpanklik(ActionEvent event) {
        if ((!txtefekid.getText().isEmpty())) {
            EfekModel eq = new EfekModel();
            eq.setEfekid(txtefekid.getText());
            eq.setEfektype(cmbefektype.getSelectionModel().getSelectedItem());
            eq.setEfekvalue((int) sldvalue.getValue());

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
            cmbefektype.getSelectionModel().select(eq.getEfektype());
            sldvalue.setValue(eq.getEfekvalue());
            btnreset.setDisable(true);
        }
    }

}
