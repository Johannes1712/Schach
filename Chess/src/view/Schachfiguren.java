package view;
/**
 * ist das Panel wo die Bilder angezeigt werden
 * 
 * @author Johannes Haslwanter
 * @version 1.0
 */
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Schachfiguren{
	
	BufferedImage turmW,springerW,laeuferW,koenigW,dameW,turmB,springerB,laeuferB,koenigB,dameB;
	ArrayList<Image> list= new ArrayList<Image>();
	
	public void figurenLaden()
	{
		try {
			
			turmW=ImageIO.read(new File("Bild0.png"));
			list.add(turmW);
			springerW=ImageIO.read(new File("png"));
			list.add(springerW);
			laeuferW=ImageIO.read(new File("Bild2.png"));
			list.add(laeuferW);
			koenigW=ImageIO.read(new File("Bild3.png"));
			list.add(koenigW);
			dameW=ImageIO.read(new File("Bild4.png"));
			list.add(dameW);
			
			turmB=ImageIO.read(new File("Bild0.png"));
			list.add(turmB);
			springerB=ImageIO.read(new File("png"));
			list.add(springerB);
			laeuferB=ImageIO.read(new File("Bild2.png"));
			list.add(laeuferB);
			koenigB=ImageIO.read(new File("Bild3.png"));
			list.add(koenigB);
			dameB=ImageIO.read(new File("Bild4.png"));
			list.add(dameB);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}