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
                d.setAtk(rs.getInt("atk"));
                d.setMatk(rs.getInt("matk"));
                d.setHp(rs.getInt("hp"));
                d.setMp(rs.getInt("mp"));
                d.setDef(rs.getInt("def"));
                d.setMdef(rs.getInt("mdef"));
                d.setHit(rs.getInt("hit"));
                d.setAspd(rs.getInt("aspd"));
                d.setCspd(rs.getInt("cspd"));
                d.setCriticalrate(rs.getInt("critical_rate"));
                d.setCriticaldamage(rs.getInt("critical_damage"));

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
                    + "efek_id,atk,matk,hp,"
                    + "mp,def,mdef,hit,aspd,cspd,critical_rate,critical_damage) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            con.preparedStatement.setString(1, getEfekModel().getEfekid());
            con.preparedStatement.setInt(2, getEfekModel().getAtk());
            con.preparedStatement.setInt(3, getEfekModel().getMatk());
            con.preparedStatement.setInt(4, getEfekModel().getHp());
            con.preparedStatement.setInt(5, getEfekModel().getMp());
            con.preparedStatement.setInt(6, getEfekModel().getDef());
            con.preparedStatement.setInt(7, getEfekModel().getMdef());
            con.preparedStatement.setInt(8, getEfekModel().getHit());
            con.preparedStatement.setInt(9, getEfekModel().getAspd());
            con.preparedStatement.setInt(10, getEfekModel().getCspd());
            con.preparedStatement.setInt(11, getEfekModel().getCriticalrate());
            con.preparedStatement.setInt(12, getEfekModel().getCriticaldamage());
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
                    "update efek set atk = ?, matk = ?, "
                    + "hp = ?, mp = ?, def = ?, mdef = ?, hit = ?,"
                    + "aspd=?, cspd=?, critical_rate = ?, critical_damage=?  where efek_id = ?;");
            con.preparedStatement.setInt(1, getEfekModel().getAtk());
            con.preparedStatement.setInt(2, getEfekModel().getMatk());
            con.preparedStatement.setInt(3, getEfekModel().getHp());
            con.preparedStatement.setInt(4, getEfekModel().getMp());
            con.preparedStatement.setInt(5, getEfekModel().getDef());
            con.preparedStatement.setInt(6, getEfekModel().getMdef());
            con.preparedStatement.setInt(7, getEfekModel().getHit());
            con.preparedStatement.setInt(8, getEfekModel().getAspd());
            con.preparedStatement.setInt(9, getEfekModel().getCspd());
            con.preparedStatement.setInt(10, getEfekModel().getCriticalrate());
            con.preparedStatement.setInt(11, getEfekModel().getCriticaldamage());
            con.preparedStatement.setString(12, getEfekModel().getEfekid());
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
                d.setAtk(rs.getInt("atk"));
                d.setMatk(rs.getInt("matk"));
                d.setHp(rs.getInt("hp"));
                d.setMp(rs.getInt("mp"));
                d.setDef(rs.getInt("def"));
                d.setMdef(rs.getInt("mdef"));
                d.setHit(rs.getInt("hit"));
                d.setAspd(rs.getInt("aspd"));
                d.setCspd(rs.getInt("cspd"));
                d.setCriticalrate(rs.getInt("critical_rate"));
                d.setCriticaldamage(rs.getInt("critical_damage"));
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
                d.setAtk(rs.getInt("atk"));
                d.setMatk(rs.getInt("matk"));
                d.setHp(rs.getInt("hp"));
                d.setMp(rs.getInt("mp"));
                d.setDef(rs.getInt("def"));
                d.setMdef(rs.getInt("mdef"));
                d.setHit(rs.getInt("hit"));
                d.setAspd(rs.getInt("aspd"));
                d.setCspd(rs.getInt("cspd"));
                d.setCriticalrate(rs.getInt("critical_rate"));
                d.setCriticaldamage(rs.getInt("critical_damage"));
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
