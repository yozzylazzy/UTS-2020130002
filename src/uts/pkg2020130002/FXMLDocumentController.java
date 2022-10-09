/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package uts.pkg2020130002;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private Label efekweapon;
    @FXML
    private TextArea txtnamaset;
    @FXML
    private TextArea txteffect;
    private ListView<String> scr4;
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
    private ComboBox<String> cmbring;
    private ComboBox<String> cmbbracelet;
    private ComboBox<String> cmbnecklace;
    @FXML
    private MenuItem displayefek;
    @FXML
    private MenuItem displaysetequip;
    @FXML
    private TableView<?> tbvstatbelt;
    @FXML
    private TableView<DetailsetefekModel> tbvstatarmor;

    public static DBEquipmentset dtequipset = new DBEquipmentset();
    public static DBDetailequipset dtdetailequipset = new DBDetailequipset();
    public static DBDetailsetefek dtdetailsetefek = new DBDetailsetefek();
    public static DBEquipment dtequipments = new DBEquipment();
    public static DBEfek dtefek = new DBEfek();

    ObservableList<String> details = FXCollections.observableArrayList();
    ObservableList<String> weapons = FXCollections.observableArrayList();
    ObservableList<String> armors = FXCollections.observableArrayList();
    ObservableList<String> belts = FXCollections.observableArrayList();

    private String weapon = "", armor = "", belt = "";
    @FXML
    private MenuItem masterequipment;
    @FXML
    private MenuItem masterequipmentset;
    @FXML
    private MenuItem masterdetailequipset;
    @FXML
    private MenuItem masterdetailsetefek;
    @FXML
    private MenuItem displayequipment;
    @FXML
    private MenuItem displaydetailsetequip;
    @FXML
    private MenuItem displaydetailsetefek;

    //
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < dtequipments.LoadWeapon().size(); i++) {
            weapons.add(i, dtequipments.LoadWeapon().get(i).getEquipmentname());
        }
        cmbweapons.getItems().addAll(weapons);

        for (int i = 0; i < dtequipments.LoadArmor().size(); i++) {
            armors.add(i, dtequipments.LoadArmor().get(i).getEquipmentname());
        }
        cmbarmor.getItems().addAll(armors);

        for (int i = 0; i < dtequipments.LoadBelt().size(); i++) {
            belts.add(i, dtequipments.LoadBelt().get(i).getEquipmentname());
        }
        cmbbelt.getItems().addAll(belts);
        
        checkEquipped();
    }

    private void img1clicked(MouseEvent event) {
        scr1.setDisable(false);
        scr1.setVisible(true);
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

    private void img4clicked(MouseEvent event) {
        scr4.setDisable(false);
        scr4.setVisible(true);
    }

    private void exitscr4(MouseEvent event) {
        scr4.setDisable(true);
        scr4.setVisible(false);
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

    private void exitscr1(MouseEvent event) {
        scr1.setDisable(true);
        scr1.setVisible(false);
    }

    @FXML
    private void showweaponklik(ActionEvent event) {

    }

    private void img5clicked(MouseEvent event) {
        scr5.setDisable(false);
        scr5.setVisible(true);
    }

    @FXML
    private void img6clicked(MouseEvent event) {
        scr6.setDisable(false);
        scr6.setVisible(true);
    }

    private void exitscr5(MouseEvent event) {
        scr5.setDisable(true);
        scr5.setVisible(false);
    }

    @FXML
    private void exitscr6(MouseEvent event) {
        scr6.setDisable(true);
        scr6.setVisible(false);
    }

    public void checkEquipped() {
        ObservableList<DetailsetefekModel> data = FXMLDocumentController.dtdetailsetefek.LoadEquipSet("W00001", "A00001", "E00002");
        if (data != null) {
            tbvstatarmor.getColumns().clear();
            tbvstatarmor.getItems().clear();

            TableColumn col = new TableColumn("Set_Equip_ID");
            col.setCellValueFactory(new PropertyValueFactory<DetailequipsetModel, String>("Setequipid"));
            tbvstatarmor.getColumns().addAll(col);

            col = new TableColumn("Item_Set");
            col.setCellValueFactory(new PropertyValueFactory<DetailequipsetModel, String>("Itemset"));
            tbvstatarmor.getColumns().addAll(col);

            tbvstatarmor.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvstatarmor.getScene().getWindow().hide();;
        }
    }

    public void loadStat(String x) {
        ObservableList<EquipmentModel> data = FXMLDocumentController.dtequipments.LoadInHome(weapon, armor, belt);
        if (data != null) {
            tbvstat.getColumns().clear();
            tbvstat.getItems().clear();
            TableColumn col = new TableColumn("STR");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Str"));
            tbvstat.getColumns().addAll(col);
            col = new TableColumn("INT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Intl"));
            tbvstat.getColumns().addAll(col);
            col = new TableColumn("AGI");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Agi"));
            tbvstat.getColumns().addAll(col);
            col = new TableColumn("DEX");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Dex"));
            tbvstat.getColumns().addAll(col);
            col = new TableColumn("VIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Vit"));
            tbvstat.getColumns().addAll(col);
            col = new TableColumn("CRIT");
            col.setCellValueFactory(new PropertyValueFactory<EquipmentModel, Integer>("Crit"));
            tbvstat.getColumns().addAll(col);
            tbvstat.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvstat.getScene().getWindow().hide();;
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
    private void displaydetailsetequipclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayDetailEquipSet.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayDetailSetEfek.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputDetailSetEfek.fxml"));
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
    private void masterdetailequipsetclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputDetailSetEquip.fxml"));
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

    /* Planningnya begini : (Sementara Uji Coba sampai jalan 3 dlu (Belt, Weapon, Armor)
    0-belt
    1-necklace
    2-bracelet
    3-weapon
    4-ring
    5-armor
     */
    @FXML
    private void updatearmor(ActionEvent event) {
        String armorstat = cmbarmor.getSelectionModel().getSelectedItem();
        int a = cmbarmor.getSelectionModel().getSelectedIndex();
        scr3.setItems(FXCollections.observableArrayList(
                dtequipments.Load().get(a).getEquipmentname(), String.valueOf(dtequipments.Load().get(a).getVit()), String.valueOf(dtequipments.Load().get(a).getEquipmentrarity())));
        armor = dtequipments.Load().get(a).getEquipmentid();
        loadStat(armorstat);
    }

    @FXML
    private void updateBelt(ActionEvent event) {
        String beltstat = cmbbelt.getSelectionModel().getSelectedItem();
        int a = cmbbelt.getSelectionModel().getSelectedIndex();
        scr6.setItems(FXCollections.observableArrayList(
                dtequipments.Load().get(a).getEquipmentname(), String.valueOf(dtequipments.Load().get(a).getVit()), String.valueOf(dtequipments.Load().get(a).getEquipmentrarity())));
        belt = dtequipments.Load().get(a).getEquipmentid();
        loadStat(beltstat);
    }

    @FXML
    private void updateWeapon(ActionEvent event) {
        String weapstat = cmbweapons.getSelectionModel().getSelectedItem();
        int a = cmbweapons.getSelectionModel().getSelectedIndex();
        scr2.setItems(FXCollections.observableArrayList(
                dtequipments.Load().get(a).getEquipmentname(), String.valueOf(dtequipments.Load().get(a).getVit()), String.valueOf(dtequipments.Load().get(a).getEquipmentrarity())));
        weapon = dtequipments.Load().get(a).getEquipmentid();
        loadStat(weapstat);
    }

}
