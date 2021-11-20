package org.c02.iot.clock;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.clock.ClockUtil;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ClockUtilTest {

    @Test
    public void testAllPointer() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);

        ClockUtil clock = new ClockUtil(buttonInstance);
        Instant time = LocalTime.of(3, 5, 45).atDate(LocalDate.of(2020, 1, 1)).
                atZone(ZoneId.systemDefault()).toInstant();
        clock.show(Date.from(time));
        
        verify(buttonInstance).setLeds(any(ArrayList.class));

        verifyNoMoreInteractions(buttonInstance);
    }
}
