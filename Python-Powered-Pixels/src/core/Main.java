package core;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluOrtho2D;

import java.io.File;
import java.io.FileInputStream;

import graphics.TextureRenderer;

import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.python.core.Py;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public class Main {
	private static PythonInterpreter interpreter;
	
	public static void main(String[] args) {
		interpreter = new PythonInterpreter();
		createWindow();
		initOpenGL();
		try {
			interpreter.execfile(Main.class.getClassLoader().getResourceAsStream("init.py"));
			PySystemState sys = Py.getSystemState();
			sys.path.append(new PyString(getJARPath()));
			//TextureRenderer.init();
			interpreter.execfile("script.py");
			idle();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Python error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void init() {
		createWindow();
		initOpenGL();
		//TextureRenderer.init();
	}

	private static void createWindow() {
		try {
			Display.setResizable(true);
			Display.setTitle("Pixel Toy");
			Display.setLocation(100, 100);
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.create();
			
			Mouse.create();
			Keyboard.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	private static void initOpenGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		gluOrtho2D(0, Display.getWidth(), 0, Display.getHeight());
		glClearColor(1, 1, 1, 1);
		glShadeModel(GL_SMOOTH);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glDisable(GL_TEXTURE_2D);
	}
	
	private static void newFrame() {
		//TextureRenderer.drawScreenFrame();
		
		Display.update();
		Display.sync(60);

		//TextureRenderer.setupNextFrame();
		//TextureRenderer.updateTexture();
		
		if(Display.isCloseRequested()) {
			Display.destroy();
			System.exit(0);
		}
		
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glViewport(0, 0, Display.getWidth(), Display.getHeight()); 
		gluOrtho2D(0, Display.getWidth(), 0, Display.getHeight());
		
		//Input.updateVariables(interpreter);
		
		glDisable(GL_TEXTURE_2D);
	}
	
	public static void newBlankFrame() {
		newFrame();
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
	}

	private static void idle() {
		System.out.println("Idling..");
		while(!Display.isCloseRequested()) {
			TextureRenderer.drawScreenFrame();
			TextureRenderer.setupNextFrame();

			Display.update();
			Display.sync(60);
		}
	}

	private static String getJARPath() {
		String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		File jarFile = new File(path).getParentFile();
		System.out.println("Adding to python path: "+jarFile.getAbsolutePath());
		return jarFile.getAbsolutePath();
	}
} 
