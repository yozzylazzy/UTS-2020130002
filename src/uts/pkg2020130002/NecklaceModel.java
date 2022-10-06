/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

/**
 *
 * @author Yosef Adrian
 */
public class NecklaceModel extends StatusModel{
    private String necklaceid, statusid, necklacename;
    private int necklacemdef, beltrarity;

    public String getNecklaceid() {
        return necklaceid;
    }

    public void setNecklaceid(String necklaceid) {
        this.necklaceid = necklaceid;
    }

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }

    public String getNecklacename() {
        return necklacename;
    }

    public void setNecklacename(String necklacename) {
        this.necklacename = necklacename;
    }

    public int getNecklacemdef() {
        return necklacemdef;
    }

    public void setNecklacemdef(int necklacemdef) {
        this.necklacemdef = necklacemdef;
    }

    public int getBeltrarity() {
        return beltrarity;
    }

    public void setBeltrarity(int beltrarity) {
        this.beltrarity = beltrarity;
    }
    
}
