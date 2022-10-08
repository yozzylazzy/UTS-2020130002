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
public class DBDetailequipset {
      
    private DetailequipsetModel data = new DetailequipsetModel();

    public DetailequipsetModel getDetailequipsetModel() {
        return (data);
    }

    public void setDetailequipsetModel(DetailequipsetModel s) {
        data = s;
    }

    public ObservableList<DetailequipsetModel> Load() {
        try {
            ObservableList<DetailequipsetModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from detail_equip_set");

            int i = 1;
            while (rs.next()) {
                DetailequipsetModel d = new DetailequipsetModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setEquipmentid(rs.getString("equipment_id"));
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
      public int validasi(String equipid, String setid) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from detail_equip_set where equipment_id = '" + equipid + "'"
                    + " and set_equip_id = '" + setid + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean Delete(String equipid, String setid) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            //System.out.println(id);
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from detail_equip_set where equipment_id = ? and set_equip_id = ?");
            con.preparedStatement.setString(1, equipid);
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into detail_equip_set("
                    + "set_equip_id, equipment_id) values (?,?)");
            con.preparedStatement.setString(1, getDetailequipsetModel().getSetequipid());
            con.preparedStatement.setString(2, getDetailequipsetModel().getEquipmentid());
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
