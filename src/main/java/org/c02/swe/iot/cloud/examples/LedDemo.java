package org.c02.swe.iot.cloud.examples;

import java.awt.*;
import java.io.IOException;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.WhiteLedRunning;

public class LedDemo {

	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public static void main(String[] args) throws IOException, ParticleException {

		/*api.callMethod("ledsOff", null); // Schaltet die LEDs aus
		// nn = Position 01-12
		// rrr = rot
		// ggg = grün
		// bbb = blau
		// nnrrrgggbbb
		api.callMethod("led", "01255255255");
		api.callMethod("led", "05255000000"); //red
		api.callMethod("led", "06000255000"); //green
		api.callMethod("led", "07000000255"); //blue
		api.callMethod("led", "11000255255");
*/
		// api.callMethod("ledsOff", null);

		Button button = new Button(api);

		button.allLedsOff();

		WhiteLedRunning w = new WhiteLedRunning(button);
		for (int i = 0; i < 100; i++) {
			w.next();
			button.allLedsOff();
		}

//		for (int i = 1; i <= 12 ; i++) {
//			button.setLed(i, Color.red);
//
//		}
	}
}
