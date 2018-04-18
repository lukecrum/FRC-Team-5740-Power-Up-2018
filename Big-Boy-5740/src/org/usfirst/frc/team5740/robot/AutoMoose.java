package org.usfirst.frc.team5740.robot;

import java.io.File;

import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;

import edu.wpi.first.wpilibj.Notifier;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class AutoMoose {
	Notifier notifier;
	//File file = new File("driveStraightTurnLeft_left.csv");
	/*public void AutoMoose() {
	
	//Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
	Trajectory trajectory = Pathfinder.readFromCSV(file);
	TankModifier modifier = new TankModifier(trajectory).modify(0.591312);
	EncoderFollower left = new EncoderFollower(modifier.getLeftTrajectory());
	EncoderFollower right = new EncoderFollower(modifier.getRightTrajectory());
	left.configureEncoder(0, 1000, 0.01524);
	right.configureEncoder(0, 1000, 0.01524);
	left.configurePIDVA(1.0, 0.0, 0.0, 1 / 1.472184, 0); //tweak
	right.configurePIDVA(1.0, 0.0, 0.0, 1 / 1.472184, 0); //tweak
	double l = left.calculate(RobotObjects.leftNormalTalon.getSelectedSensorPosition(0)); //potential source of error
	double r = right.calculate(RobotObjects.rightNormalTalon.getSelectedSensorPosition(0)); //potential source of error
	double gyro_heading = RobotObjects.gyro.getAngle();
	double desired_heading = Pathfinder.r2d(left.getHeading());
	double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
	double turn = 0.8 * (-1.0/80.0) * angleDifference;
	RobotObjects.drive.tankDrive(l + turn, r - turn);
	}*/

	void resetEncoders() {
		RobotObjects.leftNormalTalon.setSelectedSensorPosition(0, 0, 0);
		RobotObjects.rightNormalTalon.setSelectedSensorPosition(0, 0, 0);
	}
	public void followTrajectory(File file) {
		Trajectory trajectory = Pathfinder.readFromCSV(file); //read path from CSV
		
		TankModifier modifier = new TankModifier(trajectory).modify(0.591312); //meters (drive base width)
		EncoderFollower left = new EncoderFollower(modifier.getLeftTrajectory());
		EncoderFollower right = new EncoderFollower(modifier.getRightTrajectory());
		
		left.configureEncoder(RobotObjects.leftNormalTalon.getSelectedSensorPosition(0), 4096, 0.01524); //1st value: current encoder position, 2nd value: ticks per revolution, 3rd value: Wheel diameter (meters)
		right.configureEncoder(RobotObjects.rightNormalTalon.getSelectedSensorPosition(0), 4096, 0.01524); //see above
		left.configurePIDVA(1.0, 0.0, 0.0, 1 / 1.472184, 0.2); //1st value: Proportional gain: high number, 2nd: Integral gain: leave as 0, 3rd: Derivative gain: tweak if path isnt following smooth
		right.configurePIDVA(1.0, 0.0, 0.0, 1 / 1.472184, 0.2); //4th value: velocity ratio: 1/max_velocity in m/s, 5th: acceleration gain: tweak if u want to accelerate faster
		
		notifier = new Notifier(()->{
			double l = left.calculate(RobotObjects.leftNormalTalon.getSelectedSensorPosition(0)); //potential source of error
			double r = right.calculate(RobotObjects.rightNormalTalon.getSelectedSensorPosition(0)); //potential source of error
			
			double gyro_heading = RobotObjects.gyro.getAngle();
			double desired_heading = Pathfinder.r2d(left.getHeading());
			double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
			double turn = 0.8 * (-1.0/80.0) * angleDifference;
			RobotObjects.leftDrive.set(l + turn);
			RobotObjects.rightDrive.set(turn - r);
			
		});
	}
	
	public void Start(String CSVName) {
		File csv = new File(CSVName);
		resetEncoders();
		followTrajectory(csv);
		notifier.startPeriodic(0.05);
	}
}
