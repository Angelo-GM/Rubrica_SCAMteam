/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.edu.gastaldiabba.rubrica.model;

/**
 *
 * @author zdrahal.federica
 */
public class Cliente {
private String nomeAz;
private String indirizzo;
private String cap;
private String mail;
private String telefono;
private String pIVA;
private String citta;
private int aff;

public String getNomeAz(){
    return nomeAz;
}
public void setNomeAz(String x){
    nomeAz=x;
}
public String getIndirizzo(){
    return indirizzo;
}
public void setIndirizzo(String x){
    indirizzo=x;
}
    public String getCap() {
        return cap;
    }

    public void setCap(String x) {
        cap = x;
    }
    public String getMail(){
    return mail;
}
public void setMail(String x){
    mail=x;
}
public String getTelefono(){
    return telefono;
}
public void setTelefono(String x){
    telefono=x;
}
public String getPIVA(){
    return pIVA;
}
public void setPIVA(String x){
    pIVA=x;
}
public String getCitta(){
    return citta;
}
public void setCitta(String x){
    citta=x;
}
public int getAff(){
    return aff;
}
public void setAff(int x){
    aff=x;
}
public Cliente() {}
public Cliente(String n, String i, String c, String t, String IVA, String cit, String m, int a) {
    nomeAz = n;
    indirizzo = i;
    cap = c;
    telefono = t;
    pIVA = IVA;
    citta = cit;
    mail = m;
    aff = a;
} 

}
