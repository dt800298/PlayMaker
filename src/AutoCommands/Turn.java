package AutoCommands;

import org.usfirst.frc.team548.robot.Constants;
import org.usfirst.frc.team548.robot.DriveTrain;
import org.usfirst.frc.team548.robot.Elevator;

public class Turn extends AutoCommandBase{
	
	private double turnPower;
	private double elevatorSetPoint;
	
	public Turn(double timeOut, double power, double elevatorSetPoint){
		super(timeOut);
		this.elevatorSetPoint = elevatorSetPoint;
		this.turnPower = power;
	}
	
	public void init(){
		
	}
	
	public void run(){
		DriveTrain.arcadeDrive(0, turnPower);
	}
	
	public void end(){
		Elevator.setPosition(elevatorSetPoint);
	}
	
	protected String getCommandName(){
		return "turn";
	}

}
