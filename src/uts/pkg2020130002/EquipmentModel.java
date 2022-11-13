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

    private String equipmentid,equipmenttype,equipmentname, efekid, efektype;
    private int equipmentrarity, efekvalue;
    public String getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(String equipmentid) {
        this.equipmentid = equipmentid;
    }

    public String getEfektype() {
        return efektype;
    }

    public void setEfektype(String efektype) {
        this.efektype = efektype;
    }

    public int getEfekvalue() {
        return efekvalue;
    }

    public void setEfekvalue(int efekvalue) {
        this.efekvalue = efekvalue;
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

    public String getEfekid() {
        return efekid;
    }

    public void setEfekid(String efekid) {
        this.efekid = efekid;
    }

}
