package org.usfirst.frc.team5740.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Drive extends Subsystem {

	
    public Drive() {

	}
    
    static double driveP = 0;
    static double turnP = 0;
    
    public static void resetEncoders() {
    		RobotObjects.leftDriveEncoder.reset();
    		RobotObjects.rightDriveEncoder.reset();
    }
    static double encoderAverage() {
    	double value = (RobotObjects.leftDriveEncoder.get() + RobotObjects.rightDriveEncoder.get() ) /2;
    	return value;
    }
    
    
    public static void driveDistance(double dist) {
    		DriverStation ds = DriverStation.getInstance();
    		dist = dist / 0.078;
		resetEncoders();
		RobotObjects.gyro.reset();
		double initial = RobotObjects.gyro.getAngle();
		double turn = -1*((RobotObjects.gyro.getAngle() - initial)* 0.4);
		while(encoderAverage() < dist && ds.isAutonomous()) {
			RobotObjects.drive.arcadeDrive(1,  turn);
		}
		
    }
    public static boolean driveDistanceBool(double dist) {
		DriverStation ds = DriverStation.getInstance();
		dist = dist / 0.078;
	resetEncoders();
	RobotObjects.gyro.reset();
	double initial = RobotObjects.gyro.getAngle();
	double turn = -1*((RobotObjects.gyro.getAngle() - initial)* 0.4);
	while(encoderAverage() < dist && ds.isAutonomous()) {
		RobotObjects.drive.arcadeDrive(1,  turn);
		return false;
	}
	return true;
}
    public static void turn(Integer degrees) {
    		RobotObjects.gyro.reset();
    		DriverStation ds = DriverStation.getInstance();
    		double target = RobotObjects.gyro.getAngle() + degrees;
    		double errorAngle = RobotObjects.gyro.getAngle() - target;
    		while(Math.abs(errorAngle) > 0 && ds.isAutonomous() && ds.isEnabled() ) {
    			if(target > 0) {
    				RobotObjects.drive.arcadeDrive(0, 0.25);
    				errorAngle = RobotObjects.gyro.getAngle() - target;
    			} else {
    				RobotObjects.drive.arcadeDrive(0, -0.25);
    				errorAngle = RobotObjects.gyro.getAngle() - target;
    			}
    				
    			
    		}
    }
    public static void turnPlease(Integer angle) {
    	RobotObjects.gyro.reset();
    	double error = Math.abs(RobotObjects.gyro.getAngle() - angle);
    	double target = RobotObjects.gyro.getAngle() + angle;
    	while(Math.abs(error) > 0) {
    		if(target > 0) {
    			RobotObjects.drive.arcadeDrive(0, 0.25);
    			error = error - RobotObjects.gyro.getAngle();
    		}
    		if(target < 0) {
    			RobotObjects.drive.arcadeDrive(0, -0.25);
				error = error - RobotObjects.gyro.getAngle();
    		}
    	}
    	}
    public static void turnNeg(Integer degrees) {
		//RobotObjects.gyro.reset();
		DriverStation ds = DriverStation.getInstance();
		double target = RobotObjects.gyro.getAngle() + degrees;
		while(RobotObjects.gyro.getAngle() < target && ds.isAutonomous() && ds.isEnabled() ) {
			RobotObjects.drive.arcadeDrive(0, 0.75);
		}
}
    
    public static void driveDistanceControlled(double dist) {
		DriverStation ds = DriverStation.getInstance();
		dist /= 0.156;
		resetEncoders();
		RobotObjects.gyro.reset();
		double turn = RobotObjects.gyro.getAngle() * 0.05;
		
		while(-RobotObjects.leftDriveEncoder.get() < dist && ds.isAutonomous() && ds.isEnabled() ) {
			double error = -RobotObjects.leftDriveEncoder.get() - dist;
			RobotObjects.drive.arcadeDrive(error*driveP, -turn);
		}
	}

    
    
    public static void turnControlled(Integer degrees) {
		DriverStation ds = DriverStation.getInstance();
		double startAngle = RobotObjects.gyro.getAngle();
		double target = RobotObjects.gyro.getAngle() + degrees;
		while(RobotObjects.gyro.getAngle() > target && ds.isAutonomous() && ds.isEnabled() ) {
			double angle = RobotObjects.gyro.getAngle() - startAngle;
			double error = degrees - angle;
			RobotObjects.drive.arcadeDrive(0, error*turnP);
		}
    }
    
    
    /*
    public static void driveDistanceControlled(double dist) {
		DriverStation ds = DriverStation.getInstance();
		double degrees = dist / 0.156;
		resetEncoders();
		RobotObjects.gyro.reset();
		double turn = RobotObjects.gyro.getAngle() * 0.05;
		
		while(-RobotObjects.e1.get() < degrees && ds.isAutonomous() && ds.isEnabled() ) {
			double error = 
			RobotObjects.drive.arcadeDrive(-1,  turn);
		}
	}

    public static void turnControlled(Integer degrees) {
		DriverStation ds = DriverStation.getInstance();
		double target = RobotObjects.gyro.getAngle() + degrees;
		while(RobotObjects.gyro.getAngle() > target && ds.isAutonomous() && ds.isEnabled() ) {
			RobotObjects.drive.arcadeDrive(0, 0.75);
		}
*/
    
    public static void periodicDrive() {
    		RobotObjects.drive.arcadeDrive(-RobotObjects.controller1.getRawAxis(1), RobotObjects.controller1.getRawAxis(4));
    }
    
    public static void shift(String direction ) {
    	/*	switch(direction){
    		case "up":
    			RobotObjects.shiftSolenoid.set(DoubleSolenoid.Value.kForward);
    			break;
    		case "down":
    			RobotObjects.shiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    			break;
    		}*/
    }
    
	public void initDefaultCommand() {
		
    }
	public static void Dump() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'R') {
		while(RobotObjects.flipperHighLimit.get() != true) {
			RobotObjects.eTalon1.set(ControlMode.PercentOutput, -0.3);
		   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, -0.3);	
	   	}
		RobotObjects.eTalon1.set(ControlMode.PercentOutput, 0);
	   	RobotObjects.eTalon2.set(ControlMode.PercentOutput, 0);	
	}
	}
}

