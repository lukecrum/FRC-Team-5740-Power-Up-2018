package org.usfirst.frc.team5740.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotObjects {
	public static Victor v1 = new Victor(0);
	public static Victor v2 = new Victor(1);
	public static Encoder e1 = new Encoder(0, 1);
	public static Encoder e2 = new Encoder(2, 3);
	public static DifferentialDrive drive = new DifferentialDrive(v1, v2);
	public static DoubleSolenoid s1 = new DoubleSolenoid(0, 1);
	public static Joystick controller1 = new Joystick(0);
	public static Joystick controller2 = new Joystick(1);
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
}
