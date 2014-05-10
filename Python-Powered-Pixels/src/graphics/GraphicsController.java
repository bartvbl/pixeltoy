package graphics;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.TextureImpl;

import texture.Texture;
import texture.TextureLoader;

public class GraphicsController {
	private static final TrueTypeFont font = new TrueTypeFont(new Font("Arial", Font.PLAIN, 18), true);
	private static final int circleDisplayListID = generateCircleDisplayList();
	private static final int squareDisplayListID = generateSquareDisplayList();
	
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
	
	public static void drawRectangle(double x, double y, double width, double height) {
		glPushMatrix();
		glScaled(width, height, 1);
		glTranslated(x/width, y/height, 0);
		glCallList(squareDisplayListID);
		glPopMatrix();
	}
	
	public static void drawCircle(double x, double y, double radius) {
		glPushMatrix();
		glScaled(radius, radius, 1);
		glTranslated(x/radius, y/radius, 0);
		glCallList(circleDisplayListID);
		glPopMatrix();
	}
	
	public static void drawTriangle(int[] point1, int[] point2, int[] point3) {
		
	}
	
	public static void drawLine(double x1, double y1, double x2, double y2) {
		glBegin(GL_LINES);
		glVertex2d(x1, y1);
		glVertex2d(x2, y2);
		glEnd();
	}
	
	public static void drawPoint(double x, double y) {
		glBegin(GL_POINTS);
		glVertex2d(x, y);
		glEnd();
	}
	
	public static void drawString(double x, double y, String string) {
		glPushMatrix();
		glScaled(1, -1, 1);
		glTranslated(0, -18 + -2 * y, 0);
		TextureImpl.bindNone();
		Color fontColour = Colour.getCurrentColour();
		font.drawString((float)x, (float)y, string, fontColour);
		TextureImpl.unbind();
		glDisable(GL_TEXTURE_2D);
		glPopMatrix();
	}
	
	public static Texture loadImage(String src, boolean smooth) {
		return TextureLoader.loadTextureFromFile(src, smooth);
	}
	
	public static void drawImage(Texture image, double x, double y, double width, double height) {
		image.draw(x, y, width, height);
	}
}
