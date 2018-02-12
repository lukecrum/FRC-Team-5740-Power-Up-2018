package org.usfirst.frc.team5740.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
 
    public void initDefaultCommand() {

    }
    public static void lift(double value) {
    		RobotObjects.elevatorGroup.set(value);
    }
  
}

