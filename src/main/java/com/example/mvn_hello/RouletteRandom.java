package com.example.mvn_hello;

import java.util.Random;

public class RouletteRandom implements IRandom {
    public int random() {
        return new Random().nextInt(6);
    }
}
