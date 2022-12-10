/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Yosef Adrian
 */
public class DBInventory {

    private InventoryModel data = new InventoryModel();

    public InventoryModel getInventoryModel() {
        return (data);
    }

    public void setInventoryModel(InventoryModel s) {
        data = s;
    }

    public ObservableList<InventoryModel> Load() {
        try {
            ObservableList<InventoryModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from inventory");
            int i = 1;
            while (rs.next()) {
                InventoryModel d = new InventoryModel();
                d.setUserid(rs.getString("user_id"));
                d.setSetequipid(rs.getString("set_equip_id"));
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

    public int validasi(String id, String equipid) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from inventory where user_id = '" + id + "'"
                    + " and equipment_id = '" + equipid + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean Delete(String id, String equipid) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            //System.out.println(id);
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from inventory where user_id = ? and equipment_id = ?");
            con.preparedStatement.setString(1, id);
            con.preparedStatement.setString(2, equipid);
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into inventory("
                    + "user_id, equipment_id) values (?,?)");
            con.preparedStatement.setString(1, getInventoryModel().getUserid());
            con.preparedStatement.setString(2, getInventoryModel().getEquipmentid());
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
