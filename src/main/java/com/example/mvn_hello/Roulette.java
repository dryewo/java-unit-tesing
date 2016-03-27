package com.example.mvn_hello;

import java.util.Random;

public class Roulette {

    public static void doRoulette() {
        final int outcome = diceRoll();
        if (outcome == 0)
            formatC();
        else
            System.out.println("Someone is lucky today.");
    }

    private static int diceRoll() {
        System.out.println("Rolling dice...");
        return new Random().nextInt(6);
    }

    private static void formatC() {
        System.out.println("Formatting C:");
    }
}
