/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Yosef Adrian
 */
public class DBPlayer {

    private PlayerModel data = new PlayerModel();
    private HashMap<String, InventoryModel> datadetailinv = new HashMap<String, InventoryModel>();

    //Mengarah kepada efekid dan itemsetnya untuk difokuskan
    public PlayerModel getPlayerModel() {
        return (data);
    }

    public void setPlayerModel(PlayerModel s) {
        data = s;
    }

    public HashMap<String, InventoryModel> getInventoryModel() {
        return (datadetailinv);
    }

    public void setInventoryModel(InventoryModel d) {
        datadetailinv.put(d.getEquipmentid(), d);
    }

    public ObservableList<PlayerModel> Load() {
        try {
            ObservableList<PlayerModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from player");
            int i = 1;
            while (rs.next()) {
                PlayerModel d = new PlayerModel();
                d.setUserid(rs.getString("user_id"));
                //System.out.println(d.getSetname());
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

    public ObservableList<InventoryModel> LoadDetil() {
        try {
            ObservableList<InventoryModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            datadetailinv.clear();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select * from player p join inventory i on (p.user_id=i.user_id) join "
                    + " equipments e on (i.equipment_id=e.equipment_id) where user_id = '" + getPlayerModel().getUserid() + "'");
            int i = 1;
            while (rs.next()) {
                InventoryModel d = new InventoryModel();
                d.setUserid(rs.getString("set_equip_id"));
                d.setEquipmentid(rs.getString("efek_id"));
                d.setEquipmentname(rs.getString("equipment_name"));
                tableData.add(d);
                setInventoryModel(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<InventoryModel> LoadDetilSet(String userid) {
        try {
            ObservableList<InventoryModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            datadetailinv.clear();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select * from player p join inventory i on (p.user_id=i.user_id) join "
                    + " equipments e on (i.equipment_id=e.equipment_id) where p.user_id = '" + userid + "'");
            int i = 1;
            while (rs.next()) {
                InventoryModel d = new InventoryModel();
                d.setUserid(rs.getString("set_equip_id"));
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmentname(rs.getString("equipment_name"));
                tableData.add(d);
                setInventoryModel(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
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
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from player where user_id = '" + id + "'");
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
                    "delete from player where user_id = ?");
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

    public boolean saveall() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        if (datadetailinv.values().size() > 0) {
            try {
                con.bukaKoneksi();
                con.dbKoneksi.setAutoCommit(false);
                con.preparedStatement = con.dbKoneksi.prepareStatement(
                        "delete from player where user_id =?");
                con.preparedStatement.setString(1, getPlayerModel().getUserid());
                con.preparedStatement.executeUpdate();
                con.preparedStatement = con.dbKoneksi.prepareStatement(
                        "insert into player (user_id) values (?)");
                con.preparedStatement.setString(1, getPlayerModel().getUserid());
                con.preparedStatement.executeUpdate();
                con.preparedStatement = con.dbKoneksi.prepareStatement(
                        "delete from inventory where user_id =?");
                con.preparedStatement.setString(1, getPlayerModel().getUserid());
                con.preparedStatement.executeUpdate();
                //System.out.println(datadetailinv.values());
                for (InventoryModel sm : datadetailinv.values()) {
                    con.preparedStatement = con.dbKoneksi.prepareStatement("insert into inventory (user_id,equipment_id) values (?,?)");
                    con.preparedStatement.setString(1, sm.getUserid());
                    con.preparedStatement.setString(2, sm.getEquipmentid());
                    con.preparedStatement.executeUpdate();
                }
                con.dbKoneksi.commit();
                berhasil = true;
            } catch (Exception e) {
                e.printStackTrace();
                berhasil = false;
            } finally {
                con.tutupKoneksi();
                return berhasil;
            }
        }
        return false;
    }

    public PlayerModel getdata(String nomor) {
        PlayerModel tmp = new PlayerModel();
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "select * from player where user_id = '"
                    + nomor + "'");
            while (rs.next()) {
                tmp.setUserid(rs.getString("user_id"));;
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public String getLastUID() {
        try {
            String lastid = "";
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            datadetailinv.clear();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select max(user_id) as LASTID from player");
            int i = 1;
            while (rs.next()) {
                PlayerModel d = new PlayerModel();
                d.setUserid(rs.getString("LASTID"));
                setPlayerModel(d);
                i++;
                lastid = d.getUserid();
            }
            con.tutupKoneksi();
            return lastid;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
