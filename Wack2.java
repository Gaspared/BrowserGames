package game;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Wack2 {

	public static void main(String[] args) throws AWTException {
		
		Robot robot = new Robot();
		long endTime = System.currentTimeMillis()+60000; // 1 min
		
		
		int x [] = {290,365,410,435,715,900,810,1130,990,900,780,600,480,590,680,800,880,960};
		int y [] = {805,830,730,910,890,905,870,800,760,730,740,740,770,850,810,800,820,850};
		
		robot.delay(2000);
		
		while(endTime >= System.currentTimeMillis()){
			
			for (int i = 0; i<=17; i++) {
				robot.mouseMove(x[i], y[i]);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(20);
				
				
			}
			
			
		}
	}

}
