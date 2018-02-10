package org.usfirst.frc.team5740.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotObjects {
	public static Victor v1 = new Victor(0);
	public static Victor v2 = new Victor(1);
	public static Encoder e1 = new Encoder(0, 1);
	public static Encoder e2 = new Encoder(2, 3);
	public static DifferentialDrive drive = new DifferentialDrive(v1, v2);
	public static Solenoid solenoid0 = new Solenoid(0);
	public static Solenoid solenoid1 = new Solenoid(1);
	public static Solenoid solenoid2 = new Solenoid(2);
	public static Solenoid solenoid3 = new Solenoid(3);
	public static Solenoid solenoid4 = new Solenoid(4);
	public static DoubleSolenoid solenoid5 = new DoubleSolenoid(5, 6);
	public static Joystick controller1 = new Joystick(0);
	public static Joystick controller2 = new Joystick(1);
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
}