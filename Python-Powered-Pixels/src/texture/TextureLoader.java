package texture;

import static org.lwjgl.opengl.GL11.*;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;

public class TextureLoader {	
	public static Texture loadTextureFromFile(String src, boolean smooth, int animatedImageCountX)
	{
		int textureID = createTextureFromImage(loadImageFromFile(src), smooth);
		return new Texture(textureID, animatedImageCountX);
	}
	
	private static int createTextureFromImage(BufferedImage image, boolean smooth)
	{
		byte[] imageData = TexturePixelConverter.getImageDataBytes(image);
		if((image != null) && (imageData != null))
		{
			return createTexture(imageData, image.getWidth(), image.getHeight(), smooth);
		} else {
			return -1;
		}
	}

	private static BufferedImage loadImageFromFile(String src)
	{
		BufferedImage img = null;
		InputStream in = null;
    	try {
    		in = new FileInputStream(src);
    		img = ImageIO.read(in);
    	}
    	catch (IOException ioe) {
                System.out.println(new File(src).getAbsolutePath());
    		ioe.printStackTrace();
    		if (in != null) {
    			try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    		return null;
    	}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -1*img.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        BufferedImage image = op.filter(img, null);
		return image;
	}
	
	private static int createTexture(byte[] imageData, int width, int height, boolean smooth)
	{
		IntBuffer textureReference = BufferUtils.createIntBuffer(1);
		ByteBuffer bb = BufferUtils.createByteBuffer(imageData.length);
		bb.put(imageData).flip();
		glGenTextures(textureReference);
		int textureID = textureReference.get(0);
		glPushAttrib(GL_TEXTURE_BIT);
		glBindTexture(GL_TEXTURE_2D,textureID);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
		if(smooth) {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);			
		} else {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		}
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, bb);
		glPopAttrib();
		return textureID;
	}

	
}
