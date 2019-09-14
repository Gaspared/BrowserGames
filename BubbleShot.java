package game;

//https://www.gameboss.com/gamepages/bubbleshooterclassic.php
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;



public class BubbleShot extends Thread{

	long endTime = System.currentTimeMillis()+30000;  // 
	
	public Rectangle rect1, rect;

	public BubbleShot(int x, int y, int width, int height) {
		rect = new Rectangle(x, y, width, height);
	}
	
	public void run() {
		try {
			Robot robot = new Robot();
			robot.delay(2000);
		
			int count = 0;
			
			while(endTime >= System.currentTimeMillis()) {			//true
				BufferedImage img = robot.createScreenCapture(rect);
				WritableRaster r=img.getRaster();
				DataBuffer db=r.getDataBuffer();
				DataBufferInt dbi=(DataBufferInt)db;
				int[] data=dbi.getData();            	
				
				//color
				rect1 = new Rectangle(727,866,2,2);
				BufferedImage imga = robot.createScreenCapture(rect1);
				int color = imga.getRGB(0,0);

	
				
				for (int x_scale = 0; x_scale < rect.width; x_scale += 2) {
					for(int y_scale = 0; y_scale < rect.height; y_scale += 2) {
						int rgb = data[x_scale + rect.width * y_scale];
			
							
							if ((rgb == color)) {  
				
								
							robot.mouseMove(rect.x + x_scale, rect.y + y_scale);
							robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
							robot.delay(1000);
							count++;
							robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
							
						}

						
					} 
				}
			}
		}
		catch(AWTException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("start");
		new BubbleShot(450, 550, 550, 250).start(); 


	}
}