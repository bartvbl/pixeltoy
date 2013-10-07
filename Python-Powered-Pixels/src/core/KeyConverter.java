package core;

import org.lwjgl.input.Keyboard;

//this is a terrible hack, due to LWJGL's limited ability to convert keys to strings. 
//This program can not use the much better event system due to the crossover with python.
public class KeyConverter {
	
	public static boolean isKeyDown(String keyCharacter)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_A) && (keyCharacter.equals("a")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_B) && (keyCharacter.equals("b")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_C) && (keyCharacter.equals("c")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_D) && (keyCharacter.equals("d")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_E) && (keyCharacter.equals("e")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_F) && (keyCharacter.equals("f")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_G) && (keyCharacter.equals("g")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_H) && (keyCharacter.equals("h")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_I) && (keyCharacter.equals("i")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_J) && (keyCharacter.equals("j")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_K) && (keyCharacter.equals("k")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_L) && (keyCharacter.equals("l")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_M) && (keyCharacter.equals("m")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_N) && (keyCharacter.equals("n")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_O) && (keyCharacter.equals("o")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_P) && (keyCharacter.equals("p")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_Q) && (keyCharacter.equals("q")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_R) && (keyCharacter.equals("r")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_S) && (keyCharacter.equals("s")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_T) && (keyCharacter.equals("t")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_U) && (keyCharacter.equals("u")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_V) && (keyCharacter.equals("v")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_W) && (keyCharacter.equals("w")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_X) && (keyCharacter.equals("x")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_Y) && (keyCharacter.equals("y")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_Z) && (keyCharacter.equals("z")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && (keyCharacter.equals("SPACE")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_0) && (keyCharacter.equals("0")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_1) && (keyCharacter.equals("1")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_2) && (keyCharacter.equals("2")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_3) && (keyCharacter.equals("3")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_4) && (keyCharacter.equals("4")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_5) && (keyCharacter.equals("5")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_6) && (keyCharacter.equals("6")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_7) && (keyCharacter.equals("7")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_8) && (keyCharacter.equals("8")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_9) && (keyCharacter.equals("9")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) && (keyCharacter.equals("LEFT")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && (keyCharacter.equals("RIGHT")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_UP) && (keyCharacter.equals("UP")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && (keyCharacter.equals("DOWN")))
		{
			return true;
		} else if((Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) && (keyCharacter.equals("SHIFT")))
		{
			return true;
		} else if((Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL)) && (keyCharacter.equals("CONTROL")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_TAB) && (keyCharacter.equals("TAB")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_RETURN) && (keyCharacter.equals("ENTER")))
		{
			return true;
		} else if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && (keyCharacter.equals("ESCAPE")))
		{
			return true;
		} else {
			return false;
		}
	}
}
