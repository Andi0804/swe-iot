package org.c02.iot;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.ArrayList;

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

    @Test
    public void testLedWithStatus() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        final LedStatus ledStatus = new LedStatus(1, Color.blue);

        Button testButton = new Button(api);

        testButton.setLed(ledStatus);

        verify(api).callMethod("led", "01000000255");
    }

    @Test
    public void testLedWithStatuses() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        ArrayList<LedStatus> ledStatuses = new ArrayList<>();
        ledStatuses.add(new LedStatus(1, Color.red));
        ledStatuses.add(new LedStatus(2, Color.blue));

        Button testButton = new Button(api);

        testButton.setLeds(ledStatuses);

        verify(api).callMethod("led", "01000000255");
        verify(api).callMethod("led", "02255000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testColorIsNull() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        final LedStatus ledStatus = new LedStatus(1, null);

        testButton.setLed(ledStatus);

        verify(api, never()).callMethod(anyString(), anyString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayWithNullValues() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        ArrayList<LedStatus> ledStatuses = new ArrayList<>();
        ledStatuses.add(new LedStatus(1, Color.red));
        ledStatuses.add(null);

        Button testButton = new Button(api);

        testButton.setLeds(ledStatuses);

        verify(api, never()).callMethod(anyString(), anyString());
    }
}
