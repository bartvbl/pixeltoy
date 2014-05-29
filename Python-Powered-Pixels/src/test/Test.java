package test;

import pixeltoy.PixelToy;

public class Test {

	public static void main(String[] args) {
		PixelToy.init();
		while(true) {
			PixelToy.drawing.useColour(255, 0, 0, 255);
			PixelToy.drawing.drawCircle(100, 100, 10);
			PixelToy.newFrame();
		}
	}

}
