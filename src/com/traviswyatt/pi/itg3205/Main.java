package com.traviswyatt.pi.itg3205;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;

public class Main {

	public static void main(String[] args) throws IOException {
		// http://developer-blog.net/wp-content/uploads/2013/09/raspberry-pi-rev2-gpio-pinout.jpg
		// http://pi4j.com/example/control.html
		ITG3205 itg3205 = new ITG3205(I2CBus.BUS_1);
		
		itg3205.setup();
		if (!itg3205.verifyDeviceID()) {
			throw new IOException("Failed to verify ITG3205 device ID");
		}
		
		// F_sample = F_internal / (divider + 1)
		// divider = F_internal / F_sample - 1
		itg3205.writeSampleRateDivider(2); // 2667 Hz
		itg3205.writeDLPFBandwidth(ITG3205.ITG3205_DLPF_BW_256);
		
		float scalingFactor = 1f / ITG3205.ITG3205_SENSITIVITY_SCALE_FACTOR;
		
		short[] raw = new short[3];
		float[] r = new float[3];
		
		while (true) {
			itg3205.readRawRotations(raw);
			for (int i = 0; i < raw.length; i++) {
				r[i] = (float) raw[i] * scalingFactor;
			}
			System.out.println("x=" + r[0] + ",\ty=" + r[1] + ",\tz=" + r[2] + "\tdeg/s");
		}
	}

}
