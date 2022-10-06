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
public class DBSeteffect {

    private SeteffectModel data = new SeteffectModel();

    public SeteffectModel getSeteffectModel() {
        return (data);
    }

    public void setSeteffectModel(SeteffectModel s) {
        data = s;
    }

    public ObservableList<SeteffectModel> Load() {
        try {
            ObservableList<SeteffectModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from setequipment");

            int i = 1;
            while (rs.next()) {
                SeteffectModel d = new SeteffectModel();
                d.setSetid(rs.getString("set_id"));
                d.setBeltid(rs.getString("belt_id"));
                d.setNecklaceid(rs.getString("necklace_id"));
                d.setBraceletid(rs.getString("bracelet_id"));
                d.setWeaponid(rs.getString("weapon_id"));
                d.setRingid(rs.getString("ring_id"));
                d.setArmorid(rs.getString("armor_id"));

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


//    public ObservableList<EquipmentModel> LoadWeaponName() {
//        try {
//            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
//            Koneksi con = new Koneksi();
//            con.bukaKoneksi();
//            con.statement = con.dbKoneksi.createStatement();
//            ResultSet rs
//                    = con.statement.executeQuery("Select weapon_name from weapons");
//            int i = 1;
//            while (rs.next()) {
//                EquipmentModel d = new EquipmentModel();
//                d.setWeaponname(rs.getString("weapon_name"));
//                TableData.add(d);
//                i++;
//            }
//            con.tutupKoneksi();
//            return TableData;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//     public ObservableList<EquipmentModel> LoadWeaponStat(String x) {
//        try {
//            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
//            Koneksi con = new Koneksi();
//            con.bukaKoneksi();
//            con.statement = con.dbKoneksi.createStatement();
//            ResultSet rs
//                    = con.statement.executeQuery("Select str, intl, agi, dex, vit, crit"
//                            + " from weapons w join status s on (w.status_id=s.status_id) where weapon_name = '" + x + "'");
//
//            int i = 1;
//            while (rs.next()) {
//                EquipmentModel d = new EquipmentModel();
//                d.setStr(rs.getInt("str"));
//                d.setIntl(rs.getInt("intl"));
//                d.setAgi(rs.getInt("agi"));
//                d.setDex(rs.getInt("dex"));
//                d.setVit(rs.getInt("vit"));
//                d.setCrit(rs.getInt("crit"));
//                TableData.add(d);
//                i++;
//            }
//            con.tutupKoneksi();
//            return TableData;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    
}
