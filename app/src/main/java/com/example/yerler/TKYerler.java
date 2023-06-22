package com.example.yerler;

public class TKYerler {
    private String tkIsim;
    private String tkAciklama;
    private String tkResimUrl;

    public TKYerler(String isim, String aciklama, String resimUrl) {
        this.tkIsim = isim;
        this.tkAciklama = aciklama;
        this.tkResimUrl = resimUrl;
    }

    public String getTkIsim() {
        return tkIsim;
    }

    public String getTkAciklama() {
        return tkAciklama;
    }

    public String getTkResimUrl() {
        return tkResimUrl;
    }
}
