/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public int validasi(String id) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from equipments where equipment_id = '" + id + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean Delete(String id) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            //System.out.println(id);
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from equipments where equipment_id = ?");
            con.preparedStatement.setString(1, id);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean insert() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into equipments(equipment_id,equipment_type,equipment_name,equipment_rarity,"
                    + "str,intl,vit,agi,dex,crit) values (?,?,?,?,?,?,?,?,?,?)");
            con.preparedStatement.setString(1, getEquipmentModel().getEquipmentid());
            con.preparedStatement.setString(2, getEquipmentModel().getEquipmenttype());
            con.preparedStatement.setString(3, getEquipmentModel().getEquipmentname());
            con.preparedStatement.setInt(4, getEquipmentModel().getEquipmentrarity());
            con.preparedStatement.setInt(5, getEquipmentModel().getStr());
            con.preparedStatement.setInt(6, getEquipmentModel().getIntl());
            con.preparedStatement.setInt(7, getEquipmentModel().getVit());
            con.preparedStatement.setInt(8, getEquipmentModel().getAgi());
            con.preparedStatement.setInt(9, getEquipmentModel().getDex());
            con.preparedStatement.setInt(10, getEquipmentModel().getCrit());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = (PreparedStatement) con.dbKoneksi.prepareStatement(
                    "update equipments set equipment_type = ?, equipment_name = ?, "
                    + "equipment_rarity = ?, str = ?, intl = ? vit = ?, agi = ?,"
                    + "dex=?, crit=?  where equipment_id = ?;");
            con.preparedStatement.setString(1, getEquipmentModel().getEquipmenttype());
            con.preparedStatement.setString(2, getEquipmentModel().getEquipmentname());
            con.preparedStatement.setInt(3, getEquipmentModel().getEquipmentrarity());
            con.preparedStatement.setInt(4, getEquipmentModel().getStr());
            con.preparedStatement.setInt(5, getEquipmentModel().getIntl());
            con.preparedStatement.setInt(6, getEquipmentModel().getVit());
            con.preparedStatement.setInt(7, getEquipmentModel().getAgi());
            con.preparedStatement.setInt(8, getEquipmentModel().getDex());
            con.preparedStatement.setInt(9, getEquipmentModel().getCrit());
            con.preparedStatement.setString(10, getEquipmentModel().getEquipmentid());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

}
