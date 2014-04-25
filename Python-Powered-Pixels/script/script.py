from java.lang.Math import sin, cos, tan

blockImage = loadImage('res/cube.png')
deltaX = 18
deltaY = 9
counter = 1
counterDelta = 0.01
rowDelta = 0.5
amplitude = 65

while(True):
	counter += counterDelta
	for j in xrange(0, 40):
		angleX = counter + (j * rowDelta)
		for i in xrange(0, 40):
			angleY = counter + (i * rowDelta)
			height = (i + j) * cos(angleY) * cos(angleX)
			blockImage.draw(825 - (deltaX * i) + (deltaX * j), 800 - (deltaY * i) - (deltaY * j) + height, 38, 40)
	newFrame()