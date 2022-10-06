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
public class DBRing {

    private RingModel data = new RingModel();

    public RingModel getRingModel() {
        return (data);
    }

    public void setRingModel(RingModel s) {
        data = s;
    }

    public ObservableList<RingModel> Load() {
        try {
            ObservableList<RingModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from rings");

            int i = 1;
            while (rs.next()) {
                RingModel d = new RingModel();
                d.setRingid(rs.getString("ring_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setRingname(rs.getString("ring_name"));
                d.setRingmdef(rs.getInt("ring_mdef"));
                d.setRingrarity(rs.getInt("ring_rarity"));

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

    public ObservableList<RingModel> LoadAll() {
        try {
            ObservableList<RingModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select r.*,"
                            + "str, intl, agi, dex, vit, crit"
                            + " from rings r join status s on (r.status_id=s.status_id)");

            int i = 1;
            while (rs.next()) {
                RingModel d = new RingModel();
                d.setRingid(rs.getString("ring_id"));
                d.setStatusid(rs.getString("status_id"));
                d.setRingname(rs.getString("ring_name"));
                d.setRingmdef(rs.getInt("ring_mdef"));
                d.setRingrarity(rs.getInt("ring_rarity"));
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

    public ObservableList<RingModel> LoadWeaponName() {
        try {
            ObservableList<RingModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select ring_name from rings");
            int i = 1;
            while (rs.next()) {
                RingModel d = new RingModel();
                d.setRingname(rs.getString("ring_name"));
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

    public ObservableList<RingModel> LoadWeaponStat(String x) {
        try {
            ObservableList<RingModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs
                    = con.statement.executeQuery("Select str, intl, agi, dex, vit, crit"
                            + " from rings r join status s on (r.status_id=s.status_id) where ring_name = '" + x + "'");

            int i = 1;
            while (rs.next()) {
                RingModel d = new RingModel();
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
