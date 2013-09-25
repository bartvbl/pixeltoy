from math import *

circleRadius = 25

points = 0

speed1x = 0
speed1y = 0

speed2x = 0
speed2y = 0

#acceleration
accel = 0.05

Player2x = _screenWidth / 10
Player2y = _screenHeight / 2

Player1x = _screenWidth * 0.9
Player1y = _screenHeight / 2

while True:
	newFrame()
	useColour(255, 0, 0, 255)
	drawCircle(Player1x, Player1y, circleRadius)
	useColour(0, 0, 255, 255)
	drawCircle(Player2x, Player2y, circleRadius)
	drawString(20,20,"Points: "+str(points))
	
	if isKeyDown('UP'):
		speed1y = speed1y + accel
		
	if isKeyDown('DOWN'):
		speed1y = speed1y - accel
		
	if isKeyDown('LEFT'):
		speed1x = speed1x - accel
		
	if isKeyDown('RIGHT'):
		speed1x = speed1x + accel
		
	Player1y = Player1y + speed1y
	Player1x = Player1x + speed1x
	speed1y = speed1y * 0.99
	speed1x = speed1x * 0.99
		
	if isKeyDown('w'):
		speed2y = speed2y + accel
		
	if isKeyDown('s'):
		speed2y = speed2y - accel
		
	if isKeyDown('a'):
		speed2x = speed2x - accel
		
	if isKeyDown('d'):
		speed2x = speed2x + accel
	
	Player2y = Player2y + speed2y
	Player2x = Player2x + speed2x
	speed2y = speed2y * 0.99
	speed2x = speed2x * 0.99
	
	if Player1y < circleRadius:
		speed1y = speed1y * -1
		Player1y = (circleRadius+1)
		
	if Player1y > (_screenHeight - circleRadius):
		speed1y = speed1y * -1
		Player1y = _screenHeight - (circleRadius+1)
		
	if Player1x < circleRadius:
		speed1x = speed1x * -1
		Player1x = (circleRadius+1)
	
	if Player1x > (_screenWidth - circleRadius):
		speed1x = speed1x * -1
		Player1x = _screenWidth - (circleRadius+1)
		
		
		
	if Player2y < circleRadius:
		speed2y = speed2y * -1
		Player2y = (circleRadius+1)
		
	if Player2y > (_screenHeight - circleRadius):
		speed2y = speed2y * -1
		Player2y = _screenHeight - (circleRadius+1)
		
	if Player2x < circleRadius:
		speed2x = speed2x * -1
		Player2x = (circleRadius+1)
	
	if Player2x > (_screenWidth - circleRadius):
		speed2x = speed2x * -1
		Player2x = _screenWidth - (circleRadius+1)
	
	if sqrt ((Player1x-Player2x) * (Player1x-Player2x) + (Player1y-Player2y) * (Player1y-Player2y)) < 50.0:
		
		speed1x = 0
		speed1y = 0
	
		speed2x = 0
		speed2y = 0
		
		Player2x = _screenWidth / 10
		Player2y = _screenHeight / 2

		Player1x = _screenWidth * 0.9
		Player1y = _screenHeight / 2
	
		points += 1
		