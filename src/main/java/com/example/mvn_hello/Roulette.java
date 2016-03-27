package com.example.mvn_hello;

import java.util.Random;

public class Roulette {

    public static void doRoulette() {
        final int outcome = new Random().nextInt(6);
        if (outcome == 0)
            formatC();
        else
            System.out.println("Someone is lucky today.");
    }

    private static void formatC() {
        System.out.println("Formatting C:");
    }
}
