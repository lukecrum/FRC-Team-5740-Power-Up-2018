package org.usfirst.frc.team5740.robot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Timer;

import edu.wpi.first.wpilibj.Encoder;

public class AutoMapper {
	static Encoder e1, e2;
	static Integer e1End, e2End;
	static String filename;
	static Integer lastL = 0;
	static Integer lastR = 0;
	static void resetEncoders() {
		e1.reset();
		e2.reset();
	}
	public AutoMapper(Encoder enc1, Encoder enc2, String name) {
		e1 = enc1;
		e2 = enc2;
		resetEncoders();
		filename = name;
	}
	static void Write(String line) throws IOException {
		File output = new File(filename);
		FileOutputStream outputStream = new FileOutputStream(output);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		writer.write(line);
		writer.newLine();
		writer.close();
	}
	public static void New() {
		resetEncoders();
		lastL = 0;
		lastR = 0;
	}
	public static void MapChange() throws IOException { //this will be called in auto periodic
	/* GENERAL MODEL:
	1) Reset all of the encoders
	2) Wait until a change in the encoders is detected
	3) Wait until it stops changing
	4) record the value of each encoder to the file
	5) reset them again
	6) wait until change starts then stops again
	7) record again
	8) reset again
	etc...
	...
	...
	...
	 */
	
	while(e1.get() != 0 || e2.get() != 0) {
		if(e1.get() == lastL && lastR == e2.get()) {
			String line = Integer.toString(e1.get()) + ", " + Integer.toString(e2.get());
			Write(line);
			New();
		}
		lastL = e1.get();
		lastR = e2.get();
	}
	}
	public static void MapPeriodic() {
		Timer timer = new Timer();
		timer.schedule(new MapPeriodic(e1, e2), 0, 500);
	}
}