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
public class DBEquipment {

    private EquipmentModel data = new EquipmentModel();

    public EquipmentModel getEquipmentModel() {
        return (data);
    }

    public void setEquipmentModel(EquipmentModel s) {
        data = s;
    }

    public ObservableList<EquipmentModel> Load() {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from weapons");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setWeaponid(rs.getString("weapon_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setWeaponname(rs.getString("weapon_name"));
                d.setWeaponatk(rs.getInt("weapon_atk"));
                d.setWeaponrarity(rs.getInt("weapon_rarity"));

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
