package org.usfirst.frc.team5740.robot.subsystems;

import org.usfirst.frc.team5740.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.TalonSRX; 
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;     		
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class RobotObjects {
	public static Victor leftDrive = new Victor(Constants.leftDriveMotorPWM);
	public static Victor rightDrive = new Victor(Constants.rightDriveMotorPWM);
	public static Spark clawIntake =  new  Spark(Constants.clawIntakeSparkPWM);
	public static Spark clawRotation = new Spark(Constants.clawRotationSparkPWM);
	public static DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);
	
	public static Talon eTalon1 = new Talon(Constants.eTalon1CAN);
	public static Talon eTalon2 = new Talon(Constants.eTalon2CAN);
	public static Talon eTalon3 = new Talon(Constants.eTalon3CAN);
	public static Talon eTalon4 = new Talon(Constants.eTalon4CAN);
//	public static SpeedControllerGroup elevatorGroup = new SpeedControllerGroup(eTalon1, eTalon2, eTalon3, eTalon4);
	
	public static Encoder leftDriveEncoder = new Encoder(Constants.leftDriveEncoderPortOne, Constants.leftDriveEncoderPortTwo);
	public static Encoder rightDriveEncoder = new Encoder(Constants.rightDriveEncoderPortOne, Constants.rightDriveEncoderPortTwo);
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	public static DoubleSolenoid clawSolenoid = new DoubleSolenoid(Constants.clawSolenoidPortOne, Constants.clawSolenoidPortTwo);
	public static DoubleSolenoid shiftSolenoid = new DoubleSolenoid(Constants.shiftSolenoidPortOne, Constants.shiftSolenoidPortTwo);
	
	public static Joystick controller1 = new Joystick(Constants.controller1Port);
	public static Joystick controller2 = new Joystick(Constants.controller2Port);
}	
