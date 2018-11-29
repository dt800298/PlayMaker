package AutoModes;

import AutoCommands.ArmGoUp;
import AutoCommands.AutoCommandBase;
import AutoCommands.DT_DriveDistance;
import AutoCommands.DT_TurnToAngle;
import AutoCommands.DriveDistance;
import AutoCommands.DropCube;
import AutoCommands.ElevatorSetPoint;
import AutoCommands.Turn;
//import AutoCommands.OneSideTurn;
import AutoCommands.TurnToAngle;
//import AutoCommands.Wait;


public abstract class AutoMode {
	private String autoName;
	
	public  void start(){
		run();
	}
	
    protected abstract void run();

    protected  void driveDistance(double seconds, double power, double distance, double threshold, double elevatorSetPoint, double ingestorPower){
		runCommand(new DriveDistance(seconds, power, distance, elevatorSetPoint, ingestorPower));
	}
	
    protected void dropCube(double seconds, double powerLeft, double powerRight, double elevatorSetPoint){
    	runCommand(new DropCube(seconds, powerLeft, powerRight, elevatorSetPoint));
    }
    
    protected void turn(double timeOut, double power, double setPoint){
    	runCommand(new Turn(timeOut, power, setPoint));
    }
    
    protected void turnToAngle(double seconds, double angle, double offset, double power, double setPoint){
    	runCommand(new TurnToAngle(seconds, angle, offset, power, setPoint));
    }
    protected void dtTurnToAngle(double seconds, double angle, double power, double setPoint){
    	runCommand(new DT_TurnToAngle(seconds, angle, power, setPoint));
    }
    protected void dtDriveDistance(double seconds, double power, double distance, double elevatorSetPoint, double ingestorSetPoint){
    	runCommand(new DT_DriveDistance(seconds, power, distance, elevatorSetPoint, ingestorSetPoint));
    }
    
    protected void armGoUp(double seconds, boolean pos){
    	runCommand(new ArmGoUp(seconds, pos));
    }
    
    protected void elevatotSet(double seconds, double angle){
    	runCommand(new ElevatorSetPoint(seconds, angle));
    }
    
	private  void runCommand(AutoCommandBase command) {
		// TODO Auto-generated method stub
		command.execute();
	}
	
	
}
