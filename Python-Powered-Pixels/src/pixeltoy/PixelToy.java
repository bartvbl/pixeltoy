package pixeltoy;

import java.util.Random;

import org.lwjgl.opengl.Display;
import core.GameController;
import core.Input;
import core.Main;

public class PixelToy {
	public static Drawing drawing;
	public static Input intput;
	
	private static final Random random = new Random();
	private static final GameController controller = new GameController();
	
	public static void init() {
		Main.init();
		drawing = new Drawing();
		intput = new Input();
	}
	
	public static void quit() {
		controller.quit();
	}
	
	public static void newFrame() {
		controller.newFrame();
	}
	
	public static double random() {
		return random.nextDouble();
	}
	
	public static int getScreenWidth() {
		return Display.getWidth();
	}
	
	public static int getScreenHeight() {
		return Display.getHeight();
	}
}
