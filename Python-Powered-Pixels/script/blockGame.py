from java.lang.Math import sin, cos, tan, floor

blockImage = loadImage('res/cube.png')
deltaX = 18
deltaY = 9
blockHeight = 22

boardWidth = 30
boardHeight = 30
gameOver = False

playerX = 0
playerY = 0
playerZ = 0
playerSpeed = 0.03

blocks = [[0 for _ in range(boardHeight)] for _ in range(boardWidth)]
falling = [[0 for _ in range(boardHeight)] for _ in range(boardWidth)]

for i in xrange(0, len(blocks)-1):
	for j in xrange(0, len(blocks[i])-1):
		falling[i][j] = random() * 15000

def drawImageAt(x, y, z, width, height, image):
	image.draw(600 - (deltaX * x) + (deltaX * y), 600 - (deltaY * x) - (deltaY * y) + z, 38, 40)
		
def drawBlock(i, j, height):
	drawImageAt(i, j, blocks[i][j] + height, 38, 40, blockImage)

while(True):
	if not gameOver:
		if isKeyDown('a'):
			playerX += playerSpeed
		if isKeyDown('w'):
			playerX -= playerSpeed
		if isKeyDown('s'):
			playerY += playerSpeed
		if isKeyDown('q'):
			playerY -= playerSpeed
		if playerX < 0:
			playerX = 0
		if playerX > boardWidth - 2:
			playerX = boardWidth - 2
		if playerY < 0:
			playerY = 0
		if playerY > boardHeight - 2:
			playerY = boardHeight - 2
		for i in xrange(0, len(blocks)-1):
			for j in xrange(0, len(blocks[i])-1):
				falling[i][j] -= 1
				if falling[i][j] < 0:
					blocks[i][j] -= 1
					drawBlock(i, j, 0)
				elif falling[i][j] < 100:
					drawBlock(i, j, -5*random())
				else:
					drawBlock(i, j, 0)
	else:
		drawString(100, 100, 'Game Over!')
		playerZ -= 1
	heightAtBlock = blocks[int(playerX+0.5)][int(playerY + 0.5)]
	if heightAtBlock < 0:
		gameOver = True
	drawImageAt(playerX, playerY, blockHeight + playerZ, 38, 40, blockImage)
	newFrame()