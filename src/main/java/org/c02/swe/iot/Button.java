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

        DecimalFormat df = new DecimalFormat("00") ;
        df.setMinimumIntegerDigits(2);

        String formattedColor = ""+color.getRed() +color.getGreen()+color.getBlue();

        for (int i = 1; i <= 12; i++) {
            if(i == position)
                wi.callMethod("led", df.format(i) + formattedColor);
        }
    }

    public void allLedsOff() throws ParticleException {
        wi.callMethod("ledsOff", null);
    }

    public void setLed(LedStatus status) throws ParticleException {
        DecimalFormat df = new DecimalFormat("00") ;
        df.setMinimumIntegerDigits(2);

        String formattedColor = "" + status.getColor().getRed() + status.getColor().getGreen() + status.getColor().getBlue();
        String formattedPos = df.format(status.getPosition());

        wi.callMethod("led", formattedPos+formattedColor);
    }

    public void setLeds(List<LedStatus> statuses) throws ParticleException {
        for (LedStatus status: statuses) {
            setLed(status);
        }
    }
}