/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package uts.pkg2020130002;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.text.html.HTMLDocument;
import static uts.pkg2020130002.FXML_InputMasterDetilEfekController.data;

/**
 *
 * @author asus
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Menu showweapon;
    @FXML
    private ComboBox<String> cmbweapons;
    @FXML
    private TableView<EquipmentModel> tbvstat;
    @FXML
    private MenuItem masterefek;
    @FXML
    private ComboBox<String> cmbarmor;
    @FXML
    private ComboBox<String> cmbbelt;
    @FXML
    private ComboBox<String> cmbring;
    @FXML
    private ComboBox<String> cmbnecklace;
    @FXML
    private MenuItem displayefek;
    @FXML
    private MenuItem displaysetequip;
    @FXML
    private TableView<EfekModel> tbvstatbelt;
    @FXML
    private TableView<SetcountModel> tbvstatarmor;
    @FXML
    private MenuItem masterequipment;
    @FXML
    private MenuItem masterequipmentset;
    @FXML
    private MenuItem displayequipment;
    @FXML
    private MenuItem displaydetailsetefek;
    @FXML
    private MenuItem btnexit;
    @FXML
    private MenuItem masterdetailsetefek;
    @FXML
    private ImageView imgbackground;
    @FXML
    private ImageView imgchar;
    @FXML
    private ImageView imgring;
    @FXML
    private ImageView imgnecklace;
    @FXML
    private ImageView imgbackground1;
    @FXML
    private Rectangle equipmentpaneqctivated;
    @FXML
    private Rectangle statuspaneactivated;
    @FXML
    private AnchorPane equipmentmenu;
    @FXML
    private Button btnequipmentmenuactiv;
    @FXML
    private Button btnstatusactiv;
    @FXML
    private AnchorPane statuspaneactiv;
    @FXML
    private Label menuname;

    public static DBEquipmentset dtequipset = new DBEquipmentset();
    public static DBDetailsetefek dtdetailsetefek = new DBDetailsetefek();
    public static DBEquipment dtequipments = new DBEquipment();
    public static DBEfek dtefek = new DBEfek();
    public static DBDetailefek dtdetailefek = new DBDetailefek();
    public static DBSetcount dtsetcount = new DBSetcount();
    public static DBInventory dtinventory = new DBInventory();
    public static DBPlayer dtplayer = new DBPlayer();
    public static DBPlayer newsetplayer = new DBPlayer();

    ObservableList<String> details = FXCollections.observableArrayList();
    private String weapon = "", armor = "", belt = "", necklace = "", ring = "";

    @FXML
    private Label totalhp;
    @FXML
    private Label totalmp;
    @FXML
    private Label totalatk;
    @FXML
    private Label totalmatk;
    @FXML
    private Label totaldef;
    @FXML
    private Label totalmdef;
    @FXML
    private Label totalhit;
    @FXML
    private Label totalflee;
    @FXML
    private Label totalaspd;
    @FXML
    private Label totalcspd;

    private int hp = 0, mp = 0, atk = 0, matk = 0, def = 0, mdef = 0, hit = 0, flee = 0, aspd = 0, cspd = 0;
    private int hpefek = 0, mpefek = 0, atkefek = 0, matkefek = 0, defefek = 0, mdefefek = 0, hitefek = 0, fleeefek = 0, aspdefek = 0, cspdefek = 0;

    @FXML
    private MenuItem displaydetailefek;
    @FXML
    private MenuItem masterdetailefek;
    @FXML
    private Label txtequipset;
    @FXML
    private ComboBox<String> cmbuserid;
    @FXML
    private Button btnsaveequipset;
    @FXML
    private Label lblequipname;
    @FXML
    private Label lblequiptype;
    @FXML
    private Label txtfieldequipsetall;
    @FXML
    private ImageView imgarmor;
    @FXML
    private ImageView imghelm;
    @FXML
    private ImageView imgbelt;
    @FXML
    private Label lblequipefektype;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setComboweapon();
        setCombobelt();
        setComboarmor();
        setComboRing();
        setCombonecklace();
        setComboId();
    }

    public void setComboId() {
        cmbuserid.getSelectionModel().select(null);
        cmbuserid.getItems().clear();
        ObservableList<String> userid = FXCollections.observableArrayList();
        for (int i = 0; i < dtplayer.Load().size(); i++) {
            userid.add(i, dtplayer.Load().get(i).getUserid());
        }
        cmbuserid.getItems().addAll(userid);
    }

    public void setComboweapon() {
        if (!cmbweapons.getSelectionModel().isEmpty()) {
            String weapstat = cmbweapons.getSelectionModel().getSelectedItem();
            if (cmbweapons.getSelectionModel().getSelectedItem() != null) {
                for (int i = 0; i < dtequipments.Load().size(); i++) {
                    if (weapstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                        weapon = "";
                        reduceStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                        lepasequip(dtequipments.Load().get(i).getEquipmentid());
                    }
                }
            }
            loadStat();
            checkEquipped();
            loadEfek();
            loadSetEfek();
        }
        cmbweapons.getSelectionModel().select(null);
        cmbweapons.getItems().clear();
        ObservableList<String> weapons = FXCollections.observableArrayList();
        for (int i = 0; i < dtequipments.LoadWeapon().size(); i++) {
            weapons.add(i, dtequipments.LoadWeapon().get(i).getEquipmentname());
        }
        cmbweapons.getItems().addAll(weapons);
    }

    public void setComboarmor() {
        if (!cmbarmor.getSelectionModel().isEmpty()) {
            String armorstat = cmbarmor.getSelectionModel().getSelectedItem();
            if (cmbarmor.getSelectionModel().getSelectedItem() != null) {
                for (int i = 0; i < dtequipments.Load().size(); i++) {
                    if (armorstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                        armor = "";
                        reduceStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                        lepasequip(dtequipments.Load().get(i).getEquipmentid());
                    }
                }
            }
            loadStat();
            checkEquipped();
            loadEfek();
            loadSetEfek();
        }
        cmbarmor.getSelectionModel().select(null);
        cmbarmor.getItems().clear();
        ObservableList<String> armors = FXCollections.observableArrayList();
        for (int i = 0; i < dtequipments.LoadArmor().size(); i++) {
            armors.add(i, dtequipments.LoadArmor().get(i).getEquipmentname());
        }
        cmbarmor.getItems().addAll(armors);
    }

    public void setCombobelt() {
        if (!cmbbelt.getSelectionModel().isEmpty()) {
            String beltstat = cmbbelt.getSelectionModel().getSelectedItem();
            if (cmbbelt.getSelectionModel().getSelectedItem() != null) {
                for (int i = 0; i < dtequipments.Load().size(); i++) {
                    if (beltstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                        belt = "";
                        reduceStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                        lepasequip(dtequipments.Load().get(i).getEquipmentid());
                    }
                }
            }
            loadStat();
            checkEquipped();
            loadEfek();
            loadSetEfek();
        }
        cmbbelt.getSelectionModel().select(null);
        cmbbelt.getItems().clear();
        ObservableList<String> belts = FXCollections.observableArrayList();
        for (int i = 0; i < dtequipments.LoadBelt().size(); i++) {
            belts.add(i, dtequipments.LoadBelt().get(i).getEquipmentname());
        }
        cmbbelt.getItems().addAll(belts);
    }

    public void setCombonecklace() {
        if (!cmbnecklace.getSelectionModel().isEmpty()) {
            String necklacestat = cmbnecklace.getSelectionModel().getSelectedItem();
            if (cmbnecklace.getSelectionModel().getSelectedItem() != null) {
                for (int i = 0; i < dtequipments.Load().size(); i++) {
                    if (necklacestat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                        necklace = "";
                        reduceStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                        lepasequip(dtequipments.Load().get(i).getEquipmentid());
                    }
                }
            }
            loadStat();
            checkEquipped();
            loadEfek();
            loadSetEfek();
        }
        cmbnecklace.getSelectionModel().select(null);
        cmbnecklace.getItems().clear();
        ObservableList<String> necklaces = FXCollections.observableArrayList();
        for (int i = 0; i < dtequipments.LoadNecklace().size(); i++) {
            necklaces.add(i, dtequipments.LoadNecklace().get(i).getEquipmentname());
        }
        cmbnecklace.getItems().addAll(necklaces);
    }

    public void setComboRing() {
        if (!cmbring.getSelectionModel().isEmpty()) {
            String ringstat = cmbring.getSelectionModel().getSelectedItem();
            if (cmbring.getSelectionModel().getSelectedItem() != null) {
                for (int i = 0; i < dtequipments.Load().size(); i++) {
                    if (ringstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                        ring = "";
                        reduceStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                        lepasequip(dtequipments.Load().get(i).getEquipmentid());
                    }
                }
            }
            loadStat();
            checkEquipped();
            loadEfek();
            loadSetEfek();
        }
        cmbring.getSelectionModel().select(null);
        cmbring.getItems().clear();
        ObservableList<String> rings = FXCollections.observableArrayList();
        for (int i = 0; i < dtequipments.LoadRing().size(); i++) {
            rings.add(i, dtequipments.LoadRing().get(i).getEquipmentname());
        }
        cmbring.getItems().addAll(rings);
    }

    @FXML
    private void img3clicked(MouseEvent event) {

    }

    @FXML
    private void showweaponklik(ActionEvent event) {

    }

    public ObservableList<EfekModel> LoadEfekSet(ArrayList<String> efekid) {
        ObservableList<EfekModel> tableData = FXCollections.observableArrayList();
        ObservableList<EfekModel> efekdata = FXMLDocumentController.dtefek.Load();
        hpefek = 0;
        mpefek = 0;
        atkefek = 0;
        matkefek = 0;
        defefek = 0;
        mdefefek = 0;
        hitefek = 0;
        fleeefek = 0;
        aspdefek = 0;
        cspdefek = 0;
        for (int i = 0; i < efekid.size(); i++) {
            for (int j = 0; j < efekdata.size(); j++) {
                if (efekid.get(i).equals(efekdata.get(j).getEfekid())) {
                    //System.out.println("Efek ID Array : " + efekid.get(i));
                    EfekModel d = new EfekModel();
                    d.setEfekid(efekdata.get(j).getEfekid());
                    d.setEfektype(efekdata.get(j).getEfektype());
                    d.setEfekvalue(efekdata.get(j).getEfekvalue());
                    updateStatusCharacterFromEfek(efekdata.get(j).getEfektype(), efekdata.get(j).getEfekvalue());
                    tableData.add(d);
                }
            }
        }
        return tableData;
    }

    public void loadSetEfek() {
        ObservableList<EfekModel> data = LoadEfekSet(loadEfekID());
        if (data != null) {
            tbvstatbelt.getColumns().clear();
            tbvstatbelt.getItems().clear();
            TableColumn col = new TableColumn("Efek_ID");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, String>("Efekid"));
            tbvstatbelt.getColumns().addAll(col);
            col = new TableColumn("Efek_Type");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, String>("Efektype"));
            tbvstatbelt.getColumns().addAll(col);
            col = new TableColumn("Efek_Value");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, String>("Efekvalue"));
            tbvstatbelt.getColumns().addAll(col);
            tbvstatbelt.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvstatbelt.getScene().getWindow().hide();
        }
    }

    public ArrayList<String> loadEfek() {
        ArrayList nameset = new ArrayList<String>();
        ArrayList itemmax = new ArrayList<Integer>();
        ArrayList setnow = new ArrayList<Integer>();
        String setequipnow = "", setnameakhir = "";
        int itemsetnow = 0, jumlahmax = 0;
        for (int i = 0; i < dtequipments.LoadEquipSet(weapon, armor, belt, ring, necklace).size(); i++) {
            setequipnow = dtequipments.LoadEquipSet(weapon, armor, belt, ring, necklace).get(i).getSetequipid();
            itemsetnow = dtequipments.LoadEquipSet(weapon, armor, belt, ring, necklace).get(i).getJumlah();
            jumlahmax = dtequipset.getdata(setequipnow).getJumlahmax();
            itemmax.add(i, jumlahmax);
            setnow.add(i, itemsetnow);
            if (itemsetnow >= jumlahmax) {
                nameset.add(i, dtdetailsetefek.LoadSetEfek(setequipnow, jumlahmax));
            } else {
                nameset.add(i, dtdetailsetefek.LoadSetEfek(setequipnow, itemsetnow));
            }
        }
        for (int j = 0; j < nameset.size(); j++) {
            if (setnameakhir != "") {
                setnameakhir = setnameakhir + "\n✜ " + nameset.get(j).toString() + " - " + setnow.get(j) + "/" + itemmax.get(j);
            } else {
                setnameakhir = "✜ " + nameset.get(j).toString() + " - " + setnow.get(j) + "/" + itemmax.get(j);
            }
        }
        txtequipset.setText(String.valueOf(setnameakhir));
        return nameset;
    }

    public ArrayList<String> loadEfekID() {
        ArrayList nameset = new ArrayList<String>();
        String setequipnow = "", setnameakhir = "";
        int jumlahmax;
        int itemsetnow = 0;
        for (int i = 0; i < dtequipments.LoadEquipSet(weapon, armor, belt, ring, necklace).size(); i++) {
            setequipnow = dtequipments.LoadEquipSet(weapon, armor, belt, ring, necklace).get(i).getSetequipid();
            itemsetnow = dtequipments.LoadEquipSet(weapon, armor, belt, ring, necklace).get(i).getJumlah();
            jumlahmax = dtequipset.getdata(setequipnow).getJumlahmax();
            if (itemsetnow > jumlahmax) {
                for (int k = 0; k < dtsetcount.LoadEquipSet(setequipnow, jumlahmax).size(); k++) {
                    nameset.add(k, dtsetcount.LoadEquipSet(setequipnow, jumlahmax).get(k).getEfekid());
                }
            } else {
                for (int k = 0; k < dtsetcount.LoadEquipSet(setequipnow, itemsetnow).size(); k++) {
                    nameset.add(k, dtsetcount.LoadEquipSet(setequipnow, itemsetnow).get(k).getEfekid());
                }
            }
        }
        for (int j = 0; j < nameset.size(); j++) {
            // System.out.println(nameset.get(j) + " " + nameset.size());
            if (setnameakhir != "") {
                setnameakhir = setnameakhir + "\n" + nameset.get(j).toString();
            } else {
                setnameakhir = nameset.get(j).toString();
            }
        }
        return nameset;
    }

    public void checkEquipped() {
        ObservableList<SetcountModel> data = FXMLDocumentController.dtequipments.LoadEquipSet(weapon, armor, belt, ring, necklace);
        if (data != null) {
            tbvstatarmor.getColumns().clear();
            tbvstatarmor.getItems().clear();

            TableColumn col = new TableColumn("Set_Equip_ID");
            col.setCellValueFactory(new PropertyValueFactory<SetcountModel, String>("Setequipid"));
            tbvstatarmor.getColumns().addAll(col);

            col = new TableColumn("Jumlah");
            col.setCellValueFactory(new PropertyValueFactory<SetcountModel, String>("Jumlah"));
            tbvstatarmor.getColumns().addAll(col);

            tbvstatarmor.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvstatarmor.getScene().getWindow().hide();
        }
    }

    public void loadStat() {
        ObservableList<EquipmentModel> data = FXMLDocumentController.dtequipments.LoadInHome(weapon, armor, belt, ring, necklace);
        if (data != null) {
            tbvstat.getColumns().clear();
            tbvstat.getItems().clear();
            TableColumn col = new TableColumn("Equipment_ID");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Equipmentid"));
            tbvstat.getColumns().addAll(col);
            col = new TableColumn("Equipment_Type");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Equipmenttype"));
            tbvstat.getColumns().addAll(col);
            col = new TableColumn("Efek_Type");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Efektype"));
            tbvstat.getColumns().addAll(col);
            col = new TableColumn("Efek_Value");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Efekvalue"));
            tbvstat.getColumns().addAll(col);
            tbvstat.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvstat.getScene().getWindow().hide();
        }
    }

    @FXML
    private void displayefekclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayEfek.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void displaysetequipclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayEquipmentSet.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void displayequipmentclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayEquipment.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void displaydetailsetefekclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayMasterDetilEfek.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void masterequipmentclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputEquipment.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void masterequipmentsetclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputEquipmentSet.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void masterdetailsetefekclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputMasterDetilEfek.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void masterefekclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputEfek.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updatearmor(ActionEvent event) {
        String armorstat = cmbarmor.getSelectionModel().getSelectedItem();
        if (cmbarmor.getSelectionModel().getSelectedItem() != null) {
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (armorstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    tambahequip(dtequipments.Load().get(i).getEquipmentid());
                    armor = dtequipments.Load().get(i).getEquipmentid();
                    updateStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                }
            }
        }
        loadStat();
        checkEquipped();
        loadEfek();
        loadSetEfek();
    }

    public void reduceStatusCharacter(String type, int value) {
        switch (type.toLowerCase()) {
            case "hp":
                hp = hp - value;
                break;
            case "mp":
                mp = mp - value;
                break;
            case "atk":
                atk = atk - value;
                break;
            case "matk":
                matk = matk - value;
                break;
            case "def":
                def = def - value;
                break;
            case "mdef":
                mdef = mdef - value;
                break;
            case "hit":
                hit = hit - value;
                break;
            case "flee":
                flee = flee - value;
                break;
            case "aspd":
                aspd = aspd - value;
                break;
            case "cspd":
                cspd = cspd - value;
                break;
            default:
                throw new AssertionError();
        }
        totalaspd.setText(String.valueOf(aspd));
        totalcspd.setText(String.valueOf(cspd));
        totalhit.setText(String.valueOf(hit));
        totalhp.setText(String.valueOf(hp));
        totalmp.setText(String.valueOf(mp));
        totalatk.setText(String.valueOf(atk));
        totalmatk.setText(String.valueOf(matk));
        totaldef.setText(String.valueOf(def));
        totalmdef.setText(String.valueOf(mdef));
        totalflee.setText(String.valueOf(flee));
    }

    public void updateStatusCharacter(String type, int value) {
        switch (type.toLowerCase()) {
            case "hp":
                hp = hp + value;
                break;
            case "mp":
                mp = mp + value;
                break;
            case "atk":
                atk = atk + value;
                break;
            case "matk":
                matk = matk + value;
                break;
            case "def":
                def = def + value;
                break;
            case "mdef":
                mdef = mdef + value;
                break;
            case "hit":
                hit = hit + value;
                break;
            case "flee":
                flee = flee + value;
                break;
            case "aspd":
                aspd = aspd + value;
                break;
            case "cspd":
                cspd = cspd + value;
                break;
            default:
                throw new AssertionError();
        }
        totalaspd.setText(String.valueOf(aspd));
        totalcspd.setText(String.valueOf(cspd));
        totalhit.setText(String.valueOf(hit));
        totalhp.setText(String.valueOf(hp));
        totalmp.setText(String.valueOf(mp));
        totalatk.setText(String.valueOf(atk));
        totalmatk.setText(String.valueOf(matk));
        totaldef.setText(String.valueOf(def));
        totalmdef.setText(String.valueOf(mdef));
        totalflee.setText(String.valueOf(flee));
    }

    public void updateStatusCharacterFromEfek(String type, int value) {
        switch (type.toLowerCase()) {
            case "hp":
                hpefek = hpefek + value;
                break;
            case "mp":
                mpefek = mpefek + value;
                break;
            case "atk":
                atkefek = atkefek + value;
                break;
            case "matk":
                matkefek = matkefek + value;
                break;
            case "def":
                defefek = defefek + value;
                break;
            case "mdef":
                mdefefek = mdefefek + value;
                break;
            case "hit":
                hitefek = hitefek + value;
                break;
            case "flee":
                fleeefek = fleeefek + value;
                break;
            case "aspd":
                aspdefek = aspdefek + value;
                break;
            case "cspd":
                cspdefek = cspdefek + value;
                break;
            default:
                throw new AssertionError();
        }
        totalaspd.setText(String.valueOf(aspdefek + aspd));
        totalcspd.setText(String.valueOf(cspdefek + cspd));
        totalhit.setText(String.valueOf(hitefek + hit));
        totalhp.setText(String.valueOf(hpefek + hp));
        totalmp.setText(String.valueOf(mpefek + mp));
        totalatk.setText(String.valueOf(atkefek + atk));
        totalmatk.setText(String.valueOf(matkefek + matk));
        totaldef.setText(String.valueOf(defefek + def));
        totalmdef.setText(String.valueOf(mdefefek + mdef));
        totalflee.setText(String.valueOf(fleeefek + flee));
    }

    @FXML
    private void updateBelt(ActionEvent event) {
        String beltstat = cmbbelt.getSelectionModel().getSelectedItem();
        if (cmbbelt.getSelectionModel().getSelectedItem() != null) {
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (beltstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    belt = dtequipments.Load().get(i).getEquipmentid();
                    updateStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                    tambahequip(dtequipments.Load().get(i).getEquipmentid());
                }
            }
        }
        loadStat();
        checkEquipped();
        loadEfek();
        loadSetEfek();
    }

    @FXML
    private void updateWeapon(ActionEvent event) {
        String weapstat = cmbweapons.getSelectionModel().getSelectedItem();
        if (cmbweapons.getSelectionModel().getSelectedItem() != null) {
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (weapstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    weapon = dtequipments.Load().get(i).getEquipmentid();
                    updateStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                    tambahequip(dtequipments.Load().get(i).getEquipmentid());
                }
            }
        }
        loadStat();
        checkEquipped();
        loadEfek();
        loadSetEfek();
    }

    @FXML
    private void btnexitclick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void setWeapon(MouseEvent event) {
        setComboweapon();
    }

    @FXML
    private void setArmor(MouseEvent event) {
        setComboarmor();
    }

    @FXML
    private void setBelt(MouseEvent event) {
        setCombobelt();
    }

    public void setEquipStatsInfo(EquipmentModel e, ObservableList<DetailefekModel> f) {
        lblequipname.setText(e.getEquipmentname());
        String ratestar = "";
        for (int i = 0; i < e.getEquipmentrarity(); i++) {
            ratestar = ratestar + "☆";
        }
        lblequiptype.setText(e.getEquipmenttype() + "  -  " + ratestar);
        lblequipefektype.setText("🔱 " + e.getEfektype() + " - " + String.valueOf(e.getEfekvalue()));
        String efekfull = "";
        int i = 1;
        for (int x = 0; x < f.size(); x++) {
            int cekcombo = f.get(x).getJumlah();
            if (cekcombo == i) {
                efekfull = efekfull + "   ➼ " + f.get(x).getEfektype() + " - " + f.get(x).getEfekvalue() + "\n";
            } else {
                efekfull = efekfull + "☬ " + f.get(x).getSetname() + " - " + f.get(x).getJumlah() + "/" + f.get(x).getJumlahmax() + "\n"
                        + "   ➼ " + f.get(x).getEfektype() + " - " + f.get(x).getEfekvalue() + "\n";
                i++;
            }
        }
        txtfieldequipsetall.setText(
                efekfull
        );
    }

    @FXML
    private void updatering(ActionEvent event) {
        String ringstat = cmbring.getSelectionModel().getSelectedItem();
        if (cmbring.getSelectionModel().getSelectedItem() != null) {
            //System.out.println(armorstat);
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (ringstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    ring = dtequipments.Load().get(i).getEquipmentid();
                    updateStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                    tambahequip(dtequipments.Load().get(i).getEquipmentid());
                }
            }
        }
        loadStat();
        checkEquipped();
        loadEfek();
        loadSetEfek();
    }

    @FXML
    private void btnequipmentpaneactivated(ActionEvent event) {
        statuspaneactiv.setDisable(true);
        statuspaneactiv.setVisible(false);
        btnstatusactiv.setDisable(false);
        equipmentmenu.setDisable(false);
        equipmentmenu.setVisible(true);
        btnequipmentmenuactiv.setDisable(true);
        equipmentpaneqctivated.setVisible(true);
        statuspaneactivated.setVisible(false);
        menuname.setText("EQUIPMENT");
    }

    @FXML
    private void btnstatuspaneactivated(ActionEvent event) {
        equipmentmenu.setDisable(true);
        equipmentmenu.setVisible(false);
        btnequipmentmenuactiv.setDisable(false);
        statuspaneactiv.setDisable(false);
        statuspaneactiv.setVisible(true);
        btnstatusactiv.setDisable(true);
        equipmentpaneqctivated.setVisible(false);
        statuspaneactivated.setVisible(true);
        menuname.setText("STATUS CHARACTER");
    }

    @FXML
    private void setNecklace(MouseEvent event) {
        setCombonecklace();
    }

    @FXML
    private void updateNecklace(ActionEvent event) {
        String necklacestat = cmbnecklace.getSelectionModel().getSelectedItem();
        if (cmbnecklace.getSelectionModel().getSelectedItem() != null) {
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (necklacestat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    necklace = dtequipments.Load().get(i).getEquipmentid();
                    updateStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                    tambahequip(dtequipments.Load().get(i).getEquipmentid());
                }
            }
        }
        loadStat();
        checkEquipped();
        loadEfek();
        loadSetEfek();
    }

    @FXML
    private void setRing(MouseEvent event) {
        setComboRing();
    }

    @FXML
    private void imgringclicked(MouseEvent event) {
        String ringstat = cmbring.getSelectionModel().getSelectedItem();
        if (cmbring.getSelectionModel().getSelectedItem() != null) {
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (ringstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    setEquipStatsInfo(dtequipments.Load().get(i), dtdetailefek.LoadSetEfek(dtequipments.Load().get(i).getSetequipid()));
                }
            }
        }
    }

    @FXML
    private void imgnecklaceclicked(MouseEvent event) {
        String necklacestat = cmbnecklace.getSelectionModel().getSelectedItem();
        if (cmbnecklace.getSelectionModel().getSelectedItem() != null) {
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (necklacestat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    setEquipStatsInfo(dtequipments.Load().get(i), dtdetailefek.LoadSetEfek(dtequipments.Load().get(i).getSetequipid()));
                }
            }
        }
    }

    @FXML
    private void displaydetailefekclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayDetailEfek.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void masterdetailefekclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputDetailEfek.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateequip(ActionEvent event) {
        String userid = cmbuserid.getSelectionModel().getSelectedItem();
        setComboRing();
        setComboarmor();
        setCombobelt();
        setCombonecklace();
        setComboweapon();
        for (int i = 0; i < dtplayer.LoadDetilSet(userid).size(); i++) {
            String a = dtplayer.LoadDetilSet(userid).get(i).getEquipmentname();
            String b = dtplayer.LoadDetilSet(userid).get(i).getEquipmentid();
            // System.out.println(a);
            //System.out.println(b); 
            // System.out.println(b.substring(0, 1));
            if (b.substring(0, 1).equalsIgnoreCase("W")) {
                cmbweapons.getSelectionModel().select(a);
            }
            if (b.substring(0, 1).equalsIgnoreCase("A")) {
                cmbarmor.getSelectionModel().select(a);
            }
            if (b.substring(0, 1).equalsIgnoreCase("E")) {
                cmbbelt.getSelectionModel().select(a);
            }
            if (b.substring(0, 1).equalsIgnoreCase("R")) {
                cmbring.getSelectionModel().select(a);
            }
            if (b.substring(0, 1).equalsIgnoreCase("N")) {
                cmbnecklace.getSelectionModel().select(a);
            }
        }
    }

    public void tambahequip(String equipid) {
        if ((!dtplayer.getLastUID().isEmpty())) {
            String newid = "";
            String lastid = dtplayer.getLastUID();
            String kode = lastid.substring(0, 2);
            int lastnum = Integer.parseInt(lastid.substring(2, 10));
            int newnum = lastnum + 1;
            newid = kode;
            int p = String.valueOf(newnum).length();
            for (int x = 0; x <= (9 - 2 - p); x++) {
                newid = newid + 0;
            }
            newid = newid + newnum;

            InventoryModel tmp = new InventoryModel();
            tmp.setUserid(newid);
            tmp.setEquipmentid(equipid);
            if (newsetplayer.getInventoryModel().get(equipid) == null) {
                newsetplayer.setInventoryModel(tmp);
                // System.out.println(tmp.getUserid() + " - " + tmp.getEquipmentid() + " - " + newsetplayer.getInventoryModel());
            }
        }
    }

    public void lepasequip(String equipid) {
        String newid = "";
        String lastid = dtplayer.getLastUID();
        String kode = lastid.substring(0, 2);
        int lastnum = Integer.parseInt(lastid.substring(2, 10));
        int newnum = lastnum + 1;
        newid = kode;
        int p = String.valueOf(newnum).length();
        for (int x = 0; x <= (9 - 2 - p); x++) {
            newid = newid + 0;
        }
        newid = newid + newnum;

        InventoryModel tmp = new InventoryModel();
        tmp.setUserid(newid);
        tmp.setEquipmentid(equipid);
        if (tmp != null) {
            newsetplayer.getInventoryModel().remove(tmp.getEquipmentid());
        }
    }

    @FXML
    private void btnsaveequipsetclick(ActionEvent event) {
        if ((!dtplayer.getLastUID().isEmpty())) {
            String newid = "";
            String lastid = dtplayer.getLastUID();
            String kode = lastid.substring(0, 2);
            int lastnum = Integer.parseInt(lastid.substring(2, 10));
            int newnum = lastnum + 1;
            newid = kode;
            int p = String.valueOf(newnum).length();
            for (int x = 0; x <= (9 - 2 - p); x++) {
                newid = newid + 0;
            }
            newid = newid + newnum;

            newsetplayer.getPlayerModel().setUserid(newid);
            if (newsetplayer.saveall()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan ", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan ", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "User_ID Gagal Diload!", ButtonType.OK);
            a.showAndWait();
        }
    }

    @FXML
    private void imgarmorclicked(MouseEvent event) {
        String armorstat = cmbarmor.getSelectionModel().getSelectedItem();
        if (cmbarmor.getSelectionModel().getSelectedItem() != null) {
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (armorstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    setEquipStatsInfo(dtequipments.Load().get(i), dtdetailefek.LoadSetEfek(dtequipments.Load().get(i).getSetequipid()));
                }
            }
        }
    }

    @FXML
    private void imghelmclicked(MouseEvent event) {
        String weaponstat = cmbweapons.getSelectionModel().getSelectedItem();
        if (cmbweapons.getSelectionModel().getSelectedItem() != null) {
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (weaponstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    setEquipStatsInfo(dtequipments.Load().get(i), dtdetailefek.LoadSetEfek(dtequipments.Load().get(i).getSetequipid()));
                }
            }
        }
    }

    @FXML
    private void imgbeltclicked(MouseEvent event) {
        String beltstat = cmbbelt.getSelectionModel().getSelectedItem();
        if (cmbbelt.getSelectionModel().getSelectedItem() != null) {
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (beltstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    setEquipStatsInfo(dtequipments.Load().get(i), dtdetailefek.LoadSetEfek(dtequipments.Load().get(i).getSetequipid()));
                }
            }
        }
    }

    @FXML
    private void setloaduserid(MouseEvent event) {
        setComboId();
    }

}
