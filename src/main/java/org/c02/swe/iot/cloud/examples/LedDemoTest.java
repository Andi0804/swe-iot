package org.c02.swe.iot.cloud.examples;

import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.io.IOException;

public class LedDemoTest {

	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public static void main(String[] args) throws IOException, ParticleException, InterruptedException {

		api.callMethod("ledsOff", null); // Schaltet die LEDs aus
		// nn = Position 01-12
		// rrr = rot
		// ggg = grün
		// bbb = blau
		// nnrrrgggbbb

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
