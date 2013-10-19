package core;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.TextureImpl;

import texture.TextureLoader;

public class GraphicsController {
	private final TrueTypeFont font = new TrueTypeFont(new Font("Arial", Font.PLAIN, 18), true);
	private final int circleDisplayListID = generateCircleDisplayList();
	private final int squareDisplayListID = generateSquareDisplayList();
	private int[] currentColour = new int[]{0, 0, 0, 255};
	
	private static int generateCircleDisplayList() {
		int listID = glGenLists(1);
		glNewList(listID, GL_COMPILE);
		
		glBegin(GL_TRIANGLE_FAN);
		glVertex2d(0, 0);
		for(int angle = 0; angle <= 360; angle++) {
			double x = Math.sin(Math.toRadians(-angle));
			double y = Math.cos(Math.toRadians(-angle));
			glVertex2d(x, y);
		}
		glEnd();
		
		glEndList();
		return listID;
	}
	
	private static int generateSquareDisplayList() {
		int listID = glGenLists(1);
		glNewList(listID, GL_COMPILE);
		
		glBegin(GL_QUADS);
		glTexCoord2d(0, 0);
		glVertex2d(0, 0);
		glTexCoord2d(1, 0);
		glVertex2d(1, 0);
		glTexCoord2d(1, 1);
		glVertex2d(1, 1);
		glTexCoord2d(0, 1);
		glVertex2d(0, 1);
		glEnd();
		
		glEndList();
		return listID;
	}
	
	public void drawRectangle(double x, double y, double width, double height) {
		glPushMatrix();
		glScaled(width, height, 1);
		glTranslated(x/width, y/height, 0);
		glCallList(squareDisplayListID);
		glPopMatrix();
	}
	
	public void drawCircle(double x, double y, double radius) {
		glPushMatrix();
		glScaled(radius, radius, 1);
		glTranslated(x/radius, y/radius, 0);
		glCallList(circleDisplayListID);
		glPopMatrix();
	}
	
	public void drawTriangle(int[] point1, int[] point2, int[] point3) {
		
	}
	
	public void drawLine(double x1, double y1, double x2, double y2) {
		glBegin(GL_LINES);
		glVertex2d(x1, y1);
		glVertex2d(x2, y2);
		glEnd();
	}
	
	public void drawPoint(double x, double y) {
		glBegin(GL_POINTS);
		glVertex2d(x, y);
		glEnd();
	}
	
	public void drawString(double x, double y, String string) {
		glPushMatrix();
		glScaled(1, -1, 1);
		glTranslated(0, -18 + -2 * y, 0);
		TextureImpl.bindNone();
		Color fontColour = new Color(currentColour[0], currentColour[1], currentColour[2], currentColour[3]);
		font.drawString((float)x, (float)y, string, fontColour);
		TextureImpl.unbind();
		glDisable(GL_TEXTURE_2D);
		glPopMatrix();
	}
	
	public void useColour(double r, double g, double b, double a) {
		double red = r / 255d;
		double green = g / 255d;
		double blue = b / 255d;
		double alpha = a / 255d;
		glColor4d(red, green, blue, alpha);
		this.currentColour = new int[]{(int) r, (int) g, (int) b, (int) a};
	}
	
	public int loadImage(String src) {
		return TextureLoader.loadTextureFromFile(src);
	}
	
	public void drawImage(int image, double x, double y, double width, double height) {
		glEnable(GL_TEXTURE_2D);
		glColor4d(1, 1, 1, 1);

		glBindTexture(GL_TEXTURE_2D, image);
		drawRectangle(x, y, width, height);
		
		glDisable(GL_TEXTURE_2D);
		double red = (double)currentColour[0] / 255d;
		double green = (double)currentColour[1] / 255d;
		double blue = (double)currentColour[2] / 255d;
		double alpha = (double)currentColour[3] / 255d;
		glColor4d(red, green, blue, alpha);
	}
	
	public void resetColour() {
		useColour(255, 0, 0, 255);
	}
}
