package org.usfirst.frc.team5740.robot.subsystems;

import org.usfirst.frc.team5740.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.TalonSRX; 
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;     		
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.CameraServer;
public class RobotObjects {
	public static WPI_TalonSRX leftDrive = new WPI_TalonSRX(Constants.leftDriveMotorPWM);
	public static WPI_TalonSRX rightDrive = new WPI_TalonSRX(Constants.rightDriveMotorPWM);
	public static TalonSRX leftNormalTalon = new TalonSRX(6);
	public static TalonSRX rightNormalTalon = new TalonSRX(8);
	public static Spark clawIntake =  new  Spark(Constants.clawIntakeSparkPWM);
	public static Spark clawRotation = new Spark(Constants.clawRotationSparkPWM);
	public static DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);
	
	public static TalonSRX eTalon1 = new TalonSRX(Constants.eTalon1CAN);
	public static TalonSRX eTalon2 = new TalonSRX(Constants.eTalon2CAN);
	public static TalonSRX eTalon3 = new TalonSRX(Constants.eTalon3CAN);
	public static TalonSRX eTalon4 = new TalonSRX(Constants.eTalon4CAN);
	
	public static DigitalInput flipperHighLimit = new DigitalInput(Constants.flipperHighLimitPort);
	public static DigitalInput flipperLowLimit = new DigitalInput(Constants.flipperLowLimitPort);
	public static DigitalInput clawLimit = new DigitalInput(Constants.clawLimitPort);
	
	public static Encoder leftDriveEncoder = new Encoder(Constants.leftDriveEncoderPortOne, Constants.leftDriveEncoderPortTwo);
	public static Encoder rightDriveEncoder = new Encoder(Constants.rightDriveEncoderPortOne, Constants.rightDriveEncoderPortTwo, true);
	public static Encoder clawRotationEncoder = new Encoder(Constants.clawRotationEncoderPortOne, Constants.clawRotationEncoderPortTwo);
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	public static DoubleSolenoid clawSolenoid = new DoubleSolenoid(Constants.clawSolenoidPortOne, Constants.clawSolenoidPortTwo);
	public static DoubleSolenoid shiftSolenoid = new DoubleSolenoid(Constants.shiftSolenoidPortOne, Constants.shiftSolenoidPortTwo);
	
	public static Joystick controller1 = new Joystick(Constants.controller1Port);
	public static Joystick controller2 = new Joystick(Constants.controller2Port);

}	
