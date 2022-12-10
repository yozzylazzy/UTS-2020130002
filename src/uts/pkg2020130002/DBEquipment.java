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
public class DBEquipment {

    private EquipmentModel data = new EquipmentModel();

    public EquipmentModel getEquipmentModel() {
        return (data);
    }

    public void setEquipmentModel(EquipmentModel s) {
        data = s;
    }

    public ObservableList<EquipmentModel> Load() {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select e.*, f.* from equipments "
                    + "e join efek f on(e.efek_id = f.efek_id)");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setEfekid(rs.getString("efek_id"));
                d.setEfektype(rs.getString("efek_type"));
                d.setEfekvalue(rs.getInt("efek_value"));
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

    public ObservableList<EquipmentModel> LoadInHome(String equipidone, String equipidtwo, String equipidthree, String equipidfour, String equipidfive) {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipments e join efek f on(e.efek_id = f.efek_id) where"
                    + " equipment_id in ('" + equipidone + "', '" + equipidtwo + "', '" + equipidthree + "', '" + equipidfour + "', '" + equipidfive + "')");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
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

    public ObservableList<EquipmentModel> LoadWeapon() {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipments where equipment_type = 'Weapon'");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setEfekid(rs.getString("efek_id"));

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

    public ObservableList<EquipmentModel> LoadArmor() {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipments where equipment_type = 'Armor'");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setEfekid(rs.getString("efek_id"));

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

    public ObservableList<EquipmentModel> LoadBelt() {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipments where equipment_type = 'Belt'");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setEfekid(rs.getString("efek_id"));

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

    public ObservableList<EquipmentModel> LoadRing() {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipments where equipment_type = 'Ring'");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setEfekid(rs.getString("efek_id"));

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

    public ObservableList<EquipmentModel> LoadNecklace() {
        try {
            ObservableList<EquipmentModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from equipments where equipment_type = 'Necklace'");

            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
                d.setEfekid(rs.getString("efek_id"));
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

    public ObservableList<String> LoadEquipmentType() {
        try {
            ObservableList<String> EquipType = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select DISTINCT(equipment_type) from equipments");

            int i = 1;
            while (rs.next()) {
                EquipType.add(rs.getString("equipment_type"));
                i++;
                //System.out.println(rs.getString("weapon_id") + rs.getString("status_id") + rs.getString("weapon_name") + rs.getString(rs.getInt("weapon_atk"))
                // + rs.getInt("weapon_rarity"));
            }
            con.tutupKoneksi();
            return EquipType;
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
            ResultSet rs = con.statement.executeQuery("Select Count(*) as jml from equipments where equipment_id = '" + id + "'");
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
                    "delete from equipments where equipment_id = ?");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into equipments("
                    + "equipment_id,equipment_type,equipment_name,equipment_rarity,efek_id) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getEquipmentModel().getEquipmentid());
            con.preparedStatement.setString(2, getEquipmentModel().getEquipmenttype());
            con.preparedStatement.setString(3, getEquipmentModel().getEquipmentname());
            con.preparedStatement.setInt(4, getEquipmentModel().getEquipmentrarity());
            con.preparedStatement.setString(5, getEquipmentModel().getEfekid());
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
                    "update equipments set equipment_type = ?, equipment_name = ?, "
                    + "equipment_rarity = ?,efek_id=?  where equipment_id = ?;");
            con.preparedStatement.setString(1, getEquipmentModel().getEquipmenttype());
            con.preparedStatement.setString(2, getEquipmentModel().getEquipmentname());
            con.preparedStatement.setInt(3, getEquipmentModel().getEquipmentrarity());
            con.preparedStatement.setString(4, getEquipmentModel().getEfekid());
            con.preparedStatement.setString(5, getEquipmentModel().getEquipmentid());
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

    public ObservableList<EquipmentModel> LookUp(String fld, String dt) {
        try {
            ObservableList<EquipmentModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select equipment_id,equipment_type,equipment_name,equipment_rarity,"
                    + " e.efek_id, efek_type, efek_value "
                    + "from equipments e join efek f on(e.efek_id = f.efek_id) "
                    + "where " + fld + " like '%" + dt + "%'");
            int i = 1;
            while (rs.next()) {
                EquipmentModel d = new EquipmentModel();
                d.setEquipmentid(rs.getString("equipment_id"));
                d.setEquipmenttype(rs.getString("equipment_type"));
                d.setEquipmentname(rs.getString("equipment_name"));
                d.setEquipmentrarity(rs.getInt("equipment_rarity"));
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

    public ObservableList<SetcountModel> LoadEquipSet(String armorid, String weaponid, String beltid, String ringid, String necklaceid) {
        try {
            ObservableList<SetcountModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(""
                    + "select set_equip_id, Count(SET_EQUIP_ID) as \"Terpakai\"\n"
                    + " from equipments"
                    + " where equipment_id IN ('" + armorid + "', '" + weaponid + "', '" + beltid + "','" + ringid + "','" + necklaceid + "')\n"
                    + " GROUP BY SET_EQUIP_ID ");
            int i = 1;
            while (rs.next()) {
                SetcountModel d = new SetcountModel();
                d.setSetequipid(rs.getString("set_equip_id"));
                d.setJumlah(rs.getInt("Terpakai"));
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
