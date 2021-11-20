package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningLed extends AbstractEffect {

    public SpinningLed(IButton button) {
        super(button);
    }


    public boolean spin(int countSpins, Color color) throws ParticleException {

//        if (count >= 11) {
//            reset();
//            return false;
//        }
//        button.setLed(count,Color.white);
//        count++;
        return true;
    }

    @Override
    public boolean next() throws ParticleException {
        return false;
    }

    @Override
    public void reset() throws ParticleException{
//        button.allLedsOff();
//        count = 0;
    }
}
