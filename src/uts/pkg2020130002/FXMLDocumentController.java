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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author asus
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ListView<String> scr2;
    @FXML
    private ListView<String> scr3;
    private ListView<String> scr1;

    @FXML
    private Menu showweapon;
    @FXML
    private ImageView img6;
    private ListView<String> scr5;
    @FXML
    private ListView<String> scr6;
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

    ObservableList<String> details = FXCollections.observableArrayList();

    private String weapon = "", armor = "", belt = "", necklace = "", ring = "";
    @FXML
    private ListView<String> equiparmorlist;
    @FXML
    private ListView<String> equipweaponlist;
    @FXML
    private ListView<String> equipbeltlist;
    @FXML
    private ListView<String> equipnecklacelist;
    @FXML
    private ListView<String> equipringlist;
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
    private ListView<String> scrring;
    @FXML
    private ListView<String> scrnecklace;
    @FXML
    private MenuItem displaydetailefek;
    @FXML
    private MenuItem masterdetailefek;
    @FXML
    private Label txtequipset;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setComboweapon();
        setCombobelt();
        setComboarmor();
        setComboRing();
        setCombonecklace();
//        checkEquipped();
//        loadEfek();
//        loadSetEfek();
    }

    public void setComboweapon() {
        if (!cmbweapons.getSelectionModel().isEmpty()) {
            String weapstat = cmbweapons.getSelectionModel().getSelectedItem();
            if (cmbweapons.getSelectionModel().getSelectedItem() != null) {
                for (int i = 0; i < dtequipments.Load().size(); i++) {
                    if (weapstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                        scr2.setItems(FXCollections.observableArrayList(
                                dtequipments.Load().get(i).getEquipmentname(), String.valueOf(dtequipments.Load().get(i).getEquipmentname()), String.valueOf(dtequipments.Load().get(i).getEquipmentrarity())));
                        weapon = "";
                        reduceStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                        // System.out.println(weapon);
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
        equipweaponlist.getItems().clear();
        ObservableList<String> weapons = FXCollections.observableArrayList();
        for (int i = 0; i < dtequipments.LoadWeapon().size(); i++) {
            weapons.add(i, dtequipments.LoadWeapon().get(i).getEquipmentname());
        }
        //System.out.println("loaded...");
        cmbweapons.getItems().addAll(weapons);
        equipweaponlist.getItems().addAll(weapons);
    }

    public void setComboarmor() {
        if (!cmbarmor.getSelectionModel().isEmpty()) {
            String armorstat = cmbarmor.getSelectionModel().getSelectedItem();
            if (cmbarmor.getSelectionModel().getSelectedItem() != null) {
                //System.out.println(armorstat);
                for (int i = 0; i < dtequipments.Load().size(); i++) {
                    if (armorstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                        scr3.setItems(FXCollections.observableArrayList(
                                dtequipments.Load().get(i).getEquipmentname(), String.valueOf(dtequipments.Load().get(i).getEquipmentname()), String.valueOf(dtequipments.Load().get(i).getEfektype() + " - "
                                + dtequipments.Load().get(i).getEfekvalue()),
                                String.valueOf(dtequipments.Load().get(i).getEquipmentrarity())));
                        armor = "";
                        reduceStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
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
        equiparmorlist.getItems().clear();
        ObservableList<String> armors = FXCollections.observableArrayList();
        for (int i = 0; i < dtequipments.LoadArmor().size(); i++) {
            armors.add(i, dtequipments.LoadArmor().get(i).getEquipmentname());
        }
        //System.out.println("loaded...");
        cmbarmor.getItems().addAll(armors);
        equiparmorlist.getItems().addAll(armors);
    }

    public void setCombobelt() {
        if (!cmbbelt.getSelectionModel().isEmpty()) {
            String beltstat = cmbbelt.getSelectionModel().getSelectedItem();
            if (cmbbelt.getSelectionModel().getSelectedItem() != null) {
                for (int i = 0; i < dtequipments.Load().size(); i++) {
                    if (beltstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                        scr6.setItems(FXCollections.observableArrayList(
                                dtequipments.Load().get(i).getEquipmentname(), String.valueOf(dtequipments.Load().get(i).getEquipmentname()), String.valueOf(dtequipments.Load().get(i).getEquipmentrarity())));
                        belt = "";
                        //System.out.println(belt);
                        reduceStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
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
        equipbeltlist.getItems().clear();
        ObservableList<String> belts = FXCollections.observableArrayList();
        for (int i = 0; i < dtequipments.LoadBelt().size(); i++) {
            belts.add(i, dtequipments.LoadBelt().get(i).getEquipmentname());
        }
        //System.out.println("loaded...");
        cmbbelt.getItems().addAll(belts);
        equipbeltlist.getItems().addAll(belts);
    }

    public void setCombonecklace() {
        if (!cmbnecklace.getSelectionModel().isEmpty()) {
            String necklacestat = cmbnecklace.getSelectionModel().getSelectedItem();
            if (cmbnecklace.getSelectionModel().getSelectedItem() != null) {
                for (int i = 0; i < dtequipments.Load().size(); i++) {
                    if (necklacestat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                        scrnecklace.setItems(FXCollections.observableArrayList(
                                dtequipments.Load().get(i).getEquipmentname(), String.valueOf(dtequipments.Load().get(i).getEquipmentname()), String.valueOf(dtequipments.Load().get(i).getEfektype() + " - "
                                + dtequipments.Load().get(i).getEfekvalue()),
                                String.valueOf(dtequipments.Load().get(i).getEquipmentrarity())));
                        necklace = "";
                        reduceStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
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
        equipnecklacelist.getItems().clear();
        ObservableList<String> necklaces = FXCollections.observableArrayList();
        for (int i = 0; i < dtequipments.LoadNecklace().size(); i++) {
            necklaces.add(i, dtequipments.LoadNecklace().get(i).getEquipmentname());
        }
        //System.out.println("loaded...");
        cmbnecklace.getItems().addAll(necklaces);
        equipnecklacelist.getItems().addAll(necklaces);
    }

    public void setComboRing() {
        if (!cmbring.getSelectionModel().isEmpty()) {
            String ringstat = cmbring.getSelectionModel().getSelectedItem();
            if (cmbring.getSelectionModel().getSelectedItem() != null) {
                //System.out.println(armorstat);
                for (int i = 0; i < dtequipments.Load().size(); i++) {
                    if (ringstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                        scrring.setItems(FXCollections.observableArrayList(
                                dtequipments.Load().get(i).getEquipmentname(), String.valueOf(dtequipments.Load().get(i).getEquipmentname()), String.valueOf(dtequipments.Load().get(i).getEfektype() + " - "
                                + dtequipments.Load().get(i).getEfekvalue()),
                                String.valueOf(dtequipments.Load().get(i).getEquipmentrarity())));
                        ring = "";
                        reduceStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
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
        equipringlist.getItems().clear();
        ObservableList<String> rings = FXCollections.observableArrayList();
        for (int i = 0; i < dtequipments.LoadRing().size(); i++) {
            rings.add(i, dtequipments.LoadRing().get(i).getEquipmentname());
        }
        //System.out.println("loaded...");
        cmbring.getItems().addAll(rings);
        equipringlist.getItems().addAll(rings);
    }

    @FXML
    private void img2clicked(MouseEvent event) {
        scr2.setDisable(false);
        scr2.setVisible(true);
    }

    @FXML
    private void img3clicked(MouseEvent event) {
        scr3.setDisable(false);
        scr3.setVisible(true);
    }

    @FXML
    private void exitscr2(MouseEvent event) {
        scr2.setDisable(true);
        scr2.setVisible(false);
    }

    @FXML
    private void exitscr3(MouseEvent event) {
        scr3.setDisable(true);
        scr3.setVisible(false);
    }

    @FXML
    private void showweaponklik(ActionEvent event) {

    }

    @FXML
    private void img6clicked(MouseEvent event) {
        scr6.setDisable(false);
        scr6.setVisible(true);
    }

    @FXML
    private void exitscr6(MouseEvent event) {
        scr6.setDisable(true);
        scr6.setVisible(false);
    }

    public ObservableList<EfekModel> LoadEfekSet(ArrayList<String> efekid) {
        ObservableList<EfekModel> tableData = FXCollections.observableArrayList();
        ObservableList<EfekModel> efekdata = FXMLDocumentController.dtefek.Load();
        //System.out.println(efekid.size());
        for (int i = 0; i < efekid.size(); i++) {
            for (int j = 0; j < efekdata.size(); j++) {
                if (efekid.get(i).equals(efekdata.get(j).getEfekid())) {
                    System.out.println("Efek ID Array : " + efekid.get(i));
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
        //txtnamaset.setText(nameset);
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
            //System.out.println(nameset.get(j));
            if (setnameakhir != "") {
                setnameakhir = setnameakhir + "\n" + nameset.get(j).toString() + " - " + setnow.get(j) + "/" + itemmax.get(j);
            } else {
                setnameakhir = nameset.get(j).toString() + " - " + setnow.get(j) + "/" + itemmax.get(j);
            }
        }
        txtequipset.setText(String.valueOf(setnameakhir));
        return nameset;
    }

    //Ini Masih Bermasalah
    public ArrayList<String> loadEfekID() {
        ArrayList nameset = new ArrayList<String>();
        String setequipnow = "", setnameakhir = "";
        int jumlahmax;
        int itemsetnow = 0;
        //txtnamaset.setText(nameset);
        //System.out.println(dtdetailsetefek.LoadEquipSet(weapon, armor, belt).size());
        for (int i = 0; i < dtequipments.LoadEquipSet(weapon, armor, belt, ring, necklace).size(); i++) {
            setequipnow = dtequipments.LoadEquipSet(weapon, armor, belt, ring, necklace).get(i).getSetequipid();
            itemsetnow = dtequipments.LoadEquipSet(weapon, armor, belt, ring, necklace).get(i).getJumlah();
            jumlahmax = dtequipset.getdata(setequipnow).getJumlahmax();
            //System.out.println(setequipnow + " --- " + itemsetnow);
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
            System.out.println(nameset.get(j) + " " + nameset.size());
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

    /* Plan Awal : (Sementara Uji Coba sampai jalan 3 dlu (Belt, Weapon, Armor)
    0-belt
    1-necklace
    3-weapon
    4-ring
    5-armor
     */
    @FXML
    private void updatearmor(ActionEvent event) {
        String armorstat = cmbarmor.getSelectionModel().getSelectedItem();
        if (cmbarmor.getSelectionModel().getSelectedItem() != null) {
            //System.out.println(armorstat);
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (armorstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    scr3.setItems(FXCollections.observableArrayList(
                            dtequipments.Load().get(i).getEquipmentname(), String.valueOf(dtequipments.Load().get(i).getEquipmentname()), String.valueOf(dtequipments.Load().get(i).getEfektype() + " - "
                            + dtequipments.Load().get(i).getEfekvalue()),
                            String.valueOf(dtequipments.Load().get(i).getEquipmentrarity())));
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
                hp = hp + value + hpefek;
                break;
            case "mp":
                mp = mp + value + mpefek;
                break;
            case "atk":
                atk = atk + value + atkefek;
                break;
            case "matk":
                matk = matk + value + matkefek;
                break;
            case "def":
                def = def + value + defefek;
                break;
            case "mdef":
                mdef = mdef + value + mdefefek;
                break;
            case "hit":
                hit = hit + value + hitefek;
                break;
            case "flee":
                flee = flee + value + fleeefek;
                break;
            case "aspd":
                aspd = aspd + value + aspdefek;
                break;
            case "cspd":
                cspd = cspd + value + cspdefek;
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
                hpefek = value;
                break;
            case "mp":
                mpefek = value;
                break;
            case "atk":
                atkefek = value;
                break;
            case "matk":
                matkefek = value;
                break;
            case "def":
                defefek = value;
                break;
            case "mdef":
                mdefefek = value;
                break;
            case "hit":
                hitefek = value;
                break;
            case "flee":
                fleeefek = value;
                break;
            case "aspd":
                aspdefek = value;
                break;
            case "cspd":
                cspdefek = value;
                break;
            default:
                throw new AssertionError();
        }
        System.out.println(hpefek + mpefek + atkefek + matkefek+hitefek);
    }

    @FXML
    private void updateBelt(ActionEvent event) {
        String beltstat = cmbbelt.getSelectionModel().getSelectedItem();
        if (cmbbelt.getSelectionModel().getSelectedItem() != null) {
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (beltstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    scr6.setItems(FXCollections.observableArrayList(
                            dtequipments.Load().get(i).getEquipmentname(), String.valueOf(dtequipments.Load().get(i).getEquipmentname()), String.valueOf(dtequipments.Load().get(i).getEquipmentrarity())));
                    belt = dtequipments.Load().get(i).getEquipmentid();
                    //System.out.println(belt);
                    updateStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
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
                    scr2.setItems(FXCollections.observableArrayList(
                            dtequipments.Load().get(i).getEquipmentname(), String.valueOf(dtequipments.Load().get(i).getEquipmentname()), String.valueOf(dtequipments.Load().get(i).getEquipmentrarity())));
                    weapon = dtequipments.Load().get(i).getEquipmentid();
                    updateStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
                    // System.out.println(weapon);
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

    @FXML
    private void updatering(ActionEvent event) {
        String ringstat = cmbring.getSelectionModel().getSelectedItem();
        if (cmbring.getSelectionModel().getSelectedItem() != null) {
            //System.out.println(armorstat);
            for (int i = 0; i < dtequipments.Load().size(); i++) {
                if (ringstat.equals(dtequipments.Load().get(i).getEquipmentname())) {
                    scrring.setItems(FXCollections.observableArrayList(
                            dtequipments.Load().get(i).getEquipmentname(), String.valueOf(dtequipments.Load().get(i).getEquipmentname()), String.valueOf(dtequipments.Load().get(i).getEfektype() + " - "
                            + dtequipments.Load().get(i).getEfekvalue()),
                            String.valueOf(dtequipments.Load().get(i).getEquipmentrarity())));
                    ring = dtequipments.Load().get(i).getEquipmentid();
                    updateStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
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
                    scrnecklace.setItems(FXCollections.observableArrayList(
                            dtequipments.Load().get(i).getEquipmentname(), String.valueOf(dtequipments.Load().get(i).getEquipmentname()), String.valueOf(dtequipments.Load().get(i).getEfektype() + " - "
                            + dtequipments.Load().get(i).getEfekvalue()),
                            String.valueOf(dtequipments.Load().get(i).getEquipmentrarity())));
                    necklace = dtequipments.Load().get(i).getEquipmentid();
                    updateStatusCharacter(dtequipments.Load().get(i).getEfektype(), dtequipments.Load().get(i).getEfekvalue());
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
        scrring.setDisable(false);
        scrring.setVisible(true);
    }

    @FXML
    private void exitscrring(MouseEvent event) {
        scrring.setDisable(true);
        scrring.setVisible(false);
    }

    @FXML
    private void exitscrnecklace(MouseEvent event) {
        scrnecklace.setDisable(true);
        scrnecklace.setVisible(false);
    }

    @FXML
    private void imgnecklaceclicked(MouseEvent event) {
        scrnecklace.setDisable(false);
        scrnecklace.setVisible(true);
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

}
