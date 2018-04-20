package org.usfirst.frc.team5740.robot.subsystems;

import org.usfirst.frc.team5740.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.TalonSRX; 
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;     		
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.CameraServer;
public class RobotObjects {
	public static WPI_TalonSRX leftDriveTalon = new WPI_TalonSRX(Constants.leftDriveTalonCAN);
	public static WPI_TalonSRX leftDriveVictor = new WPI_TalonSRX(Constants.leftDriveVictorCAN);
	public static WPI_TalonSRX rightDriveTalon = new WPI_TalonSRX(Constants.rightDriveTalonCAN);
	public static WPI_TalonSRX rightDriveVictor = new WPI_TalonSRX(Constants.rightDriveVictorCAN);
	public static TalonSRX leftNormalTalon = new TalonSRX(Constants.leftDriveTalonCAN);
	public static VictorSPX leftNormalVictor = new VictorSPX(Constants.leftDriveVictorCAN);
	public static TalonSRX rightNormalTalon = new TalonSRX(Constants.rightDriveTalonCAN);
	public static VictorSPX rightNormalVictor = new VictorSPX(Constants.rightDriveVictorCAN);
	public static SpeedControllerGroup leftDrive = new SpeedControllerGroup(leftDriveTalon, leftDriveVictor);
	public static SpeedControllerGroup rightDrive = new SpeedControllerGroup(rightDriveTalon, rightDriveVictor);
	public static Spark clawIntake =  new  Spark(Constants.clawIntakeSparkPWM);
	public static Spark clawRotation = new Spark(Constants.clawRotationSparkPWM);
	public static DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);
	
	public static TalonSRX eTalon1 = new TalonSRX(Constants.eTalon1CAN);
	public static TalonSRX eTalon2 = new TalonSRX(Constants.eTalon2CAN);
	public static TalonSRX clawTalon1 = new TalonSRX(Constants.clawTalon1CAN);
	public static TalonSRX clawTalon2 = new TalonSRX(Constants.clawTalon2CAN);
	
	public static DigitalInput flipperHighLimit = new DigitalInput(Constants.flipperHighLimitPort);
	public static DigitalInput flipperLowLimit = new DigitalInput(Constants.flipperLowLimitPort);
	public static DigitalInput clawLimit = new DigitalInput(Constants.clawLimitPort);
	
	public static Encoder leftDriveEncoder = new Encoder(Constants.leftDriveEncoderPortOne, Constants.leftDriveEncoderPortTwo);
	public static Encoder rightDriveEncoder = new Encoder(Constants.rightDriveEncoderPortOne, Constants.rightDriveEncoderPortTwo, true);
	public static Encoder clawRotationEncoder = new Encoder(Constants.clawRotationEncoderPortOne, Constants.clawRotationEncoderPortTwo);
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	/*public static DoubleSolenoid clawSolenoid = new DoubleSolenoid(Constants.clawSolenoidPortOne, Constants.clawSolenoidPortTwo);
	public static DoubleSolenoid shiftSolenoid = new DoubleSolenoid(Constants.shiftSolenoidPortOne, Constants.shiftSolenoidPortTwo);
	public static DoubleSolenoid rampSolenoid = new DoubleSolenoid(Constants.rampSolenoidPortOne, Constants.rampSolenoidPortTwo);
	*/
	public static Joystick controller1 = new Joystick(Constants.controller1Port);
	public static Joystick controller2 = new Joystick(Constants.controller2Port);

}	
