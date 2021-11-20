package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningWheel extends AbstractEffect {

    private Color red = Color.red;
    private Color blue = Color.blue;
    private int spin;

    public SpinningWheel(IButton button) {
        super(button);
    }


    public void spin(int spin) throws ParticleException {
        reset();
        this.spin=spin;
        next();
    }

    public void initWheel() throws ParticleException {

    }

    @Override
    public boolean next() throws ParticleException {
        int count = 0;
        while(count/11<spin){
            if(count%2==0) button.setLed(new LedStatus((count%11)+1, red));
            else button.setLed(new LedStatus((count%11)+1, blue));
            count++;
        }
        return true;
    }

    @Override
    public void reset() throws ParticleException{
        button.allLedsOff();
    }
}
