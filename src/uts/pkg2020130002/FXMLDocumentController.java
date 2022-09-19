/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package uts.pkg2020130002;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

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
    private ListView<EquipmentModel> scr4;
    @FXML
    private ListView<EquipmentModel> scr2;
    @FXML
    private ListView<EquipmentModel> scr3;
    @FXML
    private ListView<EquipmentModel> scr1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scr1.accessibleTextProperty();
        // TODO
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

}
