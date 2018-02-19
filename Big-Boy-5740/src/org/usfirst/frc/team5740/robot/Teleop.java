package org.usfirst.frc.team5740.robot;

import org.usfirst.frc.team5740.robot.subsystems.Claw;
import org.usfirst.frc.team5740.robot.subsystems.Drive;
import org.usfirst.frc.team5740.robot.subsystems.Elevator;
import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;
import edu.wpi.first.wpilibj.command.Subsystem;
public class Teleop extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public static void Periodic() {
    	if(RobotObjects.controller1.getRawAxis(4) <.25) {	
    		if(RobotObjects.controller1.getRawAxis(3) > .1) {
    			Drive.shift("up");
    		} else {
    			Drive.shift("down");
    		}
    	} 
    	if(RobotObjects.controller2.getRawAxis(5) > .5 || RobotObjects.controller2.getRawAxis(5) < -.5) {
            RobotObjects.clawRotation.setSpeed(-RobotObjects.controller2.getRawAxis(5));
        } else {
            RobotObjects.clawRotation.setSpeed(0);
        	
        }
         
        if(RobotObjects.controller2.getRawAxis(2) > .5) {
            Claw.retract();
        } else if(RobotObjects.controller2.getRawAxis(3) > .5) {
            Claw.extend(); 
        } else {
        	Claw.limpNoodle();
        }
        
        if(RobotObjects.controller2.getRawAxis(1) > .5 || RobotObjects.controller2.getRawAxis(1) < -.5 ) {
        	Elevator.lift(RobotObjects.controller2.getRawAxis(1));
        } else {	
        	Elevator.lift(0);        	
        }
        
        if(RobotObjects.controller2.getRawButton(1) != false) {
        	RobotObjects.clawIntake.setSpeed(1);
        } else {
        	RobotObjects.clawIntake.setSpeed(0);        	
        }
        
        if(RobotObjects.controller2.getRawButton(2) != false) {
        	RobotObjects.clawIntake.setSpeed(-1);
        } else {
        	RobotObjects.clawIntake.setSpeed(0);        	
        }
    }
}

