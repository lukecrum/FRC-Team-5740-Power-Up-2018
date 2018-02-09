package org.usfirst.frc.team5740.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotObjects {
	static Victor v1 = new Victor(0);
	static Victor v2 = new Victor(1);
	static Encoder e1 = new Encoder(0, 1);
	static Encoder e2 = new Encoder(2, 3);
	static DifferentialDrive drive = new DifferentialDrive(v1, v2);
	static DoubleSolenoid s1 = new DoubleSolenoid(0, 1);
	static Joystick controller1 = new Joystick(0);
	static Joystick controller2 = new Joystick(1);
	static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
}
