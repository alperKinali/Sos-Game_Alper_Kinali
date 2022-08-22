package org.kodluyoruz;

import java.util.Random;

public class Game {
    //4 yapildi.

    private Player[] oyuncular = new Player[2];
    private int sira;
    private int boyut;
    private Blok[][] bloklar;

    // boş constructor
    public Game(){

    }

    public Game(Player player1, Pc pc, int boyut){
        this.oyuncular[0] = player1;
        this.oyuncular[1] = pc;
        this.boyut = boyut;
        bloklar = new Blok[boyut][boyut];

        for (int i = 0; i < boyut; i++){
            for (int j = 0; j < boyut; j++){
                bloklar[i][j] = new Blok(i,j);
            }
        }
        this.sira = ilkBasla();
    }

    /*
    public void tablo(){
        for (int i = 0; i <= this.boyut; i++){
            for (int j = 0; j <= this.boyut; j++){
                if (i == 0){
                    System.out.print(j + " ");
                }
                else {
                    if (j == 0){
                        System.out.print(i + " ");
                    }
                    else {
                        System.out.print(bloklar[i-1][j-1].getHarf() + " ");
                    }
                }
            }
            System.out.println();
        }
    }
     */

    public Blok harfYaz(int satir, int sutun, char harf){
        Blok blok = bloklar[satir-1][sutun-1];
        if (blok.isNull()){
            blok.setHarf(harf);
            blok.setNull(false);
        }
        else {
            return null;
        }
        return blok;
    }

    // girilen game alanın boyut kontrolu
    public boolean boyutKontrol(int boyut){
        if (boyut >= 5 && boyut <= 10){
            return true;
        }
        return false;
    }

    public int ilkBasla(){
        Random rnd = new Random();
        return rnd.nextInt(2);
    }

    public int getBoyut() {
        return boyut;
    }

    public void setBoyut(int boyut) {
        this.boyut = boyut;
    }

    public Player[] getOyuncular() {
        return oyuncular;
    }

    public int getSira() {
        return sira;
    }

    public void setSira(int sira) {
        this.sira = sira;
    }

    public Blok[][] getBloklar() {
        return bloklar;
    }

    public void setBloklar(Blok[][] bloklar) {
        this.bloklar = bloklar;
    }
}
