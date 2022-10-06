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
public class DBNecklace {

    private NecklaceModel data = new NecklaceModel();

    public NecklaceModel getNecklaceModel() {
        return (data);
    }

    public void setNecklaceModel(NecklaceModel s) {
        data = s;
    }

    public ObservableList<NecklaceModel> Load() {
        try {
            ObservableList<NecklaceModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from necklaces");

            int i = 1;
            while (rs.next()) {
                NecklaceModel d = new NecklaceModel();
                d.setNecklaceid(rs.getString("necklace_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setNecklacename(rs.getString("necklace_name"));
                d.setNecklacemdef(rs.getInt("necklace_mdef"));
                d.setBeltrarity(rs.getInt("necklace_rarity"));
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

    public ObservableList<NecklaceModel> LoadAll() {
        try {
            ObservableList<NecklaceModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select n.*,"
                            + "str, intl, agi, dex, vit, crit"
                            + " from necklaces n join status s on (n.status_id=s.status_id)");

            int i = 1;
            while (rs.next()) {
                NecklaceModel d = new NecklaceModel();
                d.setNecklaceid(rs.getString("necklace_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setNecklacename(rs.getString("necklace_name"));
                d.setNecklacemdef(rs.getInt("necklace_mdef"));
                d.setBeltrarity(rs.getInt("necklace_rarity"));
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

    public ObservableList<NecklaceModel> LoadWeaponName() {
        try {
            ObservableList<NecklaceModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select necklace_name from necklaces");
            int i = 1;
            while (rs.next()) {
                NecklaceModel d = new NecklaceModel();
                d.setNecklacename(rs.getString("necklace_name"));
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

     public ObservableList<NecklaceModel> LoadWeaponStat(String x) {
        try {
            ObservableList<NecklaceModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select str, intl, agi, dex, vit, crit"
                            + " from necklaces n join status s on (n.status_id=s.status_id) where necklace_name = '" + x + "'");

            int i = 1;
            while (rs.next()) {
                NecklaceModel d = new NecklaceModel();
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
