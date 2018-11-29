package AutoCommands;

import org.usfirst.frc.team548.robot.DriveTrain;
import org.usfirst.frc.team548.robot.Elevator;

public class DT_TurnToAngle extends AutoCommandBase{
	
	private double angle = 0;
	private double power;
	private double angleOffset;
	private double elevatorSetPoint;
	public DT_TurnToAngle(double timeOut, double angle, double power, double elevatorSetPoint) {
		super(timeOut);
		this.angle = angle;
		this.power = power;
		this.elevatorSetPoint = elevatorSetPoint;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		DriveTrain.resetGyro();
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		DriveTrain.turnToAngle(angle);
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		DriveTrain.disablePID();
		System.out.println(DriveTrain.getAngle());
		DriveTrain.resetGyro();
		Elevator.setPosition(elevatorSetPoint);
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "PID Turn To Angle";
	}

}
