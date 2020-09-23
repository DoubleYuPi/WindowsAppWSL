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
public class Arraycompart {
    private String nomor;
    private String compartement;
    private String blok;
    private String estate;


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

public String getcompart(){
    return compartement;
}

public void setcompart(String compartement){
    this.compartement = compartement;
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
}