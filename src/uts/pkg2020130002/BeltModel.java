/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

/**
 *
 * @author Yosef Adrian
 */
public class BeltModel extends StatusModel {
      private String beltid, statusid,beltname;
      private int belthealth, beltrarity;

    public String getBeltid() {
        return beltid;
    }

    public void setBeltid(String beltid) {
        this.beltid = beltid;
    }

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }

    public String getBeltname() {
        return beltname;
    }

    public void setBeltname(String beltname) {
        this.beltname = beltname;
    }

    public int getBelthealth() {
        return belthealth;
    }

    public void setBelthealth(int belthealth) {
        this.belthealth = belthealth;
    }

    public int getBeltrarity() {
        return beltrarity;
    }

    public void setBeltrarity(int beltrarity) {
        this.beltrarity = beltrarity;
    }
      
}
