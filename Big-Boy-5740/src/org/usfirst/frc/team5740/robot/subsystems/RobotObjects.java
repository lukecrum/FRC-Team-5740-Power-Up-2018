package org.usfirst.frc.team5740.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
public class RobotObjects {
	public static Victor leftDrive = new Victor(0);
	public static Victor rightDrive = new Victor(1);
	public static Encoder e1 = new Encoder(0, 1);
	public static Encoder e2 = new Encoder(2, 3);
	public static DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);
	public static DoubleSolenoid clawSolenoid = new DoubleSolenoid(0, 1);
	public static DoubleSolenoid shiftSolenoid = new DoubleSolenoid(2, 3);
	public static DoubleSolenoid elevatorSolenoid = new DoubleSolenoid(4, 5);
	public static DoubleSolenoid rampSolenoid = new DoubleSolenoid(6, 7);
	public static Joystick controller1 = new Joystick(0);
	public static Joystick controller2 = new Joystick(1);
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static TalonSRX eTalonLeft = new TalonSRX(1);
	public static TalonSRX eTalonRight = new TalonSRX(3);
	public static VictorSPX eVictorLeft = new VictorSPX(2);
	public static VictorSPX eVictorRight = new VictorSPX(4);
	public static SpeedControllerGroup elevatorGroup = new SpeedControllerGroup(eTalonLeft, eVictorLeft, eTalonRight, eVictorRight);
	public static Spark clawIntake =  new  Spark(2);
	public static Spark clawRotation = new Spark(3);
}	