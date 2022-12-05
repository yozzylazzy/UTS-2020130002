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
public class FXML_InputMasterDetilEquipmentSetController implements Initializable {

    @FXML
    private TextField txtnamaset;
    @FXML
    private ComboBox<String> cmbequipefek;
    @FXML
    private TextField txtequipmentstats;
    @FXML
    private TableView<DetailequipmentsetModel> tbvdetilequip;
    @FXML
    private Button btnclear;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btntambah;
    @FXML
    private TextField txtrarity;
    @FXML
    private TextField txtequipmentid;
    @FXML
    private TextField txtsetequipid;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnexit;
    @FXML
    private ComboBox<String> cmbequiptype;
    @FXML
    private TextField txtequipmentname;
    @FXML
    private Button btnloadequipment;

    private boolean editmode = false;
    public static DBEquipmentset data = new DBEquipmentset(); //Masukan ke FXML_DocumentController agar dapat dibuat static dan dipakai dimana2
    String namalgn, alamat;
    int harga;
    String namabrg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data.getDetailEquipmentSetModel().clear();
        cmbequiptype.setItems(FXCollections.observableArrayList(
                "Weapon", "Armor", "Belt"));
        cmbequipefek.setItems(FXCollections.observableArrayList(
                "ATK", "MATK", "HP", "MP", "DEF", "MDEF", "HIT", "CRIT", "ASPD", "CSPD"));
        //cmbefektype.getSelectionModel().select(0);
        //Untuk mengambil tanggal hari ini otomatis
        showData();
    }

    @FXML
    private void tbvdetilequipklik(MouseEvent event) {
        DetailequipmentsetModel tmp = tbvdetilequip.getSelectionModel().getSelectedItem();
        if (tmp != null) {
            txtequipmentid.setText(tmp.getEquipmentid());
            txtequipmentname.setText(tmp.getEquipmentname());
            txtequipmentstats.setText(String.valueOf(tmp.getEfekvalue()));
            txtrarity.setText(String.valueOf(tmp.getEquipmentrarity()));
            cmbequiptype.getSelectionModel().select(tmp.getEquipmenttype());
            cmbequipefek.getSelectionModel().select(tmp.getEfektype());
            int total = 0;
            for (int i = 0; i < tbvdetilequip.getItems().size(); i++) {
                DetailequipmentsetModel n = tbvdetilequip.getItems().get(i);
//                System.out.println(i);
//                System.out.println(n);
            }
            //txttotalbayar.setText(String.valueOf(total));
        }
    }

    @FXML
    private void btnclearklik(ActionEvent event) {
        txtequipmentid.setText("");
        txtequipmentname.setText("");
        txtequipmentstats.setText("");
        txtrarity.setText("");
        cmbequiptype.getSelectionModel().select(0);
        cmbequipefek.getSelectionModel().select(0);
    }

    @FXML
    private void btnhapusklik(ActionEvent event) {
        DetailequipmentsetModel tmp = tbvdetilequip.getSelectionModel().getSelectedItem();
        if (tmp != null) {
            tbvdetilequip.getItems().remove(tmp);
            data.getDetailsetEfekModel().remove(tmp.getEfekid());
            btnclearklik(event);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Pilih data dulu", ButtonType.OK);
            a.showAndWait();
            tbvdetilequip.requestFocus();
        }
    }

    @FXML
    private void btntambahklik(ActionEvent event) {
        DetailequipmentsetModel tmp = new DetailequipmentsetModel();
        tmp.setSetequipid(txtsetequipid.getText());
        tmp.setEquipmentid(txtequipmentid.getText());
        tmp.setEquipmentname(txtequipmentname.getText());
        tmp.setEfektype(cmbequipefek.getSelectionModel().getSelectedItem());
        tmp.setEfekvalue(Integer.parseInt(txtequipmentstats.getText()));
        tmp.setEquipmenttype(cmbequiptype.getSelectionModel().getSelectedItem());
        tmp.setEquipmentrarity(Integer.parseInt(txtrarity.getText()));
        if (data.getDetailEquipmentSetModel().get(txtequipmentid.getText()) == null) {
            data.setDetailEquipmentSetModel(tmp);
            tbvdetilequip.getItems().add(tmp);
        } else {
            int p = -1;
            for (int i = 0; i < tbvdetilequip.getItems().size(); i++) {
                if (tbvdetilequip.getItems().get(i).getEfekid().equalsIgnoreCase(
                        txtequipmentid.getText())) {
                    p = i;
                }
            }
            if (p >= 0) {
                tbvdetilequip.getItems().set(p, tmp);
                data.getDetailsetEfekModel().remove(txtequipmentid.getText());
                data.setDetailEquipmentSetModel(tmp);
            }
        }
        //hitungTotal();
        btnclearklik(event);
    }

    @FXML
    private void setequipidcek(KeyEvent event) {

    }

    public void showData() {
        //Melaod data sesuai database
        tbvdetilequip.getColumns().clear();
        tbvdetilequip.getItems().clear();
        TableColumn col = new TableColumn("Equipment_ID");
        col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmentid"));
        tbvdetilequip.getColumns().addAll(col);
        col = new TableColumn("Equipment_Name");
        col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Equipmentname"));
        tbvdetilequip.getColumns().addAll(col);
        col = new TableColumn("Equipment_Type");
        col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, String>("Equipmenttype"));
        tbvdetilequip.getColumns().addAll(col);
        col = new TableColumn("Efek_Type");
        col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Efektype"));
        tbvdetilequip.getColumns().addAll(col);
        col = new TableColumn("Rarity");
        col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Equipmentrarity"));
        tbvdetilequip.getColumns().addAll(col);
        col = new TableColumn("Efek_Value");
        col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Efekvalue"));
        tbvdetilequip.getColumns().addAll(col);
    }

    @FXML
    private void btnsimpanklik(ActionEvent event) {
        data.getEquipmentsetModel().setSetequipid(txtsetequipid.getText());
        data.getEquipmentsetModel().setSetname(txtnamaset.getText());
        if (data.savealldetailequipset()) {
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
        txtequipmentid.setText("");
        txtequipmentname.setText("");
        txtequipmentstats.setText("");
        txtnamaset.setText("");
        txtsetequipid.setText("");
        txtrarity.setText("");
        data.getDetailsetEfekModel().clear();
        editmode = false;
        txtequipmentid.requestFocus();
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void btnloadequipmentklik(ActionEvent event) {
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
                txtequipmentname.setText(String.valueOf(isidt.getEquipName()));
                cmbequiptype.getSelectionModel().select(isidt.getType());
                cmbequipefek.getSelectionModel().select(isidt.getEfek());
                txtequipmentstats.setText(String.valueOf(isidt.getStats()));
                txtrarity.setText(String.valueOf(isidt.getRarity()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void execute(EquipmentsetModel d) {
        if (!d.getSetequipid().isEmpty()) {
            FXML_InputMasterDetilEquipmentSetController.data.getEquipmentsetModel().setSetequipid(d.getSetequipid());
            if (FXML_InputMasterDetilEquipmentSetController.data.validasi(d.getSetequipid()) >= 1) {
                EquipmentsetModel tmp = FXML_InputMasterDetilEquipmentSetController.data.getdata(d.getSetequipid());
                editmode = true;
                FXML_InputMasterDetilEquipmentSetController.data.setEquipmentsetModel(d);
                txtsetequipid.setText(d.getSetequipid());
                txtnamaset.setText(d.getSetname());
                ObservableList<DetailequipmentsetModel> data
                        = FXML_InputMasterDetilEquipmentSetController.data.LoadDetilEquipset();
                if (data != null) {
                    tbvdetilequip.setItems(data);
                }
                txtsetequipid.setEditable(false);
                txtnamaset.requestFocus();
            }
        }
    }
}
