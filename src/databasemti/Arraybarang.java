/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasemti;

import databasewsl.*;

/**
 *
 * @author ASUS
 */
public class Arraybarang {
    private String nomor2;
    private String kode2;
    private String nama2;
    private String csat;
    private String ckat;
    private String stock;


/*public Arraydetail (int nomor6, String nama7, byte[] gambar, String detail, String keterangan){
    super();
    nomor6 = nomor6;
    this.nama7 = nama7;
    this.gambar = gambar;
    this.detail = detail;
    this.keterangan = keterangan;
}*/

    public String getnomor(){
    return nomor2;
}

public void setnomor(String nomor){
    this.nomor2 = nomor;
}

public String getkode(){
    return kode2;
}

public void setkode(String kode){
    this.kode2 = kode;
}

public String getnama(){
    return nama2;
}

public void setnama(String nama){
    this.nama2 = nama;
}

public String getcsat(){
    return csat;
}

public void setcsat(String csat){
    this.csat = csat;
}

public String getckat(){
    return ckat;
}

public void setckat(String ckat){
    this.ckat = ckat;
}

public String getstock(){
    return stock;
}

public void setstock(String stock){
    this.stock = stock;
}
}