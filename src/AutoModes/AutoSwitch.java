package AutoModes;

import edu.wpi.first.wpilibj.Timer;

public class AutoSwitch extends AutoMode {
	protected void run(){
		dtDriveDistance(.5, .3, 5, 0, 0);
		Timer.delay(.5);
		dtDriveDistance(.7,.3,5,0,0);
		dtDriveDistance(1.5,.6,5,0,0);
		dropCube(1, .9, .9, 0);
		dtDriveDistance(1,-.3,5,0,0);
	}

}
