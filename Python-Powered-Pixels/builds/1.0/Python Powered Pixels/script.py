ySpeed = 0.0
height = 700
x = 0
radius = 900

while radius > 0:
	newFrame()
	clearScreen()
	useColour(255, 0, 0, 255)
	drawCircle(x, height, radius)
	ySpeed -= 1
	
	if(isKeyDown('RIGHT')):
		x += 4
	if(isKeyDown('LEFT')):
		x -= 4
	
	if isKeyDown(' '):
		ySpeed += 1.3
	
	height += ySpeed
	
	useColour(0, 0, 255, 255)
	drawString(x, height, 'This is a test!')
	
	if((height < 0) & (ySpeed < 0)):
		ySpeed *= -0.95
		height = 0
		radius -= 3