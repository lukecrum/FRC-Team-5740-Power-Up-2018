package org.usfirst.frc.team5740.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {

    public void initDefaultCommand() {

    }
    public static void limpNoodle() {
    	
    }
    public static void extend() {
    		
    }
    public static void retract() {
    		RobotObjects.clawSolenoid.set(DoubleSolenoid.Value.kReverse);
    		RobotObjects.clawIntake.setSpeed(1);
    }
}

