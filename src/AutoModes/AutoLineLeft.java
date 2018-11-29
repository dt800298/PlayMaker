package AutoModes;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;

public class AutoLineLeft extends AutoMode {

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
		if(gameData!=null && gameData.charAt(0)=='L'){
//			dtDriveDistance(.5, .6, 5, 0, 0);
//			Timer.delay(.5);
//			dtDriveDistance(.7,.3,5,0,0);
//			dtDriveDistance(1.5,.6,5,0,0);
//			dropCube(1, .9, .9, 0);
//			dtDriveDistance(1,-.3,5,0,0);
			
			dtDriveDistance(1.5,.75,10,0,0);
			Timer.delay(.5);
			dropCube(1, .9, .9, 0);	
		}
		else{
//		dtDriveDistance(.5, .3, 5, 0, 0);
//		Timer.delay(.5);
//		dtDriveDistance(.3,.3,5,0,0);
//		dtDriveDistance(1.5,.6,1,0,0);
			
		dtDriveDistance(1.15, .85, 10, 0, 0);

		}
	}

}
