package org.kodluyoruz;

import java.util.Random;
import java.util.stream.IntStream;


public class Pc extends  Player{
    Random rnd = new Random();
    Character[] harf = { 'S', 'O'};
    public Pc() {
        super("Bilgisayar");
    }
    public int satirVeYaSutunSec(int boyut){

        return rnd.nextInt((boyut - 1) + 1) + 1;
    }



    public char harfSec(){
        return harf[rnd.nextInt(2)];
    }

}
