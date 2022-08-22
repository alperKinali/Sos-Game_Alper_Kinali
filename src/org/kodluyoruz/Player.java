package org.kodluyoruz;

public class Player {
    //1 yapıldı.
    // bos const
    public Player(){

    }

    public Player(String isim) {
        this.isim = isim;
        this.puan = 0;
    }

    private  String isim;
    private int puan;

    // getter and setter.
    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }
    public int getPuan() {
        return puan;
    }
    public void setPuan(int puan) {
        this.puan = puan;
    }
}
