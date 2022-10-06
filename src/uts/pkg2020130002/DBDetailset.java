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
public class DBDetailset {

    private DetailsetModel data = new DetailsetModel();

    public DetailsetModel getDetailsetModel() {
        return (data);
    }

    public void setDetailsetModel(DetailsetModel s) {
        data = s;
    }

    public ObservableList<DetailsetModel> Load() {
        try {
            ObservableList<DetailsetModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from detailset");

            int i = 1;
            while (rs.next()) {
                DetailsetModel d = new DetailsetModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setEfekid(rs.getString("efek_id"));
                d.setSetid(rs.getString("set_id"));
                d.setSetname(rs.getString("set_name"));
                d.setMinset(rs.getInt("min_set"));

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

    public ObservableList<DetailsetModel> LoadAll() {
        try {
            ObservableList<DetailsetModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select e.*, s.*, d.* "
                            + " from detailset d join efek e on (d.efek_id=e.efek_id) join "
                            + " setequipment s on (d.set_id = s.set_id)");

            int i = 1;
            while (rs.next()) {
                DetailsetModel d = new DetailsetModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setEfekid(rs.getString("efek_id"));
                d.setSetid(rs.getString("set_id"));
                d.setSetname(rs.getString("set_name"));
                d.setMinset(rs.getInt("min_set"));
                d.setAtk(rs.getInt("atk"));
                d.setMatk(rs.getInt("matk"));
                d.setHp(rs.getInt("hp"));
                d.setMp(rs.getInt("mp"));
                d.setDef(rs.getInt("def"));
                d.setMdef(rs.getInt("mdef"));
                d.setHit(rs.getInt("hit"));
                d.setAspd(rs.getInt("aspd"));
                d.setCspd(rs.getInt("cspd"));
                d.setCriticalrate(rs.getInt("critical_rate"));
                d.setCriticaldamage(rs.getInt("critical_damage"));
                d.setBeltid(rs.getString("belt_id"));
                d.setNecklaceid(rs.getString("necklace_id"));
                d.setBraceletid(rs.getString("bracelet_id"));
                d.setWeaponid(rs.getString("weapon_id"));
                d.setRingid(rs.getString("ring_id"));
                d.setArmorid(rs.getString("armor_id"));
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

    public ObservableList<DetailsetModel> LoadSetName(String armor, String belt, String bracelet, String ring, String weapon, String necklace) {
        try {
            ObservableList<DetailsetModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select set_equip_id, set_name, d.efek_id, min_set "
                            + " from detailset d join efek e on (d.efek_id=e.efek_id) join "
                            + " setequipment s on (d.set_id = s.set_id) join armor a on (s.armor_id=a.armor_id) join belts b "
                            + " on(s.belt_id = b.belt_id) join bracelets br on (s.bracelet_id = br.bracelet_id) join rings r on (s.ring_id=r.ring_id)"
                            + " join weapons w on (s.weapon_id = s.weapon_id) join necklaces ne on (s.necklace_id = ne.necklace_id)"
                            + " where armor_name = '" + armor + "' or belt_name = '" + belt + "' or bracelet_name = '" + 
                            bracelet + "' or ring_name = '" + ring + "' or weapon_name = '" + weapon + "' or necklace_name = '" + necklace + "'");

            int i = 1;
            while (rs.next()) {
                DetailsetModel d = new DetailsetModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setEfekid(rs.getString("efek_id"));
//                d.setSetid(rs.getString("set_id"));
                d.setSetname(rs.getString("set_name"));
                d.setMinset(rs.getInt("min_set"));
//                d.setAtk(rs.getInt("atk"));
//                d.setMatk(rs.getInt("matk"));
//                d.setHp(rs.getInt("hp"));
//                d.setMp(rs.getInt("mp"));
//                d.setDef(rs.getInt("def"));
//                d.setMdef(rs.getInt("mdef"));
//                d.setHit(rs.getInt("hit"));
//                d.setAspd(rs.getInt("aspd"));
//                d.setCspd(rs.getInt("cspd"));
//                d.setCriticalrate(rs.getInt("critical_rate"));
//                d.setCriticaldamage(rs.getInt("critical_damage"));
//                d.setBeltid(rs.getString("belt_id"));
//                d.setNecklaceid(rs.getString("necklace_id"));
//                d.setBraceletid(rs.getString("bracelet_id"));
//                d.setWeaponid(rs.getString("weapon_id"));
//                d.setRingid(rs.getString("ring_id"));
//                d.setArmorid(rs.getString("armor_id"));
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
//    public ObservableList<EquipmentModel> LoadWeaponStat(String x) {
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

}
