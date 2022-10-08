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
            ResultSet rs = con.statement.executeQuery("Select * from equipments");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setStr(rs.getInt("str"));
                d.setIntl(rs.getInt("intl"));
                d.setVit(rs.getInt("vit"));
                d.setAgi(rs.getInt("agi"));
                d.setDex(rs.getInt("dex"));
                d.setCrit(rs.getInt("crit"));

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

    public ObservableList<EquipmentModel> LoadInHome(String equipidone, String equipidtwo, String equipidthree) {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipments where"
                    + " equipment_id in ('" + equipidone + "', '" + equipidtwo + "', '" + equipidthree + "')");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setStr(rs.getInt("str"));
                d.setIntl(rs.getInt("intl"));
                d.setVit(rs.getInt("vit"));
                d.setAgi(rs.getInt("agi"));
                d.setDex(rs.getInt("dex"));
                d.setCrit(rs.getInt("crit"));

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

    public ObservableList<EquipmentModel> LoadWeapon() {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipments where equipment_type = 'Weapon'");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setStr(rs.getInt("str"));
                d.setIntl(rs.getInt("intl"));
                d.setVit(rs.getInt("vit"));
                d.setAgi(rs.getInt("agi"));
                d.setDex(rs.getInt("dex"));
                d.setCrit(rs.getInt("crit"));

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
    public ObservableList<EquipmentModel> LoadArmor() {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipments where equipment_type = 'Armor'");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setStr(rs.getInt("str"));
                d.setIntl(rs.getInt("intl"));
                d.setVit(rs.getInt("vit"));
                d.setAgi(rs.getInt("agi"));
                d.setDex(rs.getInt("dex"));
                d.setCrit(rs.getInt("crit"));

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
    public ObservableList<EquipmentModel> LoadBelt() {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipments where equipment_type = 'Belt'");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setStr(rs.getInt("str"));
                d.setIntl(rs.getInt("intl"));
                d.setVit(rs.getInt("vit"));
                d.setAgi(rs.getInt("agi"));
                d.setDex(rs.getInt("dex"));
                d.setCrit(rs.getInt("crit"));

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
