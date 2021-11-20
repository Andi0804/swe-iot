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

        Color colorMinute, colorHour, colorSecond;

        ArrayList<LedStatus> statuses = new ArrayList<LedStatus>();

        colorHour = Color.red;
        colorMinute = Color.green;
        colorSecond = Color.blue;

        if (hour == minute) {
            colorMinute = new Color(255, 255, 0);
            colorHour = new Color(255, 255, 0);
        }

        if (minute == second) {
            colorMinute = new Color(0, 255, 255);
            colorHour = new Color(0, 255, 255);
        }

        if (hour == second) {
            colorMinute = new Color(255, 0, 255);
            colorHour = new Color(255, 0, 255);
        }

        if (hour == minute && hour == second) {
            colorHour = Color.white;
            colorMinute = Color.white;
            colorSecond = Color.white;
        }

        statuses.add(new LedStatus(hour, colorHour)); // Rot
        statuses.add(new LedStatus(minute, colorMinute)); // Grün
        statuses.add(new LedStatus(second, colorSecond)); // Blau

        button.setLeds(statuses);
    }
}
