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

        if (hour == 0)
            hour = 1;

        if (minute == 0)
            minute = 1;

        if (second == 0)
            second = 1;

        ArrayList<LedStatus> statuses = new ArrayList<LedStatus>();

        Color colorHour = Color.red;
        Color colorMinute = Color.green;
        Color colorSecond = Color.blue;

        if (hour == minute) {
            colorMinute = Color.yellow;
            colorHour = Color.yellow;
        }

        if (minute == second) {
            colorMinute = Color.cyan;
            colorSecond =  Color.cyan;
        }

        if (hour == second) {
            colorHour = Color.magenta;
            colorSecond = Color.magenta;
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
