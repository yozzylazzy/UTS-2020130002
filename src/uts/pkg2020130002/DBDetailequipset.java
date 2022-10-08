/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Yosef Adrian
 */
public class DBDetailequipset {
      
    private DetailequipsetModel data = new DetailequipsetModel();

    public DetailequipsetModel getDetailequipsetModel() {
        return (data);
    }

    public void setDetailequipsetModel(DetailequipsetModel s) {
        data = s;
    }

    public ObservableList<DetailequipsetModel> Load() {
        try {
            ObservableList<DetailequipsetModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from detail_equip_set");

            int i = 1;
            while (rs.next()) {
                DetailequipsetModel d = new DetailequipsetModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setEquipmentid(rs.getString("equipment_id"));
                //System.out.println(rs.getString("weapon_id") + rs.getString("status_id") + rs.getString("weapon_name") + rs.getString(rs.getInt("weapon_atk"))
                // + rs.getInt("weapon_rarity"));
                TableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return TableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
