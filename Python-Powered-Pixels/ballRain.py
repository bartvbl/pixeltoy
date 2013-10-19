class Ball:
	x = 0
	y = 0
	ySpeed = 0.0
	radius = 0.0
	red = 0.0
	green = 0.0
	blue = 0.0
	
	def __init__(self):
		self.generateBall()
	
	def draw(self):
		self.ySpeed -= 1
		self.y += self.ySpeed
		useColour(self.red, self.green, self.blue, 255)
		drawCircle(self.x, self.y, self.radius)
		
		if((self.y < 0) & (self.ySpeed < 0)):
			self.ySpeed *= -0.95
			self.y = 0
			self.radius -= 3
			if self.radius < 0:
				self.generateBall()
	
	def generateBall(self):
		self.x = random() * _screenWidth
		self.y = random() * _screenHeight
		self.radius = (random() * 70) + 10
		self.red = (random() * 254) + 1
		self.green = (random() * 254) + 1
		self.blue = (random() * 254) + 1

ballArray = []
for i in xrange(0, 100):
	ballArray.append(Ball())

while 1:
	newFrame()
	for ball in ballArray:
		ball.draw()