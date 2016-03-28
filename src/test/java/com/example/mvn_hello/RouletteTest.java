package com.example.mvn_hello;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RouletteTest {
    @Test
    public void ifZeroDiceCallFormatC() throws Exception {
        final IRandom random = mock(IRandom.class);
        final IFileUtils fileUtils = mock(IFileUtils.class);
        final Roulette roulette = new Roulette(random, fileUtils);
        when(random.random()).thenReturn(0);

        roulette.doRoulette();

        verify(random, times(1)).random();
        verify(fileUtils, times(1)).formatC();
    }

    @Test
    public void ifNonZeroDiceDontCallFormat() throws Exception {
        final IRandom random = mock(IRandom.class);
        final IFileUtils fileUtils = mock(IFileUtils.class);
        final Roulette roulette = new Roulette(random, fileUtils);
        when(random.random()).thenReturn(42);

        roulette.doRoulette();

        verify(random, times(1)).random();
        verify(fileUtils, times(0)).formatC();
    }
}
