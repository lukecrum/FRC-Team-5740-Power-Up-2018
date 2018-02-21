package org.usfirst.frc.team5740.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;

public class Claw extends Subsystem {
	public static String last;
    public void initDefaultCommand() {

    }
    public static void limpNoodle() {
    	RobotObjects.clawSolenoid.set(DoubleSolenoid.Value.kOff);
    }
    
    public static void extend() {
    	RobotObjects.clawSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public static void retract() {
    	RobotObjects.clawSolenoid.set(DoubleSolenoid.Value.kReverse);    		
    }
    public static void moveClaw(String direction) {
    	RobotObjects.clawRotationEncoder.reset();
    	switch(direction) {
    	case "up":
    		if(last == "down") {
    		while(RobotObjects.clawRotationEncoder.get() < 14200) {
    			RobotObjects.clawRotation.setSpeed(1);
    		}
    		last = "up";
    		}

    		
    	case "down":
    		if(last == "up") {
    		while(RobotObjects.clawRotationEncoder.get() > -14200) {
    			RobotObjects.clawRotation.setSpeed(-1);
    		}
    		last = "down";
    	}
    	}
    }
}

