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
public class DBEfek {

    private EfekModel data = new EfekModel();

    public EfekModel getEfekModel() {
        return (data);
    }

    public void setEfekModel(EfekModel s) {
        data = s;
    }

    public ObservableList<EfekModel> Load() {
        try {
            ObservableList<EfekModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from efek");

            int i = 1;
            while (rs.next()) {
                EfekModel d = new EfekModel();
                d.setEfekid(rs.getString("efek_id"));
                d.setEfektype(rs.getString("efek_type"));
                d.setEfekvalue(rs.getInt("efek_value"));

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
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from efek where efek_id = '" + id + "'");
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
                    "delete from efek where efek_id = ?");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into efek("
                    + "efek_id,efek_type,efek_value) values (?,?,?)");
            con.preparedStatement.setString(1, getEfekModel().getEfekid());
            con.preparedStatement.setString(2, getEfekModel().getEfektype());
            con.preparedStatement.setInt(3, getEfekModel().getEfekvalue());
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
                    "update efek set efek_type = ?, efek_value = ? where efek_id = ?;");
            con.preparedStatement.setString(1, getEfekModel().getEfektype());
            con.preparedStatement.setInt(2, getEfekModel().getEfekvalue());
            con.preparedStatement.setString(3, getEfekModel().getEfekid());
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

    public ObservableList<EfekModel> LookUp(String fld, String dt) {
        try {
            ObservableList<EfekModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * "
                    + "from efek where " + fld + " like '%" + dt + "%'");
            int i = 1;
            while (rs.next()) {
                EfekModel d = new EfekModel();
                d.setEfekid(rs.getString("efek_id"));
                d.setEfektype(rs.getString("efek_type"));
                d.setEfekvalue(rs.getInt("efek_value"));
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

    public ObservableList<EfekModel> LoadEfekSet(String dt) {
        try {
            ObservableList<EfekModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * "
                    + "from efek where efek_id IN ('" + dt + "'");
            int i = 1;
            while (rs.next()) {
                EfekModel d = new EfekModel();
                d.setEfekid(rs.getString("efek_id"));
                d.setEfektype(rs.getString("efek_type"));
                d.setEfekvalue(rs.getInt("efek_value"));
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
