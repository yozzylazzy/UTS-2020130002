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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_InputDetailEfekController implements Initializable {

    public static DBSetcount data = new DBSetcount();
    @FXML
    private TextField txtjumlah;
    @FXML
    private ComboBox<String> cmbefektype;
    @FXML
    private TextField txtefekvalue;
    @FXML
    private Button btnloadefek;
    @FXML
    private TableView<DetailefekModel> tbvdetilefek;
    @FXML
    private Button btnclear;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btntambah;
    @FXML
    private TextField txtefekid;
    @FXML
    private TextField txtsetequipid;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnexit;

    private boolean editmode = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data.getDetailEfekModel().clear();
        cmbefektype.setItems(FXCollections.observableArrayList(
                "ATK", "MATK", "HP", "MP", "DEF", "MDEF", "HIT", "CRIT", "ASPD", "CSPD"));
        //cmbefektype.getSelectionModel().select(0);
        //Untuk mengambil tanggal hari ini otomatis
        showData();
    }

    public void showData() {
        //Melaod data sesuai database
        tbvdetilefek.getColumns().clear();
        tbvdetilefek.getItems().clear();
        TableColumn col = new TableColumn("Efek_ID");
        col.setCellValueFactory(new PropertyValueFactory<EfekModel, String>("Efekid"));
        tbvdetilefek.getColumns().addAll(col);
        col = new TableColumn("Efek_Type");
        col.setCellValueFactory(new PropertyValueFactory<EfekModel, String>("Efektype"));
        tbvdetilefek.getColumns().addAll(col);
        col = new TableColumn("Efek_Value");
        col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Efekvalue"));
        tbvdetilefek.getColumns().addAll(col);
        col = new TableColumn("Jumlah");
        col.setCellValueFactory(new PropertyValueFactory<DetailefekModel, Integer>("Jumlah"));
        tbvdetilefek.getColumns().addAll(col);
    }

    public void execute(SetcountModel d) {
        if (!d.getSetequipid().isEmpty()) {
            FXML_InputDetailEfekController.data.getSetcountModel().setSetequipid(d.getSetequipid());
            if (FXML_InputDetailEfekController.data.validasi(d.getSetequipid(), d.getJumlah()) >= 1) {
                SetcountModel tmp = FXML_InputDetailEfekController.data.getdata(d.getSetequipid(), d.getJumlah());
                editmode = true;
                FXML_InputDetailEfekController.data.setSetcountModel(d);
                txtsetequipid.setText(d.getSetequipid());
                txtjumlah.setText(String.valueOf(d.getJumlah()));
                ObservableList<DetailefekModel> data = FXML_InputDetailEfekController.data.LoadDetil();
                if (data != null) {
                    tbvdetilefek.setItems(data);
                }
                txtsetequipid.setEditable(false);
            }
        }
    }

    @FXML
    private void nofakturcek(KeyEvent event) {
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
                txtefekvalue.setText(String.valueOf(isidt.getEfekvalue()));
                cmbefektype.getSelectionModel().select(isidt.getEfektype());
                //data.getJualModel().set
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void tbvdetilefekklik(MouseEvent event) {
        DetailefekModel tmp = tbvdetilefek.getSelectionModel().getSelectedItem();
        if (tmp != null) {
            txtefekid.setText(tmp.getEfekid());
            txtefekvalue.setText(String.valueOf(tmp.getEfekvalue()));
            txtjumlah.setText(String.valueOf(tmp.getJumlah()));
            cmbefektype.setValue(String.valueOf(tmp.getEfektype()));
            int total = 0;
            for (int i = 0; i < tbvdetilefek.getItems().size(); i++) {
                DetailefekModel n = tbvdetilefek.getItems().get(i);
            }
            //txttotalbayar.setText(String.valueOf(total));
        }
    }

    @FXML
    private void btnclearklik(ActionEvent event) {
        txtefekid.setText("");
        txtefekvalue.setText("");
        cmbefektype.getSelectionModel().select(0);
        txtefekid.requestFocus();
    }

    @FXML
    private void btnhapusklik(ActionEvent event) {
        DetailefekModel tmp = tbvdetilefek.getSelectionModel().getSelectedItem();
        if (tmp != null) {
            tbvdetilefek.getItems().remove(tmp);
            data.getDetailEfekModel().remove(tmp.getEfekid());
            btnclearklik(event);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Pilih data dulu", ButtonType.OK);
            a.showAndWait();
            tbvdetilefek.requestFocus();
        }
    }

    @FXML
    private void btntambahklik(ActionEvent event) {
        DetailefekModel tmp = new DetailefekModel();
        tmp.setSetequipid(txtsetequipid.getText());
        tmp.setEfekid(txtefekid.getText());
        tmp.setEfektype(cmbefektype.getSelectionModel().getSelectedItem());
        tmp.setEfekvalue(Integer.parseInt(txtefekvalue.getText()));
        tmp.setJumlah(Integer.parseInt(txtjumlah.getText()));
        if (data.getDetailEfekModel().get(txtefekid.getText()) == null) {
            data.setDetailEfekModel(tmp);
            tbvdetilefek.getItems().add(tmp);
        } else {
            int p = -1;
            for (int i = 0; i < tbvdetilefek.getItems().size(); i++) {
                if (tbvdetilefek.getItems().get(i).getEfekid().equalsIgnoreCase(
                        txtefekid.getText())) {
                    p = i;
                }
            }
            if (p >= 0) {
                tbvdetilefek.getItems().set(p, tmp);
                data.getDetailEfekModel().remove(txtefekid.getText());
                data.setDetailEfekModel(tmp);
            }
        }
        btnclearklik(event);
    }

    @FXML
    private void btnsimpanklik(ActionEvent event) {
        data.getSetcountModel().setSetequipid(txtsetequipid.getText());
        data.getSetcountModel().setJumlah(Integer.parseInt(txtjumlah.getText()));
        if (data.saveall()) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan ", ButtonType.OK);
            a.showAndWait();
            btnresetklik(event);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan ", ButtonType.OK);
            a.showAndWait();
        }
    }

    @FXML
    private void btnresetklik(ActionEvent event) {
        btnclearklik(event);
        txtefekid.setText("");
        txtefekvalue.setText("");
        txtjumlah.setText("");
        txtsetequipid.setText("");
        data.getDetailEfekModel().clear();
        editmode = false;
        txtefekid.requestFocus();
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

}
