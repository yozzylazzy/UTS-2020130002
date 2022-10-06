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
public class DBArmor {

    private ArmorModel data = new ArmorModel();

    public ArmorModel getArmorModel() {
        return (data);
    }

    public void setArmorModel(ArmorModel s) {
        data = s;
    }

    public ObservableList<ArmorModel> Load() {
        try {
            ObservableList<ArmorModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from armor");

            int i = 1;
            while (rs.next()) {
                ArmorModel d = new ArmorModel();
                d.setArmorid(rs.getString("armor_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setArmorname(rs.getString("armor_name"));
                d.setArmordef(rs.getInt("armor_def"));
                d.setArmorrarity(rs.getInt("armor_rarity"));

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

    public ObservableList<ArmorModel> LoadAll() {
        try {
            ObservableList<ArmorModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select armor_id, a.status_id, armor_name, armor_def, armor_rarity,"
                            + "str, intl, agi, dex, vit, crit"
                            + " from armor a join status s on (a.status_id=s.status_id)");

            int i = 1;
            while (rs.next()) {
                ArmorModel d = new ArmorModel();
                d.setArmorid(rs.getString("armor_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setArmorname(rs.getString("armor_name"));
                d.setArmordef(rs.getInt("armor_def"));
                d.setArmorrarity(rs.getInt("armor_rarity"));
                d.setStr(rs.getInt("str"));
                d.setIntl(rs.getInt("intl"));
                d.setAgi(rs.getInt("agi"));
                d.setDex(rs.getInt("dex"));
                d.setVit(rs.getInt("vit"));
                d.setCrit(rs.getInt("crit"));
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

    public ObservableList<ArmorModel> LoadWeaponName() {
        try {
            ObservableList<ArmorModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select armor_name from armor");
            int i = 1;
            while (rs.next()) {
                ArmorModel d = new ArmorModel();
                d.setArmorname(rs.getString("armor_name"));
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

     public ObservableList<ArmorModel> LoadWeaponStat(String x) {
        try {
            ObservableList<ArmorModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select str, intl, agi, dex, vit, crit"
                            + " from armor a join status s on (a.status_id=s.status_id) where armor_name = '" + x + "'");

            int i = 1;
            while (rs.next()) {
                ArmorModel d = new ArmorModel();
                d.setStr(rs.getInt("str"));
                d.setIntl(rs.getInt("intl"));
                d.setAgi(rs.getInt("agi"));
                d.setDex(rs.getInt("dex"));
                d.setVit(rs.getInt("vit"));
                d.setCrit(rs.getInt("crit"));
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
