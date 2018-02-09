package org.usfirst.frc.team5740.robot;
import org.usfirst.frc.team5740.robot.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AutoCommands extends Subsystem {
	
    public void initDefaultCommand() {
    		
    }
    
    public void LL() {

		Drive.resetEncoders();
		Drive.driveDistance(174.75);
		Drive.turn(90);
		Drive.driveDistance(25.19);
		
	}

	public void LR() {
		Drive.resetEncoders();
		Drive.driveDistance(208);
		Drive.turn(90);
		Drive.driveDistance(61.19);
		Drive.turn(90);
		Drive.driveDistance(12);
	}

	public void RR() {
		Drive.resetEncoders();
		Drive.driveDistance(174.75);
		Drive.turn(-90);
		Drive.driveDistance(25.19);
	}

	public void RL() {
		Drive.resetEncoders();
		Drive.driveDistance(208);
		Drive.turn(-90);
		Drive.driveDistance(61.19);
		Drive.turn(-90);
		Drive.driveDistance(12);
	}
	
	public static void selectAuto() {
		
	}
	
	public static void runAuto() {
		
	}
}

