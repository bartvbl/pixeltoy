package core;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.python.util.PythonInterpreter;

public class Input {

	public static void updateVariables(PythonInterpreter interpreter) {
		if(interpreter == null) {
			return;
		}
		
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		
		interpreter.set("_mouseX", mouseX);
		interpreter.set("_mouseY", mouseY);
		
		interpreter.set("_screenWidth", Display.getWidth());
		interpreter.set("_screenHeight", Display.getHeight());
	}
	
	public static boolean isLeftMouseDown() {
		return Mouse.isButtonDown(0);
	}
	
	public static boolean isRightMouseDown() {
		return Mouse.isButtonDown(1);
	}
	
	public static double getMouseWheelDelta() {
		return Mouse.getDWheel();
	}
	
	public static boolean isKeyDown(String keyString) {
		return KeyConverter.isKeyDown(keyString);
	}
	
	public static int getMouseX() {
		return Mouse.getX();
	}

	public static int getMouseY() {
		return Mouse.getY();
	}
}
