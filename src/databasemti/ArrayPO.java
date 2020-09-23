/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasemti;

import databasekmf.*;


/**
 *
 * @author ASUS
 */
public class ArrayPO {
    private String nomor;
    private String nama;
    private String satuan;
    private String harga;
    private String qty;
    private String jumlah;
    private String suplier;
    private String alamat;
    private String po;
    private String ppn;
    


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

public String getharga(){
    return harga;
}

public void setharga(String harga){
    this.harga = harga;
}

public String getqty(){
    return qty;
}

public void setqty(String qty){
    this.qty = qty;
}

public String getjumlah(){
    return jumlah;
}

public void setjumlah(String jumlah){
    this.jumlah = jumlah;
}

public String getsuplier(){
    return suplier;
}

public void setsuplier(String suplier){
    this.suplier = suplier;
}

public String getalamat(){
    return alamat;
}

public void setalamat(String alamat){
    this.alamat = alamat;
}

public String getpo(){
    return po;
}

public void setpo(String po){
    this.po = po;
}

public String getppn(){
    return ppn;
}

public void setppn(String ppn){
    this.ppn = ppn;
}
}