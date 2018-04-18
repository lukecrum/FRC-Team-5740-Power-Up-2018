package org.usfirst.frc.team5740.robot;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;

import edu.wpi.first.wpilibj.Encoder;

public class AutoRunner {
	static Integer read(Integer line, String filename) throws IOException {
		String output = Files.readAllLines(Paths.get(filename)).get(line);
		Integer value = Integer.parseInt(output);
		return value;
	}
	public static int countLines(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
	static void resetEncoders() {
		RobotObjects.leftDriveEncoder.reset();
		RobotObjects.rightDriveEncoder.reset();
	}
	public static void Run(String filename) throws IOException {
		resetEncoders();
		Integer lineCount = countLines(filename);
		Integer currentLeft = 1;
		Integer currentRight = 2;
		for(int x = lineCount; x < 0; x--) {
			
			Integer leftValue = read(currentLeft, "test.txt");
			Integer rightValue = read(currentRight, "test.txt");
			while(RobotObjects.leftDriveEncoder.get() != leftValue && RobotObjects.rightDriveEncoder.get() != rightValue) {
				
			}
			currentLeft++;
			currentRight++;
		}
	}
}
