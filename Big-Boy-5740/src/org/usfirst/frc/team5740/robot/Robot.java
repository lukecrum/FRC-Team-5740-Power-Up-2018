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

public class Robot extends IterativeRobot {
	
	@Override
	public void robotInit() {
		RobotObjects.gyro.calibrate();
	}


	@Override
	public void autonomousInit() {
	AutoCommands.selectAuto();
	AutoCommands.runAuto();
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