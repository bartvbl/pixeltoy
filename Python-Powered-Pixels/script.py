man1 = loadImage('res/man1.png')
man2 = loadImage('res/man2.png')

while True:
	if isKeyDown('SPACE'):
		drawImage(man2, 32, 32, 256, 256)
	else:
		drawImage(man1, 32, 32, 256, 256)
	newFrame()