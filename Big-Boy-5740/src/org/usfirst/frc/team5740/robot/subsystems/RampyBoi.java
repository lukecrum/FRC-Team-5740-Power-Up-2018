package org.usfirst.frc.team5740.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampyBoi extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public static void Lift() {
    	//RobotObjects.rTalon1.set(ControlMode.PercentOutput, 1);
    	//RobotObjects.rTalon2.set(ControlMode.PercentOutput, 1);
    }
    public static void Stop() {
    	//RobotObjects.rTalon1.set(ControlMode.PercentOutput, 0);
    	//RobotObjects.rTalon2.set(ControlMode.PercentOutput, 0);
    }
}

