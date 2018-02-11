package org.usfirst.frc.team5740.robot;
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
    			RobotObjects.shiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    		} else {
     		 RobotObjects.shiftSolenoid.set(DoubleSolenoid.Value.kForward);
     	  }
         
    		if(RobotObjects.controller2.getRawAxis(5) != 0) {
            RobotObjects.clawRotation.setSpeed(RobotObjects.controller2.getRawAxis(5));
         }
         
         if(RobotObjects.controller2.getRawAxis(2) != 0) {
             RobotObjects.clawSolenoid.set(DoubleSolenoid.Value.kReverse);
             RobotObjects.clawIntake.setSpeed(1);
         }
  
         if(RobotObjects.controller2.getRawAxis(3) != 0) {
             RobotObjects.clawSolenoid.set(DoubleSolenoid.Value.kReverse);
         }  
         
         if (RobotObjects.controller1.getRawButton(7) != false) {
             RobotObjects.rampSolenoid.set(DoubleSolenoid.Value.kForward);
         }
         if (RobotObjects.controller1.getRawButton(8) != false) {
             RobotObjects.elevatorSolenoid.set(DoubleSolenoid.Value.kForward);
         }
 }
}

