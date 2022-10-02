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
public class EquipmentModel extends StatusModel {

    private String weaponid, statusid, weaponname;
    private int weaponatk, weaponrarity;

    public String getWeaponid() {
        return weaponid;
    }

    public void setWeaponid(String weaponid) {
        this.weaponid = weaponid;
    }

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }

    public String getWeaponname() {
        return weaponname;
    }

    public void setWeaponname(String weaponname) {
        this.weaponname = weaponname;
    }

    public int getWeaponatk() {
        return weaponatk;
    }

    public void setWeaponatk(int weaponatk) {
        this.weaponatk = weaponatk;
    }

    public int getWeaponrarity() {
        return weaponrarity;
    }

    public void setWeaponrarity(int weaponrarity) {
        this.weaponrarity = weaponrarity;
    }
  
}
