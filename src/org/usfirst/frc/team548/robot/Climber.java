package org.usfirst.frc.team548.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Climber {
	private static Climber instance;
	private static TalonSRX talonUn, talonDeux, talonShoulder;
	
	public static Climber getInstance(){
		if(instance == null)
			instance = new Climber();
		return instance;
	}
	
	private Climber(){
		talonUn = new TalonSRX(Constants.CLIMBER_TALON_UN); //Master
		talonDeux = new TalonSRX(Constants.CLIMBER_TALON_DEUX); //Slave
		talonShoulder = new TalonSRX(Constants.CLIMBER_TALON_SHOULDER);
		talonDeux.set(ControlMode.Follower, talonUn.getDeviceID());
		
	}
	public static void latch(double power){
		talonShoulder.set(ControlMode.PercentOutput, .5*power);
	}
	public static void climb(double power){
		talonUn.set(ControlMode.PercentOutput, power);
	}
	public static void lock(){
		talonShoulder.setNeutralMode(NeutralMode.Brake);
	}
	
	
}
