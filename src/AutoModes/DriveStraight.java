package AutoModes;

import org.usfirst.frc.team548.robot.DriveTrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight extends AutoMode {
	
	public DriveStraight(){
		super();
	}
	@Override
	protected void run() {
		// TODO Auto-generated method stub
		
		String gameData = "";
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		//
		if(gameData==null) {
			for(int i = 0; i < 20; i++) {
				gameData = DriverStation.getInstance().getGameSpecificMessage();
				if(gameData!=null) break;
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		if(true){
//			dtDriveDistance(.5,.3,5,0,0);
//			Timer.delay(.5);
//			dtDriveDistance(.5, .3,5,0,0);
//			dtDriveDistance(2,.6,5,0,0);
			
			dtDriveDistance(1.25,.75,10,0,0);
			
			
			//uirkj
		}
		/*else {
			if(DriveTrain.isConnected()){
				turnToAngle(1, 60, 30, .5, 0);
				dtDriveDistance(2, -.7, (20057 - (260 * 10)), 0, 0);
				turnToAngle(1., -35, 25, .5, 0);
				dtDriveDistance(1, -.5, (260 * 28), 0, 0);
				dropCube(.5, .7, .7, 0);
				//armGoUp(.1, true);
				dtDriveDistance(2, .5, (260 * 12), 0, 0);
				//turnToAngle(1, -90, 13, .5, 0);
			}
			else{
				System.out.println("NO GYRO");
				turnToAngle(.4, -90, 13, .5, 0);
				dtDriveDistance(1, -.5, (260 * 20), 0, 0);
			}
			//armGoUp(2, true);
			
			//armGoUp(1, true);		
		*/
		}
		
	}
	
	


//260 encoderclicks = 1 in


//write down autos and where they go and other stuff
//understand what is happening
//know how I am adjusting to failure and stuff
	//Deal with failure
//alows us with something to start with in the next year


	//drop off at back
	//drop one off at switch, then attempt to pick one up and go to scale
	//most autons should dump cube and then go towards middle of field