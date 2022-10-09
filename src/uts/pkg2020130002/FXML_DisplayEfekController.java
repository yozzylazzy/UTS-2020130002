/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.pkg2020130002;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yosef Adrian
 */
public class FXML_DisplayEfekController implements Initializable {

    @FXML
    private TableView<EfekModel> tbvefekequip;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button akhir;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnhapussiswa;
    @FXML
    private Button btneditsiswa;
    @FXML
    private Button btntambahsiswa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showData();
    }

    public void showData() {
        ObservableList<EfekModel> data = FXMLDocumentController.dtefek.Load();
        if (data != null) {
            tbvefekequip.getColumns().clear();
            tbvefekequip.getItems().clear();
            TableColumn col = new TableColumn("Efek_ID");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, String>("Efekid"));
            tbvefekequip.getColumns().addAll(col);

            col = new TableColumn("ATK");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, String>("Atk"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("MATK");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, String>("Matk"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("HP");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Hp"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("MP");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Mp"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("DEF");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Def"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("MDEF");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Mdef"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("HIT");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Hit"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("ASPD");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Aspd"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("CSPD");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Cspd"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("Critical_Rate");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Criticalrate"));
            tbvefekequip.getColumns().addAll(col);
            col = new TableColumn("Critical_Damage");
            col.setCellValueFactory(new PropertyValueFactory<EfekModel, Integer>("Criticaldamage"));
            tbvefekequip.getColumns().addAll(col);
            tbvefekequip.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvefekequip.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void btnawalklik(ActionEvent event) {
        tbvefekequip.getSelectionModel().selectFirst();
        tbvefekequip.requestFocus();
    }

    @FXML
    private void btnakhirklik(ActionEvent event) {
        tbvefekequip.getSelectionModel().selectLast();
        tbvefekequip.requestFocus();
    }

    @FXML
    private void btnsebelumklik(ActionEvent event) {
        tbvefekequip.getSelectionModel().selectAboveCell();
        tbvefekequip.requestFocus();
    }

    @FXML
    private void btnsesudahklik(ActionEvent event) {
        tbvefekequip.getSelectionModel().selectBelowCell();
        tbvefekequip.requestFocus();
    }

    @FXML
    private void btnexitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void btntambahklik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputEfek.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
            showData();
            btnawalklik(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
        showData();
        btnawalklik(event);
    }

    @FXML
    private void btneditklik(ActionEvent event) {
        EfekModel eq = new EfekModel();
        eq = tbvefekequip.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputEfek.fxml"));
            Parent root = (Parent) loader.load();
            FXML_InputEfekController isidt = loader.getController();
            isidt.execute(eq);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showData();
        btnawalklik(event);
    }

    @FXML
    private void btnhapusklik(ActionEvent event) {
        EfekModel eq = new EfekModel();
        eq = tbvefekequip.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Ingin Menghapus data ke-" + eq + "?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            // System.out.print(s);
            if (FXMLDocumentController.dtefek.Delete(eq.getEfekid())) {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Data berhasil dihapus", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Data gagal dihapus", ButtonType.OK);
                b.showAndWait();
            }
            showData();
        }
    }
}
