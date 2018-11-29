/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team548.robot;

import com.kauailabs.navx.frc.AHRS;

import AutoModes.AutoLineLeft;
import AutoModes.AutoLineRight;
import AutoModes.AutoMode;
import AutoModes.DriveStraight;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	AutoMode autonCommand;
	SendableChooser<AutoMode> autoChooser;
	
	public static PowerDistributionPanel PDP;
	
	public Robot(){
		AHRS hyro = new AHRS(SPI.Port.kMXP);
	}
	
	@Override
	public void robotInit() {
		DriveTrain.getInstance();
		Elevator.getInstance();
		TeleOp.getInstance();
		Elevator.getInstance();
		Ingestor.getInstance();
		Climber.getInstance();
		USBLED.getInstance();
		Server.getInstance();
		PDP = new PowerDistributionPanel();
		
		Server.run();
		
		autoChooser = new SendableChooser<AutoMode>();
		autoChooser.addDefault("Left", new AutoLineLeft());
		autoChooser.addDefault("Middle", new DriveStraight());
		autoChooser.addDefault("Right", new AutoLineRight());
		SmartDashboard.putData("Auto mode", autoChooser);
		//SmarasdftDashboard.putNumber("Match Time:", DriverStation.getInstance().getMatchTime());
		
	}
	
	@Override
	public void autonomousInit() {
		DriveTrain.resetGyro();
		autoChooser.getSelected().start();
		Ingestor.closeIngestor();
	}

	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putNumber("Drive Train", DriveTrain.getEncoderAverage());
		SmartDashboard.putNumber("AUTO GYRO", DriveTrain.getAngle());
	}

	@Override
	public void teleopPeriodic() {		
		TeleOp.run();
	}
	
	@Override
	public void teleopInit(){
		TeleOp.init();

	}	
	@Override
	public void testPeriodic() {
	}
}
