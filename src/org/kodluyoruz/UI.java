package org.kodluyoruz;

import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    public int anaMenu(){
        System.out.println("----------SOS OYUNU----------");
        System.out.println("1) OYUNA BASLA.");
        System.out.println("0) CIKIS.");
        System.out.print("SECIMINIZI GIRINIZ: ");
        return scanner.nextInt();
    }

    // boyutu belirle game'den
    public int boyutBelirle(){
        System.out.print("Oyunun Boyutunu Giriniz (MIN: 5, MAX: 10): ");
        return scanner.nextInt();
    }
    public String oyuncuAdiGir(){
        System.out.print("Adinizi Giriniz: ");
        return scanner.next();
    }
    // normalda game'de olan tablo buraya alındı.

    public void tabloYaz(Game game){
        for (int i = 0; i <= game.getBoyut(); i++){
            for (int j = 0; j <= game.getBoyut(); j++){
                if (i == 0){
                    System.out.print(j + " ");
                }
                else {
                    if (j == 0){
                        System.out.print(i + " ");
                    }
                    else {
                        System.out.print(game.getBloklar()[i-1][j-1].getHarf() + " ");
                    }
                }
            }
            System.out.println();
        }
    }
    public void puanDurumu(Player[] players){
        System.out.println("----------PUAN DURUMU----------");
        for (int i = 0; i < players.length; i++){
            System.out.println(players[i].getIsim() + ":" + players[i].getPuan());
        }
    }

    // oyuncu icin satir secimi.
    public int satirSec(){
        System.out.print("Satir Giriniz: ");
        return scanner.nextInt();
    }

    // oyuncu icin sutun secimi
    public int sutunSec(){
        System.out.print("Sutun Giriniz: ");
        return scanner.nextInt();
    }

    // oyuncu icin harf secimi
    public char harfSec(){
        System.out.print("Harf Giriniz (S, O): ");
        char[] harf = scanner.next().toCharArray();
        return harf[0];
    }

    public void kazanan(Game game){
        if (game.getOyuncular()[0].getPuan() > game.getOyuncular()[1].getPuan()){
            System.out.println(game.getOyuncular()[0].getIsim() + " KAZANDI");
        }
        else if (game.getOyuncular()[0].getPuan() < game.getOyuncular()[1].getPuan()){
            System.out.println(game.getOyuncular()[1].getIsim() + " KAZANDI");
        }
        else {
            System.out.println("BERABERLIK");
        }
    }

}
