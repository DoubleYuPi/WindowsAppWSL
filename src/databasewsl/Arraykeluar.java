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
public class Arraykeluar {
    private String nomor;
    private String kode;
    private String nama;
    private String satuan;
    private String kategori;
    private String departemen;
    private String blok;
    private String estate;
    private String jumlah;
    private String harga;
    


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

public String getsatuan(){
    return satuan;
}

public void setsatuan(String satuan){
    this.satuan = satuan;
}

public String getkategori(){
    return kategori;
}

public void setkategori(String kategori){
    this.kategori = kategori;
}
public String getdepartemen(){
    return departemen;
}

public void setdepartemen(String departemen){
    this.departemen = departemen;
}
public String getblok(){
    return blok;
}

public void setblok(String blok){
    this.blok = blok;
}
public String getestate(){
    return estate;
}

public void setestate(String estate){
    this.estate = estate;
}
public String getjumlah(){
    return jumlah;
}

public void setjumlah(String jumlah){
    this.jumlah = jumlah;
}

public String getharga(){
    return harga;
}

public void setharga(String harga){
    this.harga = harga;
}
}