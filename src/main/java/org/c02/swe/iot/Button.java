package org.c02.swe.iot;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.List;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {

    IParticleApi wi;

    public Button(IParticleApi wrapperInstance) {
        this.wi = wrapperInstance;
    }

    public void setLed(int position, Color color) throws ParticleException {

        if (position < 1 || position > 12)
            throw new IllegalArgumentException();

        if (color == null)
            throw new IllegalArgumentException();

        DecimalFormat dfPos = new DecimalFormat("00") ;
        dfPos.setMinimumIntegerDigits(2);

        DecimalFormat dfColor = new DecimalFormat("000") ;
        String formattedColor = ""+dfColor.format(color.getRed()) + dfColor.format(color.getGreen()) + dfColor.format(color.getBlue());

        for (int i = 1; i <= 12; i++) {
            if(i == position)
                wi.callMethod("led", dfPos.format(i) + formattedColor);
        }
    }

    public void allLedsOff() throws ParticleException {
        wi.callMethod("ledsOff", null);
    }

    public void setLed(LedStatus status) throws ParticleException {
        setLed(status.getPosition(), status.getColor());
    }

    public void setLeds(List<LedStatus> statuses) throws ParticleException {

        for (LedStatus status: statuses) {
            if(status == null)
                throw new IllegalArgumentException();
            setLed(status);
        }
    }
}