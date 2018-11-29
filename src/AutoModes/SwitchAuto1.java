package AutoModes;

import org.usfirst.frc.team548.robot.DriveTrain;

import edu.wpi.first.wpilibj.DriverStation;

public class SwitchAuto1 extends AutoMode {

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		//RIGHT SWITCH
		
		String gameData = "";
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
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
		
		 if(gameData != null && gameData.charAt(0) == 'L'){
			dtDriveDistance(.7, .3, (260 * 8), 0, 0);
			dtDriveDistance(4, .6, (260*144), 0, 0);
			turnToAngle(2, -90, 45, .5, 0);
			dtDriveDistance(1, -.6, (260 * 30), 0, 0);
			dropCube(1, .9, .9, 0);
			dtDriveDistance(1, .6, (260 * 10), 0, 0);
			//turnToAngle(2, 90, 45, .5, 0);
			//armGoUp(.1, true);
		}
		else{
			 dtDriveDistance(.7, .3, (260 * 8), 0, 0);
			dtDriveDistance(4, .6, (260*144), 0, 0);
			//armGoUp(1, true);
		}
		
		
		
	}

}