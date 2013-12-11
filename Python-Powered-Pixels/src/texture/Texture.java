package texture;

import static org.lwjgl.opengl.GL11.*;
import graphics.Colour;
import graphics.GraphicsController;

public class Texture {
	private final int id;
	private double rotation = 0;

	public Texture(int id) {
		this.id = id;
	}
	
	public void bind() {
		glBindTexture(GL_TEXTURE_2D, id);
	}
	
	public void setRotation(double rotationDegrees) {
		this.rotation = rotationDegrees;
	}
	
	public void rotate(double rotationDegrees) {
		this.rotation += rotationDegrees;
	}
	
	public void draw(double x, double y, double width, double height) {
		glEnable(GL_TEXTURE_2D);
		glColor4d(1, 1, 1, 1);

		this.bind();
		
		glPushMatrix();
		glTranslated(x, y, 0);
		glRotated(rotation, 0, 0, 1);
		glTranslated((-width)/2d, (-height)/2d, 0);
		GraphicsController.drawRectangle(0, 0, width, height);
		glPopMatrix();
		
		glDisable(GL_TEXTURE_2D);
		Colour.useCurrentSelectedColour();
	}
}
