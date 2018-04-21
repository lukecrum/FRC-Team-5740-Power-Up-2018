/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5740.robot;
import org.usfirst.frc.team5740.robot.subsystems.Claw;
import org.usfirst.frc.team5740.robot.subsystems.Drive;
import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;
import org.usfirst.frc.team5740.robot.Teleop;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends IterativeRobot {
	String gameData;
	Command autonomousCommand;
	//SendableChooser<AutoCommands> autoChooser;
	@Override
	public void robotInit() {
	//	CameraServer.getInstance().getInstance().startAutomaticCapture();
		RobotObjects.gyro.calibrate();
		RobotObjects.gyro.reset();
		//autoChooser = new SendableChooser<AutoCommands>();
		//autoChooser.addDefault("Robot at Left", new AutoCommands("left"));
		//autoChooser.addObject("Robot at Right", new AutoCommands("right"));
		
		
	}


	@Override
	public void autonomousInit() {
		/*RobotObjects.gyro.reset();
		long t = System.currentTimeMillis();
		long end = t+1500;
		while(System.currentTimeMillis() < end) {
			RobotObjects.drive.arcadeDrive(1, 0);
		}
		RobotObjects.drive.arcadeDrive(0, 0);*/
		//Drive.driveDistance(140); //forward 100 inches
		//Drive.turn(90); //right 90 degrees
		//Timer.delay(0.5);
		//Drive.Dump();
		//AutoCommands.LL();
		//gameData = DriverStation.getInstance().getGameSpecificMessage();
		//if(gameData.charAt(0) =='R') {
		//	Drive.Dump();
		//}
		//AutoCommands.Right();
		//Drive.driveDistance(78);
		//Drive.turnPlease(90);
		//System.out.println(RobotObjects.gyro.getAngle());
		RobotObjects.gyro.reset();
		//AutoMoose.Start();
		AutoMoose.LeftJank();
	}


	@Override
	public void autonomousPeriodic() {
	/*	gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) =='R') {
		if (RobotObjects.flipperHighLimit.get() == false) {
			RobotObjects.eTalon1.set(ControlMode.PercentOutput, 0.3);
		   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, 0.3);		
	   	} else {
		RobotObjects.eTalon1.set(ControlMode.PercentOutput, 0);
	   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, 0);	
	}
	}
	*/
	}
	
	@Override
	public void teleopPeriodic() {
		Drive.periodicDrive();
		Teleop.Periodic();
		if(RobotObjects.controller1.getRawButton(1) != false) {
			System.out.println("Right encooder " + RobotObjects.rightNormalTalon.getSelectedSensorPosition(0));
			System.out.println("Left encooder " + RobotObjects.leftNormalTalon.getSelectedSensorPosition(0));
			System.out.println("Gyro: " + RobotObjects.gyro.getAngle());
		}
		if(RobotObjects.controller1.getRawButton(2) != false) {
			AutoMoose.resetEncoders();
		}
	}

	@Override
	public void testPeriodic() {
	}
}