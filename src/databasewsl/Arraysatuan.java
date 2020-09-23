/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasewsl;

import databasemti.*;
import databasewsl.*;

/**
 *
 * @author ASUS
 */
public class Arraysatuan {
    private String nomor;
    private String kode;
    private String nama;
    private String keterangan;


/*public Arraydetail (int nomor6, String nama7, byte[] gambar, String detail, String keterangan){
    super();
    nomor6 = nomor6;
    this.nama7 = nama7;
    this.gambar = gambar;
    this.detail = detail;
    this.keterangan = keterangan;
}*/

    public String getnomor(){
    return nomor;
}

public void setnomor(String nomor){
    this.nomor = nomor;
}

public String getkode(){
    return kode;
}

public void setkode(String kode){
    this.kode = kode;
}

public String getnama(){
    return nama;
}

public void setnama(String nama){
    this.nama = nama;
}

public String getketerangan(){
    return keterangan;
}

public void setketerangan(String keterangan){
    this.keterangan = keterangan;
}
}