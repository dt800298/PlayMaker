package AutoModes;

import edu.wpi.first.wpilibj.Timer;

public class AutoLine extends AutoMode {

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		
		dtDriveDistance(.5, .3, 5, 0, 0);
		Timer.delay(.5);
		dtDriveDistance(2,.6,1,0,0);
	}

}
