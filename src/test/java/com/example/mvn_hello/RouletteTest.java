package com.example.mvn_hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.method;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.suppress;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.reflect.Whitebox.invokeMethod;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Roulette.class)
public class RouletteTest {

    @Test
    public void ifZeroDiceCallFormatC() throws Exception {
        // CALL_REAL_METHODS to be able to call doRoulette()
        mockStatic(Roulette.class, Mockito.CALLS_REAL_METHODS);
        // When diceRoll is called, always return 0
        doReturn(0).when(Roulette.class, "diceRoll");
        // Do nothing instead of formatting C:
        suppress(method(Roulette.class, "formatC"));

        Roulette.doRoulette();

        // Check that methods were invoked
        verifyPrivate(Roulette.class, times(1)).invoke("diceRoll");
        verifyPrivate(Roulette.class, times(1)).invoke("formatC");
    }

    @Test
    public void ifNonZeroDiceDontCallFormat() throws Exception {
        mockStatic(Roulette.class, Mockito.CALLS_REAL_METHODS);
        doReturn(1).when(Roulette.class, "diceRoll");
        suppress(method(Roulette.class, "formatC"));

        Roulette.doRoulette();

        verifyPrivate(Roulette.class, times(1)).invoke("diceRoll");
        verifyPrivate(Roulette.class, times(0)).invoke("formatC");
    }

    @Test
    public void diceRollTest() throws Exception {
        final Random random = mock(Random.class);
        whenNew(Random.class).withNoArguments().thenReturn(random);
        when(random.nextInt(6)).thenReturn(42);

        assertEquals(42, invokeMethod(Roulette.class, "diceRoll"));

        verifyNew(Random.class).withNoArguments();
        verify(random, times(1)).nextInt(6);
    }
}
