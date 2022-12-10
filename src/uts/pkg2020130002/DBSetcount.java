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
public class DBSetcount {

    private SetcountModel data = new SetcountModel();

    public SetcountModel getSetcountModel() {
        return (data);
    }

    public void setSetcountModel(SetcountModel s) {
        data = s;
    }

    public ObservableList<SetcountModel> Load() {
        try {
            ObservableList<SetcountModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from set_count");
            int i = 1;
            while (rs.next()) {
                SetcountModel d = new SetcountModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setJumlah(rs.getInt("jumlah"));
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

    public int validasi(String id, int jumlah) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from set_count where set_equip_id = '" + id + "'"
                    + " and jumlah = '" + jumlah + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean Delete(String id, int jumlah) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            //System.out.println(id);
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from set_count where set_equip_id = ? and jumlah = ?");
            con.preparedStatement.setString(1, id);
            con.preparedStatement.setInt(2, jumlah);
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into set_count("
                    + "set_equip_id, jumlah) values (?,?)");
            con.preparedStatement.setString(1, getSetcountModel().getSetequipid());
            con.preparedStatement.setInt(2, getSetcountModel().getJumlah());
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
    
     public ObservableList<DetailefekModel> LoadEquipSet(String setequipid, int jumlah) {
        try {
            ObservableList<DetailefekModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(""
                    + "select set_equip_id, efek_id "
                    + " from detail_efek"
                    + " where set_equip_id= '" + setequipid + "' and jumlah <= '" + jumlah + "'");
            int i = 1;
            while (rs.next()) {
                DetailefekModel d = new DetailefekModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setJumlah(jumlah);
                d.setEfekid(rs.getString("efek_id"));
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
}
