package org.usfirst.frc.team548.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleOp {
	private static XBoxController driver, manip;
	private static TeleOp instance;
	
	public static TeleOp getInstance() {
		if (instance == null)
			instance = new TeleOp();
		return instance;
	}
	
	private TeleOp(){
		driver = new XBoxController(Constants.XB_POS_DRIVER);
		manip = new XBoxController(Constants.XB_POS_MANIP);
	}
	
	public static void init(){
		Elevator.setElevatorOut();
	}
	
	public static void run(){
		//DriveTrain.preventTip();
		
		Elevator.setOutputLimit();

		//Driver
		//DriveTrain.arcadeDrive(driver.getRightStickYAxis(), Utils.negPowTwo(driver.getLeftStickXAxis()));
		DriveTrain.tankDrive(driver.getRightStickYAxis(), driver.getLeftStickYAxis());
		
		if(driver.getRightBumper()){
			DriveTrain.setHighGear(true);
		}
		else
			DriveTrain.setHighGear(false);	
		
		//Manip		
		if(manip.getRightBumper())
			Climber.climb(manip.getRightStickYAxis());
		else if(manip.getRightTriggerButton())
			Climber.latch(manip.getRightStickYAxis());
		else { 
			
			Elevator.setPower(manip.getRightStickYAxis());
			Climber.climb(0);
		}
		//if(!manip.getRightTriggerButton()) Climber.lock();
		
		
		
		if(manip.getLeftBumper())
			Ingestor.closeIngestor();
		else{ 
			Ingestor.openIngest();
		}
		 

		if(manip.getYButton())
			Elevator.setElevatorIn();
		else
			Elevator.setElevatorOut();
		
		
		
		
		if(manip.getBackButton()){
			Ingestor.leftControl(.5);
			Ingestor.rightControl(-.5);
		}
		else if(manip.getStartButton()){
			Ingestor.leftControl(-.5);
			Ingestor.rightControl(.5);
		}
		else if(manip.getLeftJoystickButton()){
			Ingestor.leftControl(-.3);
			Ingestor.rightControl(-.3);
		}
		else 
			Ingestor.bothControl(-manip.getLeftStickYAxis());
		
		
		
		if(manip.getBButton())
			Elevator.setBarsOut();
		else
			Elevator.setBarsIn();
		
		
		if(driver.getAButton()){
			Elevator.resetEncoder();
		}
		
		if(driver.getAButton()){
			Elevator.setPosition(20000);
		}
		
		
		
		//SmartDashboard
		SmartDashboard.putNumber("DT Gryo", DriveTrain.getAngle());
		SmartDashboard.putNumber("DT Encoder", DriveTrain.getEncoderAverage());
		//SmartDashboard.putNumber("Pitch", DriveTrain.getRoll());
		SmartDashboard.putNumber("eleavtor encoder", Elevator.getPosition());
		SmartDashboard.putNumber("Angle", DriveTrain.getAngle());
		//SmartDashboard.putBoolean("Limit Switch Error", Elevator.checkLimitSwitches(Elevator.getBottomLimitSwitch()));
		SmartDashboard.putBoolean("Switch", Elevator.getBottomLimitSwitch());
		SmartDashboard.putNumber("xbox", manip.getLeftStickYAxis());
		SmartDashboard.putNumber("Elevator power", Elevator.getAmountPower());
		SmartDashboard.putBoolean("GYRO", DriveTrain.isConnected());
	}
	
}
