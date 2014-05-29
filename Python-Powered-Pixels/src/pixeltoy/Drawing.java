package pixeltoy;

import graphics.Colour;
import graphics.GraphicsController;

public class Drawing {
	public void drawRectangle(double x, double y, double width, double height) {
		GraphicsController.drawRectangle(x, y, width, height);
	}
	
	public void drawLine(double x1, double y1, double x2, double y2) {
		GraphicsController.drawLine(x1, y1, x2, y2);
	}
	
	public void drawPoint(double x, double y) {
		GraphicsController.drawPoint(x, y);
	}
	
	public void drawString(double x, double y, String string) {
		GraphicsController.drawString(x, y, string);
	}
	
	public void drawCircle(double x, double y, double radius) {
		GraphicsController.drawCircle(x, y, radius);
	}
	
	public void useColour(double r, double g, double b, double a) {
		Colour.useColour(r, g, b, a);
	}
	
	public void useColour(double r, double g, double b) {
		Colour.useColour(r, g, b, 255);
	}
}
