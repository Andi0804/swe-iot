package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningLed extends AbstractEffect {

    public SpinningLed(IButton button) {
        super(button);
    }

    public void spin(int countSpins, Color color) {

    }

    @Override
    public boolean next() throws ParticleException {
        return true;
    }

    @Override
    public void reset() throws ParticleException{
        /*button.allLedsOff();
        count = 0;*/
    }
}
