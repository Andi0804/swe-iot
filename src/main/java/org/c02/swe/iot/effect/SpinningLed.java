package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningLed extends AbstractEffect {

    private Color color;

    public SpinningLed(IButton button) {
        super(button);
    }

    public void spin(int countSpins, Color color) throws ParticleException {
        if (countSpins < 1)
            throw new IllegalStateException();

        reset();
        this.color = color;
        for (int i = 1; i <= countSpins; i++) {
            next();
        }
    }

    @Override
    public boolean next() throws ParticleException {
        for (int i = 1; i <= 11; i++) {
            button.setLed(i, color);
            reset();
        }
        return true;
    }

    @Override
    public void reset() throws ParticleException{
        button.allLedsOff();
    }
}
