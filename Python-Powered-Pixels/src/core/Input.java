package core;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.python.util.PythonInterpreter;

public class Input {

	public static void updateVariables(PythonInterpreter interpreter) {
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		
		interpreter.set("_mouseX", mouseX);
		interpreter.set("_mouseY", mouseY);
		
		interpreter.set("_screenWidth", Display.getWidth());
		interpreter.set("_screenHeight", Display.getHeight());
	}
	
	public static boolean isMouseDown() {
		return Mouse.isButtonDown(0);
	}
	
	public static boolean isKeyDown(String keyString) {
		return KeyConverter.isKeyDown(keyString);
	}

}
