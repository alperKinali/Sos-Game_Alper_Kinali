package org.kodluyoruz;

public class Blok {
    // 3 yapildi.
    // boş kurucusu.
    public  Blok(){

    }

    // blok her oluşturulurken bizden satır ve sütun ister(constructor)
    // ve içerisinde ki karakter harfi.
    public Blok(int satir, int sutun){
        this.satir = satir;
        this.sutun = sutun;
        this.isNull = true;
        this.harf = ' ';
    }

    private char harf;
    private boolean isNull;
    private int satir;
    private int sutun;



    // getter and setter.
    public char getHarf() {
        return harf;
    }

    public void setHarf(char harf) {
        this.harf = harf;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    public int getSatir() {
        return satir;
    }

    public int getSutun() {
        return sutun;
    }
}
