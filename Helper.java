package game;

import java.awt.Color;

public class Helper {

	public static void main(String[] args) {
		// 116, 67, 35
		
		int r, g , b, rgb;
		Color c;
		
		
		r = 116;
		g = 67;
		b = 35;
		c = new Color(r,g,b);
		rgb = c.hashCode();
		System.out.println(rgb);

	}

}
