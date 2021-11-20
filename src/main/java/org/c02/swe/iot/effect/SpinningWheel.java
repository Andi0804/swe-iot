package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningWheel extends AbstractEffect {

    private Color red = Color.red;
    private Color blue = Color.blue;

    public SpinningWheel(IButton button) {
        super(button);
    }


    public void spin() throws ParticleException {
        reset();
        next();
    }

    public void initWheel() throws ParticleException {

    }

    @Override
    public boolean next() throws ParticleException {
        int count = 1;
        while(true){
            if(count%2==0) button.setLed(new LedStatus(count%12, blue));
            else button.setLed(new LedStatus(count%12, red));
            count++;
        }
    }

    @Override
    public void reset() throws ParticleException{
        button.allLedsOff();
    }
}
