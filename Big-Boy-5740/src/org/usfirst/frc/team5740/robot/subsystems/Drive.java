package org.usfirst.frc.team5740.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {

	
    public Drive() {

	}
    
    static double driveP = 0;
    static double turnP = 0;
    
    public static void resetEncoders() {
    		RobotObjects.e1.reset();
    		RobotObjects.e2.reset();
    }
    
    
    
    public static void driveDistance(double dist) {
    		DriverStation ds = DriverStation.getInstance();
    		dist /= 0.156;
		resetEncoders();
		RobotObjects.gyro.reset();
		double turn = RobotObjects.gyro.getAngle() * 0.05;
		while(-RobotObjects.e1.get() < dist && ds.isAutonomous() && ds.isEnabled() ) {
			RobotObjects.drive.arcadeDrive(-1,  turn);
		}
    }
    
    public static void turn(Integer degrees) {
    		DriverStation ds = DriverStation.getInstance();
    		double target = RobotObjects.gyro.getAngle() + degrees;
    		while(RobotObjects.gyro.getAngle() > target && ds.isAutonomous() && ds.isEnabled() ) {
    			RobotObjects.drive.arcadeDrive(0, 0.75);
    		}
    }
    
    
    public static void driveDistanceControlled(double dist) {
		DriverStation ds = DriverStation.getInstance();
		dist /= 0.156;
		resetEncoders();
		RobotObjects.gyro.reset();
		double turn = RobotObjects.gyro.getAngle() * 0.05;
		
		while(-RobotObjects.e1.get() < dist && ds.isAutonomous() && ds.isEnabled() ) {
			double error = -RobotObjects.e1.get() - dist;
			RobotObjects.drive.arcadeDrive(error*driveP,  turn);
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
    		RobotObjects.drive.arcadeDrive(-RobotObjects.controller1.getRawAxis(1), -RobotObjects.controller1.getRawAxis(4));
    }
    
    public static void shift(String direction ) {
    		switch(direction){
    		case "up":
    			RobotObjects.shiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    		case "down":
    			RobotObjects.shiftSolenoid.set(DoubleSolenoid.Value.kForward);
    		}
    }
    
	public void initDefaultCommand() {
		
    }

}

