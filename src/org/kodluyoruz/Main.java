package org.kodluyoruz;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // bos constructorlarından oluşturuldu.
        UI ui = new UI();
        Game game = new Game();
        BlokKontrol kontrol = new BlokKontrol();
        Player oyuncu = new Player();
        Pc pc = new Pc();

        int islem =ui.anaMenu();
        int boyut =0;
        boolean basla =false;
        boolean sira =false;

        // girilen blok değeri
        Blok  sonBlok = new Blok();

        while (islem==1){
            if (oyuncu.getIsim()==null){
                oyuncu.setIsim(ui.oyuncuAdiGir());
                boyut=ui.boyutBelirle();
            }
            if (game.boyutKontrol(boyut) && !basla ){
                // boyut degerleri dogru
                // ve daha oyun baslamadı ise
                game=new Game( oyuncu,pc,boyut);
                basla=true;
            }
            else if (!basla){
                System.out.println("!!HATALI BOYUT GIRILDI!! ");
                boyut = ui.boyutBelirle();
            }
            if (basla){
                ui.tabloYaz(game);
                System.out.println("SIRA: " + game.getOyuncular()[game.getSira()].getIsim());
                if (game.getOyuncular()[game.getSira()].getIsim().equals("Bilgisayar")){
                    // random gelen değer pc de ise
                    sonBlok=game.harfYaz(pc.satirVeYaSutunSec(boyut),pc.satirVeYaSutunSec(boyut),pc.harfSec());
                }
                else {
                    sonBlok=game.harfYaz(ui.satirSec(),ui.sutunSec(),ui.harfSec());
                }
                if (sonBlok !=null){
                    // girilen yerde zaten harf yoksa
                    sira=kontrol.puanKontrol(game.getOyuncular()[game.getSira()], game.getBloklar(), sonBlok,boyut);
                    game.setSira(kontrol.siraKimin(sira, game.getSira()));
                }
                else {
                    System.out.println("!!!DOLU BLOK SECILDI!!!");
                }
                ui.puanDurumu(game.getOyuncular());
                if (kontrol.bitis(game.getBloklar(),boyut)){
                    // bitti mi bitmedi mi
                    // biti
                    System.out.println("----------OYUN BİTTİ-----------");
                    ui.puanDurumu(game.getOyuncular());
                    ui.kazanan(game);
                    basla = false;
                    oyuncu.setIsim(null);
                    islem = ui.anaMenu();

                }

            }

        }







    }
}
