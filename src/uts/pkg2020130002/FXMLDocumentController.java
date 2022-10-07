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
    private ComboBox<String> cmbbelt;
    @FXML
    private ComboBox<String> cmbring;
    @FXML
    private ComboBox<String> cmbbracelet;
    @FXML
    private ComboBox<String> cmbnecklace;

    public static DBStatus dtstatus = new DBStatus();
    public static DBSeteffect dtseteq = new DBSeteffect();
    public static DBDetailset dtdetailset = new DBDetailset();
    public static DBArmor dtarmor = new DBArmor();
    public static DBEquipment dtweapons = new DBEquipment();
    public static DBNecklace dtnecklaces = new DBNecklace();
    public static DBBelt dtbelts = new DBBelt();
    public static DBBracelet dtbracelets = new DBBracelet();
    public static DBRing dtrings = new DBRing();
    public static DBEfek dtefek = new DBEfek();
    ObservableList<String> weapons = FXCollections.observableArrayList();
    ObservableList<String> armors = FXCollections.observableArrayList();
    ObservableList<String> necklaces = FXCollections.observableArrayList();
    ObservableList<String> belts = FXCollections.observableArrayList();
    ObservableList<String> bracelets = FXCollections.observableArrayList();
    ObservableList<String> rings = FXCollections.observableArrayList();
    ObservableList<String> details = FXCollections.observableArrayList();
    List<String> equipped = new ArrayList<String>();

    @FXML
    private MenuItem displaystatus;
    @FXML
    private MenuItem displayefek;
    @FXML
    private MenuItem displaysetequip;
    @FXML
    private MenuItem displaydetailset;

    //
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

        for (int i = 0; i < dtbelts.LoadWeaponName().size(); i++) {
            belts.add(i, dtbelts.LoadWeaponName().get(i).getBeltname());
        }
        cmbbelt.getItems().addAll(belts);

        for (int i = 0; i < dtbracelets.LoadWeaponName().size(); i++) {
            bracelets.add(i, dtbracelets.LoadWeaponName().get(i).getBraceletname());
        }
        cmbbracelet.getItems().addAll(bracelets);

        for (int i = 0; i < dtrings.LoadWeaponName().size(); i++) {
            rings.add(i, dtrings.LoadWeaponName().get(i).getRingname());
        }
        cmbring.getItems().addAll(rings);
        
        for(int i=0; i<6; i++){
            equipped.add("");
        }
    }

    public void setNamaEfek(int a) {
        //System.out.print(dtweapons.Load().get(a).getWeaponid());
        for (int j = 0; j < dtdetailset.Load().size(); j++) {
            if (dtdetailset.LoadAll().get(j).getWeaponid().equals(dtweapons.Load().get(a).getWeaponid())) {
                System.out.println(
                        dtdetailset.LoadAll().get(j).getWeaponid()
                );
                txtnamaset.setText(dtdetailset.LoadAll().get(a).getSetname());
            }
        }
    }

    public void validasiSetEquipment() {
        
      System.out.println(dtseteq.Load());
      for(int i=0; i<dtseteq.Load().size();i++){
          if(equipped.get(0) == dtseteq.Load().get(i).getBeltid()){
              System.out.println("1");
          }
      }
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputArmor.fxml"));
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
    private void masterweaponclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputWeapon.fxml"));
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
    private void masternecklaceclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputNecklace.fxml"));
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
    private void masterbraceletclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputBracelet.fxml"));
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
    private void masterbeltclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputBelt.fxml"));
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
    private void masterringclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputRing.fxml"));
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
    private void masterstatusclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputStatus.fxml"));
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
    private void mastersetefekclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputSetEfek.fxml"));
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
    private void masterdetailsetclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputDetailSet.fxml"));
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
    private void displaystatusclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayStatus.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplaySetefek.fxml"));
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
    private void displaydetailsetclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayDetailSet.fxml"));
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

    /*
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
                dtarmor.Load().get(a).getArmorname(), String.valueOf(dtarmor.Load().get(a).getArmordef()), String.valueOf(dtarmor.Load().get(a).getArmorrarity())));
        loadStat(armorstat);
        equipped.set(5,  dtarmor.Load().get(a).getArmorid());
        validasiSetEquipment();
        System.out.println(equipped);
    }

    @FXML
    private void updateBelt(ActionEvent event) {
        String beltstat = cmbbelt.getSelectionModel().getSelectedItem();
        int a = cmbbelt.getSelectionModel().getSelectedIndex();
        scr6.setItems(FXCollections.observableArrayList(
                dtbelts.Load().get(a).getBeltname(), String.valueOf(dtbelts.Load().get(a).getBelthealth()), String.valueOf(dtbelts.Load().get(a).getBeltrarity())));
        loadStat(beltstat);
        equipped.set(0, dtbelts.Load().get(a).getBeltid());
    }

    @FXML
    private void updateRing(ActionEvent event) {
        String ringstat = cmbring.getSelectionModel().getSelectedItem();
        int a = cmbring.getSelectionModel().getSelectedIndex();
        scr1.setItems(FXCollections.observableArrayList(
                dtrings.Load().get(a).getRingname(), String.valueOf(dtrings.Load().get(a).getRingmdef()), String.valueOf(dtrings.Load().get(a).getRingrarity())));
        loadStat(ringstat);
        equipped.set(4, dtrings.Load().get(a).getRingid());
    }

    @FXML
    private void updateBracelet(ActionEvent event) {
        String braceletstat = cmbbracelet.getSelectionModel().getSelectedItem();
        int a = cmbbracelet.getSelectionModel().getSelectedIndex();
        scr5.setItems(FXCollections.observableArrayList(
                dtbracelets.Load().get(a).getBraceletname(), String.valueOf(dtbracelets.Load().get(a).getBraceletdef()), String.valueOf(dtbracelets.Load().get(a).getBraceletrarity())));
        loadStat(braceletstat);
        equipped.set(2, dtbracelets.Load().get(a).getBraceletid());
    }

    @FXML
    private void updateNecklace(ActionEvent event) {
        String necklacestat = cmbnecklace.getSelectionModel().getSelectedItem();
        int a = cmbnecklace.getSelectionModel().getSelectedIndex();
        scr4.setItems(FXCollections.observableArrayList(
                dtnecklaces.Load().get(a).getNecklacename(), String.valueOf(dtnecklaces.Load().get(a).getNecklacemdef()), String.valueOf(dtnecklaces.Load().get(a).getBeltrarity())));
        loadStat(necklacestat);
        equipped.set(1, dtnecklaces.Load().get(a).getNecklaceid());
    }

    @FXML
    private void updateWeapon(ActionEvent event) {
        String weapstat = cmbweapons.getSelectionModel().getSelectedItem();
        int a = cmbweapons.getSelectionModel().getSelectedIndex();
        scr2.setItems(FXCollections.observableArrayList(
                dtweapons.Load().get(a).getWeaponname(), String.valueOf(dtweapons.Load().get(a).getWeaponatk()), String.valueOf(dtweapons.Load().get(a).getWeaponrarity())));
        loadStat(weapstat);
        equipped.set(3, dtweapons.Load().get(a).getWeaponid());
    }
}
