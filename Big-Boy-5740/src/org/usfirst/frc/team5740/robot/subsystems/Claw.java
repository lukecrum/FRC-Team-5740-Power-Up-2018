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
    
    public static void moveClawUp() {
		while(RobotObjects.clawRotationEncoder.get() < 720) {
				RobotObjects.clawRotation.set(1);
			if(RobotObjects.clawRotationEncoder.get() > 720) {
				RobotObjects.clawRotation.set(0);
			}
		}
   	}
}


