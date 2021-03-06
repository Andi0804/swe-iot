package org.c02.swe.iot.cloud.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.SpinningWheel;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class LedDemoAppSpinningWheel {

	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public static void main(String[] args) throws IOException, ParticleException {

//		Button button = new Button(api);
//		button.allLedsOff();
//
//		SpinningWheel sw = new SpinningWheel(button);
//		sw.spin(2);

		while(true)
		{
			api.callMethod("ledMultiple", "0125500000002000000255");
			api.callMethod("ledMultiple", "0425500000005000000255");
			api.callMethod("ledMultiple", "0725500000008000000255");
			api.callMethod("ledMultiple", "1025500000011000000255");
			api.callMethod("ledsOff", null);
		}
	}
}
