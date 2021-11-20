package org.c02.iot.effect.test;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.SpinningLed;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.Mockito.*;

public class SpinningLedTest {

    @Test
    public void testReset() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);

        SpinningLed poc = new SpinningLed(buttonInstance);
        poc.reset();

        verify(buttonInstance).allLedsOff();
        verifyNoMoreInteractions(buttonInstance);
    }

    @Test
    public void testOneTick() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        SpinningLed poc = new SpinningLed(buttonInstance);
        int spins = 1;

        poc.spin(spins, Color.blue);

        InOrder inOrder = Mockito.inOrder(buttonInstance);
        for (int count = 1; count <= 11 * spins; count++) {
            inOrder.verify(buttonInstance).setLed(count, Color.blue);
        }

        inOrder.verify(buttonInstance).allLedsOff();
        inOrder.verifyNoMoreInteractions();
    }


    @Test
    public void testSequenceTwoTicks() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        SpinningLed poc = new SpinningLed(buttonInstance);

        int spins = 2;

        poc.spin(spins, Color.red);

        InOrder inOrder = Mockito.inOrder(buttonInstance);
        for (int i = 0; i < spins; i++) {
            for (int count = 1; count <= 11; count++) {
                inOrder.verify(buttonInstance).setLed(count, Color.red);
            }
        }

        inOrder.verify(buttonInstance).allLedsOff();
        inOrder.verifyNoMoreInteractions();
    }

    @Test(expected = IllegalStateException.class)
    public void testNegativeSpins() throws ParticleException {

        IButton buttonInstance = Mockito.mock(IButton.class);
        SpinningLed poc = new SpinningLed(buttonInstance);

        int spins = -2;

        poc.spin(spins, Color.red);

        verifyNoInteractions(buttonInstance);
    }
}
