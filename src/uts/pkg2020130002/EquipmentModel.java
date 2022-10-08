/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

/**
 *
 * @author Yosef Adrian
 */

/*
//https://gamefaqs.gamespot.com/ps4/237501-super-neptunia-rpg/faqs/77548/equipment?validate=1
-->Ngikutin Super Neptunia RPG Prinsipnya
https://store.playstation.com/en-sg/product/UP0031-CUSA12059_00-DLC0000000000003
Equipment yang dipakai permain terbagi menjadi 6 buah jenis eq
Nama Jenis Eq :
-Weapons
-Bracelets
-Accessories
-Necklace

 */
public class EquipmentModel {

    private String equipmentid,equipmenttype,equipmentname;
    private int equipmentrarity, str, intl, vit, agi, dex, crit;

    public String getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(String equipmentid) {
        this.equipmentid = equipmentid;
    }

    public String getEquipmenttype() {
        return equipmenttype;
    }

    public void setEquipmenttype(String equipmenttype) {
        this.equipmenttype = equipmenttype;
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(String equipmentname) {
        this.equipmentname = equipmentname;
    }

    public int getEquipmentrarity() {
        return equipmentrarity;
    }

    public void setEquipmentrarity(int equipmentrarity) {
        this.equipmentrarity = equipmentrarity;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getIntl() {
        return intl;
    }

    public void setIntl(int intl) {
        this.intl = intl;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }
}
