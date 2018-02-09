package org.usfirst.frc.team5740.robot;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {

	
    public Drive() {

	}
    
    public static void resetEncoders() {
    		RobotObjects.e1.reset();
    		RobotObjects.e2.reset();
    }
    
    public static void driveDistance(double dist) {
    		double degrees = dist / 0.156;
		resetEncoders();
		RobotObjects.gyro.reset();
		double turn = RobotObjects.gyro.getAngle() * 0.05;
		while(-RobotObjects.e1.get() < degrees) {
			RobotObjects.drive.arcadeDrive(-1,  turn);
		}
    }
    
    public static void turn(Integer degrees) {
    		double target = RobotObjects.gyro.getAngle() + degrees;
    		while(RobotObjects.gyro.getAngle() > target) {
    			RobotObjects.drive.arcadeDrive(0, 0.75);
    		}
    }
    
    public static void periodicDrive() {
    		RobotObjects.drive.arcadeDrive(-RobotObjects.controller1.getRawAxis(1), -RobotObjects.controller1.getRawAxis(4));
    }
    
	public void initDefaultCommand() {
		
    }

}

