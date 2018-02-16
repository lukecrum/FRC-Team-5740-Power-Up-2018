package org.usfirst.frc.team5740.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
 
    public void initDefaultCommand() {

    }
    public static void lift(double value) {
    		RobotObjects.eTalon1.set(ControlMode.PercentOutput, value);
    		RobotObjects.eTalon2.set(ControlMode.PercentOutput, value);
    		RobotObjects.eTalon3.set(ControlMode.PercentOutput, value);
    		RobotObjects.eTalon4.set(ControlMode.PercentOutput, value);
    }
  
}

