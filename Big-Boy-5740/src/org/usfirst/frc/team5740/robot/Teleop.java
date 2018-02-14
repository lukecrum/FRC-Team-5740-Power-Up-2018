package org.usfirst.frc.team5740.robot;
import org.usfirst.frc.team5740.robot.subsystems.Claw;
import org.usfirst.frc.team5740.robot.subsystems.Drive;
import org.usfirst.frc.team5740.robot.subsystems.Elevator;
import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Teleop extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Periodic() {
    	if(RobotObjects.controller1.getRawAxis(3) != 0) {
    		Drive.shift("up");
    	} else {
     		Drive.shift("down");
     	}
         
    	if(RobotObjects.controller2.getRawAxis(5) != 0) {
            RobotObjects.clawRotation.setSpeed(RobotObjects.controller2.getRawAxis(5));
        }
         
        if(RobotObjects.controller2.getRawAxis(2) != 0) {
            Claw.retract();
        }
  
        if(RobotObjects.controller2.getRawAxis(3) != 0) {
            Claw.extend(); 
        }  
         
        if (RobotObjects.controller1.getRawButton(7) != false) {
            RobotObjects.rampSolenoid.set(DoubleSolenoid.Value.kForward);
        }
        
        if (RobotObjects.controller1.getRawButton(8) != false) {
            RobotObjects.elevatorSolenoid.set(DoubleSolenoid.Value.kForward);
        }
        
        if (RobotObjects.controller2.getRawAxis(1) != 0) {
        	Elevator.lift(RobotObjects.controller2.getRawAxis(1));
        }
    }
}

