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
public class Arraydetail {
    private String nomordet;
    private String namadet;
    private byte[] gambar;
    private String detail;
    private String keterangandet;
    private String serial;


/*public Arraydetail (int nomor6, String nama7, byte[] gambar, String detail, String keterangan){
    super();
    nomor6 = nomor6;
    this.nama7 = nama7;
    this.gambar = gambar;
    this.detail = detail;
    this.keterangan = keterangan;
}*/

    public String getnomordet(){
    return nomordet;
}

public void setnomordet(String nomordet){
    this.nomordet = nomordet;
}

public String getnamadet(){
    return namadet;
}

public void setnamadet(String namadet){
    this.namadet = namadet;
}

public byte[] getgambar(){
    return gambar;
}

public void setgambar(byte[] gambar){
    this.gambar = gambar;
}

public String getdetail(){
    return detail;
}

public void setdetail(String detail){
    this.detail = detail;
}

public String getketerangandet(){
    return keterangandet;
}

public void setketerangandet(String keterangandet){
    this.keterangandet = keterangandet;
}

public String getserial(){
    return serial;
}

public void setserial(String serial){
    this.serial = serial;
}
}