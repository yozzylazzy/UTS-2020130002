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
public class DBBracelet {

    private BraceletModel data = new BraceletModel();

    public BraceletModel getBraceletModel() {
        return (data);
    }

    public void setBraceletModel(BraceletModel s) {
        data = s;
    }

    public ObservableList<BraceletModel> Load() {
        try {
            ObservableList<BraceletModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from bracelets");

            int i = 1;
            while (rs.next()) {
                BraceletModel d = new BraceletModel();
                d.setBraceletid(rs.getString("bracelet_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setBraceletname(rs.getString("bracelet_name"));
                d.setBraceletdef(rs.getInt("bracelet_def"));
                d.setBraceletrarity(rs.getInt("bracelet_rarity"));

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

    public ObservableList<BraceletModel> LoadAll() {
        try {
            ObservableList<BraceletModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select b.*,"
                            + "str, intl, agi, dex, vit, crit"
                            + " from bracelets b join status s on (b.status_id=s.status_id)");

            int i = 1;
            while (rs.next()) {
                BraceletModel d = new BraceletModel();
                d.setBraceletid(rs.getString("bracelet_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setBraceletname(rs.getString("bracelet_name"));
                d.setBraceletdef(rs.getInt("bracelet_def"));
                d.setBraceletrarity(rs.getInt("bracelet_rarity"));
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

    public ObservableList<BraceletModel> LoadWeaponName() {
        try {
            ObservableList<BraceletModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select bracelet_name from bracelets");
            int i = 1;
            while (rs.next()) {
                BraceletModel d = new BraceletModel();
                d.setBraceletname(rs.getString("bracelet_name"));
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

     public ObservableList<BraceletModel> LoadWeaponStat(String x) {
        try {
            ObservableList<BraceletModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select str, intl, agi, dex, vit, crit"
                            + " from bracelets b join status s on (b.status_id=s.status_id) where bracelet_name = '" + x + "'");

            int i = 1;
            while (rs.next()) {
                BraceletModel d = new BraceletModel();
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
