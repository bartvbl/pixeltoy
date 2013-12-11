from graphics import GraphicsController 
from graphics import Colour
from core import GameController 
from core import Input 
from java.util import Random 
 
#internal variables. Please do not use them; they can change name and function at any time.
sys_graphicsController = GraphicsController() 
sys_gameController = GameController() 
sys_inputController = Input()
sys_random = Random()
sys_colour = Colour()
 
def random(): 
	return sys_random.nextDouble()
 
def drawRectangle(x, y, width, height):
	global sys_graphicsController
	sys_graphicsController.drawRectangle(x, y, width, height)
 
def drawCircle(x, y, radius):
	global sys_graphicsController
	sys_graphicsController.drawCircle(x, y, radius)
 
def drawLine(x1, y1, x2, y2):
	global sys_graphicsController
	sys_graphicsController.drawLine(x1, y1, x2, y2)
 
def drawPoint(x, y):
	global sys_graphicsController
	sys_graphicsController.drawPoint(x, y)
 
def drawString(x, y, string):
	global sys_graphicsController
	sys_graphicsController.drawString(x, y, string)
 
def useColour(r, g, b, a):
	global sys_graphicsController
	sys_colour.useColour(r, g, b, a)
 
def newFrame():
	global sys_graphicsController
	sys_gameController.newFrame()
 
def isLeftMouseDown():
	global sys_inputController
	return sys_inputController.isLeftMouseDown()
 
def isRightMouseDown():
	global sys_inputController
	return sys_inputController.isRightMouseDown()
 
def getMouseWheelDelta():
	global sys_inputController
	return sys_inputController.getMouseWheelDelta()
 
def isKeyDown(key):
	global sys_inputController
	return sys_inputController.isKeyDown(key)
 
def loadImage(src):
	global sys_graphicsController
	return sys_graphicsController.loadImage(src)
 
def drawImage(image, x, y, width, height):
	global sys_graphicsController
	sys_graphicsController.drawImage(image, x, y, width, height)

#variables updated by backend
_mouseX = 0
_mouseY = 0 
_screenWidth = 640 
_screenHeight = 480 
 
sys_colour.resetColour()