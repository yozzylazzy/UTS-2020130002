/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Yosef Adrian
 */
public class DBDetailequipmentset {
     private DetailequipmentsetModel data = new DetailequipmentsetModel();

    public DetailequipmentsetModel getDetailequipmentsetModel() {
        return (data);
    }

    public void setDetailequipmentsetModel(DetailequipmentsetModel s) {
        data = s;
    }

    public ObservableList<DetailequipmentsetModel> Load() {
        try {
            ObservableList<DetailequipmentsetModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from detail_equipment_set");
            int i = 1;
            while (rs.next()) {
                DetailequipmentsetModel d = new DetailequipmentsetModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setEquipmentid(rs.getString("equipment_id"));
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

    public int validasi(String id, String setid) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from detail_equipment_set where set_equip_id = '" + id + "'"
                    + " and equipment_id = '" + setid + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean Delete(String id, String setid) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            //System.out.println(id);
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from detail_equipment_set where set_equip_id = ? and equipment_id = ?");
            con.preparedStatement.setString(1, id);
            con.preparedStatement.setString(2, setid);
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into detail_equipment_set("
                    + "set_equip_id, equipment_id) values (?,?)");
            con.preparedStatement.setString(1, getDetailequipmentsetModel().getSetequipid());
            con.preparedStatement.setString(2, getDetailequipmentsetModel().getEquipmentid());
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
                    "update detail_equipment_set set equipment_id = ? where set_equip_id = ?;");
            con.preparedStatement.setString(1, getDetailequipmentsetModel().getEquipmentid());
            con.preparedStatement.setString(2, getDetailequipmentsetModel().getSetequipid());
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

    public ObservableList<DetailsetefekModel> LoadEquipSet(String armorid, String weaponid, String beltid) {
        try {
            ObservableList<DetailsetefekModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(""
                    + "select es.set_equip_id, Count(es.SET_EQUIP_ID) as \"Terpakai\"\n"
                    + " from equipment_set es join equipments de2 on(de2.`EQUIPMENT_ID` = es.`EQUIPMENT_ID`)"
                    + "  where de2.`EQUIPMENT_ID` IN ('" + armorid + "', '" + weaponid + "', '" + beltid + "')\n"
                    + "   GROUP BY es.SET_EQUIP_ID ");
            int i = 1;
            while (rs.next()) {
                DetailsetefekModel d = new DetailsetefekModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setItemset(rs.getInt("Terpakai"));
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String LoadSetEfek(String setequipid, int jumlahset) {
        String namaefek = "";
        try {
            ObservableList<DetailsetefekModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select set_name from detail_set_efek ds "
                    + "join equipment_set es on(ds.set_equip_id=es.set_equip_id) "
                    + "where ds.set_equip_id = '" + setequipid + "' and item_set <= '" + jumlahset + "'"
                            + "GROUP BY item_set");
            int i = 1;
            while (rs.next()) {
                namaefek = rs.getString("set_name");
                //System.out.println(rs.getString("set_name"));
                i++;
            }
            con.tutupKoneksi();
            return namaefek;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> LoadEfekID(String setequipid, int jumlahset) {
        ArrayList namaefek = new ArrayList<String>();
        try {
            //ObservableList<DetailsetefekModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select efek_id from detail_set_efek ds "
                    + "join equipment_set es on(ds.set_equip_id=es.set_equip_id) "
                    + "where ds.set_equip_id = '" + setequipid + "' and item_set <= '" + jumlahset + "'"
                            + "GROUP BY item_set");
            int i = 1;
            while (rs.next()) {
                namaefek.add(rs.getString("efek_id"));
                //System.out.println(rs.getString("efek_id")); ->Sesuai
                i++;
            }
            con.tutupKoneksi();
            return namaefek;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
    }
}
