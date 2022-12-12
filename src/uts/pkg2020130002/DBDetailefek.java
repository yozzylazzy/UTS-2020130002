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
public class DBDetailefek {

    private DetailefekModel data = new DetailefekModel();

    public DetailefekModel getDetailefekModel() {
        return (data);
    }

    public void setDetailefekModel(DetailefekModel s) {
        data = s;
    }

    public ObservableList<DetailefekModel> Load() {
        try {
            ObservableList<DetailefekModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from detail_efek");
            int i = 1;
            while (rs.next()) {
                DetailefekModel d = new DetailefekModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setJumlah(rs.getInt("jumlah"));
                d.setEfekid(rs.getString("efek_id"));
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

    public int validasi(String id, int jumlah, String efekid) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from detail_efek where set_equip_id = '" + id + "'"
                    + " and jumlah = '" + jumlah + "'"
                    + " and efek_id = '" + efekid + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean Delete(String id, int jumlah, String efekid) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            //System.out.println(id);
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from detail_efek where set_equip_id = ? and jumlah = ? and efek_id = ?");
            con.preparedStatement.setString(1, id);
            con.preparedStatement.setInt(2, jumlah);
            con.preparedStatement.setString(3, efekid);
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into detail_efek("
                    + "set_equip_id, jumlah, efek_id) values (?,?,?)");
            con.preparedStatement.setString(1, getDetailefekModel().getSetequipid());
            con.preparedStatement.setInt(2, getDetailefekModel().getJumlah());
            con.preparedStatement.setString(3, getDetailefekModel().getEfekid());
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

    public String LoadSetEfek(String setequipid, int jumlahset) {
        String namaefek = "";
        try {
            ObservableList<DetailsetefekModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select set_name from detail_efek ds "
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

    public ObservableList<DetailefekModel> LoadSetEfek(String setequipid) {
        try {
            ObservableList<DetailefekModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from detail_efek de "
                    + "join equipment_set es on(de.set_equip_id=es.set_equip_id) join "
                    + " efek e on (de.efek_id=e.efek_id) "
                    + "where de.set_equip_id = '" + setequipid + "'"
                    + "ORDER BY jumlah");
            int i = 1;
            while (rs.next()) {
                DetailefekModel tmp = new DetailefekModel();
                tmp.setSetname(rs.getString("set_name"));
                tmp.setEfektype(rs.getString("efek_type"));
                tmp.setEfekvalue(rs.getInt("efek_value"));
                tmp.setJumlah(rs.getInt("jumlah"));
                tmp.setJumlahmax(rs.getInt("jumlah_max"));
                tableData.add(tmp);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
