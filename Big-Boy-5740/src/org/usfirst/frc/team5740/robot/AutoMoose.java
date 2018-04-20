package org.usfirst.frc.team5740.robot;

import java.io.File;

import org.usfirst.frc.team5740.robot.subsystems.Drive;
import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Notifier;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class AutoMoose {
	static Notifier notifier;
	static EncoderFollower left, right;
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

	static void resetEncoders() {
		RobotObjects.leftNormalTalon.setSelectedSensorPosition(0, 0, 1000);
		RobotObjects.rightNormalTalon.setSelectedSensorPosition(0, 0, 1000);
	}
	public static void followTrajectory() {
		Waypoint[] points = new Waypoint[] {

			/*	new Waypoint(0, 0, 0),
				new Waypoint(2, 0.75, 0), half a right switch auto
				new Waypoint(2.75, 0.45, Pathfinder.d2r(-50))*/
				new Waypoint(0, 0, 0),
				new Waypoint(0.5, 0, 0),
				new Waypoint(1, -0.5, Pathfinder.d2r(-90))
		};
		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.47, 1.2, 60.0);
		Trajectory trajectory = Pathfinder.generate(points, config);
		TankModifier modifier = new TankModifier(trajectory).modify(0.591312);
		left = new EncoderFollower(modifier.getLeftTrajectory());
		right = new EncoderFollower(modifier.getRightTrajectory());
		
		left.configureEncoder(RobotObjects.leftNormalTalon.getSelectedSensorPosition(0), 4096, 0.1524); //1524
		right.configureEncoder(RobotObjects.rightNormalTalon.getSelectedSensorPosition(0), 4096, 0.1524);
		double maxVel = 1 / 1.472184;
		left.configurePIDVA(0.8, 0.0, 0.0, maxVel, 0.1); //tweak
		right.configurePIDVA(0.8, 0.0, 0.0, maxVel, 0.1); //tweak
		System.out.println("1st point: " + trajectory.get(0));
		System.out.println("last point: " + trajectory.get(trajectory.length() - 1));
		
		
		notifier = new Notifier(()->{
				Integer leftValue = RobotObjects.leftNormalTalon.getSelectedSensorPosition(0);
				Integer rightValue = RobotObjects.rightNormalTalon.getSelectedSensorPosition(0);
				double l = left.calculate(leftValue); //potential source of error
				double r = right.calculate(rightValue); //potential source of error
				
				double gyro_heading = RobotObjects.gyro.getAngle();
				double desired_heading = Pathfinder.r2d(left.getHeading());
				double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
				double turn = 0.8 * (-1.0/80.0) * angleDifference;
				
				//RobotObjects.drive.tankDrive(l + turn, r - turn);
				//RobotObjects.leftDrive.set(l + turn);
				//RobotObjects.rightDrive.set(r - turn);
				if(l != 0 && r != 0) {
					RobotObjects.leftNormalVictor.set(ControlMode.Follower, 6);
					RobotObjects.rightNormalVictor.set(ControlMode.Follower, 8);
					RobotObjects.leftDriveTalon.set(ControlMode.PercentOutput, l + turn * 10);
					RobotObjects.rightDriveTalon.set(ControlMode.PercentOutput, r - turn * 10); 
				} else {
				RobotObjects.leftNormalVictor.set(ControlMode.Follower, 6);
				RobotObjects.leftDriveTalon.set(ControlMode.PercentOutput, 0);
				RobotObjects.rightNormalVictor.set(ControlMode.Follower, 8);
				RobotObjects.rightDriveTalon.set(ControlMode.PercentOutput, 0);
				}
				double leftcalc = l + turn;

				double rightcalc = r + turn;
						

				System.out.println("Turn: " + turn);

				System.out.println("Left raw: " + l);

				System.out.println("Gyro: " + RobotObjects.gyro.getAngle());
				
				System.out.println("Left calculated: " + leftcalc);

				System.out.println("Right raw: " + r);

				System.out.println("Right calculated: " + rightcalc);

				System.out.println("Path length:" + trajectory.length());
				//System.out.println("ran");
				DriverStation ds = DriverStation.getInstance();
				if(ds.isAutonomous() == false || ds.isDisabled()) {
					notifier.stop();
				}
			});
	}
	
	public static void Start() {
		

		resetEncoders();
		followTrajectory();
	//	followTrajectory(csv);
		notifier.startPeriodic(0.05);
	}
	static double average() {
		double avg = (-RobotObjects.leftNormalTalon.getSelectedSensorPosition(0) + RobotObjects.rightNormalTalon.getSelectedSensorPosition(0)) /2;
		return avg;
	}
	static void rightStepTwo() {
		resetEncoders();
		while(RobotObjects.rightNormalTalon.getSelectedSensorPosition(0) < 3176) {
			RobotObjects.drive.arcadeDrive(0, 1);
			System.out.println("right encoder: " + RobotObjects.rightNormalTalon.getSelectedSensorPosition(0)); //these 2 run then it stops
		}
		resetEncoders();
		while(average() < 10760) {
			RobotObjects.drive.arcadeDrive(1, 0);
			System.out.println("Average: " + average());
		}
	}
	static void rightStepThree() {
		resetEncoders();
		while(RobotObjects.rightNormalTalon.getSelectedSensorPosition(0) > -2698) {
			RobotObjects.drive.arcadeDrive(0, 1);
			System.out.println("Left encoder: " + -RobotObjects.leftNormalTalon.getSelectedSensorPosition(0));
		}
		resetEncoders();
		while(average() < 5160) {
			RobotObjects.drive.arcadeDrive(1, 0);
			System.out.println("Avg: " + average());
		}
	}
	static void rightStepFour() {
		resetEncoders();
		while(RobotObjects.leftNormalTalon.getSelectedSensorPosition(0) < 2500) {
			RobotObjects.drive.arcadeDrive(0, -1);
		}
		resetEncoders();
		while(average() < 5160) {
			RobotObjects.drive.arcadeDrive(1,  0);
		}
	}
	public static void RightJank() {
		resetEncoders();
		while(average() < 11900) {
			RobotObjects.drive.arcadeDrive(1,0);
			System.out.println("Average: " + average()); //nothing happens after we run this
		}
		rightStepTwo();
		rightStepThree();
		rightStepFour();
	//	while(RobotObjects.leftNormalTalon.getSelectedSensorPosition(0) )
		//step 1: 11900
		//turn right: right: 3176, left: -2872
		//step 2:  10760
		//turn left: right: -2698, left: 3318
		//step 3: 5160
	}
	static void leftStepTwo() {

		resetEncoders();
		while(RobotObjects.leftNormalTalon.getSelectedSensorPosition(0) < 3176) {
			RobotObjects.drive.arcadeDrive(0, -1);
			System.out.println("left encoder: " + RobotObjects.rightNormalTalon.getSelectedSensorPosition(0)); //these 2 run then it stops
		}
		resetEncoders();
		while(average() < 10760) {
			RobotObjects.drive.arcadeDrive(1, 0);
			System.out.println("Average: " + average());
		}
	}
	static void leftStepThree() {
		resetEncoders();
		while(RobotObjects.leftNormalTalon.getSelectedSensorPosition(0) > -2698) {
			RobotObjects.drive.arcadeDrive(0, 1);
			System.out.println("right encoder: " + -RobotObjects.leftNormalTalon.getSelectedSensorPosition(0));
		}
		resetEncoders();
		while(average() < 5160) {
			RobotObjects.drive.arcadeDrive(1, 0);
			System.out.println("Avg: " + average());
		}
	}
	static void leftStepFour() {
		resetEncoders();
		while(RobotObjects.rightNormalTalon.getSelectedSensorPosition(0) < 2500) {
			RobotObjects.drive.arcadeDrive(0, 1);
		}
		resetEncoders();
		while(average() < 5160) {
			RobotObjects.drive.arcadeDrive(1,  0);
		}
	}

	public static void LeftJank() {
		resetEncoders();
		while(average() < 11900) {
			RobotObjects.drive.arcadeDrive(1,0);
			System.out.println("Average: " + average()); //nothing happens after we run this
		}
		leftStepTwo();
		leftStepThree();
		leftStepFour();
	}
}

