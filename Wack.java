package game;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wack extends Thread {

	public Rectangle rect;
	
	public Wack(int x, int y, int width, int height) {
		rect = new Rectangle(x, y, width, height);
	}
	
	
	public void run() {
		try {
		Robot robot = new Robot();	
		
		robot.delay(1500);
		BufferedImage image = robot.createScreenCapture(rect);
		//ImageIO.write(image, "png", new File("/home/gspr/pic/screen.png"));
		
		long endTime = System.currentTimeMillis()+61000; // 61 seconds
		
		while (endTime >= System.currentTimeMillis()) {
			BufferedImage img = robot.createScreenCapture(rect);
			WritableRaster r = img.getRaster();
			DataBuffer db = r.getDataBuffer();
			DataBufferInt dbi = (DataBufferInt)db;
			int [] data=dbi.getData();
			
			for (int x_scale = 0; x_scale < rect.width; x_scale += 30) {
				for (int y_scale = 0; y_scale < rect.height; y_scale += 30) {
					int rgb = data[x_scale + rect.width * y_scale];
					
						if (rgb == -9157853 || 
							rgb == -10537187 || 
							rgb == -10143201 ||
							rgb == -8764124 ||
							rgb == -8172243 ||
							rgb == -8763348 ||
							rgb == -8829660 ||
							rgb == -6983395 ||
							rgb == -5866468 ||
							rgb == -8172499
					
								) {
							
							robot.mouseMove(rect.x + x_scale, rect.y + y_scale);
							robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
							robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
							
						}
				}
				
			}
			
			
			
		}
		
			
			
			
		}catch(AWTException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new Wack(300,350,1000,600).start();
	}

}
