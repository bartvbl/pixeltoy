package texture;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;

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
		this.rotation  = rotationDegrees;
	}
	
	public void draw(double x, double y, double width, double height) {
		
	}
}
