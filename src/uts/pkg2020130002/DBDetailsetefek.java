/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Yosef Adrian
 */
public class DBDetailsetefek {

    private DetailsetefekModel data = new DetailsetefekModel();

    public DetailsetefekModel getDetailsetefekModel() {
        return (data);
    }

    public void setDetailsetefekModel(DetailsetefekModel s) {
        data = s;
    }

    public ObservableList<DetailsetefekModel> Load() {
        try {
            ObservableList<DetailsetefekModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from detail_set_efek");

            int i = 1;
            while (rs.next()) {
                DetailsetefekModel d = new DetailsetefekModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setEfekid(rs.getString("efek_id"));
                d.setItemset(rs.getInt("item_set"));
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

    public int validasi(String id, String setid) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from detail_set_efek where efek_id = '" + id + "'"
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

    public boolean Delete(String id, String setid) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            //System.out.println(id);
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from detail_set_efek where efek_id = ? and set_equip_id = ?");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into detail_set_efek("
                    + "efek_id, set_equip_id, item_set) values (?,?,?)");
            con.preparedStatement.setString(1, getDetailsetefekModel().getEfekid());
            con.preparedStatement.setString(2, getDetailsetefekModel().getSetequipid());
            con.preparedStatement.setInt(3, getDetailsetefekModel().getItemset());
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
                    "update detail_set_efek set item_set = ? where efek_id = ? and set_equip_id = ?;");
            con.preparedStatement.setInt(1, getDetailsetefekModel().getItemset());
            con.preparedStatement.setString(2, getDetailsetefekModel().getEfekid());
            con.preparedStatement.setString(3, getDetailsetefekModel().getSetequipid());
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
                    + " from detail_equipment_set es join equipments de2 on(de2.`EQUIPMENT_ID` = es.`EQUIPMENT_ID`)"
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
                    + "where ds.set_equip_id = '" + setequipid + "'"
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
                    + "where ds.set_equip_id = '" + setequipid + "' and item_set = '" + jumlahset + "'"
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
