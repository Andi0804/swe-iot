package org.c02.swe.iot.cloud.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;
import java.io.IOException;

public class LedDemoApp {

	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public static void main(String[] args) throws IOException, ParticleException {

		Button button = new Button(api);

		button.allLedsOff();

		for (int i = 1; i <= 12 ; i++) {
			button.setLed(i, Color.blue);
		}
	}
}
