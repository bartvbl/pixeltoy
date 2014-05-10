from graphics import GraphicsController 
from graphics import Colour
from core import GameController 
from core import Input 
from java.util import Random 
 
#internal variables. Please do not use them; they can change name and function at any time.
sys_gameController = GameController() 
sys_inputController = Input()
sys_random = Random()
sys_colour = Colour()
 
def random(): 
	return sys_random.nextDouble()
 
def drawRectangle(x, y, width, height):
	GraphicsController.drawRectangle(x, y, width, height)
 
def drawCircle(x, y, radius):
	GraphicsController.drawCircle(x, y, radius)
 
def drawLine(x1, y1, x2, y2):
	GraphicsController.drawLine(x1, y1, x2, y2)
 
def drawPoint(x, y):
	GraphicsController.drawPoint(x, y)
 
def drawString(x, y, string):
	GraphicsController.drawString(x, y, string)
 
def useColour(r, g, b, a = 255):
	sys_colour.useColour(r, g, b, a)
 
def newFrame():
	sys_gameController.newFrame()
	
def quit():
	sys_gameController.quit()
 
def isLeftMouseDown():
	return sys_inputController.isLeftMouseDown()
 
def isRightMouseDown():
	return sys_inputController.isRightMouseDown()
 
def getMouseWheelDelta():
	return sys_inputController.getMouseWheelDelta()
 
def isKeyDown(key):
	return sys_inputController.isKeyDown(key)
 
def loadImage(src, smooth = True):
	return GraphicsController.loadImage(src, smooth)
 
def drawImage(image, x, y, width, height):
	GraphicsController.drawImage(image, x, y, width, height)

#variables updated by backend
_mouseX = 0
_mouseY = 0 
_screenWidth = 640 
_screenHeight = 480 
 
sys_colour.resetColour()