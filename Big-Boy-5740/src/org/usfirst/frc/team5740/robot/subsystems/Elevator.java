package org.usfirst.frc.team5740.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
 
    public void initDefaultCommand() {

    }
    public static void lift(double value) {
    	if(RobotObjects.flipperLowLimit.get() != 0 || flipperHighLimit.get() != 0) {
    		RobotObjects.eTalon1.set(ControlMode.PercentOutput, value);
    		RobotObjects.eTalon2.set(ControlMode.PercentOutput, value);
    		RobotObjects.eTalon3.set(ControlMode.PercentOutput, value);
    		RobotObjects.eTalon4.set(ControlMode.PercentOutput, value);
    	}
    }
    
  
}

