package org.c02.iot;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.Mockito.*;

public class ButtonTest {


    @Test
    public void testLedsOff() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.allLedsOff();

        verify(api).callMethod("ledsOff", null);

    }

    @Test
    public void testLedWhitePos1() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.setLed(1, Color.white);

        verify(api).callMethod("led", "01255255255");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLedPositionLowerOne() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.setLed(-1, Color.white);

        verify(api, never()).callMethod(anyString(), anyString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLedPositionHigher12() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.setLed(25, Color.white);

        verify(api, never()).callMethod(anyString(), anyString());
    }

}
