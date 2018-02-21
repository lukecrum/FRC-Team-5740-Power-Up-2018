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

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import edu.wpi.first.wpilibj.Spark;

public class Robot extends IterativeRobot {
	
	Command autonomousCommand;
	SendableChooser<AutoCommands> autoChooser;
	@Override
	public void robotInit() {
		RobotObjects.gyro.calibrate();
		autoChooser = new SendableChooser<AutoCommands>();
		autoChooser.addDefault("Robot at Left", new AutoCommands("left"));
		autoChooser.addObject("Robot at Right", new AutoCommands("right"));
		
	}


	@Override
	public void autonomousInit() {

	}


	@Override
	public void autonomousPeriodic() {

	}

	@Override
	public void teleopPeriodic() {
		//Drive.periodicDrive();
		//Teleop.Periodic();
		if(RobotObjects.controller2.getRawButton(4) != false) {
			System.out.println(RobotObjects.clawRotationEncoder.get());
		}
		if(RobotObjects.controller2.getRawButton(1) != false) {
			RobotObjects.clawRotationEncoder.reset();
			System.out.println("Reset Encoder!");
		}
		if(RobotObjects.controller2.getRawButton(2) != false) {
			Claw.moveClawUp();
			System.out.println("claw up");
		}

	}

	@Override
	public void testPeriodic() {
	}
}