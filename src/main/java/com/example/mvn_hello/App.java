package com.example.mvn_hello;

public class App {
    public static void main(String[] args) {
        final Roulette roulette = new Roulette(new RouletteRandom(), new MyFileUtils());
        roulette.doRoulette();
    }
}
