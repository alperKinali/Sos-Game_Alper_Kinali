package org.kodluyoruz;

public class BlokKontrol {
    // 5. yapildi.

    // oyunun bitip bitmediğini kontrol etmek icin.
    public boolean bitis(Blok[][] bloklar, int boyut){
        boolean sonuc = true;
        for (int i = 0; i < boyut; i++){
            for (int j = 0; j < boyut; j++){
                if (bloklar[i][j].isNull()){
                    sonuc = false;
                    break;
                }
            }
        }
        return sonuc;
    }
    // burada 'SOS' olusmasi ihtimallerine gore olasılıklara bakldı (yatay,dikey)
    // (sag alt capraz, sol ust capraz, sag ust capraz sol vb)
    public boolean puanKontrol (Player sira, Blok [][] bloklar,Blok sonBlok, int boyut ) {
        // girilen harf kontrolü
        int sonBlokSatir = sonBlok.getSatir();
        int sonBlokSutun = sonBlok.getSutun();
        boolean siraKimde = false;

        if (sonBlok.getHarf() == 'S') {
            // sos icin üst dikey  dikey kontrol
            if (sonBlokSatir - 2 >= 0) {
                if (bloklar[sonBlokSatir - 2][sonBlokSutun].getHarf() == 'S' && bloklar[sonBlokSatir - 1][sonBlokSutun].getHarf() == 'O') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                    // puan alındı hala sıra aynı kişide.
                }
            }
            // sos icin alt dikey kontrol
            if (sonBlokSatir + 2 < boyut) {
                if (bloklar[sonBlokSatir + 2][sonBlokSutun].getHarf() == 'S' && bloklar[sonBlokSatir + 1][sonBlokSutun].getHarf() == 'O') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                }
            }
            // sag yatay kontrol.
            if (sonBlokSutun + 2 < boyut) {
                if (bloklar[sonBlokSatir][sonBlokSutun + 2].getHarf() == 'S' && bloklar[sonBlokSatir][sonBlokSutun + 1].getHarf() == 'O') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                }
            }
            // sol yatay kontrol
            if (sonBlokSutun - 2 >= 0) {
                if (bloklar[sonBlokSatir][sonBlokSutun - 2].getHarf() == 'S' && bloklar[sonBlokSatir][sonBlokSutun - 1].getHarf() == 'O') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                }
            }
            // dikey ve yatay bitti capraz kontrollere gecildi
            // sag ust capraz
            if (sonBlokSatir - 2 >= 0 && sonBlokSutun + 2 < boyut) {
                if (bloklar[sonBlokSatir - 2][sonBlokSutun + 2].getHarf() == 'S' && bloklar[sonBlokSatir - 1][sonBlokSutun + 1].getHarf() == 'O') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                    // sıra puan alındıgı için korunundu.
                }
            }
            // sag alt capraz (buna bakılcak)
            //Sağ Alt Çapraz Kontrol
            if (sonBlokSatir + 2 < boyut && sonBlokSutun + 2 < boyut) {
                if (bloklar[sonBlokSatir + 2][sonBlokSutun + 2].getHarf() == 'S' && bloklar[sonBlokSatir + 1][sonBlokSutun + 1].getHarf() == 'O') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                }
            }
            // sol üst capraz.
            if (sonBlokSatir - 2 >= 0 && sonBlokSutun - 2 >= 0) {
                if (bloklar[sonBlokSatir - 2][sonBlokSutun - 2].getHarf() == 'S' && bloklar[sonBlokSatir - 1][sonBlokSutun - 1].getHarf() == 'O') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                }
            }
            // sol alt capraz.
            if (sonBlokSatir + 2 < boyut && sonBlokSutun - 2 >= 0) {
                if (bloklar[sonBlokSatir + 2][sonBlokSutun - 2].getHarf() == 'S' && bloklar[sonBlokSatir + 1][sonBlokSutun - 1].getHarf() == 'O') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                }
            }
            // capraz kosullarda bitti
        } else if (sonBlok.getHarf() == 'O') {
            // girilen deger 'O' oldugunda kontrol
            // dikey kontrol
            if (sonBlokSatir - 1 >= 0 && sonBlokSatir + 1 < boyut) {
                if (bloklar[sonBlokSatir - 1][sonBlokSutun].getHarf() == 'S' && bloklar[sonBlokSatir + 1][sonBlokSutun].getHarf() == 'S') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                }
            }

            //yatay kontrol
            if (sonBlokSutun - 1 >= 0 && sonBlokSutun + 1 < boyut) {
                if (bloklar[sonBlokSatir][sonBlokSutun - 1].getHarf() == 'S' && bloklar[sonBlokSatir][sonBlokSutun + 1].getHarf() == 'S') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                }
            }

            // capraz kontrol 1
            if (sonBlokSatir - 1 >= 0 && sonBlokSutun + 1 < boyut && sonBlokSatir + 1 < boyut && sonBlokSutun - 1 >= 0) {
                if (bloklar[sonBlokSatir - 1][sonBlokSutun + 1].getHarf() == 'S' && bloklar[sonBlokSatir + 1][sonBlokSutun - 1].getHarf() == 'S') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                }
            }
            // capraz kontrol 2
            if (sonBlokSatir + 1 < boyut && sonBlokSutun + 1 < boyut && sonBlokSatir - 1 <= 0 && sonBlokSutun - 1 <= 0) {
                if (bloklar[sonBlokSatir + 1][sonBlokSutun + 1].getHarf() == 'S' && bloklar[sonBlokSatir - 1][sonBlokSutun - 1].getHarf() == 'S') {
                    sira.setPuan(sira.getPuan() + 1);
                    siraKimde = true;
                }
            }
        }
        return siraKimde;
    }
    // ilk olarak pc mi baslasin oyuncu mu için
    public int siraKimin(boolean siraKimde, int sira){
        if (!siraKimde){
            if (sira == 0){
                return 1;
            }
            else {
                return 0;
            }
        }
        // sos bulundu puan alındı
        // sıra değişmedi.
        return sira;
    }
}
