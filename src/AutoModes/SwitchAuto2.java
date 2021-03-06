package AutoModes;

import edu.wpi.first.wpilibj.DriverStation;

public class SwitchAuto2 extends AutoMode {

	@Override
	protected void run() {
		// TODO Auto-generated method stub
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
		
		/*
		if(gameData != null && gameData.charAt(1) == 'R'){	
		//The gyro seems to be undocumented
			
			armGoUp(.001, true);
			dtDriveDistance(1, .3, (260 * 8), 10, 0, .3);
			dtDriveDistance(7, .7, (72280 - (29 * 260)), 10, 0, .3);
			turnToAngle(1, -30, 25, .5, 10000);
			dtDriveDistance(2, .4, 15 * 260, 10, 10000, .3);
			dropCube(.5, .9, .9, 10000);
			dtDriveDistance(1, -.5, 2080 + 12 * 260, 20, 0, 0);
			//OLD dtDriveDistance(1, -.5, 2080 + 9 * 260, 20, 10000, 0);
			turnToAngle(1, -110, 25, .5, 0);
			dtDriveDistance(1, .5, 2080 + 20 * 260, 20, 0, 0);
		
		
			
			armGoUp(.001, true);
			dtDriveDistance(1, .3, (260 * 8), 10, 0, .3);
			dtDriveDistance(5.5, .7, (72280 - (15 * 260)), 10, 15000, .3);
			turnToAngle(1, -50, 35, .5, 15000);
			dtDriveDistance(1, .5, (260 * 8), 10, 15000, .3);
			dropCube(.5, 1, 1, 15000);
			dtDriveDistance(1, -.5, 12 * 260, 20, 15000, 0);
		}
		*/
		
		if(gameData != null && gameData.charAt(0) == 'R'){
			dtDriveDistance(.7, .3, (260 * 8), 0, 0);
			dtDriveDistance(4, .6, (260*144), 0, 0);
			turnToAngle(2, 90, 45, .5, 0);
			dropCube(1, .9, .9, 0);
			dtDriveDistance(1, .6, (260 * 15), 0, 0);
			turnToAngle(2, -90, 45, .5, 0);
			//armGoUp(.1, true);
			
			
			
			
		}
		else{
			dtDriveDistance(.7, .3, (260 * 8), 0, 0);
			dtDriveDistance(4, .6, (260*144), 0, 0);
			//turnToAngle(2, 90, 8, .5, 0);
			//armGoUp(1, true);
		}
		
		
	}

}