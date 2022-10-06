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
public class DBStatus {

    private StatusModel data = new StatusModel();

    public StatusModel getStatusModel() {
        return (data);
    }

    public void setStatusModel(StatusModel s) {
        data = s;
    }

    public ObservableList<StatusModel> Load() {
        try {
            ObservableList<StatusModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from status");

            int i = 1;
            while (rs.next()) {
                StatusModel d = new StatusModel();
                d.setStatusid(rs.getString("status_id"));
                d.setStr(rs.getInt("str"));
                d.setIntl(rs.getInt("intl"));
                d.setDex(rs.getInt("vit"));
                d.setAgi(rs.getInt("agi"));
                d.setVit(rs.getInt("dex"));
                d.setCrit(rs.getInt("crit"));

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
