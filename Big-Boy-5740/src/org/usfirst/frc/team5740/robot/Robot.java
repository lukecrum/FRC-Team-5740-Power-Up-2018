/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5740.robot;
import org.usfirst.frc.team5740.robot.subsystems.Drive;
import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class Robot extends IterativeRobot {
	
	Command autonomousCommand;
	SendableChooser autoChooser;
	
	@Override
	public void robotInit() {
		RobotObjects.gyro.calibrate();
		autoChooser = new SendableChooser();
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
		Drive.periodicDrive();
	}

	@Override
	public void testPeriodic() {
	}
}