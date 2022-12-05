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
public class FXML_InputMasterDetilEfekController implements Initializable {

    @FXML
    private Button btnexit;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txtsetequipid;
    @FXML
    private TextField txtefekid;
    @FXML
    private TextField txtitemset;
    @FXML
    private Button btntambah;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnclear;
    @FXML
    private TableView<DetailsetefekModel> tbvdetilefek;
    @FXML
    private Button btnloadefek;
    @FXML
    private TextField txtefekvalue;
    @FXML
    private ComboBox<String> cmbefektype;
    @FXML
    private TextField txtnamaset;

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
        data.getDetailsetEfekModel().clear();
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
        col = new TableColumn("Item_Set");
        col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Itemset"));
        tbvdetilefek.getColumns().addAll(col);
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void btnresetklik(ActionEvent event) {
        btnclearklik(event);
        txtefekid.setText("");
        txtefekvalue.setText("");
        txtitemset.setText("");
        txtnamaset.setText("");
        txtsetequipid.setText("");
        txtnamaset.setText("");
        data.getDetailsetEfekModel().clear();
        editmode = false;
        txtefekid.requestFocus();
    }

    @FXML
    private void btnsimpanklik(ActionEvent event) {
        data.getEquipmentsetModel().setSetequipid(txtsetequipid.getText());
        data.getEquipmentsetModel().setSetname(txtnamaset.getText());
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
    private void nofakturcek(KeyEvent event) {
//        if (event.getCode() == KeyCode.TAB) {
//            data.getJualModel().setNofaktur(txtnofaktur.getText());
//            if (data.validasi(txtnofaktur.getText()) >= 1) {
//                JualModel tmp = data.getdata(txtnofaktur.getText());
//                if (tmp.getTanggal() != null) {
//                    datetanggal.setValue(tmp.getTanggal().toLocalDate());
//                    txtkodelgn.setText(tmp.getKodelgn());
//                    txtnamapelanggan.setText(tmp.getNamalgn());
//                    txtalamatlgn.setText(tmp.getAlamat());
//                    ObservableList<SubJualModel> dt = data.LoadDetil();
//                    if (dt != null) {
//                        tbvdetil.setItems(dt);
//                        hitungTotal();
//                    }
//                }
//                txtnofaktur.setEditable(false);
//                editmode = true;
//            }
//        }
    }

    @FXML
    private void btntambahklik(ActionEvent event) {
        DetailsetefekModel tmp = new DetailsetefekModel();
        tmp.setSetequipid(txtsetequipid.getText());
        tmp.setEfekid(txtefekid.getText());
        tmp.setEfektype(cmbefektype.getSelectionModel().getSelectedItem());
        tmp.setEfekvalue(Integer.parseInt(txtefekvalue.getText()));
        tmp.setItemset(Integer.parseInt(txtitemset.getText()));
        if (data.getDetailsetEfekModel().get(txtefekid.getText()) == null) {
            data.setDetailsetEfekModel(tmp);
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
                data.getDetailsetEfekModel().remove(txtefekid.getText());
                data.setDetailsetEfekModel(tmp);
            }

        }
        //hitungTotal();
        btnclearklik(event);
    }

    @FXML
    private void btnhapusklik(ActionEvent event) {
        DetailsetefekModel tmp = tbvdetilefek.getSelectionModel().getSelectedItem();
        if (tmp != null) {
            tbvdetilefek.getItems().remove(tmp);
            data.getDetailsetEfekModel().remove(tmp.getEfekid());
            btnclearklik(event);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Pilih data dulu", ButtonType.OK);
            a.showAndWait();
            tbvdetilefek.requestFocus();
        }
    }

    @FXML
    private void btnclearklik(ActionEvent event) {
        txtefekid.setText("");
        txtefekvalue.setText("");
        txtitemset.setText("");
        cmbefektype.getSelectionModel().select(0);
        txtefekid.requestFocus();
    }

    @FXML
    private void tbvdetilefekklik(MouseEvent event) {
        DetailsetefekModel tmp = tbvdetilefek.getSelectionModel().getSelectedItem();
        if (tmp != null) {
            txtefekid.setText(tmp.getEfekid());
            txtefekvalue.setText(String.valueOf(tmp.getEfekvalue()));
            txtitemset.setText(String.valueOf(tmp.getItemset()));
            cmbefektype.setValue(String.valueOf(tmp.getEfektype()));
            int total = 0;
            for (int i = 0; i < tbvdetilefek.getItems().size(); i++) {
                DetailsetefekModel n = tbvdetilefek.getItems().get(i);
            }
            //txttotalbayar.setText(String.valueOf(total));
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
                txtefekvalue.setText(String.valueOf(isidt.getEfekvalue()));
                cmbefektype.getSelectionModel().select(isidt.getEfektype());
                //data.getJualModel().set
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void execute(EquipmentsetModel d) {
        if (!d.getSetequipid().isEmpty()) {
            FXML_InputMasterDetilEfekController.data.getEquipmentsetModel().setSetequipid(d.getSetequipid());
            if (FXML_InputMasterDetilEfekController.data.validasi(d.getSetequipid()) >= 1) {
                EquipmentsetModel tmp = FXML_InputMasterDetilEfekController.data.getdata(d.getSetequipid());
                editmode = true;
                FXML_InputMasterDetilEfekController.data.setEquipmentsetModel(d);
                txtsetequipid.setText(d.getSetequipid());
                txtnamaset.setText(d.getSetname());
                ObservableList<DetailsetefekModel> data
                        = FXML_InputMasterDetilEfekController.data.LoadDetil();
                if (data != null) {
                    tbvdetilefek.setItems(data);
                }
                txtsetequipid.setEditable(false);
                txtnamaset.requestFocus();
            }
        }
    }
}
