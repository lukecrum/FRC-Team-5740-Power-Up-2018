package org.usfirst.frc.team5740.robot;

import org.usfirst.frc.team5740.robot.subsystems.Drive;
import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AutoCommands extends Subsystem {
	
	static String gameData = DriverStation.getInstance().getGameSpecificMessage();
	
	AutoCommands(String position) {
		switch(position) {
			case "left":
				selectAuto("left");
			case "right":
		}
	}
    public void initDefaultCommand() {
    		
    }
    public static void Right() {
    	Drive.driveDistance(78);
    	System.out.println("drove 78 inches");
    	//Drive.Dump();
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'R') {
		while(RobotObjects.flipperHighLimit.get() != true) {
			RobotObjects.eTalon1.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, -0.3);	
			RobotObjects.eTalon3.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon4.set(ControlMode.PercentOutput, -0.3);	
	   	}
		RobotObjects.eTalon1.set(ControlMode.PercentOutput, 0);
	   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, 0);	
	}
    	System.out.println("dumped");
    }
    public static void LL() {

		Drive.resetEncoders();
		Drive.driveDistance(174.75);
		Drive.turn(90);
		Drive.driveDistance(25.19);
		//Drive.Dump();
		while(RobotObjects.flipperHighLimit.get() != true) {
			RobotObjects.eTalon1.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, -0.3);	
			RobotObjects.eTalon3.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon4.set(ControlMode.PercentOutput, -0.3);	
	   	}
		RobotObjects.eTalon1.set(ControlMode.PercentOutput, 0);
	   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, 0);	
	}

	public static void LR() {
		Drive.resetEncoders();
		Drive.driveDistance(208);
		Drive.turn(90);
		Drive.driveDistance(61.19);
		Drive.turn(90);
		Drive.driveDistance(12);
		//Drive.Dump();
		while(RobotObjects.flipperHighLimit.get() != true) {
			RobotObjects.eTalon1.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, -0.3);	
			RobotObjects.eTalon3.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon4.set(ControlMode.PercentOutput, -0.3);	
	   	}
		RobotObjects.eTalon1.set(ControlMode.PercentOutput, 0);
	   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, 0);	
	}

	public static void RR() {
		Drive.resetEncoders();
		Drive.driveDistance(174.75);
		Drive.turn(-90);
		Drive.driveDistance(25.19);
		//Drive.Dump();
		while(RobotObjects.flipperHighLimit.get() != true) {
			RobotObjects.eTalon1.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, -0.3);	
			RobotObjects.eTalon3.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon4.set(ControlMode.PercentOutput, -0.3);	
	   	}
		RobotObjects.eTalon1.set(ControlMode.PercentOutput, 0);
	   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, 0);	
	}


	public static void RL() {
		Drive.resetEncoders();
		Drive.driveDistance(208);
		Drive.turn(-90);
		Drive.driveDistance(61.19);
		Drive.turn(-90);
		Drive.driveDistance(12);
		//Drive.Dump();
		while(RobotObjects.flipperHighLimit.get() != true) {
			RobotObjects.eTalon1.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, -0.3);	
			RobotObjects.eTalon3.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon4.set(ControlMode.PercentOutput, -0.3);	
	   	}
		RobotObjects.eTalon1.set(ControlMode.PercentOutput, 0);
	   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, 0);	
	}

	
	public static void selectAuto(String roboPosition) {
		switch(roboPosition){
		case "left":
			if(gameData.length() > 0)
			{
				if(gameData.charAt(0) == 'L')
				{
					LL();
				} else {
					RL();
				}
			}
		case "right":
			if(gameData.length() > 0)
			{
				if(gameData.charAt(0) == 'L')
				{
					RL();
				} else {
					RR();
				}
			}
		}
	}
}
