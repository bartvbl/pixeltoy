package core;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluOrtho2D;

import java.nio.ByteBuffer;

import org.lwjgl.opengl.Display;


public class TextureRenderer {
	private static int frameBufferID = -1;
	private static int renderTextureID = -1;
	private static int previousWidth = 640;
	private static int previousHeight = 480;
	
	public static void init() {
		frameBufferID = glGenFramebuffers();
		glBindFramebuffer(GL_FRAMEBUFFER, frameBufferID);
		createRenderTexture();
		linkRenderTexture();
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
	}
	
	public static void drawScreenFrame() {
		int width = Display.getWidth();
		int height = Display.getHeight();

		glBindFramebuffer(GL_FRAMEBUFFER, 0);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
		glViewport(0, 0, width, height);
		gluOrtho2D(0, 1, 0, 1);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		glEnable(GL_TEXTURE_2D);
		glColor4f(1, 1, 1, 1);
		glBindTexture(GL_TEXTURE_2D, renderTextureID);
		
		glBegin(GL_QUADS);
		glTexCoord2d(0, 0);
		glVertex2d(-1, -1);
		glTexCoord2d(1, 0);
		glVertex2d(1, -1);
		glTexCoord2d(1, 1);
		glVertex2d(1, 1);
		glTexCoord2d(0, 1);
		glVertex2d(-1, 1);
		glEnd();
	}
	
	public static void setupNextFrame() {
		glDisable(GL_TEXTURE_2D);
		glBindFramebuffer(GL_FRAMEBUFFER, frameBufferID);
	}
	
	public static void updateTexture() {
		int width = Display.getWidth();
		int height = Display.getHeight();
		
		if((width != previousWidth) || (height != previousHeight)) {
			createRenderTexture();
			linkRenderTexture();
		}
		
		previousWidth = width;
		previousHeight = height;
	}

	private static void createRenderTexture() {
		glEnable(GL_TEXTURE_2D);
		
		if(renderTextureID != -1) {
			glDeleteTextures(renderTextureID);
		}
		
		renderTextureID = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, renderTextureID);
		
		int width = Display.getWidth();
		int height = Display.getHeight();
		
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE, (ByteBuffer)null);
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
		
		glDisable(GL_TEXTURE_2D);
	}
	
	private static void linkRenderTexture() {
		glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, renderTextureID, 0);
		
		int isFramebufferOperational = glCheckFramebufferStatus(GL_FRAMEBUFFER);
		if(isFramebufferOperational != GL_FRAMEBUFFER_COMPLETE) {			
			System.out.println("ERROR: FrameBuffer is not operational!");
		}
	}
}
