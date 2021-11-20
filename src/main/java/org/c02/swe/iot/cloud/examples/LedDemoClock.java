package org.c02.swe.iot.cloud.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.clock.ClockUtil;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.SpinningWheel;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class LedDemoClock {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) throws IOException, ParticleException {

        Button button = new Button(api);
        button.allLedsOff();

        Date myDate = new Date();
        ClockUtil clock = new ClockUtil(button);
        clock.show(myDate);
    }
}
