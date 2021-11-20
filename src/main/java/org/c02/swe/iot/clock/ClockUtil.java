package org.c02.swe.iot.clock;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;

import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.ParticleException;


import java.awt.*;
import java.util.ArrayList;
import java.util.Date;


public class ClockUtil {

    private IButton button;

    public ClockUtil(IButton button) {
        this.button = button;
    }

    public void show(Date date) throws ParticleException {
        button.allLedsOff();
        int hour = date.getHours()%12;
        int minute = date.getMinutes()/5;
        int second = date.getSeconds()/5;


        ArrayList<LedStatus> statuses = new ArrayList();
        statuses.add(new LedStatus(hour, Color.red));
        statuses.add(new LedStatus(minute, Color.green));
        statuses.add(new LedStatus(second, Color.blue));

        button.setLeds(statuses);
    }
}
