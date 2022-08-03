package mule.ubtmicroworld.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * This class is responsible for loading images
 * @author Marco Jantos
 */
public class Imageloader {
	
	/**
	 * This method loads image files from memory
	 * @param name Name of the Image
	 * @return BufferedImage
	 */
	public static BufferedImage loadImage(String name) {
		
		try {
			
			if(name.charAt(0) == '/') {
//				String name2 = "mule/ubtmicroworld/img/Agent0.png";
//				ClassLoader cldr = Imageloader.class.getClassLoader();
//				Object o = cldr.getResource(name2); 
//				System.out.println(o);
//				
//				name2 = "/mule/ubtmicroworld/img/Agent0.png";
//				o = Imageloader.class.getResourceAsStream(name2);
//				System.out.println(o);
//				System.out.println(name);
//				System.out.println(name2);
//				System.out.println(name.equals(name2));
				InputStream stream = Imageloader.class.getResourceAsStream(name);
				return ImageIO.read(stream);
			}
			return ImageIO.read(new File(name));
			
		} catch (IOException e1) {
		}
		
		String error = name + " kann nicht geladen werden.";
		throw new IllegalArgumentException(error);

	}
}