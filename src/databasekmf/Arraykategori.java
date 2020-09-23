/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasekmf;

import databasewsl.*;
import databasemti.*;
import databasewsl.*;

/**
 *
 * @author ASUS
 */
public class Arraykategori {
    private String nomor1;
    private String kode1;
    private String nama1;
    private String keterangan1;


/*public Arraydetail (int nomor6, String nama7, byte[] gambar, String detail, String keterangan){
    super();
    nomor6 = nomor6;
    this.nama7 = nama7;
    this.gambar = gambar;
    this.detail = detail;
    this.keterangan = keterangan;
}*/

    public String getnomor(){
    return nomor1;
}

public void setnomor(String nomor){
    this.nomor1 = nomor;
}

public String getkode(){
    return kode1;
}

public void setkode(String kode){
    this.kode1 = kode;
}

public String getnama(){
    return nama1;
}

public void setnama(String nama){
    this.nama1 = nama;
}

public String getketerangan(){
    return keterangan1;
}

public void setketerangan(String keterangan){
    this.keterangan1 = keterangan;
}
}