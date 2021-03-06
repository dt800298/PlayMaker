package org.usfirst.frc.team548.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class DriveTrain implements PIDOutput {
public static DriveTrain instance;
	
	public static DriveTrain getInstance(){
		if(instance == null)
			instance = new DriveTrain();
		return instance;
	}
	
	private static TalonSRX rightFront, leftFront, rightBack, leftBack;
	private static Solenoid sol;
	private static AHRS hyro;
	private static PIDController pid;
	private static Servo tip, ramp;
	
	private DriveTrain(){
		//ramp = new Servo(1);
		tip = new Servo(1);
		rightFront = new TalonSRX(Constants.DT_TALON_RIGHTFRONT); // has encoder
		rightBack = new TalonSRX(Constants.DT_TALON_RIGHTBACK);
		leftFront = new TalonSRX(Constants.DT_TALON_LEFTFRONT);
		leftBack = new TalonSRX(Constants.DT_TALON_LEFTBACK); // has encoder
		sol = new Solenoid(Constants.DT_SOLENOID_SHIFTER);
		hyro = new AHRS(SerialPort.Port.kUSB);
		rightFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		leftBack.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		pid = new PIDController(Constants.DT_PID_P, Constants.DT_PID_I, Constants.DT_PID_D, hyro, this);
		pid.setInputRange(-180.0f,  180.0f);
		pid.setOutputRange(-0.7f, 0.7f);
		pid.setAbsoluteTolerance(2f);
        pid.setContinuous(true);
	}
	
	public static void drive(double leftPower, double rightPower){
		rightFront.set(ControlMode.PercentOutput, -rightPower);
		rightBack.set(ControlMode.PercentOutput, -rightPower);
		leftBack.set(ControlMode.PercentOutput, leftPower);
		leftFront.set(ControlMode.PercentOutput, leftPower);
	}
	
	public static void arcadeDrive(double fwd, double tur) {
		if (Math.abs(tur) < .01)
			tur = 0;
		if (Math.abs(fwd) < .2)
			fwd = 0;
		drive(Utils.ensureRange(fwd + tur, -1d, 1d), Utils.ensureRange(fwd - tur, -1d, 1d));
	}
	
	public static void tankDrive(double rightWheelPower, double leftWheelPower){
		if(Math.abs(rightWheelPower) < 0.01){
			rightWheelPower = 0d;
		}
		
		if(Math.abs(leftWheelPower) < 0.01){
			leftWheelPower = 0d;
		}
		
		drive(Utils.ensureRange(leftWheelPower, -1d, 1d), Utils.ensureRange(rightWheelPower, -1d, 1d));
	}
	
	public static void setHighGear(boolean b){
		sol.set(b);
	}
	
	public static double getAngle(){
		return hyro.getAngle();
		
	}
	
	public static double getRightEncoderDistance(){
		return (rightFront.getSelectedSensorPosition(0));
	}
	
	public static double getLeftEncoderDistance(){
		return -(leftBack.getSelectedSensorPosition(0));
	}
	
	public static void resetEncoder(){
		leftBack.setSelectedSensorPosition(0, 0, 10);
		rightFront.setSelectedSensorPosition(0, 0, 10);
		
	}
	
	
	
	
	
	public static double getEncoderAverage(){
		/*
		if(getLeftEncoderDistance() > getRightEncoderDistance()){
			return getLeftEncoderDistance();
		}
		else
		*/
		return getRightEncoderDistance();
	}
	
	public static void turnToAngle(double angle){
		pid.setSetpoint(angle);
		if (!pid.isEnabled()) {
			pid.reset();
			pid.enable();
		}
	}
	
	public static void disablePID() {
		pid.disable();
	}
	
	public void pidWrite(double output) {
		if(Math.abs(pid.getError()) < 5d){
			pid.setPID(pid.getP(), .001, 0);
		}
		else
			pid.setPID(pid.getP(), 0, 0);
		drive(output, -output);	
	}
	
	public static void resetGyro(){
		hyro.reset();
	}
	
	public static double getRoll(){
		return hyro.getRoll();
	}
	
	public static void driveStraight(double power){
		if(power > 0){
			if(getAngle() > Constants.DT_DRIVE_STRAIGHT)
				drive(power * .80, power * 1.15);
			else if(getAngle() < -Constants.DT_DRIVE_STRAIGHT)
				drive(power * 1.15, power * .85);
			else
				drive(power, power);
		}
		else{
			if(getAngle() > Constants.DT_DRIVE_STRAIGHT)
				drive(power * 1.15, power * .85);
			else if(getAngle() < -Constants.DT_DRIVE_STRAIGHT)
				drive(power * .8, power * 1.15);
			else
				drive(power, power);
		}
		
	}
	
	public static double getPitch(){
		return hyro.getPitch();
	}
	
	public static void stop(){
		rightFront.set(ControlMode.PercentOutput, 0);
		rightBack.set(ControlMode.PercentOutput, 0);
		leftBack.set(ControlMode.PercentOutput, 0);
		leftFront.set(ControlMode.PercentOutput, 0);
	}
	
	public static boolean isConnected(){
		return hyro.isConnected();
	}
	
	public static void preventTip(){
		while(Math.abs(DriveTrain.getRoll()) > 10){
			if(DriveTrain.getRoll() > 10){
				DriveTrain.drive(.5, .5);
			}
			else
				DriveTrain.drive(-.5, -.5);
		}
	}
	public static void pidDriveStraight(double power){
		pid.setSetpoint(0);
		if(!pid.isEnabled()){
			pid.reset();
			pid.enable();
		}
		drive(power, power);
	}
}
