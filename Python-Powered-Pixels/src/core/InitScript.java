package core;

public class InitScript {
	public static final String initScript = "" +
			"\nfrom core import GraphicsController" +
			"\nfrom core import GameController" +
			"\nfrom core import Input" +
			"\nfrom java.util import Random" +
			"\n" +
			"\n#internal variables" +
			"\nsys_graphicsController = GraphicsController()" +
			"\nsys_gameController = GameController()" +
			"\nsys_inputController = Input()" +
			"\nsys_random = Random()" +
			"\n" +
			"\ndef random():" +
			"\n	return sys_random.nextDouble()" +
			"\n" +
			"\ndef drawRectangle(x, y, width, height):" +
			"\n	global sys_graphicsController" +
			"\n	sys_graphicsController.drawRectangle(x, y, width, height)" +
			"\n" +
			"\ndef drawCircle(x, y, radius):" +
			"\n	global sys_graphicsController" +
			"\n	sys_graphicsController.drawCircle(x, y, radius)" +
			"\n" +
			"\ndef drawLine(x1, y1, x2, y2):" +
			"\n	global sys_graphicsController" +
			"\n	sys_graphicsController.drawLine(x1, y1, x2, y2)" +
			"\n" +
			"\ndef drawPoint(x, y):" +
			"\n	global sys_graphicsController" +
			"\n	sys_graphicsController.drawPoint(x, y)" +
			"\n" +
			"\ndef drawString(x, y, string):" +
			"\n	global sys_graphicsController" +
			"\n	sys_graphicsController.drawString(x, y, string)" +
			"\n" +
			"\ndef useColour(r, g, b, a):" +
			"\n	global sys_graphicsController" +
			"\n	sys_graphicsController.useColour(r, g, b, a)" +
			"\n" +
			"\ndef clearScreen():" +
			"\n	global sys_graphicsController" +
			"\n	sys_gameController.clearScreen()" +
			"\n" +
			"\ndef newFrame():" +
			"\n	global sys_graphicsController" +
			"\n	sys_gameController.newFrame()" +
			"\n	clearScreen()" +
			"\n" +
			"\ndef isMouseDown():" +
			"\n	global sys_inputController" +
			"\n	return sys_inputController.isMouseDown()" +
			"\n" +
			"\ndef isKeyDown(key):" +
			"\n	global sys_inputController" +
			"\n	return sys_inputController.isKeyDown(key)" +
			"\n" +
			"\n#variables updated by backend" +
			"\n_mouseX = 0" +
			"\n_mouseY = 0" +
			"\n_screenWidth = 640" +
			"\n_screenHeight = 480";
}