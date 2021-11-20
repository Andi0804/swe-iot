package org.c02.swe.iot;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.List;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {

    IParticleApi wrapperInstance;

    public Button(IParticleApi wrapperInstance) {
        this.wrapperInstance = wrapperInstance;
    }

    public void setLed(int position, Color color) throws ParticleException {

        if (position < 1 || position > 12)
            throw new IllegalArgumentException();

        DecimalFormat df = new DecimalFormat("00") ;
        df.setMinimumIntegerDigits(2);

        for (int i = 1; i <= 12; i++) {
            if(i == position)
                wrapperInstance.callMethod("led", df.format(i)+color.getRed()+color.getGreen()+color.getBlue());
        }
    }

    public void allLedsOff() throws ParticleException {
        wrapperInstance.callMethod("ledsOff", null);
    }

    public void setLed(LedStatus status) throws ParticleException {

    }

    public void setLeds(List<LedStatus> statuses) throws ParticleException {

    }
}