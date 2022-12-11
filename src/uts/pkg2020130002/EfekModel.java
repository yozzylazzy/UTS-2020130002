/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pkg2020130002;

/**
 *
 * @author Yosef Adrian
 */
public class EfekModel {

    private String efekid, efektype;
    private int efekvalue;
    private int hp, mp, atk, matk, def, mdef, hit, flee, aspd, cspd;

    public String getEfekid() {
        return efekid;
    }

    public void setEfekid(String efekid) {
        this.efekid = efekid;
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

    public void getEfek(){
         switch (efektype.toLowerCase()) {
            case "hp":
                hp = efekvalue;
                break;
            case "mp":
                mp = efekvalue;
                break;
            case "atk":
                atk = efekvalue;
                break;
            case "matk":
                matk = efekvalue;
                break;
            case "def":
                def = efekvalue;
                break;
            case "mdef":
                mdef = efekvalue;
                break;
            case "hit":
                hit = efekvalue;
                break;
            case "flee":
                flee = efekvalue;
                break;
            case "aspd":
                aspd = efekvalue;
                break;
            case "cspd":
                cspd = efekvalue;
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
}
