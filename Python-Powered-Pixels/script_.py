man1 = loadImage('res/man1.png')
man2 = loadImage('res/man2.png')

while True:
	if isKeyDown('a'):
		man1.rotate(1)
	if isKeyDown('d'):
		man1.rotate(-1)
	if isKeyDown('SPACE'):
		drawImage(man2, 128 + 32, 128 + 32, 256, 256)
	else:
		drawImage(man1, 128 + 32, 128 + 32, 256, 256)
	newFrame()