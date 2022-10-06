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
public class DBBelt {

    private BeltModel data = new BeltModel();

    public BeltModel getBeltModel() {
        return (data);
    }

    public void setBeltModel(BeltModel s) {
        data = s;
    }

    public ObservableList<BeltModel> Load() {
        try {
            ObservableList<BeltModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from belts");

            int i = 1;
            while (rs.next()) {
                BeltModel d = new BeltModel();
                d.setBeltid(rs.getString("belt_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setBeltname(rs.getString("belt_name"));
                d.setBelthealth(rs.getInt("belt_health"));
                d.setBeltrarity(rs.getInt("belt_rarity"));

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

    public ObservableList<BeltModel> LoadAll() {
        try {
            ObservableList<BeltModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select b.*,"
                            + "str, intl, agi, dex, vit, crit"
                            + " from belts b join status s on (b.status_id=s.status_id)");

            int i = 1;
            while (rs.next()) {
                BeltModel d = new BeltModel();
               d.setBeltid(rs.getString("belt_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setBeltname(rs.getString("belt_name"));
                d.setBelthealth(rs.getInt("belt_health"));
                d.setBeltrarity(rs.getInt("belt_rarity"));
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

    public ObservableList<BeltModel> LoadWeaponName() {
        try {
            ObservableList<BeltModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select belt_name from belts");
            int i = 1;
            while (rs.next()) {
                BeltModel d = new BeltModel();
                d.setBeltname(rs.getString("belt_name"));
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

     public ObservableList<BeltModel> LoadWeaponStat(String x) {
        try {
            ObservableList<BeltModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select str, intl, agi, dex, vit, crit"
                            + " from belts b join status s on (b.status_id=s.status_id) where belt_name = '" + x + "'");

            int i = 1;
            while (rs.next()) {
                BeltModel d = new BeltModel();
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
