package org.usfirst.frc.team5740.robot;
import org.usfirst.frc.team5740.robot.subsystems.RobotObjects;

import edu.wpi.first.wpilibj.DoubleSolenoid;
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
    		   RobotObjects.solenoid4.set(DoubleSolenoid.Value.kReverse);
           } else {
        	   RobotObjects.solenoid4.set(DoubleSolenoid.Value.kForward);
           }
            
            if(RobotObjects.controller2.getRawAxis(5) != 0) {
               clawRotate.setPower(controller2.getRawAxis(5));
            }
            
            if(RobotObjects.controller2.getRawAxis(2) != 0) {
            	RobotObjects.solenoid0.set(Solenoid.Value.kReverse);
            	RobotObjects.solenoid1.set(Solenoid.Value.kReverse);
            	RobotObjects.solenoid2.set(Solenoid.Value.kReverse);
            	RobotObjects.solenoid3.set(Solenoid.Value.kReverse);
            	RobotObjects.clawIntake.setPower(1);
            }
     
            if(RobotObjects.controller2.getRawAxis(3) != 0) {
            	RobotObjects.solenoid0.set(Solenoid.Value.kReverse);
            	RobotObjects.solenoid1.set(Solenoid.Value.kForward);
            	RobotObjects.solenoid2.set(Solenoid.Value.kReverse);
            	RobotObjects.solenoid3.set(Solenoid.Value.kForward);
            }  
     
            if (RobotObjects.controller1.getRawButton(8) != false) {
                RobotObjects.solenoid5.set(DoubleSolenoid.Value.kForward);
            }
    }
}

