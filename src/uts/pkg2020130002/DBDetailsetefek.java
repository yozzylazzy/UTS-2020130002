/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

import java.sql.ResultSet;
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
}
