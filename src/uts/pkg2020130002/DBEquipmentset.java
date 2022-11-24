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
public class DBEquipmentset {
    
    private EquipmentsetModel data = new EquipmentsetModel();
    private HashMap<String, DetailsetefekModel> data2 = new HashMap<String, DetailsetefekModel>();
    private HashMap<String, DetailequipmentsetModel> dataequipset = new HashMap<String, DetailequipmentsetModel>();

    //Mengarah kepada efekid dan itemsetnya untuk difokuskan
    public EquipmentsetModel getEquipmentsetModel() {
        return (data);
    }
    
    public void setEquipmentsetModel(EquipmentsetModel s) {
        data = s;
    }
    
    public HashMap<String, DetailsetefekModel> getDetailsetEfekModel() {
        return (data2);
    }
    
    public void setDetailsetEfekModel(DetailsetefekModel d) {
        data2.put(d.getEfekid(), d);
    }
    
    public HashMap<String, DetailequipmentsetModel> getDetailEquipmentSetModel() {
        return (dataequipset);
    }
    
    public void setDetailsetEfekModel(DetailequipmentsetModel d) {
        dataequipset.put(d.getEquipmentid(), d);
    }
    
    public ObservableList<EquipmentsetModel> Load() {
        try {
            ObservableList<EquipmentsetModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipment_set");
            int i = 1;
            while (rs.next()) {
                EquipmentsetModel d = new EquipmentsetModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setSetname(rs.getString("set_name"));
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
    
    public ObservableList<DetailsetefekModel> LoadDetil() {
        try {
            ObservableList<DetailsetefekModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            data2.clear();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select * from detail_set_efek d join efek e on (d.efek_id=e.efek_id) where set_equip_id = '" + getEquipmentsetModel().getSetequipid() + "'");
            int i = 1;
            while (rs.next()) {
                DetailsetefekModel d = new DetailsetefekModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setEfekid(rs.getString("efek_id"));
                d.setItemset(Integer.parseInt(rs.getString("item_set")));
                d.setEfekvalue(Integer.parseInt(rs.getString("efek_value")));
                d.setEfektype(rs.getString("efek_type"));
                tableData.add(d);
                setDetailsetEfekModel(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ObservableList<DetailequipmentsetModel> LoadDetilEquipset() {
        try {
            ObservableList<DetailequipmentsetModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            data2.clear();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select * from detail_equipment_set d join equipments e on (d.equipment_id=e.equipment_id)"
                            + " join efek f on (e.efek_id=f.efek_id) where set_equip_id = '" + getEquipmentsetModel().getSetequipid() + "'");
            int i = 1;
            while (rs.next()) {
                DetailequipmentsetModel d = new DetailequipmentsetModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(Integer.parseInt(rs.getString("equipment_rarity")));
                d.setEfekid(rs.getString("efek_id"));
                d.setEfekvalue(Integer.parseInt(rs.getString("efek_value")));
                d.setEfektype(rs.getString("efek_type"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                tableData.add(d);
                setDetailsetEfekModel(d);
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
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from equipment_set where set_equip_id = '" + id + "'");
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
                    "delete from equipment_set where set_equip_id = ?");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into equipment_set("
                    + "set_equip_id, set_name) values (?,?)");
            con.preparedStatement.setString(1, getEquipmentsetModel().getSetequipid());
            con.preparedStatement.setString(2, getEquipmentsetModel().getSetname());
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
                    "update equipment_set set set_name = ? where set_equip_id = ?;");
            con.preparedStatement.setString(1, getEquipmentsetModel().getSetname());
            con.preparedStatement.setString(2, getEquipmentsetModel().getSetequipid());
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
    
    public ObservableList<EquipmentsetModel> LookUp(String fld, String dt) {
        try {
            ObservableList<EquipmentsetModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select set_equip_id,equipment_id,set_name "
                    + "from equipment_set where " + fld + " like '%" + dt + "%'");
            int i = 1;
            while (rs.next()) {
                EquipmentsetModel d = new EquipmentsetModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setSetname(rs.getString("set_name"));
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
    
    public boolean saveall() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.dbKoneksi.setAutoCommit(false);
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from equipment_set where set_equip_id=?");
            con.preparedStatement.setString(1, getEquipmentsetModel().getSetequipid());
            con.preparedStatement.executeUpdate();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "insert into equipment_set (set_equip_id, set_name) values (?,?)");
            con.preparedStatement.setString(1, getEquipmentsetModel().getSetequipid());
            con.preparedStatement.setString(2, getEquipmentsetModel().getSetname());
            con.preparedStatement.executeUpdate();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from detail_set_efek where set_equip_id =?");
            con.preparedStatement.setString(1, getEquipmentsetModel().getSetequipid());
            con.preparedStatement.executeUpdate();
            for (DetailsetefekModel sm : data2.values()) {
                con.preparedStatement = con.dbKoneksi.prepareStatement("insert into detail_set_efek (set_equip_id,efek_id, item_set) values (?,?,?)");
                con.preparedStatement.setString(1, sm.getSetequipid());
                con.preparedStatement.setString(2, sm.getEfekid());
                con.preparedStatement.setInt(3, sm.getItemset());
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
    
      public boolean savealldetailequipset() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.dbKoneksi.setAutoCommit(false);
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from equipment_set where set_equip_id=?");
            con.preparedStatement.setString(1, getEquipmentsetModel().getSetequipid());
            con.preparedStatement.executeUpdate();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "insert into equipment_set (set_equip_id, set_name) values (?,?)");
            con.preparedStatement.setString(1, getEquipmentsetModel().getSetequipid());
            con.preparedStatement.setString(2, getEquipmentsetModel().getSetname());
            con.preparedStatement.executeUpdate();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from detail_equipment_set where set_equip_id =?");
            con.preparedStatement.setString(1, getEquipmentsetModel().getSetequipid());
            con.preparedStatement.executeUpdate();
            for (DetailequipmentsetModel sm : dataequipset.values()) {
                con.preparedStatement = con.dbKoneksi.prepareStatement("insert into detail_equipment_set (set_equip_id,equipment_id) values (?,?)");
                con.preparedStatement.setString(1, sm.getSetequipid());
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
      
    public EquipmentsetModel getdata(String nomor) {
        EquipmentsetModel tmp = new EquipmentsetModel();
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "select * from equipment_set where set_equip_id = '"
                    + nomor + "'");
            while (rs.next()) {
                tmp.setSetequipid(rs.getString("set_equip_id"));
                tmp.setSetname(rs.getString("set_name"));
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }
    
}
