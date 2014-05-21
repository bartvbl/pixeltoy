package texture;

import static org.lwjgl.opengl.GL11.*;
import graphics.Colour;

public class Texture {
	private final int id;
	private final int animatedImageCountX;

	private double rotation = 0;
	private int animationFrame = 0;

	public Texture(int id, int animatedImageCountX) {
		this.id = id;
		this.animatedImageCountX = animatedImageCountX;
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
	
	public void nextAnimationFrame() {
		animationFrame++;
		animationFrame = animationFrame % animatedImageCountX;
	}
	
	public void resetAnimation() {
		animationFrame = 0;
	}
	
	public void draw(double x, double y, double width, double height) {
		glEnable(GL_TEXTURE_2D);
		glColor4d(1, 1, 1, 1);

		this.bind();
		
		double animationFrameSize = 1d / (double) animatedImageCountX;
		double texCoordBase = ((double) animationFrame) * animationFrameSize;
		
		glPushMatrix();
		glTranslated(x, y, 0);
		glRotated(rotation, 0, 0, 1);
		glTranslated((-width)/2d, (-height)/2d, 0);
		
		glBegin(GL_QUADS);
		glTexCoord2d(texCoordBase, 0);
		glVertex2d(0, 0);
		glTexCoord2d(texCoordBase + animationFrameSize, 0);
		glVertex2d(width, 0);
		glTexCoord2d(texCoordBase + animationFrameSize, 1);
		glVertex2d(width, height);
		glTexCoord2d(texCoordBase, 1);
		glVertex2d(0, height);
		glEnd();
		
		glPopMatrix();
		
		glDisable(GL_TEXTURE_2D);
		Colour.useCurrentSelectedColour();
	}
}
