/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package uts.pkg2020130002;

import java.io.IOException;
import java.net.URL;
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
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private Label efekweapon;
    @FXML
    private TextArea txtnamaset;
    @FXML
    private TextArea txteffect;
    @FXML
    private ListView<String> scr4;
    @FXML
    private ListView<String> scr2;
    @FXML
    private ListView<String> scr3;
    @FXML
    private ListView<String> scr1;

    @FXML
    private Menu showweapon;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ListView<String> scr5;
    @FXML
    private ListView<String> scr6;
    @FXML
    private ComboBox<String> cmbweapons;

    public static DBArmor dtarmor = new DBArmor();
    public static DBEquipment dtweapons = new DBEquipment();
    public static DBNecklace dtnecklaces = new DBNecklace();
    ObservableList<String> weapons = FXCollections.observableArrayList();
    ObservableList<String> armors = FXCollections.observableArrayList();
    ObservableList<String> necklaces = FXCollections.observableArrayList();
    @FXML
    private TableView<EquipmentModel> tbvstat;
    @FXML
    private MenuItem masterarmor;
    @FXML
    private MenuItem masterweapon;
    @FXML
    private MenuItem masternecklace;
    @FXML
    private MenuItem masterbracelet;
    @FXML
    private MenuItem masterbelt;
    @FXML
    private MenuItem masterring;
    @FXML
    private MenuItem masterstatus;
    @FXML
    private MenuItem masterefek;
    @FXML
    private MenuItem mastersetefek;
    @FXML
    private MenuItem masterdetailset;
    @FXML
    private MenuItem displayarmor;
    @FXML
    private MenuItem displayweapon;
    @FXML
    private MenuItem displaynecklace;
    @FXML
    private MenuItem displaybracelet;
    @FXML
    private MenuItem displaybelt;
    @FXML
    private MenuItem displayring;
    @FXML
    private ComboBox<String> cmbarmor;
    @FXML
    private ComboBox<?> cmbbelt;
    @FXML
    private ComboBox<?> cmbring;
    @FXML
    private ComboBox<?> cmbbracelet;
    @FXML
    private ComboBox<String> cmbnecklace;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scr1.accessibleTextProperty();
        for (int i = 0; i < dtweapons.LoadWeaponName().size(); i++) {
            weapons.add(i, dtweapons.LoadWeaponName().get(i).getWeaponname());
        }
        cmbweapons.getItems().addAll(weapons);
        for (int i = 0; i < dtarmor.LoadWeaponName().size(); i++) {
            armors.add(i, dtarmor.LoadWeaponName().get(i).getArmorname());
        }
        cmbarmor.getItems().addAll(armors);
        for (int i = 0; i < dtnecklaces.LoadWeaponName().size(); i++) {
            necklaces.add(i, dtnecklaces.LoadWeaponName().get(i).getNecklacename());
        }
        cmbnecklace.getItems().addAll(necklaces);
        //cmbweapons.getSelectionModel().select(0);
    }

    public void setUpBuff(String x) {
        txteffect.setText(x);
    }

    @FXML
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

    @FXML
    private void img4clicked(MouseEvent event) {
        scr4.setDisable(false);
        scr4.setVisible(true);
    }

    @FXML
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

    @FXML
    private void exitscr1(MouseEvent event) {
        scr1.setDisable(true);
        scr1.setVisible(false);
    }

    @FXML
    private void showweaponklik(ActionEvent event) {

    }

    @FXML
    private void img5clicked(MouseEvent event) {
        scr5.setDisable(false);
        scr5.setVisible(true);
    }

    @FXML
    private void img6clicked(MouseEvent event) {
        scr6.setDisable(false);
        scr6.setVisible(true);
    }

    @FXML
    private void exitscr5(MouseEvent event) {
        scr5.setDisable(true);
        scr5.setVisible(false);
    }

    @FXML
    private void exitscr6(MouseEvent event) {
        scr6.setDisable(true);
        scr6.setVisible(false);
    }

    @FXML
    private void updateWeapon(ActionEvent event) {
        String weapstat = cmbweapons.getSelectionModel().getSelectedItem();
        int a = cmbweapons.getSelectionModel().getSelectedIndex();
        scr2.setItems(FXCollections.observableArrayList(
                dtweapons.Load().get(a).getWeaponname(), String.valueOf(dtweapons.Load().get(a).getWeaponatk()), String.valueOf(dtweapons.Load().get(a).getWeaponrarity())));
        loadStat(weapstat);
    }

    public void loadStat(String x) {
        ObservableList<EquipmentModel> data = FXMLDocumentController.dtweapons.LoadWeaponStat(x);
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
    private void masterarmorclick(ActionEvent event) {
    }

    @FXML
    private void masterweaponclick(ActionEvent event) {
    }

    @FXML
    private void masternecklaceclick(ActionEvent event) {
    }

    @FXML
    private void masterbraceletclick(ActionEvent event) {
    }

    @FXML
    private void masterbeltclick(ActionEvent event) {
    }

    @FXML
    private void masterringclick(ActionEvent event) {
    }

    @FXML
    private void masterstatusclick(ActionEvent event) {
    }

    @FXML
    private void masterefekclick(ActionEvent event) {
    }

    @FXML
    private void mastersetefekclick(ActionEvent event) {
    }

    @FXML
    private void masterdetailsetclick(ActionEvent event) {
    }

    @FXML
    private void displayarmorclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayArmor.fxml"));
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
    private void displayweaponclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayUtama.fxml"));
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
    private void displaynecklaceclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayNecklace.fxml"));
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
    private void displaybraceletclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayBracelet.fxml"));
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
    private void displaybeltclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayBelt.fxml"));
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
    private void displayringclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayRing.fxml"));
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
        int a = cmbarmor.getSelectionModel().getSelectedIndex();
        scr3.setItems(FXCollections.observableArrayList(
                dtarmor.Load().get(a).getArmorname(), String.valueOf(dtarmor.Load().get(a).getArmordef()), String.valueOf(dtarmor.Load().get(a).getArmorrarity())));
        loadStat(armorstat);
    }

    @FXML
    private void updateBelt(ActionEvent event) {
    }

    @FXML
    private void updateRing(ActionEvent event) {
    }

    @FXML
    private void updateBracelet(ActionEvent event) {
    }

    @FXML
    private void updateNecklace(ActionEvent event) {
        String necklacestat = cmbnecklace.getSelectionModel().getSelectedItem();
        int a = cmbnecklace.getSelectionModel().getSelectedIndex();
        scr4.setItems(FXCollections.observableArrayList(
                dtnecklaces.Load().get(a).getNecklacename(), String.valueOf(dtnecklaces.Load().get(a).getNecklacemdef()), String.valueOf(dtnecklaces.Load().get(a).getBeltrarity())));
        loadStat(necklacestat);
    }

}
