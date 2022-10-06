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
public class DBEfek {

    private EfekModel data = new EfekModel();

    public EfekModel getEfekModel() {
        return (data);
    }

    public void setEfekModel(EfekModel s) {
        data = s;
    }

    public ObservableList<EfekModel> Load() {
        try {
            ObservableList<EfekModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from efek");

            int i = 1;
            while (rs.next()) {
                EfekModel d = new EfekModel();
                d.setEfekid(rs.getString("efek_id"));
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
