package com.example.mvn_hello;

public class Roulette {

    private final IRandom random;
    private final IFileUtils fileUtils;

    public Roulette(IRandom random, IFileUtils fileUtils) throws IllegalArgumentException {
        if (random == null)
            throw new IllegalArgumentException("cannot random null");
        this.random = random;
        if (fileUtils == null)
            throw new IllegalArgumentException("cannot fileUtils null");
        this.fileUtils = fileUtils;
    }

    public void doRoulette() {
        final int outcome = random.random();
        if (outcome == 0)
            fileUtils.formatC();
        else
            System.out.println("Someone is lucky today.");
    }
}
