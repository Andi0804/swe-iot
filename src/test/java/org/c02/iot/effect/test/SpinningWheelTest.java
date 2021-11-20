package org.c02.iot.effect.test;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.SpinningLed;
import org.c02.swe.iot.effect.SpinningWheel;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class SpinningWheelTest {

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
    public void testSpin() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        SpinningWheel poc = new SpinningWheel(buttonInstance);

        poc.spin(1);

        InOrder inOrder = Mockito.inOrder(buttonInstance);

        //inOrder.verify(buttonInstance).setLed(1, Color.red);
        //inOrder.verify(buttonInstance).setLed(count, Color.blue);


        //inOrder.verify(buttonInstance).allLedsOff();
    }
}
